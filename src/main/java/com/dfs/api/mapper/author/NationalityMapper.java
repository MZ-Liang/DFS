package com.dfs.api.mapper.author;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.author.NationalityEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 国籍表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface NationalityMapper extends SimpleMapper<Long, NationalityEntity> {

}