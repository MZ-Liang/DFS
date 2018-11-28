package com.dfs.api.model;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 基础模型
 * @author Ming
 * @date 2018年11月15日
 */
@ApiModel(value="BasicModel",description="基础模型")
public class BasicModel extends Entity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 名称
	 */
	@ApiModelProperty("名称")
	protected String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public BasicModel() {
		super();
	}
	
	public BasicModel(Long id ,String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "BasicModel [name=" + name + ", id=" + id + "]";
	}

}
