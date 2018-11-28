package com.dfs.api.entity.user;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 用户与角色关联表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class UserRoleEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 用户id */
	private Long userId;

	/** 角色id */
	private Long roleId;

	/**
	 * 取得用户id
	 * 
	 * @return 用户id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设定用户id
	 * 
	 * @param userId 用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

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
	 * 取得用户与角色关联表实体字符串
	 * 
	 * @return 用户与角色关联表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", userId=").append(userId);
		sb.append(", roleId=").append(roleId);
		sb.append("]");
		return sb.toString();
	}
}