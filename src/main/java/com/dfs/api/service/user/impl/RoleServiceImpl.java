package com.dfs.api.service.user.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.core.service.impl.SimpleServiceImpl;
import com.dfs.api.entity.user.RoleEntity;
import com.dfs.api.mapper.user.RoleMapper;
import com.dfs.api.mapper.user.UserMapper;
import com.dfs.api.mapper.user.UserRoleMapper;
import com.dfs.api.model.PageInfo;
import com.dfs.api.model.user.RoleModel;
import com.dfs.api.service.user.PermissionService;
import com.dfs.api.service.user.RoleService;
import com.github.pagehelper.PageHelper;

/**
 * 角色服务
 * @author Ming
 * @date 2018年11月30日
 */
@Service
public class RoleServiceImpl extends SimpleServiceImpl<Long, RoleEntity> implements RoleService {
	/** 角色mapper */
	@Autowired
	private RoleMapper roleMapper;
	/** 用户与角色关联mapper */
	@Autowired
	private UserRoleMapper userRoleMapper;
	/** 用户服务 */
	@Autowired
	private UserMapper userMapper;
	/** 权限服务 */
	@Autowired
	private PermissionService permissionService;
	

	@Override
	protected SimpleMapper<Long, RoleEntity> getMapper() {
		return roleMapper;
	}

	/**
	 * 获取角色列表（可进行分页）
	 * @param pageNum 当前页数
	 * @param pageSize 每页大小
	 * @return
	 */
	@Override
	public PageInfo<RoleEntity> listRoles(Integer pageNum, Integer pageSize) {
		// 查询条件
		RoleEntity condition=new RoleEntity();
		
		// 是否分页由pageSize判断，为0全查
		PageHelper.startPage(pageNum, pageSize, pageSize==0?false:true);
		List<RoleEntity> list=roleMapper.selectByCondition(condition);
		return new PageInfo<RoleEntity>(list);
	}

	/**
	 * 根据id获取角色模型
	 * @param id 角色id
	 * @return
	 */
	@Override
	public RoleModel getRoleModelById(Long id) {
		// 查询实体
		RoleEntity entity=roleMapper.selectByPrimaryKey(id);
		// 创建模型
		RoleModel model=new RoleModel();
		// 复制属性
		BeanUtils.copyProperties(entity, model);
		model.setCreatorBM(userMapper.getBasicModel(entity.getCreator()));
		model.setRegeneratorBM(userMapper.getBasicModel(entity.getRegenerator()));
		// 设置权限
		model.setRelationModels(permissionService.listRolePermissionRelationModelByRoleId(id));
		
		return model;
	}

}
