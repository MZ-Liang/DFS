package com.dfs.api.entity.author;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 作者与编辑关联表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class AuthorEditorEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 作者id */
	private Long authorId;

	/** 编辑id */
	private Long editorId;

	/** 编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理) */
	private Integer editType;

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
	 * 取得编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理)
	 * 
	 * @return 编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理)
	 */
	public Integer getEditType() {
		return editType;
	}

	/**
	 * 设定编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理)
	 * 
	 * @param editType 编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理)
	 */
	public void setEditType(Integer editType) {
		this.editType = editType;
	}

	/**
	 * 取得作者与编辑关联表实体字符串
	 * 
	 * @return 作者与编辑关联表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", authorId=").append(authorId);
		sb.append(", editorId=").append(editorId);
		sb.append(", editType=").append(editType);
		sb.append("]");
		return sb.toString();
	}
}