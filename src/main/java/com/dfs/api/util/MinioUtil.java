package com.dfs.api.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xmlpull.v1.XmlPullParserException;

import com.dfs.api.model.TokenModel;
import com.dfs.api.model.ActionModel;

import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.PostPolicy;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidArgumentException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidExpiresRangeException;
import io.minio.errors.NoResponseException;
import io.minio.errors.RegionConflictException;

/**
 * Minio工具类，用于获取minio token(已注入bean)
 * 
 * @author Ming
 * @date 2018年11月20日
 */
public class MinioUtil {
	/** minio客户端 */
	private MinioClient minioClient;
	/** Minio Token */
	private TokenModel minioToken;
	/** 预约URL生效时间 */
	private Integer expires;

	/**
	 * 设置预约URL生效时间
	 * 
	 * @param expires
	 */
	public void setExpires(Integer expires) {
		this.expires = expires;
	}

	/**
	 * 获取预约URL生效时间
	 * 
	 * @return
	 */
	public Integer getExpires() {
		return expires;
	}

	/**
	 * 获取minio客户端
	 * 
	 * @return
	 */
	public MinioClient getMinioClient() {
		return minioClient;
	}

	/**
	 * 设置minio客户端
	 * 
	 * @param minioClient minio客户端
	 */
	public void setMinioClient(MinioClient minioClient) {
		this.minioClient = minioClient;
	}

	/**
	 * 设置minio管理员token
	 * 
	 * @param minioToken
	 */
	public void setMinioToken(TokenModel minioToken) {
		this.minioToken = minioToken;
	}

	/**
	 * 获取minio管理员token
	 * 
	 * @return
	 */
	public TokenModel getMinioToken() {
		return minioToken;
	}

	/**
	 * 为HTTP GET操作生成预签名URL。即使存储桶是私有的，浏览器/移动客户端也可以指向此URL以直接下载对象。
	 * 此预签名URL可以具有相关的到期时间（以秒为单位），之后它将不再运行。
	 * 
	 * @param bucketName 桶名
	 * @param objectName 对象名
	 * @param expires    生效时间
	 * @return String包含下载对象的URL
	 * @throws XmlPullParserException
	 * @throws IOException
	 * @throws InvalidExpiresRangeException
	 * @throws InternalException
	 * @throws ErrorResponseException
	 * @throws NoResponseException
	 * @throws InsufficientDataException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidBucketNameException
	 * @throws InvalidKeyException
	 */
	public ActionModel presignedGetObject(String bucketName, String objectName, Integer expires)
			throws InvalidKeyException, InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException,
			NoResponseException, ErrorResponseException, InternalException, InvalidExpiresRangeException, IOException,
			XmlPullParserException {
		ActionModel action = new ActionModel();
		action.setAction(minioClient.presignedGetObject(bucketName, objectName, expires));
		action.setRequestMethod(RequestMethod.GET.toString());
		return action;
	}

	/**
	 * 为HTTP GET操作生成预签名URL。即使存储桶是私有的，浏览器/移动客户端也可以指向此URL以直接下载对象。
	 * 此预签名URL可以具有相关的到期时间（默认时间），之后它将不再运行。
	 * 
	 * @param bucketName 桶名
	 * @param objectName 对象名
	 * @return String包含下载对象的URL
	 * @throws XmlPullParserException
	 * @throws IOException
	 * @throws InvalidExpiresRangeException
	 * @throws InternalException
	 * @throws ErrorResponseException
	 * @throws NoResponseException
	 * @throws InsufficientDataException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidBucketNameException
	 * @throws InvalidKeyException
	 */
	public ActionModel presignedGetObject(String bucketName, String objectName)
			throws InvalidKeyException, InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException,
			NoResponseException, ErrorResponseException, InternalException, InvalidExpiresRangeException, IOException,
			XmlPullParserException {
		return presignedGetObject(bucketName, objectName, expires);
	}

	/**
	 * 为HTTP PUT操作生成预签名URL。浏览器/移动客户端可以指向此URL以将对象直接上载到存储桶，即使它是私有的。
	 * 此预签名URL可以具有相关的到期时间（以秒为单位），之后它将不再运行
	 * 
	 * @param bucketName 桶名
	 * @param objectName 对象名
	 * @param expires    生效时间
	 * @return String包含下载对象的URL
	 * @throws InvalidKeyException
	 * @throws InvalidBucketNameException
	 * @throws NoSuchAlgorithmException
	 * @throws InsufficientDataException
	 * @throws NoResponseException
	 * @throws ErrorResponseException
	 * @throws InternalException
	 * @throws InvalidExpiresRangeException
	 * @throws IOException
	 * 
	 * @throws XmlPullParserException
	 * @throws RegionConflictException
	 */
	public ActionModel presignedPutObject(String bucketName, String objectName, Integer expires)
			throws InvalidKeyException, InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException,
			NoResponseException, ErrorResponseException, InternalException, InvalidExpiresRangeException, IOException,
			XmlPullParserException, RegionConflictException {
		// 判断桶是否存在
		if (!bucketExists(bucketName)) {
			// 不存在，则创建
			minioClient.makeBucket(bucketName);
		}
		ActionModel action = new ActionModel();
		action.setAction(minioClient.presignedPutObject(bucketName, objectName, expires));
		action.setRequestMethod(RequestMethod.PUT.toString());
		return action;
	}

	/**
	 * 为HTTP PUT操作生成预签名URL。浏览器/移动客户端可以指向此URL以将对象直接上载到存储桶，即使它是私有的。
	 * 此预签名URL可以具有相关的到期时间（默认时间），之后它将不再运行
	 * 
	 * @param bucketName 桶名
	 * @param objectName 对象名
	 * @return String包含下载对象的URL
	 * @throws InvalidKeyException
	 * @throws InvalidBucketNameException
	 * @throws NoSuchAlgorithmException
	 * @throws InsufficientDataException
	 * @throws NoResponseException
	 * @throws ErrorResponseException
	 * @throws InternalException
	 * @throws InvalidExpiresRangeException
	 * @throws IOException
	 * @throws XmlPullParserException
	 * @throws RegionConflictException
	 */
	public ActionModel presignedPutObject(String bucketName, String objectName)
			throws InvalidKeyException, InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException,
			NoResponseException, ErrorResponseException, InternalException, InvalidExpiresRangeException, IOException,
			XmlPullParserException, RegionConflictException {
		return presignedPutObject(bucketName, objectName, expires);
	}

	/**
	 * 允许将策略条件设置为POST操作的预签名URL。可以设置诸如用于接收对象上载的桶名称，密钥名称前缀，到期策略之类的策略。
	 * 
	 * @param bucketName    桶名
	 * @param objectName    对象名
	 * @param contentType   文本类型
	 * @param expires       生效时间
	 * @param contentLength 文本长度
	 * @param startRange    文本字节开始范围
	 * @param endRange      文本字节结束范围
	 * @return
	 * @throws InvalidArgumentException
	 * @throws InvalidKeyException
	 * @throws InvalidBucketNameException
	 * @throws NoSuchAlgorithmException
	 * @throws InsufficientDataException
	 * @throws NoResponseException
	 * @throws ErrorResponseException
	 * @throws InternalException
	 * @throws IOException
	 * @throws XmlPullParserException
	 */
	public ActionModel presignedPostPolicy(String bucketName, String objectName, String contentType, Integer expires,
			Long contentLength, Long startRange, Long endRange) throws InvalidArgumentException, InvalidKeyException,
			InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException, NoResponseException,
			ErrorResponseException, InternalException, IOException, XmlPullParserException {
		// 生成post对象策略
		PostPolicy policy = new PostPolicy(bucketName, objectName, DateTime.now().plusSeconds(expires));
		// 设置请求编码
		policy.setContentEncoding(StandardCharsets.UTF_8.toString());
		// 设置上传文件类型
		policy.setContentType(contentType);
		if (contentLength != null) {
			// 设置上传文件字节长度
			policy.setContentLength(contentLength);
		}
		if (startRange != null && endRange != null) {
			// 设置上传文件字节范围
			policy.setContentRange(startRange, endRange);
		}
		// minio执行策略
		Map<String, String> formData = minioClient.presignedPostPolicy(policy);

		// 返回URL模型
		ActionModel model = new ActionModel();
		model.setAction(minioToken.getClient() + "/" + bucketName);
		model.setRequestMethod(RequestMethod.POST.toString());
		model.setBodys(formData);
		return model;
	}

	/**
	 * 允许将策略条件设置为POST操作的预签名URL（默认生效时间）
	 * 
	 * @param bucketName  桶名
	 * @param objectName  对象名
	 * @param contentType 文本类型
	 * @return
	 * @throws InvalidArgumentException
	 * @throws InvalidKeyException
	 * @throws InvalidBucketNameException
	 * @throws NoSuchAlgorithmException
	 * @throws InsufficientDataException
	 * @throws NoResponseException
	 * @throws ErrorResponseException
	 * @throws InternalException
	 * @throws IOException
	 * @throws XmlPullParserException
	 */
	public ActionModel presignedPostPolicy(String bucketName, String objectName, String contentType)
			throws InvalidKeyException, InvalidArgumentException, InvalidBucketNameException, NoSuchAlgorithmException,
			InsufficientDataException, NoResponseException, ErrorResponseException, InternalException, IOException,
			XmlPullParserException {
		return presignedPostPolicy(bucketName, objectName, contentType, expires, null, null, null);
	}

	/**
	 * 判断桶是否存在
	 * 
	 * @param bucketName 桶名
	 * @return
	 * @throws InvalidKeyException
	 * @throws InvalidBucketNameException
	 * @throws NoSuchAlgorithmException
	 * @throws InsufficientDataException
	 * @throws NoResponseException
	 * @throws ErrorResponseException
	 * @throws InternalException
	 * @throws IOException
	 * @throws XmlPullParserException
	 */
	public boolean bucketExists(String bucketName)
			throws InvalidKeyException, InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException,
			NoResponseException, ErrorResponseException, InternalException, IOException, XmlPullParserException {
		return minioClient.bucketExists(bucketName);
	}

	/**
	 * 创建桶
	 * 
	 * @param bucketName 桶名
	 * @return
	 * @throws InvalidKeyException
	 * @throws InvalidBucketNameException
	 * @throws NoSuchAlgorithmException
	 * @throws InsufficientDataException
	 * @throws NoResponseException
	 * @throws ErrorResponseException
	 * @throws InternalException
	 * @throws IOException
	 * @throws XmlPullParserException
	 * @throws RegionConflictException
	 */
	public boolean makeBucket(String bucketName) throws InvalidKeyException, InvalidBucketNameException,
			NoSuchAlgorithmException, InsufficientDataException, NoResponseException, ErrorResponseException,
			InternalException, IOException, XmlPullParserException, RegionConflictException {
		if (bucketExists(bucketName)) {
			return false;
		}
		minioClient.makeBucket(bucketName);
		return true;
	}

	/**
	 * 获取对象的元数据
	 * 
	 * @param bucketName 桶名
	 * @param objectName 对象名
	 * @return
	 * @throws InvalidKeyException
	 * @throws InvalidBucketNameException
	 * @throws NoSuchAlgorithmException
	 * @throws InsufficientDataException
	 * @throws NoResponseException
	 * @throws ErrorResponseException
	 * @throws InternalException
	 * @throws IOException
	 * @throws XmlPullParserException
	 */
	public ObjectStat statObject(String bucketName, String objectName)
			throws InvalidKeyException, InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException,
			NoResponseException, ErrorResponseException, InternalException, IOException, XmlPullParserException {
		ObjectStat objectStat = minioClient.statObject(bucketName, objectName);
		return objectStat;
	}
}
