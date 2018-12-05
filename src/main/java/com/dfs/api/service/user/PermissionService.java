package com.dfs.api.service.user;

import java.util.List;

import com.dfs.api.core.service.SimpleService;
import com.dfs.api.entity.user.PermissionEntity;
import com.dfs.api.model.user.RolePermissionRelationModel;

/**
 * 权限服务
 * @author Ming
 * @date 2018年12月3日
 */
public interface PermissionService extends SimpleService<Long, PermissionEntity> {

	/**
	 * 根据角色id获取角色与权限关联模型
	 * @param roleId 角色id
	 * @return
	 */
	List<RolePermissionRelationModel> listRolePermissionRelationModelByRoleId(Long roleId);

}
