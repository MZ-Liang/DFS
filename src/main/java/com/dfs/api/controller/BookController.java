package com.dfs.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dfs.api.constant.BucketEnum;
import com.dfs.api.entity.book.BookEntity;
import com.dfs.api.model.PageInfo;
import com.dfs.api.model.ReturnMsg;
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
import com.dfs.api.model.common.FileModel;
import com.dfs.api.service.book.BookService;
import com.dfs.api.service.common.FileService;
import com.dfs.api.util.ShiroUtil;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "BookController", tags = "图书API")
@RestController
@RequestMapping("/book")
public class BookController extends BasicController{
	/** 图书服务 */
	@Autowired
	private BookService bookService;
	/** 文件服务 */
	@Autowired
	private FileService fileService;

	@ApiOperation(value = "图书主要信息", notes = "根据id获取图书主要信息")
	@ApiImplicitParam(name = "id", value = "图书id", required = true, dataType = "Long", paramType = "query")
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ReturnMsg<BookBasicModel> detail(Long id) throws Exception {
		return getSuccessMsg(bookService.getDetailMessage(id));
	}

	@ApiOperation(value = "获取图书排版文件", notes = "根据id获取图书排版文件")
	@ApiImplicitParam(name = "id", value = "图书id", required = true, dataType = "Long", paramType = "query")
	@GetMapping("/typesettingFile")
	public ReturnMsg<BookTypesettingFileModel> getTypesettingFiles(Long id) {
		return getSuccessMsg(bookService.getTypesettingFiles(id));
	}

	@ApiOperation(value = "获取图书印刷文件", notes = "根据id获取图书印刷文件")
	@ApiImplicitParam(name = "id", value = "图书id", required = true, dataType = "Long", paramType = "query")
	@GetMapping("/printedFile")
	public ReturnMsg<BookPrintedFileModel> getPrintedFiles(Long id) {
		return getSuccessMsg(bookService.getPrintedFiles(id));
	}

	@ApiOperation(value = "获取图书数字文件", notes = "根据id获取图书数字文件")
	@ApiImplicitParam(name = "id", value = "图书id", required = true, dataType = "Long", paramType = "query")
	@GetMapping("/digitalFile")
	public ReturnMsg<BookDigitalFileModel> getDigitalFiles(Long id) {
		return getSuccessMsg(bookService.getDigitalFiles(id));
	}

	@ApiOperation(value = "获取图书多媒体文件", notes = "根据id获取图书多媒体文件")
	@ApiImplicitParam(name = "id", value = "图书id", required = true, dataType = "Long", paramType = "query")
	@GetMapping("/multimediaFile")
	public ReturnMsg<BookMultimediaFileModel> getMultimediaFiles(Long id) {
		return getSuccessMsg(bookService.getMultimediaFiles(id));
	}

	@ApiOperation(value = "获取图书版权文件", notes = "根据id获取图书版权文件")
	@ApiImplicitParam(name = "id", value = "图书id", required = true, dataType = "Long", paramType = "query")
	@GetMapping("/copyrightFile")
	public ReturnMsg<BookCopyrightFileModel> getCopyrightFiles(Long id) {
		return getSuccessMsg(bookService.getCopyrightFiles(id));
	}

	@ApiOperation(value = "获取图书元数据", notes = "根据id获取图书元数据")
	@ApiImplicitParam(name = "id", value = "图书id", required = true, dataType = "Long", paramType = "query")
	@GetMapping("/metadata")
	public ReturnMsg<BookMetadataModel> getMetadata(Long id) {
		return getSuccessMsg(bookService.getMetadata(id));
	}

	@ApiOperation(value = "获取图书获奖情况", notes = "根据id获取图书获奖情况")
	@ApiImplicitParam(name = "id", value = "图书id", required = true, dataType = "Long", paramType = "query")
	@GetMapping("/awardsFile")
	public ReturnMsg<BookAwardsFileModel> getAwardsFiles(Long id) {
		return getSuccessMsg(bookService.getAwardsFiles(id));
	}

	@ApiOperation(value = "图书搜索列表", notes = "分页搜索获取图书列表信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNum", value = "页数", required = false, paramType = "query", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, paramType = "query", dataType = "Integer"), })
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ReturnMsg<PageInfo<BookBasicInfoModel>> list(
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			BookSearchModel bookSearchModel) {
		// 分页条件
		Page<BookBasicInfoModel> page = new Page<>(pageNum, pageSize);

		return getSuccessMsg(bookService.list(bookSearchModel, page));
	}

	@ApiOperation(value="新建图书",notes="只返回图书id、创建时间、创建者id")
	@GetMapping("/create")
	public ReturnMsg<BookEntity> create() {
		return getSuccessMsg(bookService.addNewBook(ShiroUtil.getUserId()));
	}
	
	@ApiOperation(value="保存图书元数据",notes="")
	@PostMapping("/saveMetadata")
	public ReturnMsg<BookEntity> saveMetadata(Integer option, @ApiParam("文件模型集合") @RequestBody BookMetadataModel model) {
		// 保存
		bookService.saveMetadata(model);
		return getSuccessMsg(null);
	}
	
	@ApiOperation(value="保存图书文件数据",notes="批处理")
	@PostMapping("/saveFilesData")
	public ReturnMsg<Boolean> saveFiles(Long bookId,@ApiParam("文件模型集合") @RequestBody List<FileModel> files) {
		return getSuccessMsg(fileService.saveOrUpdateFiles(bookId,files,BucketEnum.BOOK));
	}

}
