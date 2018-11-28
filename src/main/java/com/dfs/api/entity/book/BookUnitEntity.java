package com.dfs.api.entity.book;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 图书与单位关联表实体
 * 
 * @author Ming
 * @date 2018-11-15
 */
public class BookUnitEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 图书id */
	private Long bookId;

	/** 单位id */
	private Long unitId;

	/**
	 * 取得图书id
	 * 
	 * @return 图书id
	 */
	public Long getBookId() {
		return bookId;
	}

	/**
	 * 设定图书id
	 * 
	 * @param bookId 图书id
	 */
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	/**
	 * 取得单位id
	 * 
	 * @return 单位id
	 */
	public Long getUnitId() {
		return unitId;
	}

	/**
	 * 设定单位id
	 * 
	 * @param unitId 单位id
	 */
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	/**
	 * 取得图书与单位关联表实体字符串
	 * 
	 * @return 图书与单位关联表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", bookId=").append(bookId);
		sb.append(", unitId=").append(unitId);
		sb.append("]");
		return sb.toString();
	}
}