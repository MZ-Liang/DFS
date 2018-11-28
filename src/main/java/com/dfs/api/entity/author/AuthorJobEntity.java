package com.dfs.api.entity.author;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 作者与职业关联表实体
 * 
 * @author Ming
 * @date 2018-11-21
 */
public class AuthorJobEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 作者id */
	private Long authorId;

	/** 职业类型id */
	private Long jobId;

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
	 * 取得职业类型id
	 * 
	 * @return 职业类型id
	 */
	public Long getJobId() {
		return jobId;
	}

	/**
	 * 设定职业类型id
	 * 
	 * @param jobId 职业类型id
	 */
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	/**
	 * 取得作者与职业关联表实体字符串
	 * 
	 * @return 作者与职业关联表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", authorId=").append(authorId);
		sb.append(", jobId=").append(jobId);
		sb.append("]");
		return sb.toString();
	}
}