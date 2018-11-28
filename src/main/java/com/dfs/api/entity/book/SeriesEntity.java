package com.dfs.api.entity.book;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 丛书表实体
 * 
 * @author Ming
 * @date 2018-11-16
 */
public class SeriesEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 丛书名称 */
	private String name;

	/** 丛书责任者(对应用户) */
	private Long executor;

	/** 丛书著作方式 */
	private Long writingmode;

	/**
	 * 取得丛书名称
	 * 
	 * @return 丛书名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设定丛书名称
	 * 
	 * @param name 丛书名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取得丛书责任者(对应用户)
	 * 
	 * @return 丛书责任者(对应用户)
	 */
	public Long getExecutor() {
		return executor;
	}

	/**
	 * 设定丛书责任者(对应用户)
	 * 
	 * @param executor 丛书责任者(对应用户)
	 */
	public void setExecutor(Long executor) {
		this.executor = executor;
	}

	/**
	 * 取得丛书著作方式
	 * 
	 * @return 丛书著作方式
	 */
	public Long getWritingmode() {
		return writingmode;
	}

	/**
	 * 设定丛书著作方式
	 * 
	 * @param writingmode 丛书著作方式
	 */
	public void setWritingmode(Long writingmode) {
		this.writingmode = writingmode;
	}

	/**
	 * 取得丛书表实体字符串
	 * 
	 * @return 丛书表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", executor=").append(executor);
		sb.append(", writingmode=").append(writingmode);
		sb.append("]");
		return sb.toString();
	}
}