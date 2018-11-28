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
import com.dfs.api.model.ActionModel;
import com.dfs.api.util.MinioUtil;

import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidExpiresRangeException;
import io.minio.errors.NoResponseException;
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
	@GetMapping("/getDownloadUrl")
	public ReturnMsg<ActionModel> getDownloadUrl(String bucketName, String objectName)
			throws InvalidKeyException, InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException,
			NoResponseException, ErrorResponseException, InternalException, InvalidExpiresRangeException, IOException,
			XmlPullParserException {

		return getSuccessMsg(minioUtil.presignedGetObject(bucketName, objectName));
	}

	/*@ApiOperation(value = "获取临时上传文件操作", notes = "每次上传前都要获取UR，在指定时间内生效")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "bucketName", value = "桶名", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "objectName", value = "对象名", required = true, paramType = "query", dataType = "String"), })
	@GetMapping("/getPutUploadUrl")
	public ActionModel getUrl(String bucketName, String objectName)
			throws InvalidKeyException, InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException,
			NoResponseException, ErrorResponseException, InternalException, InvalidExpiresRangeException, IOException,
			XmlPullParserException, RegionConflictException {
		return minioUtil.presignedPutObject(bucketName, objectName);
	}*/

}
