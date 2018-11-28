package com.dfs.api.mapper.author;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.author.AuthorKeywordEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 作者与主题词关联表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface AuthorKeywordMapper extends SimpleMapper<Long, AuthorKeywordEntity> {

}