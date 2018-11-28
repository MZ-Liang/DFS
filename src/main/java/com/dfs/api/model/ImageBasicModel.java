package com.dfs.api.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图片基础模型
 * @author Ming
 * @date 2018年11月15日
 */
@ApiModel(value="ImageBasicModel",description="图片基础模型")
public class ImageBasicModel extends BasicModel implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 图片路径
	 */
	@ApiModelProperty("图片路径")
	private String path;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public ImageBasicModel() {
		super();
	}
	
	public ImageBasicModel(Long id, String name, String path) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "ImageBasicModel [path=" + path + ", name=" + name + ", id=" + id + "]";
	}
	
}
