package com.dfs.api.entity.common;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 文件表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class FileEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 文件名 */
	private String fileName;

	/** minio桶名 */
	private String bucketName;

	/** minio对象名 */
	private String objectName;

	/** 文件大小 */
	private String fileSize;

	/** 状态(1:正常 0:删除) */
	private Integer status;

	/** 文件类型 */
	private String fileType;

	/** 所属文件类型(1:编辑原稿 2:正文排版文件 3:封面扉页设计文件 4:设计素材文件 5:其他排版设计文件
	 *  6:条形码 7:封面扉页印刷文件 8:版权页文件 9:付型文件 10:其他印刷文件 11:封面(缩略图) 12:扉页(缩略图) 
	 *  13:PD文件 14:EPUB文件 15:音频文件 16:视频文件 17:出版合同 18:获奖证书) */
	private Integer documentType;

	/** 所属模块类型(1:图书 2:文集) */
	private Integer moduleType;

	/** 单位 */
	private Long unit;
	
	/** 编辑id（用户） */
	private Long editorId;
	
	/** 编辑类型（1：责任编辑 2：美术编辑 3：运营编辑 4：质检员 5：版权经理） */
	private Integer eidtorType;

	/** 创建者 */
	private Long creator;

	/** 更新者 */
	private Long regenerator;

	/** 创建时间 */
	private Long createTime;

	/** 更新时间 */
	private Long updateTime;

	/** 删除时间 */
	private Long deleteTime;

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
		this.fileName = fileName;
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
	public Long getUnit() {
		return unit;
	}

	/**
	 * 设定单位
	 * 
	 * @param unit 单位
	 */
	public void setUnit(Long unit) {
		this.unit = unit;
	}

	/**
	 * 获取编辑id
	 * @return
	 */
	public Long getEditorId() {
		return editorId;
	}

	/**
	 * 设置编辑id
	 * @param editorId
	 */
	public void setEditorId(Long editorId) {
		this.editorId = editorId;
	}

	/**
	 * 获取编辑类型（1：责任编辑 2：美术编辑 3：运营编辑 4：质检员 5：版权经理）
	 * @return
	 */
	public Integer getEidtorType() {
		return eidtorType;
	}

	/**
	 * 设置编辑类型（1：责任编辑 2：美术编辑 3：运营编辑 4：质检员 5：版权经理）
	 * @param eidtorType
	 */
	public void setEidtorType(Integer eidtorType) {
		this.eidtorType = eidtorType;
	}

	/**
	 * 取得创建者
	 * 
	 * @return 创建者
	 */
	public Long getCreator() {
		return creator;
	}

	/**
	 * 设定创建者
	 * 
	 * @param creator 创建者
	 */
	public void setCreator(Long creator) {
		this.creator = creator;
	}

	/**
	 * 取得更新者
	 * 
	 * @return 更新者
	 */
	public Long getRegenerator() {
		return regenerator;
	}

	/**
	 * 设定更新者
	 * 
	 * @param regenerator 更新者
	 */
	public void setRegenerator(Long regenerator) {
		this.regenerator = regenerator;
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

	/**
	 * 取得文件表实体字符串
	 * 
	 * @return 文件表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", fileName=").append(fileName);
		sb.append(", bucketName=").append(bucketName);
		sb.append(", objectName=").append(objectName);
		sb.append(", fileSize=").append(fileSize);
		sb.append(", status=").append(status);
		sb.append(", fileType=").append(fileType);
		sb.append(", documentType=").append(documentType);
		sb.append(", moduleType=").append(moduleType);
		sb.append(", unit=").append(unit);
		sb.append(", creator=").append(creator);
		sb.append(", regenerator=").append(regenerator);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", deleteTime=").append(deleteTime);
		sb.append("]");
		return sb.toString();
	}
}