package com.dfs.api.entity.book;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 图书与主题词关联表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class BookKeywordEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 图书id */
	private Long bookId;

	/** CIP主题词id */
	private Long keywordId;

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
	 * 取得CIP主题词id
	 * 
	 * @return CIP主题词id
	 */
	public Long getKeywordId() {
		return keywordId;
	}

	/**
	 * 设定CIP主题词id
	 * 
	 * @param keywordId CIP主题词id
	 */
	public void setKeywordId(Long keywordId) {
		this.keywordId = keywordId;
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
		sb.append(", keywordId=").append(keywordId);
		sb.append("]");
		return sb.toString();
	}
}