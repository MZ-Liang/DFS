package com.dfs.api.entity.common;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 编辑合表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class EditorEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 名称 */
	private String name;

	/** 名称(英文) */
	private String nameEn;

	/** 角色 */
	private Long role;

	/** 编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理) */
	private Integer editType;

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
	 * 取得编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理)
	 * 
	 * @return 编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理)
	 */
	public Integer getEditType() {
		return editType;
	}

	/**
	 * 设定编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理)
	 * 
	 * @param editType 编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理)
	 */
	public void setEditType(Integer editType) {
		this.editType = editType;
	}

	/**
	 * 取得编辑合表实体字符串
	 * 
	 * @return 编辑合表实体字符串
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
		sb.append(", editType=").append(editType);
		sb.append("]");
		return sb.toString();
	}
}