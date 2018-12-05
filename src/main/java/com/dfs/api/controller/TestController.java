package com.dfs.api.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dfs.api.constant.BucketEnum;
import com.dfs.api.entity.book.BookEntity;
import com.dfs.api.entity.user.UserEntity;
import com.dfs.api.model.BasicModel;
import com.dfs.api.model.HttpResult;
import com.dfs.api.model.RelationBasicModel;
import com.dfs.api.model.TokenModel;
import com.dfs.api.model.user.UserBasicModel;
import com.dfs.api.util.BeanUtils;
import com.dfs.api.util.EncryptUtility;
import com.dfs.api.util.FlowableUtil;
import com.dfs.api.util.MinioUtil;
import com.dfs.api.util.RedisUtil;
import com.dfs.api.util.ShiroUtil;

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
	private MinioUtil minioUtil;
	/** HttpClient连接池 */
	@Autowired
	private CloseableHttpClient httpClient;
	/** 连接配置信息 */
	@Autowired
	private RequestConfig requestConfig;
	@Autowired
	private FlowableUtil flowableUtil;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public HttpResult test() throws Exception {
		return flowableUtil.deleteFlowableUser(9L);
	}

	public HttpResult doPost(String url, String authorization, String body) throws Exception {
        // 声明httpPost请求
        HttpPost httpPost = new HttpPost(url);
        // 加入配置信息
        httpPost.setConfig(requestConfig);
        httpPost.setHeader("content-type", "application/json;charset=UTF-8");
        
        // 编码
        authorization=Base64.getEncoder().encodeToString((authorization).getBytes(StandardCharsets.UTF_8));
        // 添加身份授权
        httpPost.setHeader("Authorization", "Basic " + authorization);
        
        if (StringUtils.isNoneBlank(body)) {
			StringEntity params = new StringEntity(body, "UTF-8");
			httpPost.setEntity(params);
		}
		// 发起请求
        CloseableHttpResponse response = this.httpClient.execute(httpPost);
        return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(
                response.getEntity(), StandardCharsets.UTF_8));
    }

}
