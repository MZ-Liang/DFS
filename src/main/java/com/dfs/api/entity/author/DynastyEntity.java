package com.dfs.api.entity.author;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 朝代表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class DynastyEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 中文全称 */
	private String fullName;

	/** 中文简称 */
	private String shortName;

	/** 英文名称 */
	private String nameEn;

	/**
	 * 取得中文全称
	 * 
	 * @return 中文全称
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * 设定中文全称
	 * 
	 * @param fullName 中文全称
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName == null ? null : fullName.trim();
	}

	/**
	 * 取得中文简称
	 * 
	 * @return 中文简称
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * 设定中文简称
	 * 
	 * @param shortName 中文简称
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName == null ? null : shortName.trim();
	}

	/**
	 * 取得英文名称
	 * 
	 * @return 英文名称
	 */
	public String getNameEn() {
		return nameEn;
	}

	/**
	 * 设定英文名称
	 * 
	 * @param nameEn 英文名称
	 */
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	/**
	 * 取得朝代表实体字符串
	 * 
	 * @return 朝代表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", fullName=").append(fullName);
		sb.append(", shortName=").append(shortName);
		sb.append(", nameEn=").append(nameEn);
		sb.append("]");
		return sb.toString();
	}
}