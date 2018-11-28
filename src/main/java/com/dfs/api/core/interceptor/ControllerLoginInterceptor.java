package com.dfs.api.core.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.dfs.api.core.exception.NoLoginExceprion;
import com.dfs.api.util.HttpUtility;
import com.dfs.api.util.ShiroUtil;

/**
 * Controller层 不登录拦截
 * @author Ming
 * @date 2018年11月9日
 */
@Aspect
@Component
public class ControllerLoginInterceptor {
	/** 无须处理的请求 */
	private static final Set<String> set = new HashSet<>();
	
	public ControllerLoginInterceptor() {
		super();
		/** 初始化set */
		set.add("/login");
		set.add("/api");
		set.add("/regist");
		set.add("/test");
	}
	
	/**
	 * 未登录处理切入点
	 */
	@Pointcut("execution(public com.dfs.api.model.ReturnMsg  com.dfs.api.controller..*(..))")
	public void noLoginPointcut() {}
	
	/**
	 * 未登录处理
	 */
	@Before("noLoginPointcut()")
	public void before() {
		//获取request
		HttpServletRequest request=HttpUtility.getRequest();
		//获取请求路径
		String url=request.getRequestURI();
		//项目根路径
		String path=request.getContextPath();
		//存在根，则移除
		if (!"/".equals(path)) {
			url=StringUtils.removeStart(url, path);
		}
		//过滤请求
		if (!set.contains(url)) {
			//判断登录
			if (ShiroUtil.getUserId()==null) {
				//未登录，抛出异常
				throw new NoLoginExceprion();
			}
		}
	}

}
