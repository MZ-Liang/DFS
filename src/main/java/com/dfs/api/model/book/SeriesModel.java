package com.dfs.api.model.book;

import java.io.Serializable;

import com.dfs.api.model.BasicModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 丛书模型
 * @author Ming
 * @date 2018年11月16日
 */
@ApiModel(value="SeriesModel",description="丛书模型")
public class SeriesModel extends BasicModel implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** 丛书责任者 */
	@ApiModelProperty("丛书责任者")
	private BasicModel executor;
	/** 丛书著作方式 */
	@ApiModelProperty("丛书著作方式")
	private BasicModel writingmode;
	
	/**
	 * 获取丛书责任者
	 * @return
	 */
	public BasicModel getExecutor() {
		return executor;
	}
	/**
	 * 设置丛书责任者
	 * @param executor
	 */
	public void setExecutor(BasicModel executor) {
		this.executor = executor;
	}
	/**
	 * 获取丛书著作方式
	 * @return
	 */
	public BasicModel getWritingmode() {
		return writingmode;
	}
	/**
	 * 设置丛书著作方式
	 * @param writingmode
	 */
	public void setWritingmode(BasicModel writingmode) {
		this.writingmode = writingmode;
	}
	
	public SeriesModel() {
		super();
	}
	
	@Override
	public String toString() {
		return "SeriesModel [executor=" + executor + ", writingmode=" + writingmode + ", name=" + name + ", id=" + id
				+ "]";
	}

}
