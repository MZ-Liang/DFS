package com.dfs.api;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 开机启动
 * @author Ming
 * @date 2018年12月7日
 */
@Component
@Order(value=1) //执行顺序，值小优先
public class DfsApplicationRunner implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	}

}
