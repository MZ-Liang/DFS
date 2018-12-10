package com.dfs.api.mapper.user;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.user.UserEntity;
import com.dfs.api.model.BasicModel;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface UserMapper extends SimpleMapper<Long, UserEntity> {

	/**
	 * 获取用户基础模型
	 * @param id 用户id
	 * @return
	 */
	BasicModel getBasicModel(Long id);

}