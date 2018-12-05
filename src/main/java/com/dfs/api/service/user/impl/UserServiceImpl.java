package com.dfs.api.service.user.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.api.constant.Code;
import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.core.service.impl.SimpleServiceImpl;
import com.dfs.api.entity.user.UserEntity;
import com.dfs.api.entity.user.UserRoleEntity;
import com.dfs.api.mapper.user.PermissionMapper;
import com.dfs.api.mapper.user.RoleMapper;
import com.dfs.api.mapper.user.UserMapper;
import com.dfs.api.mapper.user.UserRoleMapper;
import com.dfs.api.model.BasicModel;
import com.dfs.api.model.HttpResult;
import com.dfs.api.model.RelationBasicModel;
import com.dfs.api.model.user.UserModel;
import com.dfs.api.service.user.UserService;
import com.dfs.api.util.FlowableUtil;

/**
 * 用户服务
 *
 */
@Service
public class UserServiceImpl extends SimpleServiceImpl<Long, UserEntity> implements UserService {
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
	/** flowable工具类 */
	@Autowired
	private FlowableUtil flowableUtil;

	@Override
	protected SimpleMapper<Long, UserEntity> getMapper() {
		return userMapper;
	}

	/**
	 * 根据用户id获取权限path
	 * 
	 * @param id 用户id
	 * @return
	 */
	@Override
	public Set<String> findPermissionPath(Long id) {
		return permissionMapper.getPermissionPathByUserId(id);
	}

	/**
	 * 根据用户id获取角色名称
	 * 
	 * @param id 用户id
	 * @return
	 */
	@Override
	public Set<String> findRoleName(Long id) {
		return roleMapper.getRoleNameByUserId(id);
	}

	/**
	 * 根据用户名和状态获取用户
	 */
	@Override
	public UserEntity findByUserName(String userName, Integer status) {
		UserEntity condition = new UserEntity();
		condition.setUserName(userName);
		if (null != status) {
			condition.setStatus(status);
		}
		List<UserEntity> list = userMapper.selectByCondition(condition);
		if (CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据编辑类型获取编辑基本模型
	 * 
	 * @param editorType 编辑类型
	 * @return
	 */
	@Override
	public List<BasicModel> listEditorBasicModel(Integer editorType) {
		List<BasicModel> list = userMapper.listEditorBasicModel(editorType);
		return list;
	}

	/**
	 * 创建或保存用户
	 * 
	 * @param userModel 用户模型
	 * @return
	 * @throws Exception
	 */
	@Override
	public UserModel saveOrUpdate(UserModel userModel) throws Exception {
		// 实体
		UserEntity entity = new UserEntity();
		// 复制属性
		BeanUtils.copyProperties(userModel, entity);

		// 用户与角色关联模型集合
		List<UserRoleEntity> userRoleEntities = null;
		// 用户与角色关联实体
		UserRoleEntity userRoleEntity = null;
		if (CollectionUtils.isNotEmpty(userRoleEntities)) {
			userRoleEntities = new ArrayList<UserRoleEntity>();
			for (RelationBasicModel model : userModel.getUserRoleRelations()) {
				userRoleEntity = new UserRoleEntity();
				userRoleEntity.setId(model.getRelationId());
				userRoleEntity.setRoleId(model.getId());
				userRoleEntity.setUserId(userModel.getId());
				userRoleEntities.add(userRoleEntity);
			}
		}

		// 插入用户实体
		if (null == entity.getId()) {
			userMapper.insert(entity);
			// 添加flowable用户
			HttpResult result=flowableUtil.createFlowableUser(entity.getId(), entity.getUserName(), entity.getPassword());
			// 不成功，抛异常
			if (201 != result.getCode()) {
				throw new Exception();
			}
			// 授权访问 flowable rest api
			result=flowableUtil.givePrivalege(entity.getId(), flowableUtil.getPrivalegeRestApiId());
			// 不成功，抛异常
			if (200 != result.getCode()) {
				throw new Exception();
			}
		}
		// 更新用户实体
		else {
			userMapper.updateByPrimaryKeySelective(entity);
			// 更新flowable用户
			HttpResult result=flowableUtil.updateFlowableUserSelected(entity.getId(), entity.getUserName(), entity.getPassword());
			// 不成功，抛异常
			if (200 != result.getCode()) {
				throw new Exception();
			}
		}

		// 添加关联关系
		if (CollectionUtils.isNotEmpty(userRoleEntities)) {
			for (UserRoleEntity urEntity : userRoleEntities) {
				if (null == urEntity.getRoleId()) {
					userRoleMapper.deleteByPrimaryKey(urEntity.getId());
				} else {
					if (null == urEntity.getId()) {
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


	/**
	 * 批量删除用户（逻辑处理）
	 * 
	 * @param ids 用户id集合
	 * @return
	 * @throws Exception 
	 */
	@Override
	public Boolean delete(List<Long> ids) throws Exception {
		// 更改内容
		UserEntity entity = new UserEntity();
		// 删除状态
		entity.setStatus(Code.ERROR);
		// 遍历
		for (Long id : ids) {
			// 设置id
			entity.setId(id);
			// 逻辑删除
			userMapper.updateByPrimaryKeySelective(entity);
			// 删除flowable相应用户
			HttpResult result=flowableUtil.deleteFlowableUser(entity.getId());
			// 不成功，抛异常
			if (204!=result.getCode()) {
				throw new Exception();
			}
		}
		return Boolean.TRUE;
	}

	/**
	 * 更新用户密码
	 * @param condition 条件
	 * @return
	 * @throws Exception 
	 */
	@Override
	public Boolean updatePassword(UserEntity condition) throws Exception {
		userMapper.updateByPrimaryKeySelective(condition);
		// 更新flowable用户密码
		HttpResult result=flowableUtil.updateFlowableUserSelected(condition.getId(), null, condition.getPassword());
		// 不成功，抛异常
		if (200 != result.getCode()) {
			throw new Exception();
		}
		return Boolean.TRUE;
	}

}
