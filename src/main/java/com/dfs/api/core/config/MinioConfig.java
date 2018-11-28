package com.dfs.api.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dfs.api.model.TokenModel;
import com.dfs.api.util.MinioUtil;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;

/**
 * Minio配置类
 * @author Ming
 * @date 2018年11月21日
 */
@Configuration
public class MinioConfig {
	/** minio客户端地址 */
	@Value("${minio.client}")
	private String client;
	/** 账户：Access Key */
	@Value("${minio.access.key}")
	private String accessKey;
	/** 密钥：Secret Key*/
	@Value("${minio.secret.key}")
	private String secretKey;
	/** 安全访问(true:https false:http)*/
	@Value("${minio.insecure}")
	private boolean insecure;
	/** 预约URL生效时间 */
	@Value("${minio.expires}")
	private Integer expires;

	/**
	 * 注入Minio客户端
	 * @return
	 * @throws InvalidEndpointException
	 * @throws InvalidPortException
	 */
	@Bean
	public MinioClient getMinioClient() throws InvalidEndpointException, InvalidPortException {
		return new MinioClient(client, accessKey, secretKey,insecure);
	}
	
	/**
	 * 注入Minio工具类
	 * @return
	 * @throws InvalidPortException 
	 * @throws InvalidEndpointException 
	 */
	@Bean
	public MinioUtil getMinioUtil() throws InvalidEndpointException, InvalidPortException {
		MinioUtil minioUtil=new MinioUtil();
		minioUtil.setMinioClient(getMinioClient());
		minioUtil.setMinioToken(new TokenModel(accessKey, secretKey, client));
		minioUtil.setExpires(expires);
		return minioUtil;
	}
}
