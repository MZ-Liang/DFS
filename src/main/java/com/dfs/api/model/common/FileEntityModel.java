package com.dfs.api.model.common;

import java.io.Serializable;

import com.dfs.api.entity.common.FileEntity;

/**
 * 文件实体模型
 * @author Ming
 * @date 2018年11月21日
 */
public class FileEntityModel extends FileEntity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 文件序号
	 */
	private Integer orderNumber;
	
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
