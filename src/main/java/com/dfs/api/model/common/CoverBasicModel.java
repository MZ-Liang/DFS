package com.dfs.api.model.common;

import java.io.Serializable;

import com.dfs.api.model.RelationBasicModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图片基础模型
 * @author Ming
 * @date 2018年11月15日
 */
@ApiModel(value="ImageBasicModel",description="图片基础模型")
public class CoverBasicModel extends RelationBasicModel implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("桶名")
	private String bucketName;
	@ApiModelProperty("对象名")
	private String objectName;
	
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
	
	@Override
	public String toString() {
		return "ImageBasicModel [bucketName=" + bucketName + ", objectName=" + objectName + ", relationId=" + relationId
				+ ", parentId=" + parentId + ", name=" + name + ", id=" + id + "]";
	}
	
}
