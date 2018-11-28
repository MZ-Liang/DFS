package com.dfs.api.model;

import java.io.Serializable;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ActionModel",description="Action模型")
public class ActionModel implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("连接")
	private String action;
	@ApiModelProperty("请求方法")
	private String requestMethod;
	@ApiModelProperty("请求头")
	private Map<String, String> headers;
	@ApiModelProperty("认证信息")
	private Map<String, String> auths;
	@ApiModelProperty("body参数")
	private Map<String, String> bodys;
	@ApiModelProperty("minio存储bucket名称")
	private String bucketName;
	@ApiModelProperty("minio存储object名称")
	private String objectName;
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, String> getAuths() {
		return auths;
	}

	public void setAuths(Map<String, String> auths) {
		this.auths = auths;
	}

	public Map<String, String> getBodys() {
		return bodys;
	}

	public void setBodys(Map<String, String> bodys) {
		this.bodys = bodys;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public ActionModel() {
		super();
	}

	@Override
	public String toString() {
		return "ActionModel [action=" + action + ", requestMethod=" + requestMethod + ", headers=" + headers
				+ ", auths=" + auths + ", bodys=" + bodys + ", bucketName=" + bucketName + ", objectName=" + objectName
				+ "]";
	}
	
}
