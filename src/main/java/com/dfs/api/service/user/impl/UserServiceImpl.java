package com.dfs.api.service.user.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.core.service.impl.SimpleServiceImpl;
import com.dfs.api.entity.user.UserEntity;
import com.dfs.api.entity.user.UserRoleEntity;
import com.dfs.api.mapper.user.PermissionMapper;
import com.dfs.api.mapper.user.RoleMapper;
import com.dfs.api.mapper.user.UserMapper;
import com.dfs.api.mapper.user.UserRoleMapper;
import com.dfs.api.model.BasicModel;
import com.dfs.api.model.RelationBasicModel;
import com.dfs.api.model.user.UserModel;
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
	/** 用户与角色关联mapper */
	@Autowired
	private UserRoleMapper userRoleMapper;
	

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

	/**
	 * 创建或保存用户
	 * @param userModel 用户模型
	 * @return
	 */
	@Override
	public UserModel saveOrUpdate(UserModel userModel) {
		// 实体
		UserEntity entity=new UserEntity();
		// 复制属性
		BeanUtils.copyProperties(userModel, entity);
		
		// 用户与角色关联模型集合
		List<UserRoleEntity> userRoleEntities=null;
		// 用户与角色关联实体
		UserRoleEntity userRoleEntity=null;
		if (CollectionUtils.isNotEmpty(userRoleEntities)) {
			userRoleEntities=new ArrayList<UserRoleEntity>();
			for (RelationBasicModel model : userModel.getUserRoleRelations()) {
				userRoleEntity=new UserRoleEntity();
				userRoleEntity.setId(model.getRelationId());
				userRoleEntity.setRoleId(model.getId());
				userRoleEntity.setUserId(userModel.getId());
				userRoleEntities.add(userRoleEntity);
			}
		}
		
		// 插入用户实体
		userMapper.insert(entity);
		// 添加关联关系
		if (CollectionUtils.isNotEmpty(userRoleEntities)) {
			for (UserRoleEntity urEntity : userRoleEntities) {
				if (null==urEntity.getRoleId()) {
					userRoleMapper.deleteByPrimaryKey(urEntity.getId());
				} else {
					if (null==urEntity.getId()) {
						userRoleMapper.insert(urEntity);
					} else {
						userRoleMapper.updateByPrimaryKey(urEntity);
					}
				}
			}
		}
		// 去除密码
		userModel.setPassword(null);
		return userModel;
	}

}
