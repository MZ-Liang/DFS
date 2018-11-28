package com.dfs.api.entity.author;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 作者与主题词关联表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class AuthorKeywordEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 作者id */
	private Long authorId;

	/** 主题词id */
	private Long keywordId;

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
	 * 取得主题词id
	 * 
	 * @return 主题词id
	 */
	public Long getKeywordId() {
		return keywordId;
	}

	/**
	 * 设定主题词id
	 * 
	 * @param keywordId 主题词id
	 */
	public void setKeywordId(Long keywordId) {
		this.keywordId = keywordId;
	}

	/**
	 * 取得作者与主题词关联表实体字符串
	 * 
	 * @return 作者与主题词关联表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", authorId=").append(authorId);
		sb.append(", keywordId=").append(keywordId);
		sb.append("]");
		return sb.toString();
	}
}