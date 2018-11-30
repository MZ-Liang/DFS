package com.dfs.api.model.common;

import java.io.Serializable;

import com.dfs.api.entity.common.FileEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 文件实体模型
 * @author Ming
 * @date 2018年11月21日
 */
@ApiModel(value="FileEntityModel",description="文件实体模型")
public class FileEntityModel extends FileEntity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 文件序号
	 */
	@ApiModelProperty("文件序号")
	private Integer orderNumber;
	
	@ApiModelProperty("关联表id")
	private Long relationId;
	
	@ApiModelProperty("关联主表id")
	private Long parentId;

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
	
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public FileEntityModel() {
		super();
	}

}
