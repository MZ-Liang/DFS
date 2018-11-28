package com.dfs.api.entity.book;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 图书与编辑关联表实体
 * 
 * @author Ming
 * @date 2018-11-26
 */
public class BookEditorEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 图书id */
	private Long bookId;

	/** 编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理) */
	private Integer editorType;

	/** 编辑id(用户) */
	private Long userId;

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
	 * 取得编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理)
	 * 
	 * @return 编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理)
	 */
	public Integer getEditorType() {
		return editorType;
	}

	/**
	 * 设定编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理)
	 * 
	 * @param editorType 编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理)
	 */
	public void setEditorType(Integer editorType) {
		this.editorType = editorType;
	}

	/**
	 * 取得编辑id(用户)
	 * 
	 * @return 编辑id(用户)
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设定编辑id(用户)
	 * 
	 * @param userId 编辑id(用户)
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
		sb.append(", editorType=").append(editorType);
		sb.append(", userId=").append(userId);
		sb.append("]");
		return sb.toString();
	}
}