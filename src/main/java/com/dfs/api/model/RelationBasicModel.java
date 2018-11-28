package com.dfs.api.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="RelationBasicModel",description="关联基础模型")
public class RelationBasicModel extends BasicModel implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("关联表id")
	protected Long relationId;
	
	@ApiModelProperty("关联主表id")
	protected Long parentId;

	public Long getRelationId() {
		return relationId;
	}

	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public RelationBasicModel() {
		super();
	}

	@Override
	public String toString() {
		return "RelevanceBasicModel [relationId=" + relationId + ", parentId=" + parentId + ", name=" + name + ", id="
				+ id + "]";
	}
	
}
