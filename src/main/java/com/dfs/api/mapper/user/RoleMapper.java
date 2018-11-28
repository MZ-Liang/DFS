package com.dfs.api.mapper.user;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.user.RoleEntity;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

/**
 * 角色表数据处理
 * 
 * @author Ming
 * @date 2018-11-20
 */
@Mapper
public interface RoleMapper extends SimpleMapper<Long, RoleEntity> {

	/**
	 * 根据用户id获取角色名称
	 * @param userId 用户id
	 * @return
	 */
	Set<String> getRoleNameByUserId(Long userId);

}