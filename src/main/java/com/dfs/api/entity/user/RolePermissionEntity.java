package com.dfs.api.entity.user;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 角色与权限关联表实体
 * 
 * @author Ming
 * @date 2018-11-20
 */
public class RolePermissionEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 角色id */
	private Long roleId;

	/** 权限id */
	private Long permissionId;

	/**
	 * 取得角色id
	 * 
	 * @return 角色id
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 设定角色id
	 * 
	 * @param roleId 角色id
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 取得权限id
	 * 
	 * @return 权限id
	 */
	public Long getPermissionId() {
		return permissionId;
	}

	/**
	 * 设定权限id
	 * 
	 * @param permissionId 权限id
	 */
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	/**
	 * 取得角色与权限关联表实体字符串
	 * 
	 * @return 角色与权限关联表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", roleId=").append(roleId);
		sb.append(", permissionId=").append(permissionId);
		sb.append("]");
		return sb.toString();
	}
}