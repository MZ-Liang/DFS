package com.dfs.api.mapper.book;

import org.apache.ibatis.annotations.Mapper;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.book.SeriesEntity;

/**
 * 丛书表数据处理
 * 
 * @author Ming
 * @date 2018-11-16
 */
@Mapper
public interface SeriesMapper extends SimpleMapper<Long, SeriesEntity> {

}