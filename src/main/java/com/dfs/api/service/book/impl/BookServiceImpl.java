package com.dfs.api.service.book.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.api.constant.AuthorConstant;
import com.dfs.api.constant.EditorType;
import com.dfs.api.constant.FileType;
import com.dfs.api.constant.TypeConstant;
import com.dfs.api.constant.UnitType;
import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.core.service.impl.SimpleServiceImpl;
import com.dfs.api.entity.book.BookAuthorEntity;
import com.dfs.api.entity.book.BookDepartmentEntity;
import com.dfs.api.entity.book.BookEditorEntity;
import com.dfs.api.entity.book.BookEntity;
import com.dfs.api.entity.book.BookKeywordEntity;
import com.dfs.api.entity.book.BookUnitEntity;
import com.dfs.api.mapper.author.AuthorMapper;
import com.dfs.api.mapper.author.WritingmodeMapper;
import com.dfs.api.mapper.book.BookAuthorMapper;
import com.dfs.api.mapper.book.BookDepartmentMapper;
import com.dfs.api.mapper.book.BookEditorMapper;
import com.dfs.api.mapper.book.BookKeywordMapper;
import com.dfs.api.mapper.book.BookMapper;
import com.dfs.api.mapper.book.BookUnitMapper;
import com.dfs.api.mapper.common.DataSourceMapper;
import com.dfs.api.mapper.common.DepartmentMapper;
import com.dfs.api.mapper.common.ErrorCodeMapper;
import com.dfs.api.mapper.common.KeywordMapper;
import com.dfs.api.mapper.common.TypeMapper;
import com.dfs.api.mapper.common.UnitMapper;
import com.dfs.api.mapper.user.UserMapper;
import com.dfs.api.model.PageInfo;
import com.dfs.api.model.RelationBasicModel;
import com.dfs.api.model.author.AuthorBasicModel;
import com.dfs.api.model.book.BookAwardsFileModel;
import com.dfs.api.model.book.BookBasicInfoModel;
import com.dfs.api.model.book.BookBasicModel;
import com.dfs.api.model.book.BookCopyrightFileModel;
import com.dfs.api.model.book.BookDigitalFileModel;
import com.dfs.api.model.book.BookMetadataModel;
import com.dfs.api.model.book.BookMultimediaFileModel;
import com.dfs.api.model.book.BookPrintedFileModel;
import com.dfs.api.model.book.BookSearchModel;
import com.dfs.api.model.book.BookTypesettingFileModel;
import com.dfs.api.model.user.EditorModel;
import com.dfs.api.service.book.BookService;
import com.dfs.api.service.book.SeriesService;
import com.dfs.api.service.common.FileService;
import com.dfs.api.util.CalendarUtility;
import com.dfs.api.util.ShiroUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 图书服务
 * 
 * @author Ming
 * @date 2018年11月5日
 */
@Service
public class BookServiceImpl extends SimpleServiceImpl<Long, BookEntity> implements BookService {
	/** 图书 mapper */
	@Autowired
	private BookMapper bookMapper;
	/** 部门mapper */
	@Autowired
	private DepartmentMapper departmentMapper;
	/** 作者mapper */
	@Autowired
	private AuthorMapper authorMapper;
	/** 用户mapper */
	@Autowired
	private UserMapper userMapper;
	/** 单位mapper */
	@Autowired
	private UnitMapper unitMapper;
	/** 文件服务 */
	@Autowired
	private FileService fileService;
	/** 错误码mapper */
	@Autowired
	private ErrorCodeMapper errorCodeMapper;
	/** 类别mapper */
	@Autowired
	private TypeMapper typeMapper;
	/** 著作方式基础模型mapper */
	@Autowired
	private WritingmodeMapper writingmodeMapper;
	/** 丛书服务 */
	@Autowired
	private SeriesService seriesService;
	/** 数据来源mapper */
	@Autowired
	private DataSourceMapper dataSourceMapper;
	/** CIP主题词mapper */
	@Autowired
	private KeywordMapper keywordMapper;
	/** 图书与部门关联mapper */
	@Autowired
	private BookDepartmentMapper bookDepartmentMapper;
	/** 图书与单位关联mapper */
	@Autowired
	private BookUnitMapper bookUnitMapper;
	/** 图书与编辑关联mapper */
	@Autowired
	private BookEditorMapper bookEditorMapper;
	/** 图书与作者关联mapper */
	@Autowired
	private BookAuthorMapper bookAuthorMapper;
	/** 图书与主题词关联mapper */
	@Autowired
	private BookKeywordMapper bookKeywordMapper;

	@Override
	protected SimpleMapper<Long, BookEntity> getMapper() {
		return bookMapper;
	}

	/**
	 * 根据条件分页查询图书
	 * 
	 * @param condition 查询条件
	 * @param page      分页条件
	 * @return
	 */
	@Override
	public PageInfo<BookBasicInfoModel> list(BookSearchModel condition, Page<BookBasicInfoModel> page) {
		// 分页，统计
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		// 查询
		List<BookBasicInfoModel> list = bookMapper.searchBookBasicInfo(condition);
		// 遍历结果，封装数据
		for (BookBasicInfoModel model : list) {
			// 设置关联作者
			model.setAuthors(authorMapper.getBasicModelByBookId(model.getId(), AuthorConstant.OTHER_FLAG_0));
			// 设置关联部门
			model.setDepartments(bookDepartmentMapper.getRelationBasicModelByBookId(model.getId()));
			// 设置关联排版单位
			model.setTypesettingUnit(bookUnitMapper.getRelationtBasicModelByBookId(model.getId(), UnitType.TYPESETTING_UNIT));
			// 设置关联美术编辑
			model.setArtEditor(userMapper.getEditorModelByBookIdAndEditorType(model.getId(), EditorType.ART_EDITOR));

			// 编辑基础模型
			List<EditorModel> bms = null;

			// 获取责任编辑
			bms = userMapper.getEditorModelByBookIdAndEditorType(model.getId(), EditorType.EXECUTIVE_EDITOR);
			// 设置责任编辑
			model.setExecutiveEditor(CollectionUtils.isEmpty(bms) ? null : bms.get(0));

			// 获取运营编辑
			bms = userMapper.getEditorModelByBookIdAndEditorType(model.getId(), EditorType.OPERATION_EDITOR);
			// 设置运营编辑
			model.setOperationEditor(CollectionUtils.isEmpty(bms) ? null : bms.get(0));

			// 获取质检员
			bms = userMapper.getEditorModelByBookIdAndEditorType(model.getId(), EditorType.INSPECTOR);
			// 设置质检员
			model.setInspector(CollectionUtils.isEmpty(bms) ? null : bms.get(0));
		}
		return new PageInfo<>(list);
	}

	/**
	 * 封装图书主要信息实体模型
	 * 
	 * @param model  已有基础数据的模型对象
	 * @param entity 图书实体
	 */
	private void pottingModel(BookBasicModel model, BookEntity entity) {
		// 设置创建者
		model.setCreatorBM(userMapper.getBasicModel(entity.getCreator()));
		// 设置更新者
		model.setRegeneratorBM(userMapper.getBasicModel(entity.getRegenerator()));
		// 设置部门
		model.setDepartments(bookDepartmentMapper.getRelationBasicModelByBookId(entity.getId()));
		// 设置制作单位
		model.setProductionUnit(bookUnitMapper.getRelationtBasicModelByBookId(entity.getId(), UnitType.PRODUCTION_UNIT));
		// 设置排版单位
		model.setTypesettingUnit(bookUnitMapper.getRelationtBasicModelByBookId(entity.getId(), UnitType.TYPESETTING_UNIT));
		// 设置美术编辑
		model.setArtEditor(userMapper.getEditorModelByBookIdAndEditorType(entity.getId(), EditorType.ART_EDITOR));

		// 编辑基础模型
		List<EditorModel> list = null;

		// 获取责任编辑
		list = userMapper.getEditorModelByBookIdAndEditorType(entity.getId(), EditorType.EXECUTIVE_EDITOR);
		// 设置责任编辑
		model.setExecutiveEditor(CollectionUtils.isEmpty(list) ? null : list.get(0));

		// 获取运营编辑
		list = userMapper.getEditorModelByBookIdAndEditorType(entity.getId(), EditorType.OPERATION_EDITOR);
		// 设置运营编辑
		model.setOperationEditor(CollectionUtils.isEmpty(list) ? null : list.get(0));

		// 获取质检员
		list = userMapper.getEditorModelByBookIdAndEditorType(entity.getId(), EditorType.INSPECTOR);
		// 设置质检员
		model.setInspector(CollectionUtils.isEmpty(list) ? null : list.get(0));

		// 获取版权经理
		list = userMapper.getEditorModelByBookIdAndEditorType(entity.getId(), EditorType.COPYRIGHT_MANAGER);
		// 设置版权经理
		model.setCopyrightManager(CollectionUtils.isEmpty(list) ? null : list.get(0));
	}

	/**
	 * 获取图书主要信息
	 * 
	 * @param id 图书id
	 * @return 图书主要信息模型
	 */
	@Override
	public BookBasicModel getDetailMessage(Long id) {
		// 图书基础信息查询
		BookEntity entity = bookMapper.getBasicModel(id);
		// 创建模型
		BookBasicModel basicModel = new BookBasicModel();
		if (entity != null) {
			// 属性复制
			BeanUtils.copyProperties(entity, basicModel);
			// 封装主要实体模型
			this.pottingModel(basicModel, entity);
		}
		return basicModel;
	}

	/**
	 * 获取图书排版文件模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	@Override
	public BookTypesettingFileModel getTypesettingFiles(Long id) {
		// 创建模型
		BookTypesettingFileModel model = new BookTypesettingFileModel();
		// 设置编辑原稿
		model.setEditManuscripts(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_1));
		// 设置正文排版文件
		model.setTextFypesettingFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_2));
		// 设置封面扉页设计文件
		model.setCoverPageDesignFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_3));
		// 设置设计素材文件
		model.setDesignMaterialFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_4));
		// 设置其他排版设计文件
		model.setOtherTypesettingFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_5));
		// 设置条形码
		model.setEditManuscripts(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_6));

		return model;
	}

	/**
	 * 获取图书印刷文件模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	@Override
	public BookPrintedFileModel getPrintedFiles(Long id) {
		// 创建模型
		BookPrintedFileModel model = new BookPrintedFileModel();
		// 设置封面扉页印刷文件
		model.setCoverPagePrintedFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_7));
		// 设置版权页文件
		model.setCopyrightPageFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_8));
		// 设置付型文件
		model.setPaymentFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_9));
		// 设置其他印刷文件
		model.setOtherPrintedFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_10));
		return model;
	}

	/**
	 * 获取图书数字文件模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	@Override
	public BookDigitalFileModel getDigitalFiles(Long id) {
		// 创建模型
		BookDigitalFileModel model = new BookDigitalFileModel();
		// 设置封面(缩略图)
		model.setCoverFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_11));
		// 设置扉页(缩略图)
		model.setFlyleafFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_12));
		// 设置PDF文件
		model.setPdfFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_13));
		// 设置EPUB文件
		model.setEpubrFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_14));
		return model;
	}

	/**
	 * 获取图书多媒体文件模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	@Override
	public BookMultimediaFileModel getMultimediaFiles(Long id) {
		// 创建模型
		BookMultimediaFileModel model = new BookMultimediaFileModel();
		// 设置音频文件
		model.setAudioFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_15));
		// 设置视频文件
		model.setVideoFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_16));
		return model;
	}

	/**
	 * 获取图书版权文件模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	@Override
	public BookCopyrightFileModel getCopyrightFiles(Long id) {
		// 创建模型
		BookCopyrightFileModel model = new BookCopyrightFileModel();
		// 设置出版合同
		model.setPublicationContracts(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_17));
		return model;
	}

	/**
	 * 获取图书元数据模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	@Override
	public BookMetadataModel getMetadata(Long id) {
		// 创建模型
		BookMetadataModel model = new BookMetadataModel();
		// 图书信息查询
		BookEntity entity = bookMapper.selectByPrimaryKey(id);
		if (entity != null) {
			// 属性复制
			BeanUtils.copyProperties(entity, model);
			// 封装主要实体模型
			this.pottingModel(model, entity);
			// 封装错误码基础模型
			model.setErrorCodeBM(errorCodeMapper.getBasicModel(entity.getErrorCode()));
			// 封装图书类别基础模型
			model.setBookTypeBM(typeMapper.getBasicModel(entity.getBookType(), TypeConstant.TYPE_BOOK));
			// 封装著作方式基础模型
			model.setWritingmodeBM(writingmodeMapper.getBasicModel(entity.getWritingmode()));
			// 封装其它著作方式基础模型
			model.setOtherWritingmodeBM(writingmodeMapper.getBasicModel(entity.getOtherWritingmode()));
			// 封装丛书模型
			model.setSeriesModel(seriesService.getSeriesModel(entity.getSeries()));
			// 封装数据来源基础模型
			model.setDataSourcesBM(dataSourceMapper.getBasicModel(entity.getDataSources()));
			// 封装作者模型
			model.setAuthors(authorMapper.getBasicModelByBookId(entity.getId(), AuthorConstant.OTHER_FLAG_0));
			// 封装其他作者模型
			model.setAuthors(authorMapper.getBasicModelByBookId(entity.getId(), AuthorConstant.OTHER_FLAG_1));
			// 封装CIP主题词模型
			model.setKeywords(bookKeywordMapper.getRelationModelByBookId(entity.getId()));
		}
		// 封装封面模型(待设计)
		return model;
	}

	/**
	 * 获取图书获奖情况模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	@Override
	public BookAwardsFileModel getAwardsFiles(Long id) {
		// 创建模型
		BookAwardsFileModel model = new BookAwardsFileModel();
		// 设置获奖证书
		model.setAwardsFiles(fileService.getFileModelByBookIdAndFileType(id, FileType.FILE_TYPE_18));
		return model;
	}

	/**
	 * 新建图书，只是设置id，创建信息
	 * @param creator 创建者id
	 * @return
	 */
	@Override
	public BookEntity addNewBook(Long creator) {
		// 新建时间
		Long createTime=CalendarUtility.getSystemAccurateTime();
		BookEntity bookEntity=new BookEntity();
		// 封装创建者
		bookEntity.setCreator(creator);
		bookEntity.setCreateTime(createTime);
		// 新建图书,并返回主键
		bookMapper.create(bookEntity);
		return bookEntity;
	}

	/**
	 * 保存图书元数据
	 * @param model 图书元数据模型
	 * @return
	 */
	@Override
	public Boolean saveMetadata(BookMetadataModel model) {
		Boolean bln=Boolean.FALSE;
		// 时间
		Long time=CalendarUtility.getSystemAccurateTime();
		
		// 图书实体
		BookEntity entity=new BookEntity();
		// 拷贝模型字段到实体
		BeanUtils.copyProperties(model, entity);
		// 设置更新者
		entity.setRegenerator(ShiroUtil.getUserId());
		// 设置更新时间
		entity.setUpdateTime(time);
		// 设置错误码
		entity.setErrorCode(model.getErrorCodeBM()==null?null:model.getErrorCodeBM().getId());
		// 设置图书类别
		entity.setBookType(model.getBookTypeBM().getId());
		// 设置著作方式
		entity.setWritingmode(model.getWritingmodeBM()==null?null:model.getWritingmodeBM().getId());
		// 设置其它著作方式
		entity.setOtherWritingmode(model.getOtherWritingmodeBM()==null?null:model.getOtherWritingmodeBM().getId());
		// 设置丛书
		entity.setSeries(model.getSeriesModel()==null?null:model.getSeriesModel().getId());
		// 设置数据来源
		entity.setDataSources(model.getDataSourcesBM()==null?null:model.getDataSourcesBM().getId());
		// 设置封面
		entity.setCover(model.getCoverBM()==null?null:model.getCoverBM().getId());
		
		// 图书与部门关联实体集合
		List<BookDepartmentEntity> bookDepartmentEntities=null;
		// 图书与部门关联部门实体
		BookDepartmentEntity bookDepartmentEntity=null;
		// 模型中是否有部门
		if (CollectionUtils.isNotEmpty(model.getDepartments())) {
			// 创建集合
			bookDepartmentEntities=new ArrayList<BookDepartmentEntity>();
			// 遍历模型中部门集合,并封装实体
			for (RelationBasicModel basicModel : model.getDepartments()) {
				bookDepartmentEntity=new BookDepartmentEntity();
				bookDepartmentEntity.setId(basicModel.getRelationId());
				bookDepartmentEntity.setBookId(model.getId());
				bookDepartmentEntity.setDepartmentId(basicModel.getId());
				bookDepartmentEntities.add(bookDepartmentEntity);
			}
		}
		
		// 图书与单位关联实体集合
		List<BookUnitEntity> bookUnitEntities=null;
		// 图书与单位关联实体
		BookUnitEntity bookUnitEntity=null;
		// 单位模型并集
		List<RelationBasicModel> unitList=null;
		// 合并制作单位与排版单位
		if (CollectionUtils.isNotEmpty(model.getProductionUnit())) {
			unitList=model.getProductionUnit();
			if (CollectionUtils.isNotEmpty(model.getTypesettingUnit())) {
				unitList.addAll(model.getTypesettingUnit());
			}
		} else {
			if (CollectionUtils.isNotEmpty(model.getTypesettingUnit())) {
				unitList=model.getTypesettingUnit();
			}
		}
		// 单位处理
		if (CollectionUtils.isNotEmpty(unitList)) {
			// 创建集合
			bookUnitEntities=new ArrayList<BookUnitEntity>();
			// 遍历单位,并封装实体
			for (RelationBasicModel basicModel : unitList) {
				bookUnitEntity=new BookUnitEntity();
				bookUnitEntity.setId(basicModel.getRelationId());
				bookUnitEntity.setBookId(model.getId());
				bookUnitEntity.setUnitId(basicModel.getId());
				bookUnitEntities.add(bookUnitEntity);
			}
		}
		
		// 图书与编辑关联集合
		List<BookEditorEntity> bookEditorEntities=null;
		// 图书与编辑关联实体
		BookEditorEntity bookEditorEntity=null;
		// 编辑模型并集
		List<EditorModel> editorModels=null;
		//合并全部编辑
		if (CollectionUtils.isNotEmpty(model.getArtEditor())) {
			editorModels=model.getArtEditor();
		}
		if (CollectionUtils.isEmpty(editorModels)) {
			editorModels=new ArrayList<EditorModel>();
		}
		if (model.getExecutiveEditor()!=null) {
			editorModels.add(model.getExecutiveEditor());
		}
		if (model.getOperationEditor()!=null) {
			editorModels.add(model.getOperationEditor());
		}
		if (model.getInspector()!=null) {
			editorModels.add(model.getInspector());
		}
		if (model.getCopyrightManager()!=null) {
			editorModels.add(model.getCopyrightManager());
		}
		// 编辑处理
		if (CollectionUtils.isNotEmpty(editorModels)) {
			// 创建集合
			bookEditorEntities=new ArrayList<>();
			for (EditorModel editorModel : editorModels) {
				bookEditorEntity=new BookEditorEntity();
				bookEditorEntity.setId(editorModel.getRelationId());
				bookEditorEntity.setBookId(model.getId());
				bookEditorEntity.setUserId(editorModel.getId());
				bookEditorEntity.setEditorType(editorModel.getEditorType());
				bookEditorEntities.add(bookEditorEntity);
			}
		}
		
		// 图书与作者关联集合
		List<BookAuthorEntity> bookAuthorEntities=null;
		// 图书与作者关联实体
		BookAuthorEntity bookAuthorEntity=null;
		// 作者处理
		if (CollectionUtils.isNotEmpty(model.getAuthors())) {
			bookAuthorEntities=new ArrayList<>();
			for (AuthorBasicModel authorBasicModel : model.getAuthors()) {
				bookAuthorEntity=new BookAuthorEntity();
				bookAuthorEntity.setId(authorBasicModel.getRelationId());
				bookAuthorEntity.setBookId(model.getId());
				bookAuthorEntity.setAuthorId(authorBasicModel.getId());
				bookAuthorEntity.setOtherFlag(AuthorConstant.OTHER_FLAG_0);
				bookAuthorEntities.add(bookAuthorEntity);
			} 
		}
		// 其他作者处理
		if (CollectionUtils.isNotEmpty(model.getOtherAuthors())) {
			bookAuthorEntities=new ArrayList<>();
			for (AuthorBasicModel authorBasicModel : model.getOtherAuthors()) {
				bookAuthorEntity=new BookAuthorEntity();
				bookAuthorEntity.setId(authorBasicModel.getRelationId());
				bookAuthorEntity.setBookId(model.getId());
				bookAuthorEntity.setAuthorId(authorBasicModel.getId());
				bookAuthorEntity.setOtherFlag(AuthorConstant.OTHER_FLAG_1);
				bookAuthorEntities.add(bookAuthorEntity);
			} 
		}
		
		// 图书与主题词关联集合
		List<BookKeywordEntity> bookKeywordEntities=null;
		// 图书与主题词关联实体
		BookKeywordEntity bookKeywordEntity=null;
		// 主题词处理
		if (CollectionUtils.isNotEmpty(model.getKeywords())) {
			bookKeywordEntities=new ArrayList<>();
			for (RelationBasicModel basicModel : model.getKeywords()) {
				bookKeywordEntity=new BookKeywordEntity();
				bookKeywordEntity.setId(basicModel.getRelationId());
				bookKeywordEntity.setBookId(model.getId());
				bookKeywordEntity.setKeywordId(basicModel.getId());
				bookKeywordEntities.add(bookKeywordEntity);
			}
		}
		
		// 更新图书实体数据
		bookMapper.updateByPrimaryKeySelective(entity);
		
		// 更新图书与部门关联关系
		for (BookDepartmentEntity bdEntity : bookDepartmentEntities) {
			if (bdEntity.getId()==null) {
				bookDepartmentMapper.insert(bdEntity);
			} else {
				if (bdEntity.getDepartmentId()!=null) {
					bookDepartmentMapper.updateByPrimaryKey(bdEntity);
				} else {
					bookDepartmentMapper.deleteByPrimaryKey(bdEntity.getId());
				}
			}
		}
		
		// 更新图书与单位关联关系
		for (BookUnitEntity buEntity : bookUnitEntities) {
			if (buEntity.getId()==null) {
				bookUnitMapper.insert(buEntity);
			} else {
				if (buEntity.getUnitId()!=null) {
					bookUnitMapper.updateByPrimaryKey(buEntity);
				} else {
					bookUnitMapper.deleteByPrimaryKey(buEntity.getId());
				}
			}
		}
		
		// 更新图书与编辑关联关系
		for (BookEditorEntity beEntity : bookEditorEntities) {
			if (beEntity.getId()==null) {
				bookEditorMapper.insert(beEntity);
			} else {
				if (beEntity.getUserId()!=null) {
					bookEditorMapper.updateByPrimaryKey(beEntity);
				} else {
					bookEditorMapper.deleteByPrimaryKey(beEntity.getId());
				}
			}
		}
		
		// 更新图书与作者关联关系
		for (BookAuthorEntity baEntity : bookAuthorEntities) {
			if (baEntity.getId()==null) {
				bookAuthorMapper.insert(baEntity);
			} else {
				if (baEntity.getAuthorId()!=null) {
					bookAuthorMapper.updateByPrimaryKey(baEntity);
				} else {
					bookAuthorMapper.deleteByPrimaryKey(baEntity.getId());
				}
			}
		}
		
		// 更新图书与主题词关联关系
		for (BookKeywordEntity bkEntity : bookKeywordEntities) {
			if (bkEntity.getId()==null) {
				bookKeywordMapper.insert(bkEntity);
			} else {
				if (bkEntity.getKeywordId()!=null) {
					bookKeywordMapper.updateByPrimaryKey(bkEntity);
				} else {
					bookKeywordMapper.deleteByPrimaryKey(bkEntity.getId());
				}
			}
		}
		
		bln=Boolean.TRUE;
		return bln;
	}

}
