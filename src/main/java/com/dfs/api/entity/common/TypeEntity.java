package com.dfs.api.entity.common;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 类别表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class TypeEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 类别名称 */
	private String name;

	/** 类别名称(英文) */
	private String nameEn;

	/** 类型(1:图书 2:集刊 3:资源类型 4:错误码类型) */
	private Integer type;

	/** 规则 */
	private String rule;

	/**
	 * 取得类别名称
	 * 
	 * @return 类别名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设定类别名称
	 * 
	 * @param name 类别名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取得类别名称(英文)
	 * 
	 * @return 类别名称(英文)
	 */
	public String getNameEn() {
		return nameEn;
	}

	/**
	 * 设定类别名称(英文)
	 * 
	 * @param nameEn 类别名称(英文)
	 */
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	/**
	 * 取得类型(1:图书 2:集刊 3:资源类型 4:错误码类型)
	 * 
	 * @return 类型(1:图书 2:集刊 3:资源类型 4:错误码类型)
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设定类型(1:图书 2:集刊 3:资源类型 4:错误码类型)
	 * 
	 * @param type 类型(1:图书 2:集刊 3:资源类型 4:错误码类型)
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 取得规则
	 * 
	 * @return 规则
	 */
	public String getRule() {
		return rule;
	}

	/**
	 * 设定规则
	 * 
	 * @param rule 规则
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}

	/**
	 * 取得类别表实体字符串
	 * 
	 * @return 类别表实体字符串
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
		sb.append(", type=").append(type);
		sb.append(", rule=").append(rule);
		sb.append("]");
		return sb.toString();
	}
}