package com.dfs.api.model.book;

import java.io.Serializable;
import java.util.List;

import com.dfs.api.core.entity.Entity;
import com.dfs.api.model.common.FileModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图书印刷文件模型
 * @author Ming
 * @date 2018年11月15日
 */
@ApiModel(value="BookPrintedFileModel",description="图书印刷文件模型")
public class BookPrintedFileModel extends Entity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 封面扉页印刷文件
	 */
	@ApiModelProperty("封面扉页印刷文件")
	private List<FileModel> coverPagePrintedFiles;
	
	/**
	 * 版权页文件
	 */
	@ApiModelProperty("版权页文件")
	private List<FileModel> copyrightPageFiles;
	
	/**
	 * 付型文件
	 */
	@ApiModelProperty("付型文件")
	private List<FileModel> paymentFiles;
	
	/**
	 * 其他印刷文件
	 */
	@ApiModelProperty("其他印刷文件")
	private List<FileModel> otherPrintedFiles;

	/**
	 * 获取封面扉页印刷文件
	 * @return
	 */
	public List<FileModel> getCoverPagePrintedFiles() {
		return coverPagePrintedFiles;
	}

	/**
	 * 设置封面扉页印刷文件
	 * @param coverPagePrintedFiles
	 */
	public void setCoverPagePrintedFiles(List<FileModel> coverPagePrintedFiles) {
		this.coverPagePrintedFiles = coverPagePrintedFiles;
	}

	/**
	 * 获取版权页文件
	 * @return
	 */
	public List<FileModel> getCopyrightPageFiles() {
		return copyrightPageFiles;
	}

	/**
	 * 设置版权页文件
	 * @param copyrightPageFiles
	 */
	public void setCopyrightPageFiles(List<FileModel> copyrightPageFiles) {
		this.copyrightPageFiles = copyrightPageFiles;
	}

	/**
	 * 获取付型文件
	 * @return
	 */
	public List<FileModel> getPaymentFiles() {
		return paymentFiles;
	}

	/**
	 * 设置付型文件
	 * @param paymentFiles
	 */
	public void setPaymentFiles(List<FileModel> paymentFiles) {
		this.paymentFiles = paymentFiles;
	}

	/**
	 * 获取其他印刷文件
	 * @return
	 */
	public List<FileModel> getOtherPrintedFiles() {
		return otherPrintedFiles;
	}

	/**
	 * 设置其他印刷文件
	 * @param otherPrintedFiles
	 */
	public void setOtherPrintedFiles(List<FileModel> otherPrintedFiles) {
		this.otherPrintedFiles = otherPrintedFiles;
	}

	public BookPrintedFileModel() {
		super();
	}

	@Override
	public String toString() {
		return "BookPrintedFileModel [id=" + id + ", coverPagePrintedFiles=" + coverPagePrintedFiles + ", copyrightPageFiles="
				+ copyrightPageFiles + ", paymentFiles=" + paymentFiles + ", otherPrintedFiles=" + otherPrintedFiles
				+ "]";
	}
	
}
