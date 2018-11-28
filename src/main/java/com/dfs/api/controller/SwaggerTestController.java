package com.dfs.api.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//类注解,接口简要标注
@Api(value="SwaggerTestController",tags="swagger测试接口")
@Controller
public class SwaggerTestController extends BasicController{
	
	//方法功能注解
	@ApiOperation(value="获取model",notes="根据id获取model")
	//参数注解,接口需要的参数，可以有多个，这里只写了一个，它的paramType还有path、query、body、form几种
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="参数id",paramType="path",required=true,dataType="Long"),
	})
	//接口响应信息，这里定义了一个401，当出现401，接口返回的是错误Error的实例。当然可以定义多个。
	@ApiResponses({
		@ApiResponse(code=401,message="请求未通过认证",response = Error.class)
	})
	@RequestMapping(value="/swagger/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getMessageById(@PathVariable("id")Long id) {
		return "success";
	}
	
	@ApiOperation(value="API首页",notes="API入口")
	@RequestMapping(value="/api",method = RequestMethod.GET)
	public String api(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath()+"/swagger-ui.html");
		return null;
	}

}
