package com.dfs.api.mapper.book;

import org.apache.ibatis.annotations.Mapper;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.book.BookEditorEntity;

/**
 * 图书与编辑关联表数据处理
 * 
 * @author Ming
 * @date 2018-11-26
 */
@Mapper
public interface BookEditorMapper extends SimpleMapper<Long, BookEditorEntity> {

}