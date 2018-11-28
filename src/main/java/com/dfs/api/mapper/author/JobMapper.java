package com.dfs.api.mapper.author;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.author.JobEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 职业类型表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface JobMapper extends SimpleMapper<Long, JobEntity> {

}