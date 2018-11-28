package com.dfs.api.entity.common;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 单位合表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class UnitEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 名称 */
	private String name;

	/** 名称(英文) */
	private String nameEn;

	/** 角色 */
	private Long role;

	/** 单位类型(1:排版单位 2:制作单位) */
	private Integer unitType;

	/**
	 * 取得名称
	 * 
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设定名称
	 * 
	 * @param name 名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取得名称(英文)
	 * 
	 * @return 名称(英文)
	 */
	public String getNameEn() {
		return nameEn;
	}

	/**
	 * 设定名称(英文)
	 * 
	 * @param nameEn 名称(英文)
	 */
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
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
	 * 取得单位类型(1:排版单位 2:制作单位)
	 * 
	 * @return 单位类型(1:排版单位 2:制作单位)
	 */
	public Integer getUnitType() {
		return unitType;
	}

	/**
	 * 设定单位类型(1:排版单位 2:制作单位)
	 * 
	 * @param unitType 单位类型(1:排版单位 2:制作单位)
	 */
	public void setUnitType(Integer unitType) {
		this.unitType = unitType;
	}

	/**
	 * 取得单位合表实体字符串
	 * 
	 * @return 单位合表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", nameEn=").append(nameEn);
		sb.append(", role=").append(role);
		sb.append(", unitType=").append(unitType);
		sb.append("]");
		return sb.toString();
	}
}