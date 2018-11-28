package com.dfs.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dfs.api.model.BasicModel;
import com.dfs.api.model.ReturnMsg;
import com.dfs.api.service.common.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="DepartmentController",tags="部门API")
@RestController
@RequestMapping("/department")
public class DepartmentController extends BasicController{
	/** 部门服务 */
	@Autowired
	private DepartmentService departmentService;
	
	@ApiOperation(value="获取部门下拉列表",notes="列出全部部门基本信息")
	@GetMapping("/listBasicInfo")
	public ReturnMsg<List<BasicModel>> listBasicInfo() {
		return getSuccessMsg(departmentService.listBasicInfo());
	}
}
