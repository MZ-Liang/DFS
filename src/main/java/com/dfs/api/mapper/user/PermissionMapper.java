package com.dfs.api.mapper.user;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.user.PermissionEntity;

/**
 * 权限表数据处理
 * 
 * @author Ming
 * @date 2018-11-20
 */
@Mapper
public interface PermissionMapper extends SimpleMapper<Long, PermissionEntity> {

	/**
	 * 根据用户id获取权限path
	 * @param userId 用户id
	 * @return
	 */
	Set<String> getPermissionPathByUserId(Long userId);

}