package com.dfs.api.entity.user;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 权限表实体
 * 
 * @author Ming
 * @date 2018-11-20
 */
public class PermissionEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 角色名 */
	private String name;

	/** 权限控制的请求路径 */
	private String path;

	/** 描述 */
	private String description;

	/**
	 * 取得角色名
	 * 
	 * @return 角色名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设定角色名
	 * 
	 * @param name 角色名
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 取得权限控制的请求路径
	 * 
	 * @return 权限控制的请求路径
	 */
	public String getPath() {
		return path;
	}

	/**
	 * 设定权限控制的请求路径
	 * 
	 * @param path 权限控制的请求路径
	 */
	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	/**
	 * 取得描述
	 * 
	 * @return 描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设定描述
	 * 
	 * @param description 描述
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * 取得权限表实体字符串
	 * 
	 * @return 权限表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", path=").append(path);
		sb.append(", description=").append(description);
		sb.append("]");
		return sb.toString();
	}
}