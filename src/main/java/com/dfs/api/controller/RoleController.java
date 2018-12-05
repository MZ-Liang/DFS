package com.dfs.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dfs.api.entity.user.RoleEntity;
import com.dfs.api.model.PageInfo;
import com.dfs.api.model.ReturnMsg;
import com.dfs.api.model.user.RoleModel;
import com.dfs.api.service.user.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="RoleController",tags="角色API")
@RestController
@RequestMapping("/role")
public class RoleController extends BasicController{
	/** 角色服务 */
	@Autowired
	private RoleService roleService;
	
	@ApiOperation(value="获取角色列表",notes="可进行分页")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageNum",value="当前页数",required=false,paramType="query",dataType="int",defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页的数量",required=false,paramType="query",dataType="int",defaultValue="0"),
	})
	@GetMapping("/list")
	public ReturnMsg<PageInfo<RoleEntity>> listRoles(@RequestParam(required=false,defaultValue="1")Integer pageNum,
			@RequestParam(required=false,defaultValue="0")Integer pageSize) {
		return getSuccessMsg(roleService.listRoles(pageNum,pageSize));
	}

	@ApiOperation(value="获取角色详情",notes="根据id获取角色信息")
	@ApiImplicitParam(name="id",value="角色id",paramType="path",dataType="int",required=true)
	@GetMapping("/detail")
	public ReturnMsg<RoleModel> detail(@PathVariable("id")Long id) {
		return getSuccessMsg(roleService.getRoleModelById(id));
	}
}
