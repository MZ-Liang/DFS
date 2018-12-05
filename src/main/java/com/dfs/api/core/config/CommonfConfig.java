package com.dfs.api.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.dfs.api.model.TokenModel;
import com.dfs.api.util.FlowableUtil;
import com.dfs.api.util.HttpClientUtil;

/**
 * 通用配置
 * @author Ming
 * @date 2018年11月23日
 */
@Configuration
public class CommonfConfig {
	@Value("${flowable.client}")
    private String client;
    
    @Value("${flowable.access.key}")
    private String accessKey;
    
    @Value("${flowable.secret.key}")
    private String secretKey;
    
	/**
	 * fastjson配置
	 * @return
	 */
	@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1.定义一个converters转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 2.添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        // 3.在converter中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 4.将converter赋值给HttpMessageConverter
        HttpMessageConverter<?> converter = fastConverter;
        // 5.返回HttpMessageConverters对象
        return new HttpMessageConverters(converter);
    }
	
	/**
	 * 注入flowable工具类
	 * @return
	 * @throws Exception 
	 */
	@Bean
	public FlowableUtil getFlowableUtil(@Autowired HttpClientUtil httpClientUtil) throws Exception {
		return new FlowableUtil(new TokenModel(accessKey, secretKey, client), client,httpClientUtil);
	}
}
