package com.dfs.api.service.book;

import com.dfs.api.core.service.SimpleService;
import com.dfs.api.entity.book.BookEntity;
import com.dfs.api.model.PageInfo;
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
import com.github.pagehelper.Page;

/**
 * 图书服务
 * 
 * @author Ming
 * @date 2018年11月5日
 */
public interface BookService extends SimpleService<Long, BookEntity> {

	/**
	 * 根据搜索条件分页查询图书
	 * 
	 * @param condition 查询条件
	 * @param page      分页条件
	 * @return
	 */
	PageInfo<BookBasicInfoModel> list(BookSearchModel condition, Page<BookBasicInfoModel> page);

	/**
	 * 获取图书主要信息
	 * 
	 * @param id 图书id
	 * @return 图书基础模型
	 */
	BookBasicModel getDetailMessage(Long id);

	/**
	 * 获取图书排版文件模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	BookTypesettingFileModel getTypesettingFiles(Long id);

	/**
	 * 获取图书印刷文件模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	BookPrintedFileModel getPrintedFiles(Long id);

	/**
	 * 获取图书数字文件模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	BookDigitalFileModel getDigitalFiles(Long id);

	/**
	 * 获取图书多媒体文件模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	BookMultimediaFileModel getMultimediaFiles(Long id);

	/**
	 * 获取图书版权文件模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	BookCopyrightFileModel getCopyrightFiles(Long id);

	/**
	 * 获取图书元数据模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	BookMetadataModel getMetadata(Long id);

	/**
	 * 获取图书获奖情况模型
	 * 
	 * @param id 图书id
	 * @return
	 */
	BookAwardsFileModel getAwardsFiles(Long id);

	/**
	 * 新建图书，只是设置id，创建信息
	 * @param creator 创建者id
	 * @return
	 */
	BookEntity addNewBook(Long creator);

	/**
	 * 保存图书元数据
	 * @param model 图书元数据模型
	 * @return
	 */
	Boolean saveMetadata(BookMetadataModel model);

}
