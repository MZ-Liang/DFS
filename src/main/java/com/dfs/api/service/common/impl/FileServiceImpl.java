package com.dfs.api.service.common.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.api.constant.BucketEnum;
import com.dfs.api.constant.CommonConstant;
import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.core.service.impl.SimpleServiceImpl;
import com.dfs.api.entity.common.FileEntity;
import com.dfs.api.mapper.common.FileMapper;
import com.dfs.api.mapper.common.UnitMapper;
import com.dfs.api.mapper.user.UserMapper;
import com.dfs.api.model.common.FileEntityModel;
import com.dfs.api.model.common.FileModel;
import com.dfs.api.service.common.FileService;
import com.dfs.api.util.BeanUtils;

/**
 * 文件服务
 * @author Ming
 * @date 2018年11月19日
 */
@Service
public class FileServiceImpl extends SimpleServiceImpl<Long, FileEntity> implements FileService{
	/** 文件mapper */
	@Autowired
	private FileMapper fileMapper;
	/** 用户mapper */
	@Autowired
	private UserMapper userMapper;
	/** 单位mapper */
	@Autowired
	private UnitMapper unitMapper;
	
	@Override
	protected SimpleMapper<Long, FileEntity> getMapper() {
		return fileMapper;
	}

	/**
	 * 根据图书id、文件类型、状态获取文件模型
	 * @param bookId 图书id
	 * @param fileType 文件类型
	 * @param status 状态
	 * @param moduleType 模块类型
	 * @return
	 */
	@Override
	public List<FileModel> getFileModelByBookIdAndFileType(Long bookId, Integer fileType, Integer status,Integer moduleType) {
		// 查找文件实体
		List<FileEntityModel> list=fileMapper.getFilesByBookIdAndFileType(bookId,fileType,status,moduleType);
		// 返回结果
		List<FileModel> models=null;
		if (CollectionUtils.isNotEmpty(list)) {
			// 不为空，则复制属性
			models=BeanUtils.copyList(list, FileModel.class);
			// 遍历封装实体
			for (int i = 0; i < list.size(); i++) {
				// 封装创建者
				models.get(i).setCreatorBM(userMapper.getBasicModel(list.get(i).getCreator()));
				// 封装更新者
				models.get(i).setRegeneratorBM(userMapper.getBasicModel(list.get(i).getRegenerator()));
				// 封装单位模型
				models.get(i).setUnitBM(unitMapper.getBasicModelById(list.get(i).getUnit()));
				// 封装编辑模型
				models.get(i).setEditor(userMapper.getBasicModel(list.get(i).getEditorId()));
			}
		}
		
		return models;
	}
	
	/**
	 * 获取图书模块的正常的文件模型
	 * @param bookId 图书id
	 * @param fileType 文件类型
	 * @return
	 */
	@Override
	public List<FileModel> getFileModelByBookIdAndFileType(Long bookId, Integer fileType){
		return getFileModelByBookIdAndFileType(bookId,fileType,CommonConstant.STATUS_NORMAL,BucketEnum.BOOK.getIndex());
	}

	/**
	 * 保存或更新文件信息
	 * @param id 模块中的实体id
	 * @param files 文件模型集合
	 * @param moduleType 模块类型
	 * @return
	 */
	@Override
	public Boolean saveOrUpdateFiles(Long id, List<FileModel> files, Integer moduleType) {
		Boolean bln=false;
		
		// 图书模块处理
		if (moduleType==BucketEnum.BOOK.getIndex()) {
			// 文件插入集合
			List<FileModel> saveList=new ArrayList<FileModel>();
			// 文件更新集合
			List<FileModel> updateList=new ArrayList<FileModel>();
			// 获取实体模型
			List<FileEntityModel> fileEntityModels=BeanUtils.copyList(files, FileEntityModel.class);
			// 位置
			int index=0;
			// 遍历
			for (FileModel model : files) {
				// 当前位置
				index=files.indexOf(model);
				// 设置实体模型的文件所属单位
				fileEntityModels.get(index).setUnit(model.getUnitBM()==null?null:model.getUnitBM().getId());
				// 设置实体模型的文件所属编辑
				fileEntityModels.get(index).setEditorId((model.getEditor()==null?null:model.getEditor().getId()));
				// 设置实体模型的文件创建者
				fileEntityModels.get(index).setCreator(model.getCreatorBM()==null?null:model.getCreatorBM().getId());
				// 设置实体模型的文件更新者
				fileEntityModels.get(index).setRegenerator(model.getRegeneratorBM()==null?null:model.getRegeneratorBM().getId());
				
				
				if (model.getId()==null) {
					saveList.add(model);
				} else {
					updateList.add(model);
				}
			}
			
		}
		
		bln=true;
		return bln;
	}

}
