package com.dfs.api.mapper.common;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.common.DataSourceEntity;
import com.dfs.api.model.BasicModel;

import org.apache.ibatis.annotations.Mapper;

/**
 * 数据来源表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface DataSourceMapper extends SimpleMapper<Long, DataSourceEntity> {

	/**
	 * 获取数据来源基础模型
	 * @param id 数据来源id
	 * @return
	 */
	BasicModel getBasicModel(Long id);

}