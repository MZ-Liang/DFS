package com.dfs.api.model.book;

import java.io.Serializable;
import java.util.List;

import com.dfs.api.core.entity.Entity;
import com.dfs.api.model.common.FileModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图书排版文件模型
 * @author Ming
 * @date 2018年11月15日
 */
@ApiModel(value="BookTypesettingFileModel",description="图书排版文件模型")
public class BookTypesettingFileModel extends Entity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编辑原稿
	 */
	@ApiModelProperty("编辑原稿")
	private List<FileModel> editManuscripts;
	
	/**
	 * 正文排版文件
	 */
	@ApiModelProperty("正文排版文件")
	private List<FileModel> textFypesettingFiles;
	
	/**
	 * 封面扉页设计文件
	 */
	@ApiModelProperty("封面扉页设计文件")
	private List<FileModel> coverPageDesignFiles;
	
	/**
	 * 设计素材文件
	 */
	@ApiModelProperty("设计素材文件")
	private List<FileModel> designMaterialFiles;
	
	/**
	 * 其他排版设计文件
	 */
	@ApiModelProperty("其他排版设计文件")
	private List<FileModel> otherTypesettingFiles;
	
	/**
	 * 条形码
	 */
	@ApiModelProperty("条形码")
	private FileModel barCodeFile;

	/**
	 * 获取编辑原稿
	 * @return
	 */
	public List<FileModel> getEditManuscripts() {
		return editManuscripts;
	}

	/**
	 * 设置编辑原稿
	 * @param editManuscripts
	 */
	public void setEditManuscripts(List<FileModel> editManuscripts) {
		this.editManuscripts = editManuscripts;
	}

	/**
	 * 获取正文排版文件
	 * @return
	 */
	public List<FileModel> getTextFypesettingFiles() {
		return textFypesettingFiles;
	}

	/**
	 * 设置正文排版文件
	 * @param textFypesettingFiles
	 */
	public void setTextFypesettingFiles(List<FileModel> textFypesettingFiles) {
		this.textFypesettingFiles = textFypesettingFiles;
	}

	/**
	 * 获取封面扉页设计文件
	 * @return
	 */
	public List<FileModel> getCoverPageDesignFiles() {
		return coverPageDesignFiles;
	}

	/**
	 * 设置封面扉页设计文件
	 * @param coverPageDesignFiles
	 */
	public void setCoverPageDesignFiles(List<FileModel> coverPageDesignFiles) {
		this.coverPageDesignFiles = coverPageDesignFiles;
	}

	/**
	 * 获取设计素材文件
	 * @return
	 */
	public List<FileModel> getDesignMaterialFiles() {
		return designMaterialFiles;
	}

	/**
	 * 设置设计素材文件
	 * @param designMaterialFiles
	 */
	public void setDesignMaterialFiles(List<FileModel> designMaterialFiles) {
		this.designMaterialFiles = designMaterialFiles;
	}

	/**
	 * 获取其他排版设计文件
	 * @return
	 */
	public List<FileModel> getOtherTypesettingFiles() {
		return otherTypesettingFiles;
	}

	/**
	 * 设置其他排版设计文件
	 * @param otherTypesettingFiles
	 */
	public void setOtherTypesettingFiles(List<FileModel> otherTypesettingFiles) {
		this.otherTypesettingFiles = otherTypesettingFiles;
	}

	/**
	 * 获取条形码
	 * @return
	 */
	public FileModel getBarCodeFile() {
		return barCodeFile;
	}

	/**
	 * 设置条形码
	 * @param barCodeFile
	 */
	public void setBarCodeFile(FileModel barCodeFile) {
		this.barCodeFile = barCodeFile;
	}

	public BookTypesettingFileModel() {
		super();
	}

	@Override
	public String toString() {
		return "BookTypesettingFileModel [id=" + id + ", editManuscripts=" + editManuscripts + ", textFypesettingFiles="
				+ textFypesettingFiles + ", coverPageDesignFiles=" + coverPageDesignFiles + ", designMaterialFiles="
				+ designMaterialFiles + ", otherTypesettingFiles=" + otherTypesettingFiles + ", barCodeFile="
				+ barCodeFile + "]";
	}
	
}
