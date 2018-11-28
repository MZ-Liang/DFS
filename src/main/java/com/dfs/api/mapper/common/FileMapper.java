package com.dfs.api.mapper.common;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.common.FileEntity;
import com.dfs.api.model.common.FileEntityModel;

/**
 * 文件表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface FileMapper extends SimpleMapper<Long, FileEntity> {

	/**
	 * 根据图书id、文件类型、状态获取文件实体
	 * @param bookId 图书id(require)
	 * @param fileType 文件类型(null:全查)
	 * @param status 状态(1:正常 0:删除 null:全查)
	 * @param moduleType 模块类型(require)
	 * @return
	 */
	List<FileEntityModel> getFilesByBookIdAndFileType(@Param("bookId")Long bookId, @Param("fileType")Integer fileType,
			@Param("status")Integer status,@Param("moduleType")Integer moduleType);

}