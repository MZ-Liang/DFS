package com.dfs.api.entity.book;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 图书与文件关联表实体
 * 
 * @author Ming
 * @date 2018-11-21
 */
public class BookFileEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 图书id */
	private Long bookId;

	/** 文件id */
	private Long fileId;

	/** 序号 */
	private Integer orderNumber;

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
	 * 取得文件id
	 * 
	 * @return 文件id
	 */
	public Long getFileId() {
		return fileId;
	}

	/**
	 * 设定文件id
	 * 
	 * @param fileId 文件id
	 */
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	/**
	 * 取得序号
	 * 
	 * @return 序号
	 */
	public Integer getOrderNumber() {
		return orderNumber;
	}

	/**
	 * 设定序号
	 * 
	 * @param orderNumber 序号
	 */
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * 取得图书与文件关联表实体字符串
	 * 
	 * @return 图书与文件关联表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", bookId=").append(bookId);
		sb.append(", fileId=").append(fileId);
		sb.append(", orderNumber=").append(orderNumber);
		sb.append("]");
		return sb.toString();
	}
}