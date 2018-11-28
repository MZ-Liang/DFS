package com.dfs.api.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * token模型
 * @author Ming
 * @date 2018年11月20日
 */
@ApiModel(value="TokenModel",description="token模型")
public class TokenModel implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("账户：Access key")
	private String accessKey;
	@ApiModelProperty("密钥：Secret key")
	private String secretKey;
	@ApiModelProperty("客户端地址")
	private String client;
	
	public String getAccessKey() {
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	
	public TokenModel() {
		super();
	}
	
	public TokenModel(String accessKey, String secretKey) {
		super();
		this.accessKey = accessKey;
		this.secretKey = secretKey;
	}
	
	public TokenModel(String accessKey, String secretKey, String client) {
		super();
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "TokenModel [accessKey=" + accessKey + ", secretKey=" + secretKey + ", client=" + client + "]";
	}
}
