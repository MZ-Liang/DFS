package com.dfs.api.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmlpull.v1.XmlPullParserException;

import com.dfs.api.model.ReturnMsg;
import com.dfs.api.constant.BucketEnum;
import com.dfs.api.constant.FilePrefixEnum;
import com.dfs.api.model.ActionModel;
import com.dfs.api.util.MakeNameUtil;
import com.dfs.api.util.MinioUtil;

import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidExpiresRangeException;
import io.minio.errors.NoResponseException;
import io.minio.errors.RegionConflictException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "MinioController", tags = "minio存储API")
@RestController
@RequestMapping("/minio")
public class MinioController extends BasicController{
	/** minio工具类 */
	@Autowired
	private MinioUtil minioUtil;

	@ApiOperation(value = "获取临时授权的文件下载操作", notes = "每次下载前都要获取URL，在指定时间内生效")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "bucketName", value = "桶名", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "objectName", value = "对象名", required = true, paramType = "query", dataType = "String"), })
	@GetMapping("/getDownloadAction")
	public ReturnMsg<ActionModel> getDownloadAction(String bucketName, String objectName)
			throws InvalidKeyException, InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException,
			NoResponseException, ErrorResponseException, InternalException, InvalidExpiresRangeException, IOException,
			XmlPullParserException {

		return getSuccessMsg(minioUtil.presignedGetObject(bucketName, objectName));
	}

	@ApiOperation(value = "文件上传", notes = "上传文件之前的请求，来获取临时上传授权")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "fileType", value = "文件所属类型（1:编辑原稿 2:正文排版文件 3:封面扉页设计文件 4:设计素材文件 5:其他排版设计文件"
					+ " 6:条形码 7:封面扉页印刷文件 8:版权页文件 9:付型文件 10:其他印刷文件 11:封面(缩略图) 12:扉页(缩略图)"
					+ " 13:PD文件 14:EPUB文件 15:音频文件 16:视频文件 17:出版合同 18:获奖证书）", paramType = "query", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "suffix", value = "文件后缀(如：.jpg)", paramType = "query", required = true, dataType = "String"), 
			@ApiImplicitParam(name = "bucketEnum", value = "模块类型", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "expires", value = "生效时间（单位秒）", paramType = "query", required = false, dataType = "int"),
	})
	@GetMapping("/getUploadAction")
	public ReturnMsg<ActionModel> getUploadAction(Long id, Integer fileType, String suffix,BucketEnum bucketEnum,Integer expires)
			throws InvalidKeyException, InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException,
			NoResponseException, ErrorResponseException, InternalException, InvalidExpiresRangeException,
			RegionConflictException, IOException, XmlPullParserException {
		
		// 获取存储对象名
		String objectName = MakeNameUtil.getName(id, FilePrefixEnum.getName(fileType), suffix);
		// 上传文件action
		ActionModel actionModel=null;
		if (expires==null) {
			actionModel = minioUtil.presignedPutObject(bucketEnum.getName(), objectName);
		} else {
			actionModel = minioUtil.presignedPutObject(bucketEnum.getName(), objectName,expires);
		}
		actionModel.setBucketName(BucketEnum.BOOK.getName());
		actionModel.setObjectName(objectName);
		return getSuccessMsg(actionModel);
	}

}
