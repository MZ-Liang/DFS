package com.dfs.api.model.book;

import java.io.Serializable;
import java.util.List;

import com.dfs.api.core.entity.Entity;
import com.dfs.api.model.common.FileModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图书数字文件
 * @author Ming
 * @date 2018年11月15日
 */
@ApiModel(value="BookDigitalFileModel",description="图书数字文件")
public class BookDigitalFileModel extends Entity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 封面（缩略图）
	 */
	@ApiModelProperty("封面（缩略图）")
	private List<FileModel> coverFiles;
	
	/**
	 * 扉页（缩略图）
	 */
	@ApiModelProperty("扉页（缩略图）")
	private List<FileModel> flyleafFiles;
	
	/**
	 * PDF文件
	 */
	@ApiModelProperty("PDF文件")
	private List<FileModel> pdfFiles;
	
	/**
	 * EPUB文件
	 */
	@ApiModelProperty("EPUB文件")
	private List<FileModel> epubrFiles;

	public List<FileModel> getCoverFiles() {
		return coverFiles;
	}

	public void setCoverFiles(List<FileModel> coverFiles) {
		this.coverFiles = coverFiles;
	}

	public List<FileModel> getFlyleafFiles() {
		return flyleafFiles;
	}

	public void setFlyleafFiles(List<FileModel> flyleafFiles) {
		this.flyleafFiles = flyleafFiles;
	}

	public List<FileModel> getPdfFiles() {
		return pdfFiles;
	}

	public void setPdfFiles(List<FileModel> pdfFiles) {
		this.pdfFiles = pdfFiles;
	}

	public List<FileModel> getEpubrFiles() {
		return epubrFiles;
	}

	public void setEpubrFiles(List<FileModel> epubrFiles) {
		this.epubrFiles = epubrFiles;
	}

	public BookDigitalFileModel() {
		super();
	}

	@Override
	public String toString() {
		return "BookDigitalFileModel [coverFiles=" + coverFiles + ", flyleafFiles=" + flyleafFiles + ", pdfFiles="
				+ pdfFiles + ", epubrFiles=" + epubrFiles + ", id=" + id + "]";
	}
	
}
