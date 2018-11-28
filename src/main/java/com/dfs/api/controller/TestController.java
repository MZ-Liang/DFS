package com.dfs.api.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dfs.api.constant.BucketEnum;
import com.dfs.api.core.service.HttpClientService;
import com.dfs.api.entity.book.BookEntity;
import com.dfs.api.entity.user.UserEntity;
import com.dfs.api.model.BasicModel;
import com.dfs.api.model.HttpResult;
import com.dfs.api.model.TokenModel;
import com.dfs.api.model.user.UserBasicModel;
import com.dfs.api.util.BeanUtils;
import com.dfs.api.util.EncryptUtility;
import com.dfs.api.util.MinioUtil;
import com.dfs.api.util.RedisUtil;

import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "TestController", tags = "测试API")
public class TestController extends BasicController{
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private HttpClientService httpClientService;
	@Autowired
	private MinioUtil minioUtil;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(BucketEnum bucketEnum) throws Exception {
		System.out.println(bucketEnum);
		return null;
	}

	private void name() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("id", "lmz");
		map.put("firstName", "liang");
		map.put("lastName", "ming");
		map.put("displayName", "liangming");
		map.put("url", "http://192.168.3.32:9082/identity/users/lmz");
		map.put("email", "no-reply@flowable.org");
		map.put("pictureUrl", "");
		map.put("password", "123");
		HttpResult result = httpClientService.doPost("http://192.168.3.32:9081/flowable-rest/service/identity/users",
				"rest-admin:test", map);
		System.out.println(result);
	}

}
