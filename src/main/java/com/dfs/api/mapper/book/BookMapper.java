package com.dfs.api.mapper.book;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.book.BookEntity;
import com.dfs.api.model.book.BookBasicInfoModel;
import com.dfs.api.model.book.BookSearchModel;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 图书表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface BookMapper extends SimpleMapper<Long, BookEntity> {

	/**
	 * 获取图书主要信息
	 * @param id 图书id
	 * @return 图书基础模型
	 */
	BookEntity getBasicModel(Long id);

	/**
	 * 根据条件查询图书基本信息
	 * @param condition 查询条件
	 * @return
	 */
	List<BookBasicInfoModel> searchBookBasicInfo(BookSearchModel condition);

	/**
	 * 新建图书,并返回主键
	 * @param creator 创建者id
	 * @param createTime 创建时间
	 * @return
	 */
	int create(BookEntity bookEntity);

}