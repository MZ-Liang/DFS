package com.dfs.api.core.service;

import java.util.Map;

import com.dfs.api.model.HttpResult;

/**
 * HttpClient服务
 * @author Ming
 * @date 2018年11月14日
 */
public interface HttpClientService {
	
	HttpResult doGet(String url ,String authorization) throws Exception;
	HttpResult doGet(String url ,String authorization,Map<String, Object> map) throws Exception;
	
	HttpResult doPost(String url ,String authorization) throws Exception;
	HttpResult doPost(String url ,String authorization,Map<String, Object> map) throws Exception;

}
