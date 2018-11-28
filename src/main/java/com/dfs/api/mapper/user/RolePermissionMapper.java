package com.dfs.api.mapper.user;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.user.RolePermissionEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 角色与权限关联表数据处理
 * 
 * @author Ming
 * @date 2018-11-20
 */
@Mapper
public interface RolePermissionMapper extends SimpleMapper<Long, RolePermissionEntity> {

}