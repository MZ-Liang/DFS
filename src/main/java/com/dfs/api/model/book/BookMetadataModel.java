package com.dfs.api.model.book;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.dfs.api.model.BasicModel;
import com.dfs.api.model.ImageBasicModel;
import com.dfs.api.model.RelationBasicModel;
import com.dfs.api.model.author.AuthorBasicModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图书元数据模型
 * 
 * @author Ming
 * @date 2018年11月14日
 */
@ApiModel(value="BookMetadataModel",description="图书元数据模型")
public class BookMetadataModel extends BookBasicModel implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 图书名称(英文) */
	@ApiModelProperty("图书名称(英文)")
	private String bookNameEn;

	/** 图书副名(英文) */
	@ApiModelProperty("图书副名(英文)")
	private String deputyNameEn;

	/** 状态(0:编辑中 1:待质检 2:待通过 3:待发布 4:已发布 5:撤回重新提交) */
	@ApiModelProperty("状态(0:编辑中 1:待质检 2:待通过 3:待发布 4:已发布 5:撤回重新提交)")
	private Integer status;

	/** 错误码基础模型 */
	@ApiModelProperty("错误码基础模型")
	private BasicModel errorCodeBM;

	/** 图书类别基础模型 */
	@ApiModelProperty("图书类别基础模型")
	private BasicModel bookTypeBM;

	/** 出版机构 */
	@ApiModelProperty("出版机构")
	private String publishingInstitution;

	/** 出版地 */
	@ApiModelProperty("出版地")
	private String publishingPlace;

	/** 印刷日期 */
	@ApiModelProperty("印刷日期")
	private Long printingTime;

	/** 著作方式基础模型 */
	@ApiModelProperty("著作方式基础模型")
	private BasicModel writingmodeBM;

	/** 其它作者著作方式 */
	@ApiModelProperty("其它作者著作方式")
	private BasicModel otherWritingmodeBM;

	/** 电子版权(0:无 1:有) */
	@ApiModelProperty("电子版权(0:无 1:有)")
	private Integer ertFlag;

	/** 电子版权到期日期 */
	@ApiModelProperty("电子版权到期日期")
	private Long ertDueTime;

	/** 纸质书价格 */
	@ApiModelProperty("纸质书价格")
	private BigDecimal paperBookPrice;

	/** 电子书价格 */
	@ApiModelProperty("电子书价格")
	private BigDecimal ebookPrice;

	/** 创建时间 */
	@ApiModelProperty("创建时间")
	private Long createTime;

	/** 更新时间 */
	@ApiModelProperty("更新时间")
	private Long updateTime;

	/** 出版日期 */
	@ApiModelProperty("出版日期")
	private Long publishingTime;

	/** 发布日期 */
	@ApiModelProperty("发布日期")
	private Long issueTime;

	/** 丛书模型 */
	@ApiModelProperty("丛书模型")
	private SeriesModel seriesModel;

	/** 中图法分类号 */
	@ApiModelProperty("中图法分类号")
	private String classificationNumber;

	/** 中图法分类 */
	@ApiModelProperty("中图法分类")
	private String classification;

	/** 新书核准号 */
	@ApiModelProperty("新书核准号")
	private String newBookApprovalNumber;

	/** 数据来源 */
	@ApiModelProperty("数据来源 ")
	private BasicModel dataSourcesBM;

	/** 封面 */
	@ApiModelProperty("封面")
	private ImageBasicModel coverBM;

	/** 读者对象 */
	@ApiModelProperty("读者对象")
	private String reader;

	/** 正文用纸 */
	@ApiModelProperty("正文用纸")
	private String textPaper;

	/** 装帧 */
	@ApiModelProperty("装帧")
	private String binding;

	/** 页数 */
	@ApiModelProperty("页数")
	private Long pages;

	/** 字数 */
	@ApiModelProperty("字数")
	private String wordNumber;

	/** 包册 */
	@ApiModelProperty("包册")
	private String packageBook;

	/** 首印数 */
	@ApiModelProperty("首印数")
	private Long firstPrintNumber;

	/** 开本 */
	@ApiModelProperty("开本 ")
	private String format;

	/** 单位印张 */
	@ApiModelProperty("单位印张")
	private String unitSheet;

	/** 内容简介 */
	@ApiModelProperty("内容简介")
	private String contentIntroduction;

	/** 上架建议 */
	@ApiModelProperty("上架建议")
	private String shelfSuggestion;

	/** 前言 */
	@ApiModelProperty("前言")
	private String introduction;

	/** 目录 */
	@ApiModelProperty("目录")
	private String catalog;

	/** 广告语 */
	@ApiModelProperty("广告语")
	private String slogan;

	/** 编辑推荐 */
	@ApiModelProperty("编辑推荐")
	private String editorRecom;

	/** 媒体评论 */
	@ApiModelProperty("媒体评论")
	private String mediaCommentary;

	/** 书摘 */
	@ApiModelProperty("书摘 ")
	private String bookExtract;

	/** 作者 */
	@ApiModelProperty("作者")
	private List<AuthorBasicModel> authors;
	
	/** 其他作者 */
	@ApiModelProperty("其他作者")
	private List<AuthorBasicModel> otherAuthors;
	
	/** CIP主题词 */
	@ApiModelProperty("CIP主题词 ")
	private List<RelationBasicModel> keywords;

	/**
	 * 取得图书名称(英文)
	 * 
	 * @return 图书名称(英文)
	 */
	public String getBookNameEn() {
		return bookNameEn;
	}

	/**
	 * 设定图书名称(英文)
	 * 
	 * @param bookNameEn 图书名称(英文)
	 */
	public void setBookNameEn(String bookNameEn) {
		this.bookNameEn = bookNameEn;
	}

	/**
	 * 取得图书副名(英文)
	 * 
	 * @return 图书副名(英文)
	 */
	public String getDeputyNameEn() {
		return deputyNameEn;
	}

	/**
	 * 设定图书副名(英文)
	 * 
	 * @param deputyNameEn 图书副名(英文)
	 */
	public void setDeputyNameEn(String deputyNameEn) {
		this.deputyNameEn = deputyNameEn;
	}

	/**
	 * 取得状态(0:编辑中 1:待质检 2:待通过 3:待发布 4:已发布 5:撤回重新提交)
	 * 
	 * @return 状态(0:编辑中 1:待质检 2:待通过 3:待发布 4:已发布 5:撤回重新提交)
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设定状态(0:编辑中 1:待质检 2:待通过 3:待发布 4:已发布 5:撤回重新提交)
	 * 
	 * @param status 状态(0:编辑中 1:待质检 2:待通过 3:待发布 4:已发布 5:撤回重新提交)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 取得错误码
	 * 
	 * @return 错误码
	 */
	public BasicModel getErrorCodeBM() {
		return errorCodeBM;
	}

	/**
	 * 设定错误码
	 * 
	 * @param errorCodeBM 错误码
	 */
	public void setErrorCodeBM(BasicModel errorCodeBM) {
		this.errorCodeBM = errorCodeBM;
	}

	/**
	 * 取得图书类别
	 * 
	 * @return 图书类别
	 */
	public BasicModel getBookTypeBM() {
		return bookTypeBM;
	}

	/**
	 * 设定图书类别
	 * 
	 * @param bookTypeBM 图书类别
	 */
	public void setBookTypeBM(BasicModel bookTypeBM) {
		this.bookTypeBM = bookTypeBM;
	}

	/**
	 * 取得出版机构
	 * 
	 * @return 出版机构
	 */
	public String getPublishingInstitution() {
		return publishingInstitution;
	}

	/**
	 * 设定出版机构
	 * 
	 * @param publishingInstitution 出版机构
	 */
	public void setPublishingInstitution(String publishingInstitution) {
		this.publishingInstitution = publishingInstitution;
	}

	/**
	 * 取得出版地
	 * 
	 * @return 出版地
	 */
	public String getPublishingPlace() {
		return publishingPlace;
	}

	/**
	 * 设定出版地
	 * 
	 * @param publishingPlace 出版地
	 */
	public void setPublishingPlace(String publishingPlace) {
		this.publishingPlace = publishingPlace;
	}

	/**
	 * 取得印刷日期
	 * 
	 * @return 印刷日期
	 */
	public Long getPrintingTime() {
		return printingTime;
	}

	/**
	 * 设定印刷日期
	 * 
	 * @param printingTime 印刷日期
	 */
	public void setPrintingTime(Long printingTime) {
		this.printingTime = printingTime;
	}

	/**
	 * 取得著作方式
	 * 
	 * @return 著作方式
	 */
	public BasicModel getWritingmodeBM() {
		return writingmodeBM;
	}

	/**
	 * 设定著作方式
	 * 
	 * @param writingmode 著作方式
	 */
	public void setWritingmodeBM(BasicModel writingmodeBM) {
		this.writingmodeBM = writingmodeBM;
	}

	/**
	 * 取得其它作者著作方式
	 * 
	 * @return 其它作者著作方式
	 */
	public BasicModel getOtherWritingmodeBM() {
		return otherWritingmodeBM;
	}

	/**
	 * 设定其它作者著作方式
	 * 
	 * @param otherWritingmode 其它作者著作方式
	 */
	public void setOtherWritingmodeBM(BasicModel otherWritingmodeBM) {
		this.otherWritingmodeBM = otherWritingmodeBM;
	}

	/**
	 * 取得电子版权(0:无 1:有)
	 * 
	 * @return 电子版权(0:无 1:有)
	 */
	public Integer getErtFlag() {
		return ertFlag;
	}

	/**
	 * 设定电子版权(0:无 1:有)
	 * 
	 * @param ertFlag 电子版权(0:无 1:有)
	 */
	public void setErtFlag(Integer ertFlag) {
		this.ertFlag = ertFlag;
	}

	/**
	 * 取得电子版权到期日期
	 * 
	 * @return 电子版权到期日期
	 */
	public Long getErtDueTime() {
		return ertDueTime;
	}

	/**
	 * 设定电子版权到期日期
	 * 
	 * @param ertDueTime 电子版权到期日期
	 */
	public void setErtDueTime(Long ertDueTime) {
		this.ertDueTime = ertDueTime;
	}

	/**
	 * 取得纸质书价格
	 * 
	 * @return 纸质书价格
	 */
	public BigDecimal getPaperBookPrice() {
		return paperBookPrice;
	}

	/**
	 * 设定纸质书价格
	 * 
	 * @param paperBookPrice 纸质书价格
	 */
	public void setPaperBookPrice(BigDecimal paperBookPrice) {
		this.paperBookPrice = paperBookPrice;
	}

	/**
	 * 取得电子书价格
	 * 
	 * @return 电子书价格
	 */
	public BigDecimal getEbookPrice() {
		return ebookPrice;
	}

	/**
	 * 设定电子书价格
	 * 
	 * @param ebookPrice 电子书价格
	 */
	public void setEbookPrice(BigDecimal ebookPrice) {
		this.ebookPrice = ebookPrice;
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
	 * 取得出版日期
	 * 
	 * @return 出版日期
	 */
	public Long getPublishingTime() {
		return publishingTime;
	}

	/**
	 * 设定出版日期
	 * 
	 * @param publishingTime 出版日期
	 */
	public void setPublishingTime(Long publishingTime) {
		this.publishingTime = publishingTime;
	}

	/**
	 * 取得发布日期
	 * 
	 * @return 发布日期
	 */
	public Long getIssueTime() {
		return issueTime;
	}

	/**
	 * 设定发布日期
	 * 
	 * @param issueTime 发布日期
	 */
	public void setIssueTime(Long issueTime) {
		this.issueTime = issueTime;
	}

	/**
	 * 取得中图法分类号
	 * 
	 * @return 中图法分类号
	 */
	public String getClassificationNumber() {
		return classificationNumber;
	}

	/**
	 * 设定中图法分类号
	 * 
	 * @param classificationNumber 中图法分类号
	 */
	public void setClassificationNumber(String classificationNumber) {
		this.classificationNumber = classificationNumber;
	}

	/**
	 * 取得中图法分类
	 * 
	 * @return 中图法分类
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * 设定中图法分类
	 * 
	 * @param classification 中图法分类
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}

	/**
	 * 取得新书核准号
	 * 
	 * @return 新书核准号
	 */
	public String getNewBookApprovalNumber() {
		return newBookApprovalNumber;
	}

	/**
	 * 设定新书核准号
	 * 
	 * @param newBookApprovalNumber 新书核准号
	 */
	public void setNewBookApprovalNumber(String newBookApprovalNumber) {
		this.newBookApprovalNumber = newBookApprovalNumber;
	}

	/**
	 * 取得数据来源
	 * 
	 * @return 数据来源
	 */
	public BasicModel getDataSourcesBM() {
		return dataSourcesBM;
	}

	/**
	 * 设定数据来源
	 * 
	 * @param dataSourcesBM 数据来源
	 */
	public void setDataSourcesBM(BasicModel dataSourcesBM) {
		this.dataSourcesBM = dataSourcesBM;
	}

	/**
	 * 取得封面
	 * 
	 * @return 封面
	 */
	public ImageBasicModel getCoverBM() {
		return coverBM;
	}

	/**
	 * 设定封面
	 * 
	 * @param cover 封面
	 */
	public void setCoverBM(ImageBasicModel coverBM) {
		this.coverBM = coverBM;
	}

	/**
	 * 取得读者对象
	 * 
	 * @return 读者对象
	 */
	public String getReader() {
		return reader;
	}

	/**
	 * 设定读者对象
	 * 
	 * @param reader 读者对象
	 */
	public void setReader(String reader) {
		this.reader = reader;
	}

	/**
	 * 取得正文用纸
	 * 
	 * @return 正文用纸
	 */
	public String getTextPaper() {
		return textPaper;
	}

	/**
	 * 设定正文用纸
	 * 
	 * @param textPaper 正文用纸
	 */
	public void setTextPaper(String textPaper) {
		this.textPaper = textPaper;
	}

	/**
	 * 取得装帧
	 * 
	 * @return 装帧
	 */
	public String getBinding() {
		return binding;
	}

	/**
	 * 设定装帧
	 * 
	 * @param binding 装帧
	 */
	public void setBinding(String binding) {
		this.binding = binding;
	}

	/**
	 * 取得页数
	 * 
	 * @return 页数
	 */
	public Long getPages() {
		return pages;
	}

	/**
	 * 设定页数
	 * 
	 * @param pages 页数
	 */
	public void setPages(Long pages) {
		this.pages = pages;
	}

	/**
	 * 取得字数
	 * 
	 * @return
	 */
	public String getWordNumber() {
		return wordNumber;
	}

	/**
	 * 设定字数
	 * 
	 * @param wordNumber
	 */
	public void setWordNumber(String wordNumber) {
		this.wordNumber = wordNumber;
	}

	/**
	 * 取得包册
	 * 
	 * @return 包册
	 */
	public String getPackageBook() {
		return packageBook;
	}

	/**
	 * 设定包册
	 * 
	 * @param packageBook 包册
	 */
	public void setPackageBook(String packageBook) {
		this.packageBook = packageBook;
	}

	/**
	 * 取得首印数
	 * 
	 * @return 首印数
	 */
	public Long getFirstPrintNumber() {
		return firstPrintNumber;
	}

	/**
	 * 设定首印数
	 * 
	 * @param firstPrintNumber 首印数
	 */
	public void setFirstPrintNumber(Long firstPrintNumber) {
		this.firstPrintNumber = firstPrintNumber;
	}

	/**
	 * 取得开本
	 * 
	 * @return 开本
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * 设定开本
	 * 
	 * @param format 开本
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * 取得单位印张
	 * 
	 * @return 单位印张
	 */
	public String getUnitSheet() {
		return unitSheet;
	}

	/**
	 * 设定单位印张
	 * 
	 * @param unitSheet 单位印张
	 */
	public void setUnitSheet(String unitSheet) {
		this.unitSheet = unitSheet;
	}

	/**
	 * 取得内容简介
	 * 
	 * @return 内容简介
	 */
	public String getContentIntroduction() {
		return contentIntroduction;
	}

	/**
	 * 设定内容简介
	 * 
	 * @param contentIntroduction 内容简介
	 */
	public void setContentIntroduction(String contentIntroduction) {
		this.contentIntroduction = contentIntroduction;
	}

	/**
	 * 取得上架建议
	 * 
	 * @return 上架建议
	 */
	public String getShelfSuggestion() {
		return shelfSuggestion;
	}

	/**
	 * 设定上架建议
	 * 
	 * @param shelfSuggestion 上架建议
	 */
	public void setShelfSuggestion(String shelfSuggestion) {
		this.shelfSuggestion = shelfSuggestion;
	}

	/**
	 * 取得前言
	 * 
	 * @return
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * 设定前言
	 * 
	 * @param introduction
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * 取得目录
	 * 
	 * @return 目录
	 */
	public String getCatalog() {
		return catalog;
	}

	/**
	 * 设定目录
	 * 
	 * @param catalog 目录
	 */
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	/**
	 * 取得广告语
	 * 
	 * @return 广告语
	 */
	public String getSlogan() {
		return slogan;
	}

	/**
	 * 设定广告语
	 * 
	 * @param slogan 广告语
	 */
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	/**
	 * 取得编辑推荐
	 * 
	 * @return 编辑推荐
	 */
	public String getEditorRecom() {
		return editorRecom;
	}

	/**
	 * 设定编辑推荐
	 * 
	 * @param editorRecom 编辑推荐
	 */
	public void setEditorRecom(String editorRecom) {
		this.editorRecom = editorRecom;
	}

	/**
	 * 取得媒体评论
	 * 
	 * @return 媒体评论
	 */
	public String getMediaCommentary() {
		return mediaCommentary;
	}

	/**
	 * 设定媒体评论
	 * 
	 * @param mediaCommentary 媒体评论
	 */
	public void setMediaCommentary(String mediaCommentary) {
		this.mediaCommentary = mediaCommentary;
	}

	/**
	 * 取得书摘
	 * 
	 * @return 书摘
	 */
	public String getBookExtract() {
		return bookExtract;
	}

	/**
	 * 设定书摘
	 * 
	 * @param bookExtract 书摘
	 */
	public void setBookExtract(String bookExtract) {
		this.bookExtract = bookExtract;
	}
	
	/**
	 * 获取作者
	 * @return
	 */
	public List<AuthorBasicModel> getAuthors() {
		return authors;
	}

	/**
	 * 设置作者
	 * @param authors
	 */
	public void setAuthors(List<AuthorBasicModel> authors) {
		this.authors = authors;
	}

	/**
	 * 获取其他作者
	 * @return
	 */
	public List<AuthorBasicModel> getOtherAuthors() {
		return otherAuthors;
	}

	/**
	 * 设置其他作者
	 * @param otherAuthors
	 */
	public void setOtherAuthors(List<AuthorBasicModel> otherAuthors) {
		this.otherAuthors = otherAuthors;
	}

	/**
	 * 获取CIP主题词
	 * @return
	 */
	public List<RelationBasicModel> getKeywords() {
		return keywords;
	}

	/**
	 * 设置CIP主题词
	 * @return
	 */
	public void setKeywords(List<RelationBasicModel> keywords) {
		this.keywords = keywords;
	}
	
	/**
	 * 获取丛书模型
	 * @return
	 */
	public SeriesModel getSeriesModel() {
		return seriesModel;
	}

	/**
	 * 设置丛书模型
	 * @param seriesModel
	 */
	public void setSeriesModel(SeriesModel seriesModel) {
		this.seriesModel = seriesModel;
	}

	public BookMetadataModel() {
		super();
	}

	@Override
	public String toString() {
		return "BookMetadataModel [bookNameEn=" + bookNameEn + ", deputyNameEn=" + deputyNameEn + ", status=" + status
				+ ", errorCodeBM=" + errorCodeBM + ", bookTypeBM=" + bookTypeBM + ", publishingInstitution="
				+ publishingInstitution + ", publishingPlace=" + publishingPlace + ", printingTime=" + printingTime
				+ ", writingmodeBM=" + writingmodeBM + ", otherWritingmodeBM=" + otherWritingmodeBM + ", ertFlag="
				+ ertFlag + ", ertDueTime=" + ertDueTime + ", paperBookPrice=" + paperBookPrice + ", ebookPrice="
				+ ebookPrice + ", createTime=" + createTime + ", updateTime=" + updateTime + ", publishingTime="
				+ publishingTime + ", issueTime=" + issueTime + ", seriesModel=" + seriesModel + ", classificationNumber="
				+ classificationNumber + ", classification=" + classification + ", newBookApprovalNumber="
				+ newBookApprovalNumber + ", dataSourcesBM=" + dataSourcesBM + ", coverBM=" + coverBM + ", reader=" + reader
				+ ", textPaper=" + textPaper + ", binding=" + binding + ", pages=" + pages + ", wordNumber="
				+ wordNumber + ", packageBook=" + packageBook + ", firstPrintNumber=" + firstPrintNumber + ", format="
				+ format + ", unitSheet=" + unitSheet + ", contentIntroduction=" + contentIntroduction
				+ ", shelfSuggestion=" + shelfSuggestion + ", introduction=" + introduction + ", catalog=" + catalog
				+ ", slogan=" + slogan + ", editorRecom=" + editorRecom + ", mediaCommentary=" + mediaCommentary
				+ ", bookExtract=" + bookExtract + ", authors=" + authors + ", otherAuthors=" + otherAuthors
				+ ", keywords=" + keywords + ", bookName=" + bookName + ", deputyName=" + deputyName
				+ ", editionNumber=" + editionNumber + ", impression=" + impression + ", isbn=" + isbn
				+ ", localUploadFlag=" + localUploadFlag + ", creator=" + creatorBM + ", regenerator=" + regeneratorBM
				+ ", remark=" + remark + ", departments=" + departments + ", productionUnit=" + productionUnit
				+ ", typesettingUnit=" + typesettingUnit + ", artEditor=" + artEditor + ", executiveEditor="
				+ executiveEditor + ", operationEditor=" + operationEditor + ", inspector=" + inspector
				+ ", copyrightManager=" + copyrightManager + ", id=" + id + "]";
	}

}
