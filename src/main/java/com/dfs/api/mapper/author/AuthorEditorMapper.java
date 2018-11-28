package com.dfs.api.mapper.author;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.author.AuthorEditorEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 作者与编辑关联表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface AuthorEditorMapper extends SimpleMapper<Long, AuthorEditorEntity> {

}