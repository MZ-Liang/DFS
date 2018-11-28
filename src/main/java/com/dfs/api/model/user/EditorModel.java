package com.dfs.api.model.user;

import java.io.Serializable;

import com.dfs.api.model.RelationBasicModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="EditorModel",description="编辑模型（用户）")
public class EditorModel extends RelationBasicModel implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("编辑类型（1：责任编辑 2：美术编辑 3：运营编辑 4：质检员 5：版权经理）")
	private Integer editorType;
	
	public Integer getEditorType() {
		return editorType;
	}
	public void setEditorType(Integer editorType) {
		this.editorType = editorType;
	}

	public EditorModel() {
		super();
	}

	@Override
	public String toString() {
		return "EditorModel [editorType=" + editorType + ", relationId=" + relationId + ", parentId=" + parentId
				+ ", name=" + name + ", id=" + id + "]";
	}
	
}
