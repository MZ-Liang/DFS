package com.dfs.api.entity.common;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 错误码表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class ErrorCodeEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 错误码名称 */
	private String name;

	/** 资源类型 */
	private Long sourceType;

	/** 错误码类型 */
	private Long errorType;

	/**
	 * 取得错误码名称
	 * 
	 * @return 错误码名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设定错误码名称
	 * 
	 * @param name 错误码名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取得资源类型
	 * 
	 * @return 资源类型
	 */
	public Long getSourceType() {
		return sourceType;
	}

	/**
	 * 设定资源类型
	 * 
	 * @param sourceType 资源类型
	 */
	public void setSourceType(Long sourceType) {
		this.sourceType = sourceType;
	}

	/**
	 * 取得错误码类型
	 * 
	 * @return 错误码类型
	 */
	public Long getErrorType() {
		return errorType;
	}

	/**
	 * 设定错误码类型
	 * 
	 * @param errorType 错误码类型
	 */
	public void setErrorType(Long errorType) {
		this.errorType = errorType;
	}

	/**
	 * 取得错误码表实体字符串
	 * 
	 * @return 错误码表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", sourceType=").append(sourceType);
		sb.append(", errorType=").append(errorType);
		sb.append("]");
		return sb.toString();
	}
}