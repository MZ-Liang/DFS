package com.dfs.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dfs.api.model.BasicModel;
import com.dfs.api.model.ReturnMsg;
import com.dfs.api.service.common.impl.UnitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value="UnitController",tags="单位API")
@RestController
@RequestMapping("/unit")
public class UnitController extends BasicController{
	/** 单位服务 */
	@Autowired
	private UnitService unitService;
	
	@ApiOperation(value="获取单位下拉列表",notes="根据单位类型列出单位信息")
	@ApiImplicitParam(name="unitType",value="单位类型(1：排版单位 2：制作单位)")
	@GetMapping("/listBasicInfo")
	public ReturnMsg<List<BasicModel>> listBasicInfo(Integer unitType) {
		return getSuccessMsg(unitService.listBasicInfo(unitType));
	}
}
