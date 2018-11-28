package com.dfs.api.model.book;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.dfs.api.core.entity.Entity;
import com.dfs.api.model.RelationBasicModel;
import com.dfs.api.model.author.AuthorBasicModel;
import com.dfs.api.model.user.EditorModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图书基本信息模型
 * @author Ming
 * @date 2018年11月16日
 */
@ApiModel(value="BookBasicInfoModel",description="图书基本信息模型")
public class BookBasicInfoModel  extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 图书名称 */
	@ApiModelProperty("图书名称")
	protected String bookName;
	
	/** 状态(0:编辑中 1:待质检 2:待通过 3:待发布 4:已发布 5:撤回重新提交) */
	@ApiModelProperty("状态(0:编辑中 1:待质检 2:待通过 3:待发布 4:已发布 5:撤回重新提交)")
	private Integer status;
	
	/** 纸质书价格 */
	@ApiModelProperty("纸质书价格")
	private BigDecimal paperBookPrice;
	
	/** 作者 */
	@ApiModelProperty("作者")
	private List<AuthorBasicModel> authors;
	
	/** 部门 */
	@ApiModelProperty("部门")
	protected List<RelationBasicModel> departments;
	
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getPaperBookPrice() {
		return paperBookPrice;
	}

	public void setPaperBookPrice(BigDecimal paperBookPrice) {
		this.paperBookPrice = paperBookPrice;
	}

	public List<AuthorBasicModel> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorBasicModel> authors) {
		this.authors = authors;
	}

	public BookBasicInfoModel() {
		super();
	}

	@Override
	public String toString() {
		return "BookBasicInfoModel [bookName=" + bookName + ", status=" + status + ", paperBookPrice=" + paperBookPrice
				+ ", authors=" + authors + ", departments=" + departments + ", typesettingUnit=" + typesettingUnit
				+ ", artEditor=" + artEditor + ", executiveEditor=" + executiveEditor + ", operationEditor="
				+ operationEditor + ", inspector=" + inspector + ", id=" + id + "]";
	}

}
