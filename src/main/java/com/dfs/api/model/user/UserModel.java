package com.dfs.api.model.user;

import java.io.Serializable;
import java.util.List;

import com.dfs.api.core.entity.Entity;
import com.dfs.api.model.RelationBasicModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserModel",description="用户模型")
public class UserModel extends Entity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("用户名")
	private String userName;
	
	@ApiModelProperty("密码")
	private String password;
	
	@ApiModelProperty("角色关联模型")
	private List<RelationBasicModel> userRoleRelations;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RelationBasicModel> getUserRoleRelations() {
		return userRoleRelations;
	}

	public void setUserRoleRelations(List<RelationBasicModel> userRoleRelations) {
		this.userRoleRelations = userRoleRelations;
	}

}
