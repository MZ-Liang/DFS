package com.dfs.api.core.interceptor;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dfs.api.core.exception.InvalidTokenException;
import com.dfs.api.core.exception.IpAddressException;
import com.dfs.api.core.exception.NoLoginExceprion;
import com.dfs.api.entity.user.UserEntity;
import com.dfs.api.model.TokenModel;
import com.dfs.api.service.user.UserService;
import com.dfs.api.util.EncryptUtility;
import com.dfs.api.util.HttpUtility;

/**
 * Controller层 不登录拦截
 * 
 * @author Ming
 * @date 2018年11月9日
 */
@Aspect
@Component
public class ControllerLoginInterceptor {
	/** 用户服务 */
	@Autowired
	private UserService userService;

	/**
	 * 未登录处理切入点
	 */
	@Pointcut("execution(public com.dfs.api.model.ReturnMsg  com.dfs.api.controller..*(..))")
	public void noLoginPointcut() {
	}

	/**
	 * 未登录处理
	 * 
	 * @throws Exception
	 */
	@Before("noLoginPointcut()")
	public void before() throws Exception {
		// 获取request
		HttpServletRequest request = HttpUtility.getRequest();

		// 判断登录
		if (null == SecurityUtils.getSubject().getPrincipal()) {
			// token处理
			if (!executeToken(request)) {
				// 未登录，抛出异常
				throw new NoLoginExceprion();
			}
		}
	}

	/**
	 * token处理
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private boolean executeToken(HttpServletRequest request) throws Exception {
		String token = request.getHeader("Authorization");
		// 无token
		if (StringUtils.isBlank(token)) {
			return false;
		}
		TokenModel tokenModel = null;
		// 解析token
		try {
			tokenModel = EncryptUtility.decodeToken(token);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			// token无效
			throw new InvalidTokenException();
		}
		// ip地址异常
		if (!HttpUtility.getClientIp(request).equals(tokenModel.getClient())) {
			throw new IpAddressException();
		}
		UserEntity condition = new UserEntity();
		condition.setUserName(tokenModel.getAccessKey());
		condition.setPassword(EncryptUtility.encodeMD5(tokenModel.getSecretKey()));
		// token无效
		if (CollectionUtils.isEmpty(userService.selectByCondition(condition))) {
			throw new InvalidTokenException();
		}
		// 添加用户认证信息
		Subject subject = SecurityUtils.getSubject();
		// 创建token
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(condition.getUserName(),
				condition.getPassword());
		// 进行验证，这里捕获异常，然后返回对应信息
		subject.login(usernamePasswordToken);
		return true;
	}

}
