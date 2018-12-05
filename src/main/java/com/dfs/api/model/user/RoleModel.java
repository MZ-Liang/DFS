package com.dfs.api.model.user;

import java.io.Serializable;
import java.util.List;

import com.dfs.api.core.entity.Entity;
import com.dfs.api.model.BasicModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="RoleModel",description="角色模型")
public class RoleModel extends Entity implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** 角色名 */
	@ApiModelProperty("角色名")
	private String roleName;

	/** 创建者 */
	@ApiModelProperty("创建者")
	private BasicModel creatorBM;

	/** 创建时间 */
	@ApiModelProperty("创建时间")
	private Long createTime;

	/** 更新者 */
	@ApiModelProperty("更新者")
	private BasicModel regeneratorBM;

	/** 更新时间 */
	@ApiModelProperty("更新时间")
	private Long updateTime;

	/** 描述 */
	@ApiModelProperty("描述")
	private String description;
	
	/** 角色与权限关联集合 */
	@ApiModelProperty("角色与权限关联集合")
	private List<RolePermissionRelationModel> relationModels;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public BasicModel getCreatorBM() {
		return creatorBM;
	}

	public void setCreatorBM(BasicModel creatorBM) {
		this.creatorBM = creatorBM;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public BasicModel getRegeneratorBM() {
		return regeneratorBM;
	}

	public void setRegeneratorBM(BasicModel regeneratorBM) {
		this.regeneratorBM = regeneratorBM;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<RolePermissionRelationModel> getRelationModels() {
		return relationModels;
	}

	public void setRelationModels(List<RolePermissionRelationModel> relationModels) {
		this.relationModels = relationModels;
	}
	
}
