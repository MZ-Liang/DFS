package com.dfs.api.mapper.book;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.book.BookDepartmentEntity;
import com.dfs.api.model.RelationBasicModel;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 图书与部门关联表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface BookDepartmentMapper extends SimpleMapper<Long, BookDepartmentEntity> {

	/**
	 * 根据图书id获取图书与部门关联模型
	 * @param id 图书id
	 * @return
	 */
	List<RelationBasicModel> getRelationBasicModelByBookId(Long bookId);

}