package com.dfs.api.model.book;

import java.io.Serializable;
import java.util.List;

import com.dfs.api.core.entity.Entity;
import com.dfs.api.model.common.FileModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图书获奖证书模型
 * @author Ming
 * @date 2018年11月15日
 */
@ApiModel(value="BookAwardsFileModel",description="图书获奖证书模型")
public class BookAwardsFileModel extends Entity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 获取证书
	 */
	@ApiModelProperty("获奖证书")
	private List<FileModel> awardsFiles;

	public List<FileModel> getAwardsFiles() {
		return awardsFiles;
	}

	public void setAwardsFiles(List<FileModel> awardsFiles) {
		this.awardsFiles = awardsFiles;
	}

	public BookAwardsFileModel() {
		super();
	}

	@Override
	public String toString() {
		return "BookAwardsFileModel [awardsFiles=" + awardsFiles + ", id=" + id + "]";
	}
	
}
