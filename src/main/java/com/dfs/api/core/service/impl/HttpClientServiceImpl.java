package com.dfs.api.core.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dfs.api.core.service.HttpClientService;
import com.dfs.api.model.HttpResult;

/**
 * HttpClient服务
 * @author Ming
 * @date 2018年11月14日
 */
@Service
public class HttpClientServiceImpl implements HttpClientService{
	/** HttpClient连接池 */
	@Autowired
	private CloseableHttpClient httpClient;
	
	/** 连接配置信息 */
	@Autowired
	private RequestConfig requestConfig;
	
	@Override
	public HttpResult doGet(String url, String authorization) throws Exception {
		// 声明 http get 请求
        HttpGet httpGet = new HttpGet(url);
        // 装载配置信息
        httpGet.setConfig(requestConfig);
        // 编码
        authorization=Base64.getEncoder().encodeToString((authorization).getBytes(StandardCharsets.UTF_8));
        System.out.println(authorization);
        // 添加身份授权
        httpGet.setHeader("Authorization", "Basic " + authorization);
        // 发起请求
        CloseableHttpResponse response = this.httpClient.execute(httpGet);
        return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(
                response.getEntity(), StandardCharsets.UTF_8));
	}
	
	/**
     * 带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
     * 
     * @param url
     * @return
     * @throws Exception
     */
	public HttpResult doGet(String url, String authorization, Map<String, Object> map) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(url);
 
        if (!CollectionUtils.isEmpty(map)) {
            // 遍历map,拼接请求参数
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }
 
        // 调用不带参数的get请求
        return this.doGet(uriBuilder.build().toString(),authorization);
 
    }

	 /**
     * 带参数的post请求
     * 
     * @param url
     * @param map
     * @return HttpResult
     * @throws Exception
     */
    public HttpResult doPost(String url, String authorization, Map<String, Object> map) throws Exception {
        // 声明httpPost请求
        HttpPost httpPost = new HttpPost(url);
        // 加入配置信息
        httpPost.setConfig(requestConfig);
        // 判断map是否为空，不为空则进行遍历，封装from表单对象
        if (map != null) {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
            // 构造from表单对象
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, StandardCharsets.UTF_8);
 
            // 把表单放到post里
            httpPost.setEntity(urlEncodedFormEntity);
        }
        
        // 编码
        authorization=Base64.getEncoder().encodeToString((authorization).getBytes(StandardCharsets.UTF_8));
        // 添加身份授权
        httpPost.setHeader("Authorization", "Basic " + authorization);
 
        // 发起请求
        CloseableHttpResponse response = this.httpClient.execute(httpPost);
        return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(
                response.getEntity(), StandardCharsets.UTF_8));
    }
 
    /**
     * 不带参数post请求
     * 
     * @param url
     * @return HttpResult
     * @throws Exception 
     */
    @Override
    public HttpResult doPost(String url, String authorization) throws Exception {
        return this.doPost(url, authorization, null);
    }

}
