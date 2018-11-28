package com.dfs.api.model.book;

import java.io.Serializable;
import java.util.List;

import com.dfs.api.core.entity.Entity;
import com.dfs.api.model.common.FileModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图书版权文件模型
 * @author Ming
 * @date 2018年11月15日
 */
@ApiModel(value="BookCopyrightFileModel",description="图书版权文件模型")
public class BookCopyrightFileModel extends Entity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 出版合同
	 */
	@ApiModelProperty("出版合同")
	private List<FileModel> publicationContracts;

	public List<FileModel> getPublicationContracts() {
		return publicationContracts;
	}

	public void setPublicationContracts(List<FileModel> publicationContracts) {
		this.publicationContracts = publicationContracts;
	}

	public BookCopyrightFileModel() {
		super();
	}

	@Override
	public String toString() {
		return "BookCopyrightFileModel [publicationContracts=" + publicationContracts + ", id=" + id + "]";
	}
	
}
