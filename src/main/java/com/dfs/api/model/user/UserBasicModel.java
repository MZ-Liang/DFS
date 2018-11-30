package com.dfs.api.model.user;

import com.dfs.api.core.entity.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户基础模型
 * @author Ming
 * @date 2018年11月15日
 */
@ApiModel(value="UserBasicModel",description="用户基础模型")
public class UserBasicModel extends Entity{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 账户名
	 */
	@ApiModelProperty("账户名")
	protected String userName;
	/**
	 * 昵称
	 */
	@ApiModelProperty("昵称")
	protected String nickName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public UserBasicModel() {
		super();
	}
	
	public UserBasicModel(Long id,String userName, String nickName) {
		super();
		this.id = id;
		this.userName = userName;
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		return "UserBasicModel [userName=" + userName + ", nickName=" + nickName + ", id=" + id + "]";
	}

}
