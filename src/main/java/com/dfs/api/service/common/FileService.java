package com.dfs.api.service.common;

import java.util.List;

import com.dfs.api.constant.BucketEnum;
import com.dfs.api.core.service.SimpleService;
import com.dfs.api.entity.common.FileEntity;
import com.dfs.api.model.common.FileModel;

/**
 * 文件服务
 * @author Ming
 * @date 2018年11月19日
 */
public interface FileService extends SimpleService<Long, FileEntity>{

	/**
	 * 根据图书id、文件类型、状态获取图书模块文件模型
	 * @param bookId 图书id
	 * @param fileType 文件类型
	 * @param status 状态
	 * @param moduleType 模块类型
	 * @return
	 */
	List<FileModel> getFileModelByBookIdAndFileType(Long bookId, Integer fileType, Integer status,Integer moduleType);
	
	/**
	 * 获取图书模块的正常的文件模型
	 * @param bookId 图书id
	 * @param fileType 文件类型
	 * @return
	 */
	List<FileModel> getFileModelByBookIdAndFileType(Long bookId, Integer fileType);

	/**
	 * 保存或更新文件信息
	 * @param id 模块中的实体id
	 * @param files 文件模型集合
	 * @param modulEnum 模块类型
	 * @return
	 */
	Boolean saveOrUpdateFiles(Long id, List<FileModel> files, BucketEnum modulEnum);
	
}
