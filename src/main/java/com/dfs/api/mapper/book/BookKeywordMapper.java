package com.dfs.api.mapper.book;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.book.BookKeywordEntity;
import com.dfs.api.model.RelationBasicModel;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 图书与主题词关联表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface BookKeywordMapper extends SimpleMapper<Long, BookKeywordEntity> {

	/**
	 * 根据图书id获取图书与主题词关联模型
	 * @param bookId 图书id
	 * @return
	 */
	List<RelationBasicModel> getRelationModelByBookId(Long bookId);

}