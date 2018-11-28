package com.dfs.api.mapper.common;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.common.TypeEntity;
import com.dfs.api.model.BasicModel;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 类别表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface TypeMapper extends SimpleMapper<Long, TypeEntity> {

	/**
	 * 获取类别基础模型
	 * @param id 类别id
	 * @param type 类型(UNrequire)
	 * @return
	 */
	BasicModel getBasicModel(@Param("id")Long id, @Param("type")Integer type);

}