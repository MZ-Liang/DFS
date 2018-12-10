package com.dfs.api.model.common;

import java.io.Serializable;

import com.dfs.api.model.BasicModel;
import com.dfs.api.model.RelationBasicModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 文件模型
 * @author Ming
 * @date 2018年11月15日
 */
@ApiModel(value="FileModel",description="文件模型")
public class FileModel extends RelationBasicModel implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 序号 */
	@ApiModelProperty("序号")
	private Integer orderNumber;

	/** 文件名 */
	@ApiModelProperty("文件名")
	private String fileName;

	/** minio桶名 */
	private String bucketName;

	/** minio对象名 */
	private String objectName;

	/** 文件大小 */
	@ApiModelProperty("文件大小")
	private String fileSize;
	
	/** 文件尺寸 */
	@ApiModelProperty("文件尺寸")
	private String fileDimension;
	
	/** 时长 */
	@ApiModelProperty("时长")
	private String duration;

	/** 状态(1:正常 0:删除) */
	@ApiModelProperty("状态(1:正常 0:删除)")
	private Integer status;

	/** 文件类型 */
	@ApiModelProperty("文件类型")
	private String fileType;

	/** 所属文件类型(1:编辑原稿 2:正文排版文件 3:封面扉页设计文件 4:设计素材文件 5:其他排版设计文件
	 *  6:条形码 7:封面扉页印刷文件 8:版权页文件 9:付型文件 10:其他印刷文件 11:封面(缩略图) 12:扉页(缩略图) 
	 *  13:PDF文件 14:EPUB文件 15:音频文件 16:视频文件 17:出版合同 18:获奖证书 19:封面) */
	@ApiModelProperty("所属文件类型(1:编辑原稿 2:正文排版文件 3:封面扉页设计文件 4:设计素材文件 5:其他排版设计文件\r\n" + 
			" 6:条形码 7:封面扉页印刷文件 8:版权页文件 9:付型文件 10:其他印刷文件 11:封面(缩略图) 12:扉页(缩略图) \r\n" + 
			" 13:PDF文件 14:EPUB文件 15:音频文件 16:视频文件 17:出版合同 18:获奖证书 19:封面)")
	private Integer documentType;

	/** 所属模块类型(1:图书 2:文集) */
	@ApiModelProperty("所属模块类型(1:图书 2:文集)")
	private Integer moduleType;

	/** 单位基础模型 */
	@ApiModelProperty("单位基础模型")
	private BasicModel unitBM;
	
	@ApiModelProperty("编辑基础模型(用户)")
	private BasicModel editor;
	
	/** 编辑类型 */
	@ApiModelProperty("编辑类型（1：责任编辑 2：美术编辑 3：运营编辑 4：质检员 5：版权经理）")
	private Integer editorType;


	/** 创建者基础模型 */
	@ApiModelProperty("创建者基础模型")
	private BasicModel creatorBM;

	/** 更新者基础模型 */
	@ApiModelProperty("更新者基础模型")
	private BasicModel regeneratorBM;

	/** 创建时间 */
	@ApiModelProperty("创建时间")
	private Long createTime;

	/** 更新时间 */
	@ApiModelProperty("更新时间")
	private Long updateTime;

	/** 删除时间 */
	@ApiModelProperty("删除时间")
	private Long deleteTime;

	/**
	 * 获取序号
	 * @return
	 */
	public Integer getOrderNumber() {
		return orderNumber;
	}

	/**
	 * 设置序号
	 * @param orderNumber
	 */
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * 取得文件名
	 * 
	 * @return 文件名
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 设定文件名
	 * 
	 * @param fileName 文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName == null ? null : fileName.trim();
	}

	/**
	 * 取得minio桶名
	 * 
	 * @return minio桶名
	 */
	public String getBucketName() {
		return bucketName;
	}

	/**
	 * 设定minio桶名
	 * 
	 * @param oldName minio桶名
	 */
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	/**
	 * 取得minio对象名
	 * 
	 * @return minio对象名
	 */
	public String getObjectName() {
		return objectName;
	}

	/**
	 * 设定minio对象名
	 * 
	 * @param objectName minio对象名
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	/**
	 * 取得文件大小
	 * 
	 * @return 文件大小
	 */
	public String getFileSize() {
		return fileSize;
	}

	/**
	 * 设定文件大小
	 * 
	 * @param fileSize 文件大小
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileDimension() {
		return fileDimension;
	}

	public void setFileDimension(String fileDimension) {
		this.fileDimension = fileDimension;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * 取得状态(1:正常 0:删除)
	 * 
	 * @return 状态(1:正常 0:删除)
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设定状态(1:正常 0:删除)
	 * 
	 * @param status 状态(1:正常 0:删除)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 取得文件类型
	 * 
	 * @return 文件类型
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * 设定文件类型
	 * 
	 * @param fileType 文件类型
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * 取得所属文件类型(1:编辑原稿 2:正文排版文件 3:封面扉页设计文件 4:设计素材文件 5:其他排版设计文件 6:条形码 7:封面扉页印刷文件 8:版权页文件 9:付型文件 10:其他印刷文件 11:封面(缩略图) 12:扉页(缩略图) 13:PD文件 14:EPUB文件 15:音频文件 16:视频文件 17:出版合同 18:获奖证书)
	 * 
	 * @return 所属文件类型(1:编辑原稿 2:正文排版文件 3:封面扉页设计文件 4:设计素材文件 5:其他排版设计文件 6:条形码 7:封面扉页印刷文件 8:版权页文件 9:付型文件 10:其他印刷文件 11:封面(缩略图) 12:扉页(缩略图) 13:PD文件 14:EPUB文件 15:音频文件 16:视频文件 17:出版合同 18:获奖证书)
	 */
	public Integer getDocumentType() {
		return documentType;
	}

	/**
	 * 设定所属文件类型(1:编辑原稿 2:正文排版文件 3:封面扉页设计文件 4:设计素材文件 5:其他排版设计文件 6:条形码 7:封面扉页印刷文件 8:版权页文件 9:付型文件 10:其他印刷文件 11:封面(缩略图) 12:扉页(缩略图) 13:PD文件 14:EPUB文件 15:音频文件 16:视频文件 17:出版合同 18:获奖证书)
	 * 
	 * @param documentType 所属文件类型(1:编辑原稿 2:正文排版文件 3:封面扉页设计文件 4:设计素材文件 5:其他排版设计文件 6:条形码 7:封面扉页印刷文件 8:版权页文件 9:付型文件 10:其他印刷文件 11:封面(缩略图) 12:扉页(缩略图) 13:PD文件 14:EPUB文件 15:音频文件 16:视频文件 17:出版合同 18:获奖证书)
	 */
	public void setDocumentType(Integer documentType) {
		this.documentType = documentType;
	}

	/**
	 * 取得所属模块类型(1:图书 2:文集)
	 * 
	 * @return 所属模块类型(1:图书 2:文集)
	 */
	public Integer getModuleType() {
		return moduleType;
	}

	/**
	 * 设定所属模块类型(1:图书 2:文集)
	 * 
	 * @param moduleType 所属模块类型(1:图书 2:文集)
	 */
	public void setModuleType(Integer moduleType) {
		this.moduleType = moduleType;
	}

	/**
	 * 取得单位
	 * 
	 * @return 单位
	 */
	public BasicModel getUnitBM() {
		return unitBM;
	}

	/**
	 * 设定单位
	 * 
	 * @param unit 单位
	 */
	public void setUnitBM(BasicModel unitBM) {
		this.unitBM = unitBM;
	}

	/**
	 * 获取编辑
	 * @return
	 */
	public BasicModel getEditor() {
		return editor;
	}

	/**
	 * 设置编辑
	 * @param editor
	 */
	public void setEditor(BasicModel editor) {
		this.editor = editor;
	}
	
	/**
	 * 获取编辑类型
	 * @return
	 */
	public Integer getEditorType() {
		return editorType;
	}

	/**
	 * 设置编辑类型
	 * @param editor
	 */
	public void setEditorType(Integer editorType) {
		this.editorType = editorType;
	}

	/**
	 * 取得创建者
	 * 
	 * @return 创建者
	 */
	public BasicModel getCreatorBM() {
		return creatorBM;
	}

	/**
	 * 设定创建者
	 * 
	 * @param creator 创建者
	 */
	public void setCreatorBM(BasicModel creatorBM) {
		this.creatorBM = creatorBM;
	}

	/**
	 * 取得更新者
	 * 
	 * @return 更新者
	 */
	public BasicModel getRegeneratorBM() {
		return regeneratorBM;
	}

	/**
	 * 设定更新者
	 * 
	 * @param regenerator 更新者
	 */
	public void setRegeneratorBM(BasicModel regeneratorBM) {
		this.regeneratorBM = regeneratorBM;
	}

	/**
	 * 取得创建时间
	 * 
	 * @return 创建时间
	 */
	public Long getCreateTime() {
		return createTime;
	}

	/**
	 * 设定创建时间
	 * 
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	/**
	 * 取得更新时间
	 * 
	 * @return 更新时间
	 */
	public Long getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设定更新时间
	 * 
	 * @param updateTime 更新时间
	 */
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 取得删除时间
	 * 
	 * @return 删除时间
	 */
	public Long getDeleteTime() {
		return deleteTime;
	}

	/**
	 * 设定删除时间
	 * 
	 * @param deleteTime 删除时间
	 */
	public void setDeleteTime(Long deleteTime) {
		this.deleteTime = deleteTime;
	}

	public FileModel() {
		super();
	}

}
