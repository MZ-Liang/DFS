package com.dfs.api.mapper.user;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.user.UserRoleEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与角色关联表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface UserRoleMapper extends SimpleMapper<Long, UserRoleEntity> {

}