package com.dfs.api.entity.common;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 编辑表实体
 * 
 * @author Ming
 * @date 2018-12-10
 */
public class EditorEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 编辑名称 */
	private String name;

	/** 编辑类型(1:责任编辑 2:美术编辑 3:运营编辑 4:质检员 5:版权经理) */
	private Integer editorType;

	/**
	 * 取得编辑名称
	 * 
	 * @return 编辑名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设定编辑名称
	 * 
	 * @param name 编辑名称
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
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
	 * 取得编辑表实体字符串
	 * 
	 * @return 编辑表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", editorType=").append(editorType);
		sb.append("]");
		return sb.toString();
	}
}