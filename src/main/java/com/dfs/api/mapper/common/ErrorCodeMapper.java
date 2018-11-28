package com.dfs.api.mapper.common;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.common.ErrorCodeEntity;
import com.dfs.api.model.BasicModel;

import org.apache.ibatis.annotations.Mapper;

/**
 * 错误码表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface ErrorCodeMapper extends SimpleMapper<Long, ErrorCodeEntity> {

	/**
	 * 获取错误码基本模型
	 * @param id 错误码id
	 * @return
	 */
	BasicModel getBasicModel(Long id);

}