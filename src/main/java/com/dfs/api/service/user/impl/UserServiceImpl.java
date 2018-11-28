package com.dfs.api.service.user.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.core.service.impl.SimpleServiceImpl;
import com.dfs.api.entity.user.UserEntity;
import com.dfs.api.mapper.user.PermissionMapper;
import com.dfs.api.mapper.user.RoleMapper;
import com.dfs.api.mapper.user.UserMapper;
import com.dfs.api.model.BasicModel;
import com.dfs.api.service.user.UserService;


/**
 * 用户服务
 *
 */
@Service
public class UserServiceImpl extends SimpleServiceImpl<Long, UserEntity> implements UserService{
	/** 用户mapper */
	@Autowired
	private UserMapper userMapper;
	/** 角色mapper */
	@Autowired
	private RoleMapper roleMapper;
	/** 权限mapper */
	@Autowired
	private PermissionMapper permissionMapper;
	

	@Override
	protected SimpleMapper<Long, UserEntity> getMapper() {
		return userMapper;
	}

	/**
	 * 根据用户id获取权限path
	 * @param id 用户id
	 * @return
	 */
	@Override
	public Set<String> findPermissionPath(Long id) {
		return permissionMapper.getPermissionPathByUserId(id);
	}

	/**
	 * 根据用户id获取角色名称
	 * @param id 用户id
	 * @return
	 */
	@Override
	public Set<String> findRoleName(Long id) {
		return roleMapper.getRoleNameByUserId(id);
	}

	@Override
	public UserEntity findByUserName(String userName) {
		UserEntity condition=new UserEntity();
		condition.setUserName(userName);
		List<UserEntity> list=userMapper.selectByCondition(condition);
		if (CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据编辑类型获取编辑基本模型
	 * @param editorType 编辑类型
	 * @return
	 */
	@Override
	public List<BasicModel> listEditorBasicModel(Integer editorType) {
		List<BasicModel> list=userMapper.listEditorBasicModel(editorType);
		return list;
	}

}
