package com.dfs.api.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.core.service.impl.SimpleServiceImpl;
import com.dfs.api.entity.user.PermissionEntity;
import com.dfs.api.entity.user.RolePermissionEntity;
import com.dfs.api.mapper.user.PermissionMapper;
import com.dfs.api.mapper.user.RolePermissionMapper;
import com.dfs.api.model.user.RolePermissionRelationModel;
import com.dfs.api.service.user.PermissionService;

/**
 * 权限服务
 * @author Ming
 * @date 2018年12月3日
 */
@Service
public class PermissionServiceImpl extends SimpleServiceImpl<Long, PermissionEntity> implements PermissionService {
	/** 权限mapper */
	@Autowired
	private PermissionMapper permissionMapper;
	/** 角色与权限关联mapper */
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	/**
	 * 根据角色id获取角色与权限关联模型
	 * @param roleId 角色id
	 * @return
	 */
	@Override
	public List<RolePermissionRelationModel> listRolePermissionRelationModelByRoleId(Long roleId) {
		// 角色与权限关联集合
		List<RolePermissionRelationModel> list=null;
		// 角色与权限关联实体
		RolePermissionRelationModel model=null;
		
		// 角色与权限关联查询条件
		RolePermissionEntity condition=new RolePermissionEntity();
		condition.setRoleId(roleId);
		// 执行查询
		List<RolePermissionEntity> rolePermissionEntities=rolePermissionMapper.selectByCondition(condition);
		
		// 封装角色与权限关联集合
		if (CollectionUtils.isNotEmpty(rolePermissionEntities)) {
			list=new ArrayList<RolePermissionRelationModel>();
			for (RolePermissionEntity rolePermissionEntity : rolePermissionEntities) {
				model=new RolePermissionRelationModel();
				model.setRelationId(rolePermissionEntity.getId());
				model.setRoleId(roleId);
				model.setPermissionEntity(permissionMapper.selectByPrimaryKey(rolePermissionEntity.getPermissionId()));
				list.add(model);
			} 
		}
		
		return list;
	}

	@Override
	protected SimpleMapper<Long, PermissionEntity> getMapper() {
		return permissionMapper;
	}

}
