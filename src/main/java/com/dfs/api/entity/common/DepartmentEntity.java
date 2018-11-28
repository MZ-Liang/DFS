package com.dfs.api.entity.common;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 部门表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class DepartmentEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 部门名称 */
	private String departmentName;

	/** 部门名称(英文) */
	private String departmentNameEn;

	/** 角色 */
	private Long role;

	/**
	 * 取得部门名称
	 * 
	 * @return 部门名称
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * 设定部门名称
	 * 
	 * @param departmentName 部门名称
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * 取得部门名称(英文)
	 * 
	 * @return 部门名称(英文)
	 */
	public String getDepartmentNameEn() {
		return departmentNameEn;
	}

	/**
	 * 设定部门名称(英文)
	 * 
	 * @param departmentNameEn 部门名称(英文)
	 */
	public void setDepartmentNameEn(String departmentNameEn) {
		this.departmentNameEn = departmentNameEn;
	}

	/**
	 * 取得角色
	 * 
	 * @return 角色
	 */
	public Long getRole() {
		return role;
	}

	/**
	 * 设定角色
	 * 
	 * @param role 角色
	 */
	public void setRole(Long role) {
		this.role = role;
	}

	/**
	 * 取得部门表实体字符串
	 * 
	 * @return 部门表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", departmentName=").append(departmentName);
		sb.append(", departmentNameEn=").append(departmentNameEn);
		sb.append(", role=").append(role);
		sb.append("]");
		return sb.toString();
	}
}