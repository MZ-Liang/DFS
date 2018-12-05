package com.dfs.api.model.user;

import java.io.Serializable;

import com.dfs.api.entity.user.PermissionEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="RolePermissionRelationModel",description="角色与权限关联模型")
public class RolePermissionRelationModel implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("关联表id")
	private Long relationId;
	@ApiModelProperty("角色id")
	private Long roleId;
	@ApiModelProperty("权限")
	private PermissionEntity permissionEntity;
	
	public Long getRelationId() {
		return relationId;
	}
	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public PermissionEntity getPermissionEntity() {
		return permissionEntity;
	}
	public void setPermissionEntity(PermissionEntity permissionEntity) {
		this.permissionEntity = permissionEntity;
	}
	
}
