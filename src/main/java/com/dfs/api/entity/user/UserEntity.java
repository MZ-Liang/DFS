package com.dfs.api.entity.user;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
@ApiModel(value="UserEntity",description="用户实体")
public class UserEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 账户名 */
	@ApiModelProperty("用户名")
	private String userName;

	/** 昵称 */
	@ApiModelProperty("昵称")
	private String nickName;

	/** 密码 */
	@ApiModelProperty("密码")
	private String password;
	
	@ApiModelProperty("状态（0：已删除 1：正常）")
	private Integer status;

	/** 手机号 */
	@ApiModelProperty("手机号")
	private String phone;

	/** 邮箱 */
	@ApiModelProperty("邮箱")
	private String mail;

	/**
	 * 取得账户名
	 * 
	 * @return 账户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设定账户名
	 * 
	 * @param userName 账户名
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	/**
	 * 取得昵称
	 * 
	 * @return 昵称
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * 设定昵称
	 * 
	 * @param nickName 昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName == null ? null : nickName.trim();
	}

	/**
	 * 取得密码
	 * 
	 * @return 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设定密码
	 * 
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * 取得手机号
	 * 
	 * @return 手机号
	 */
	public String getPhone() {
		return phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 设定手机号
	 * 
	 * @param phone 手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	/**
	 * 取得邮箱
	 * 
	 * @return 邮箱
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * 设定邮箱
	 * 
	 * @param mail 邮箱
	 */
	public void setMail(String mail) {
		this.mail = mail == null ? null : mail.trim();
	}

	/**
	 * 取得用户表实体字符串
	 * 
	 * @return 用户表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", userName=").append(userName);
		sb.append(", nickName=").append(nickName);
		sb.append(", password=").append(password);
		sb.append(", phone=").append(phone);
		sb.append(", mail=").append(mail);
		sb.append("]");
		return sb.toString();
	}
}