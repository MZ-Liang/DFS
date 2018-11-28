package com.dfs.api.mapper.book;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.book.BookAuthorEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 图书与作者关联表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface BookAuthorMapper extends SimpleMapper<Long, BookAuthorEntity> {

}