package com.dfs.api.entity.book;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 图书与部门关联表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class BookDepartmentEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 图书id */
	private Long bookId;

	/** 部门id */
	private Long departmentId;

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
	 * 取得部门id
	 * 
	 * @return 部门id
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * 设定部门id
	 * 
	 * @param departmentId 部门id
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * 取得图书表实体字符串
	 * 
	 * @return 图书表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", bookId=").append(bookId);
		sb.append(", departmentId=").append(departmentId);
		sb.append("]");
		return sb.toString();
	}
}