package com.dfs.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value="SystemController",tags="系统API")
@RestController
@RequestMapping("/system")
public class SystemController extends BasicController{

}
