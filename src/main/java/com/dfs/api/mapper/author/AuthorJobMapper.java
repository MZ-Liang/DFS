package com.dfs.api.mapper.author;

import org.apache.ibatis.annotations.Mapper;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.author.AuthorJobEntity;

/**
 * 作者与职业关联表数据处理
 * 
 * @author Ming
 * @date 2018-11-21
 */
@Mapper
public interface AuthorJobMapper extends SimpleMapper<Long, AuthorJobEntity> {

}