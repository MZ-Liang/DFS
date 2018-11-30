package com.dfs.api.service.common.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.api.constant.BucketEnum;
import com.dfs.api.constant.CommonConstant;
import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.core.service.impl.SimpleServiceImpl;
import com.dfs.api.entity.book.BookFileEntity;
import com.dfs.api.entity.common.FileEntity;
import com.dfs.api.mapper.book.BookFileMapper;
import com.dfs.api.mapper.common.FileMapper;
import com.dfs.api.mapper.common.UnitMapper;
import com.dfs.api.mapper.user.UserMapper;
import com.dfs.api.model.common.FileEntityModel;
import com.dfs.api.model.common.FileModel;
import com.dfs.api.service.common.FileService;
import com.dfs.api.util.BeanUtils;
import com.dfs.api.util.CalendarUtility;
import com.dfs.api.util.ShiroUtil;

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
	/** 图书与文件关联mapper */
	@Autowired
	private BookFileMapper bookFileMapper;
	
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
			// 位置
			int index=0;
			// 遍历封装实体
			for (FileModel fileModel : models) {
				index=models.indexOf(fileModel);
				// 封装创建者
				fileModel.setCreatorBM(userMapper.getBasicModel(list.get(index).getCreator()));
				// 封装更新者
				fileModel.setRegeneratorBM(userMapper.getBasicModel(list.get(index).getRegenerator()));
				// 封装单位模型
				fileModel.setUnitBM(unitMapper.getBasicModelById(list.get(index).getUnit()));
				// 封装编辑模型
				fileModel.setEditor(userMapper.getBasicModel(list.get(index).getEditorId()));
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
	 * @param modulEnum 模块类型
	 * @return
	 */
	@Override
	public Boolean saveOrUpdateFiles(Long id, List<FileModel> files, BucketEnum moduleEnum) {
		Boolean bln=false;
		long time=CalendarUtility.getSystemAccurateTime();
		
		// 图书模块处理
		if (BucketEnum.BOOK==moduleEnum) {
			if (CollectionUtils.isNotEmpty(files)) {
				// 获取文件实体集合
				List<FileEntity> fileEntities = BeanUtils.copyList(files, FileEntity.class);
				// 文件实体
				FileEntity entity=null;
				// 图书与文件关联实体
				BookFileEntity bfEntity = null;
				// 位置
				int index = 0;
				// 遍历
				for (FileModel model : files) {
					// 当前位置
					index = files.indexOf(model);
					// 获取文件实体
					entity=fileEntities.get(index);
					// 设置实体模型的文件所属单位
					entity.setUnit(model.getUnitBM() == null ? null : model.getUnitBM().getId());
					// 设置实体模型的文件所属编辑
					entity.setEditorId((model.getEditor() == null ? null : model.getEditor().getId()));
					// 设置实体模型的文件创建者
					entity
							.setCreator(model.getCreatorBM() == null ? ShiroUtil.getUserId() : model.getCreatorBM().getId());
					// 设置实体模型的文件更新者
					entity
							.setRegenerator(model.getRegeneratorBM() == null ? null : model.getRegeneratorBM().getId());
					// 设置时间
					entity.setCreateTime(model.getCreateTime() == null ? time : null);
					entity.setUpdateTime(model.getRegeneratorBM() == null ? null : time);
					
					// 设置图书与文件关联实体
					bfEntity=new BookFileEntity();
					bfEntity.setId(model.getRelationId());
					bfEntity.setBookId(id);
					bfEntity.setFileId(model.getId());
					bfEntity.setOrderNumber(model.getOrderNumber());
					
					// 持久化文件实体
					if (null==entity.getId()) {
						fileMapper.insert(entity);
					} else {
						fileMapper.updateByPrimaryKey(entity);
					}
					
					// 持久化图书与文件关联实体
					if (null==bfEntity.getId()) {
						bookFileMapper.insert(bfEntity);
					} else {
						bookFileMapper.updateByPrimaryKey(bfEntity);
					}
				} 
			}
		}
		
		bln=true;
		return bln;
	}

}
