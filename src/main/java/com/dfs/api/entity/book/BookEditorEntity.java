package com.dfs.api.entity.book;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 图书与编辑关联表实体
 * 
 * @author Ming
 * @date 2018-12-10
 */
public class BookEditorEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 图书id */
	private Long bookId;

	/** 编辑id */
	private Long editorId;

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
	 * 取得编辑id
	 * 
	 * @return 编辑id
	 */
	public Long getEditorId() {
		return editorId;
	}

	/**
	 * 设定编辑id
	 * 
	 * @param editorId 编辑id
	 */
	public void setEditorId(Long editorId) {
		this.editorId = editorId;
	}

	/**
	 * 取得图书与编辑关联表实体字符串
	 * 
	 * @return 图书与编辑关联表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", bookId=").append(bookId);
		sb.append(", editorId=").append(editorId);
		sb.append("]");
		return sb.toString();
	}
}