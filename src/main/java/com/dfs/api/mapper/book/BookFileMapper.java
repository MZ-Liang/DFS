package com.dfs.api.mapper.book;

import org.apache.ibatis.annotations.Mapper;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.book.BookFileEntity;

/**
 * 图书与文件关联表数据处理
 * 
 * @author Ming
 * @date 2018-11-21
 */
@Mapper
public interface BookFileMapper extends SimpleMapper<Long, BookFileEntity> {

}