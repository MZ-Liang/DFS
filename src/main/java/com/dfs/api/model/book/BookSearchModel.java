package com.dfs.api.model.book;

import java.io.Serializable;
import java.util.List;

import com.dfs.api.core.entity.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图书搜索模型
 * @author Ming
 * @date 2018年11月16日
 */
@ApiModel(value="BookSearchModel",description="图书搜索模型")
public class BookSearchModel extends Entity implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 搜索词类型 */
	@ApiModelProperty("搜索词类型(1:书名 2：简介 3：作者名称)")
	private Integer searchType;
	/** 搜索词 */
	@ApiModelProperty("搜索词")
	private String searchWord;
	/** 出版号 */
	@ApiModelProperty("出版号")
	private String isbn;
	/** 出版地 */
	@ApiModelProperty("出版地")
	private String publishingPlace;
	/** 中图法分类号 */
	@ApiModelProperty("中图法分类号")
	private String classificationNumber;
	/** 丛书名称 */
	@ApiModelProperty("丛书名称")
	private Long seriesName;
	/** 丛书责任者 */
	@ApiModelProperty("丛书责任者")
	private String seriesExecutor;
	/** 错误码id */
	@ApiModelProperty("错误码id")
	private Long errorCode;
	/** 状态(0:编辑中 1:待质检 2:待通过 3:待发布 4:已发布 5:撤回重新提交) */
	@ApiModelProperty("状态(0:编辑中 1:待质检 2:待通过 3:待发布 4:已发布 5:撤回重新提交)")
	private Integer status;
	/** 电子版权(0:无  1:有) */
	@ApiModelProperty("电子版权(0:无  1:有)")
	private Integer ertFlag;
	/** 电子版权到期日期 */
	@ApiModelProperty("电子版权到期日期")
	private Long ertDueTime;
	/** 版次 */
	@ApiModelProperty("版次")
	private String editionNumber;
	/** 印次 */
	@ApiModelProperty("印次")
	private String impression;
	/** 出版机构 */
	@ApiModelProperty("出版机构")
	private String publishingInstitution;
	/** 更新时间 */
	@ApiModelProperty("更新时间")
	private Long updateTime;
	/** 出版日期 */
	@ApiModelProperty("出版日期")
	private Long publishingTime;
	/** 发布日期 */
	@ApiModelProperty("发布日期")
	private Long issueTime;
	/** 主题词 */
	@ApiModelProperty("主题词")
	private List<String> keywords;
	/** 数据来源id */
	@ApiModelProperty("数据来源id")
	private Long dataSourceId;
	/** 排版单位id */
	@ApiModelProperty("排版单位id")
	private Long typesettingUnitId;
	/** 制作单位id */
	@ApiModelProperty("制作单位id")
	private Long productionUnitId;
	/** 所属部门 id*/
	@ApiModelProperty("所属部门 id")
	private Long departmentId;
	/** 责任编辑id */
	@ApiModelProperty("责任编辑id")
	private Long executiveEditorId;
	/** 美术编辑id */
	@ApiModelProperty("美术编辑id")
	private Long artEditorId;
	/** 质检员id */
	@ApiModelProperty("质检员id")
	private Long inspectorId;
	/** 运营编辑id */
	@ApiModelProperty("运营编辑id")
	private Long operationEditorId;
	/** 版权经理id */
	@ApiModelProperty("版权经理id")
	private Long copyrightManagerId;
	
	public Integer getSearchType() {
		return searchType;
	}
	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublishingPlace() {
		return publishingPlace;
	}
	public void setPublishingPlace(String publishingPlace) {
		this.publishingPlace = publishingPlace;
	}
	public String getClassificationNumber() {
		return classificationNumber;
	}
	public void setClassificationNumber(String classificationNumber) {
		this.classificationNumber = classificationNumber;
	}
	public Long getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(Long seriesName) {
		this.seriesName = seriesName;
	}
	public String getSeriesExecutor() {
		return seriesExecutor;
	}
	public void setSeriesExecutor(String seriesExecutor) {
		this.seriesExecutor = seriesExecutor;
	}
	public Long getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Long errorCode) {
		this.errorCode = errorCode;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getErtFlag() {
		return ertFlag;
	}
	public void setErtFlag(Integer ertFlag) {
		this.ertFlag = ertFlag;
	}
	public Long getErtDueTime() {
		return ertDueTime;
	}
	public void setErtDueTime(Long ertDueTime) {
		this.ertDueTime = ertDueTime;
	}
	public String getEditionNumber() {
		return editionNumber;
	}
	public void setEditionNumber(String editionNumber) {
		this.editionNumber = editionNumber;
	}
	public String getImpression() {
		return impression;
	}
	public void setImpression(String impression) {
		this.impression = impression;
	}
	public String getPublishingInstitution() {
		return publishingInstitution;
	}
	public void setPublishingInstitution(String publishingInstitution) {
		this.publishingInstitution = publishingInstitution;
	}
	public Long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	public Long getPublishingTime() {
		return publishingTime;
	}
	public void setPublishingTime(Long publishingTime) {
		this.publishingTime = publishingTime;
	}
	public Long getIssueTime() {
		return issueTime;
	}
	public void setIssueTime(Long issueTime) {
		this.issueTime = issueTime;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public Long getDataSourceId() {
		return dataSourceId;
	}
	public void setDataSourceId(Long dataSourceId) {
		this.dataSourceId = dataSourceId;
	}
	public Long getTypesettingUnitId() {
		return typesettingUnitId;
	}
	public void setTypesettingUnitId(Long typesettingUnitId) {
		this.typesettingUnitId = typesettingUnitId;
	}
	public Long getProductionUnitId() {
		return productionUnitId;
	}
	public void setProductionUnitId(Long productionUnitId) {
		this.productionUnitId = productionUnitId;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Long getExecutiveEditorId() {
		return executiveEditorId;
	}
	public void setExecutiveEditorId(Long executiveEditorId) {
		this.executiveEditorId = executiveEditorId;
	}
	public Long getArtEditorId() {
		return artEditorId;
	}
	public void setArtEditorId(Long artEditorId) {
		this.artEditorId = artEditorId;
	}
	public Long getInspectorId() {
		return inspectorId;
	}
	public void setInspectorId(Long inspectorId) {
		this.inspectorId = inspectorId;
	}
	public Long getOperationEditorId() {
		return operationEditorId;
	}
	public void setOperationEditorId(Long operationEditorId) {
		this.operationEditorId = operationEditorId;
	}
	public Long getCopyrightManagerId() {
		return copyrightManagerId;
	}
	public void setCopyrightManagerId(Long copyrightManagerId) {
		this.copyrightManagerId = copyrightManagerId;
	}
	
	public BookSearchModel() {
		super();
	}
	
	@Override
	public String toString() {
		return "BookSearchModel [searchType=" + searchType + ", searchWord=" + searchWord + ", isbn=" + isbn
				+ ", publishingPlace=" + publishingPlace + ", classificationNumber=" + classificationNumber
				+ ", seriesName=" + seriesName + ", seriesExecutor=" + seriesExecutor + ", errorCode=" + errorCode
				+ ", status=" + status + ", ertFlag=" + ertFlag + ", ertDueTime=" + ertDueTime + ", editionNumber="
				+ editionNumber + ", impression=" + impression + ", publishingInstitution=" + publishingInstitution
				+ ", updateTime=" + updateTime + ", publishingTime=" + publishingTime + ", issueTime=" + issueTime
				+ ", keywords=" + keywords + ", dataSourceId=" + dataSourceId + ", typesettingUnitId="
				+ typesettingUnitId + ", productionUnitId=" + productionUnitId + ", departmentId=" + departmentId
				+ ", executiveEditorId=" + executiveEditorId + ", artEditorId=" + artEditorId + ", inspectorId="
				+ inspectorId + ", operationEditorId=" + operationEditorId + ", copyrightManagerId="
				+ copyrightManagerId + ", id=" + id + "]";
	}
	
}
