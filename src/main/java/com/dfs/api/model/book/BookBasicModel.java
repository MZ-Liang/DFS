package com.dfs.api.model.book;

import java.io.Serializable;
import java.util.List;

import com.dfs.api.core.entity.Entity;
import com.dfs.api.model.BasicModel;
import com.dfs.api.model.RelationBasicModel;
import com.dfs.api.model.user.EditorModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图书主要信息模型
 * @author Ming
 * @date 2018年11月15日
 */
@ApiModel(value="BookBasicModel",description="图书主要信息模型")
public class BookBasicModel extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 图书名称 */
	@ApiModelProperty("图书名称")
	protected String bookName;

	/** 图书副名 */
	@ApiModelProperty("图书副名")
	protected String deputyName;
	
	/** 版次 */
	@ApiModelProperty("版次")
	protected String editionNumber;

	/** 印次 */
	@ApiModelProperty("印次")
	protected String impression;

	/** 出版号 */
	@ApiModelProperty("出版号")
	protected String isbn;

	/** 是否本地上传(0:否 1:是) */
	@ApiModelProperty("是否本地上传(0:否 1:是)")
	protected Integer localUploadFlag;
	
	/** 创建者 */
	@ApiModelProperty("创建者")
	protected BasicModel creatorBM;

	/** 更新者 */
	@ApiModelProperty("更新者")
	protected BasicModel regeneratorBM;
	
	/** 备注 */
	@ApiModelProperty("备注")
	protected String remark;
	
	/** 部门 */
	@ApiModelProperty("部门")
	protected List<RelationBasicModel> departments;
	
	/** 制作单位 */
	@ApiModelProperty("制作单位")
	protected List<RelationBasicModel> productionUnit;
	
	/** 排版单位 */
	@ApiModelProperty("排版单位")
	protected List<RelationBasicModel> typesettingUnit;
	
	/** 美术编辑 */ 
	@ApiModelProperty("美术编辑")
	protected List<EditorModel> artEditor;
	
	/** 责任编辑 */
	@ApiModelProperty("责任编辑")
	protected EditorModel executiveEditor;
	
	/** 运营编辑 */
	@ApiModelProperty("运营编辑")
	protected EditorModel operationEditor;
	
	/** 质检员 */
	@ApiModelProperty("质检员")
	protected EditorModel inspector;
	
	/** 版权经理 */
	@ApiModelProperty("版权经理")
	protected EditorModel copyrightManager;

	/**
	 * 获取图书名称
	 * @return
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * 设置图书名称
	 * @param bookName
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * 获取图书副名
	 * @return
	 */
	public String getDeputyName() {
		return deputyName;
	}

	/**
	 * 设置图书副名
	 * @param deputyName
	 */
	public void setDeputyName(String deputyName) {
		this.deputyName = deputyName;
	}

	/**
	 * 获取版次
	 * @return
	 */
	public String getEditionNumber() {
		return editionNumber;
	}

	/**
	 * 设置版次
	 * @param editionNumber
	 */
	public void setEditionNumber(String editionNumber) {
		this.editionNumber = editionNumber;
	}

	/**
	 * 获取印次
	 * @return
	 */
	public String getImpression() {
		return impression;
	}

	/**
	 * 设置印次
	 * @param impression
	 */
	public void setImpression(String impression) {
		this.impression = impression;
	}

	/**
	 * 获取出版号
	 * @return
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * 设置出版号
	 * @param isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * 获取是否本地上传(0:否 1:是)
	 * @return
	 */
	public Integer getLocalUploadFlag() {
		return localUploadFlag;
	}

	/**
	 * 设置是否本地上传(0:否 1:是)
	 * @param localUploadFlag
	 */
	public void setLocalUploadFlag(Integer localUploadFlag) {
		this.localUploadFlag = localUploadFlag;
	}

	/**
	 * 获取创建者
	 * @return
	 */
	public BasicModel getCreatorBM() {
		return creatorBM;
	}

	/**
	 * 设置创建者
	 * @param creator
	 */
	public void setCreatorBM(BasicModel creatorBM) {
		this.creatorBM = creatorBM;
	}

	/**
	 * 获取更新者
	 * @return
	 */
	public BasicModel getRegeneratorBM() {
		return regeneratorBM;
	}

	/**
	 * 设置更新者
	 * @param regenerator
	 */
	public void setRegeneratorBM(BasicModel regeneratorBM) {
		this.regeneratorBM = regeneratorBM;
	}

	/**
	 * 获取备注
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置备注
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取部门
	 * @return
	 */
	public List<RelationBasicModel> getDepartments() {
		return departments;
	}

	/**
	 * 设置部门
	 * @param departments
	 */
	public void setDepartments(List<RelationBasicModel> departments) {
		this.departments = departments;
	}

	/**
	 * 获取制作单位
	 * @return
	 */
	public List<RelationBasicModel> getProductionUnit() {
		return productionUnit;
	}

	/**
	 * 设置制作单位
	 * @param productionUnit
	 */
	public void setProductionUnit(List<RelationBasicModel> productionUnit) {
		this.productionUnit = productionUnit;
	}

	/**
	 * 获取排版单位
	 * @return
	 */
	public List<RelationBasicModel> getTypesettingUnit() {
		return typesettingUnit;
	}

	/**
	 * 设置排版单位
	 * @param typesettingUnit
	 */
	public void setTypesettingUnit(List<RelationBasicModel> typesettingUnit) {
		this.typesettingUnit = typesettingUnit;
	}

	/**
	 * 获取美术编辑
	 * @return
	 */
	public List<EditorModel> getArtEditor() {
		return artEditor;
	}

	/**
	 * 设置美术编辑
	 * @return
	 */
	public void setArtEditor(List<EditorModel> artEditor) {
		this.artEditor = artEditor;
	}

	/**
	 * 获取责任编辑 

	 * @return
	 */
	public EditorModel getExecutiveEditor() {
		return executiveEditor;
	}

	/**
	 * 设置责任编辑 

	 * @param executiveEditor
	 */
	public void setExecutiveEditor(EditorModel executiveEditor) {
		this.executiveEditor = executiveEditor;
	}

	/**
	 * 获取运营编辑
	 * @return
	 */
	public EditorModel getOperationEditor() {
		return operationEditor;
	}

	/**
	 * 设置运营编辑
	 * @param operationEditor
	 */
	public void setOperationEditor(EditorModel operationEditor) {
		this.operationEditor = operationEditor;
	}

	/**
	 * 获取质检员
	 * @return
	 */
	public EditorModel getInspector() {
		return inspector;
	}

	/**
	 * 设置质检员
	 * @param inspector
	 */
	public void setInspector(EditorModel inspector) {
		this.inspector = inspector;
	}

	/**
	 * 获取版权经理 
	 * @return
	 */
	public EditorModel getCopyrightManager() {
		return copyrightManager;
	}

	/**
	 * 设置版权经理 
	 * @param copyrightManager
	 */
	public void setCopyrightManager(EditorModel copyrightManager) {
		this.copyrightManager = copyrightManager;
	}

	public BookBasicModel() {
		super();
	}

	@Override
	public String toString() {
		return "BookBasicModel [bookName=" + bookName + ", deputyName=" + deputyName + ", editionNumber="
				+ editionNumber + ", impression=" + impression + ", isbn=" + isbn + ", localUploadFlag="
				+ localUploadFlag + ", creatorBM=" + creatorBM + ", regeneratorBM=" + regeneratorBM + ", remark=" + remark
				+ ", departments=" + departments + ", productionUnit=" + productionUnit + ", typesettingUnit="
				+ typesettingUnit + ", artEditor=" + artEditor + ", executiveEditor=" + executiveEditor
				+ ", operationEditor=" + operationEditor + ", inspector=" + inspector + ", copyrightManager="
				+ copyrightManager + ", id=" + id + "]";
	}
	
}
