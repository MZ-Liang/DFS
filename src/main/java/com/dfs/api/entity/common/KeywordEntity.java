package com.dfs.api.entity.common;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * CIP主题词表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class KeywordEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 主题词名称 */
	private String name;

	/** 主题词名称(英文) */
	private String nameEn;

	/**
	 * 取得主题词名称
	 * 
	 * @return 主题词名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设定主题词名称
	 * 
	 * @param name 主题词名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取得主题词名称(英文)
	 * 
	 * @return 主题词名称(英文)
	 */
	public String getNameEn() {
		return nameEn;
	}

	/**
	 * 设定主题词名称(英文)
	 * 
	 * @param nameEn 主题词名称(英文)
	 */
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	/**
	 * 取得CIP主题词表实体字符串
	 * 
	 * @return CIP主题词表实体字符串
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
		sb.append("]");
		return sb.toString();
	}
}