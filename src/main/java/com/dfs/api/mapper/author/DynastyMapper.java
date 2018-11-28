package com.dfs.api.mapper.author;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.author.DynastyEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 朝代表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface DynastyMapper extends SimpleMapper<Long, DynastyEntity> {

}