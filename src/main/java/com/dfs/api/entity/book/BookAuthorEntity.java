package com.dfs.api.entity.book;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 图书与作者关联表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class BookAuthorEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 图书id */
	private Long bookId;

	/** 作者id */
	private Long authorId;

	/** 其他作者标识(0:否 1:是) */
	private Integer otherFlag;

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
	 * 取得作者id
	 * 
	 * @return 作者id
	 */
	public Long getAuthorId() {
		return authorId;
	}

	/**
	 * 设定作者id
	 * 
	 * @param authorId 作者id
	 */
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	/**
	 * 取得其他作者标识(0:否 1:是)
	 * 
	 * @return 其他作者标识(0:否 1:是)
	 */
	public Integer getOtherFlag() {
		return otherFlag;
	}

	/**
	 * 设定其他作者标识(0:否 1:是)
	 * 
	 * @param otherFlag 其他作者标识(0:否 1:是)
	 */
	public void setOtherFlag(Integer otherFlag) {
		this.otherFlag = otherFlag;
	}

	/**
	 * 取得图书与作者关联表实体字符串
	 * 
	 * @return 图书与作者关联表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", bookId=").append(bookId);
		sb.append(", authorId=").append(authorId);
		sb.append(", otherFlag=").append(otherFlag);
		sb.append("]");
		return sb.toString();
	}
}