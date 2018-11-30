package com.dfs.api.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dfs.api.constant.Code;
import com.dfs.api.entity.user.UserEntity;
import com.dfs.api.model.BasicModel;
import com.dfs.api.model.RelationBasicModel;
import com.dfs.api.model.ReturnMsg;
import com.dfs.api.model.TokenModel;
import com.dfs.api.model.user.UserModel;
import com.dfs.api.service.user.UserService;
import com.dfs.api.util.EncryptUtility;
import com.dfs.api.util.HttpUtility;
import com.dfs.api.util.ShiroUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="UserController",tags="用户API")
@RestController
public class UserController extends BasicController{
	/**
	 * 用户服务
	 */
	@Autowired
	private UserService userService;
	/**
	 * shiro服务
	 */
	@Autowired
	private ShiroUtil shiroUtil;
	
    @ApiOperation(value = "登录请求" ,notes="用户登录,并返回token")
    @ApiResponses({
    	@ApiResponse(code = 101, message = "密码错误"),
    	@ApiResponse(code = 102, message = "用户不存在"),
    })
    @ApiImplicitParams({
    	@ApiImplicitParam(name="userName",value="用户名",paramType="query",required=true,dataType="String"),
    	@ApiImplicitParam(name="password",value="密码",paramType="query",required=true,dataType="String"),
    })
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String userName, String password ,HttpServletRequest request) throws Exception{
    	String message="";
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        //创建token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,EncryptUtility.encodeMD5(password));
        //进行验证，这里捕获异常，然后返回对应信息
		subject.login(usernamePasswordToken);
		
		// 登录成功,生成token
		TokenModel tokenModel=new TokenModel(userName, password, HttpUtility.getClientIp(request));
		message=EncryptUtility.encodeToken(tokenModel);
        return message;
    }
    
    @ApiOperation(value="创建用户",notes="创建新用户，并分配角色")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="userName",value="用户名",required=true,paramType="query",dataType="string"),
    	@ApiImplicitParam(name="password",value="密码",required=true,paramType="query",dataType="string"),
    })
    @PutMapping("/user/create")
    public ReturnMsg<UserModel> createUser(String userName,String password,
    		@ApiParam("用户与角色关联模型") @RequestBody List<RelationBasicModel> userRoleRelations) throws Exception {
    	// 检查用户名是否可用
    	if (Code.ERROR==checkUserName(userName).getCode()) {
			return getErrorMsg("用户名已存在");
		}
    	
    	// 封装数据
    	UserModel userModel=new UserModel();
    	userModel.setUserName(userName);
    	// 设置加密后的密码
    	userModel.setPassword(EncryptUtility.encodeMD5(password));
    	userModel.setUserRoleRelations(userRoleRelations);
		return getSuccessMsg(userService.saveOrUpdate(userModel));
	}
    
    @ApiOperation(value="检查用户名是否可用",notes="true:可用 false:不可用")
    @ApiImplicitParam(name="userName",value="用户名",required=true,paramType="query",dataType="string")
    public ReturnMsg<Boolean> checkUserName(String userName) throws Exception {
    	Boolean bln=false;
    	// 查询条件
    	UserEntity condition=new UserEntity();
    	condition.setUserName(userName);
		if (CollectionUtils.isEmpty(userService.selectByCondition(condition))) {
			bln=true;
		}
		return getSuccessMsg(bln);
	}
    
    @ApiOperation(value="获取当前登录用户的信息")
    @GetMapping("/user/info")
    public ReturnMsg<UserEntity> getUserInfo() {
		return getSuccessMsg(ShiroUtil.getUserEntity());
	}
    
    @ApiOperation(value="更改密码",notes="根据用户id更改密码")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="oldPassword",value="用户原密码",paramType="query",required=true,dataType="String"),
    	@ApiImplicitParam(name="newPassword",value="用户新密码",paramType="query",required=true,dataType="String"),
    })
    @RequestMapping(value="/user/updatePassword",method = RequestMethod.PUT)
    public ReturnMsg<UserEntity> updatePassword(String oldPassword, String newPassword) throws Exception{
    	//返回消息
    	ReturnMsg<UserEntity> msg=null;
    	//获取用户id
    	Long id = ShiroUtil.getUserId();
    	
    	//查询条件
    	UserEntity condition=new UserEntity();
    	condition.setId(id);
    	condition.setPassword(EncryptUtility.encodeMD5(oldPassword));
    	
    	// 原密码不正确
    	if(CollectionUtils.isEmpty(userService.selectByCondition(condition))){
    		msg=getErrorMsg("原密码不正确", condition);
    	}
    	// 修改密码
    	else {
			// 更改条件
    		condition.setPassword(EncryptUtility.encodeMD5(newPassword));
    		if (userService.updateBySelective(condition)) {
        		msg=getSuccessMsg("密码修改成功",null);
			}
		}
    	
    	return msg;
    }
    
    @ApiOperation(value="获取权限",notes="获取当前用户全部权限")
    @RequestMapping(value="/user/permissions",method=RequestMethod.GET)
    public ReturnMsg<Set<String>> getPermissions() {
		return getSuccessMsg(shiroUtil.getPermissions());
	}
    
    @ApiOperation(value="获取角色",notes="获取当前用户角色")
    @RequestMapping(value="/user/roles",method=RequestMethod.GET)
    public ReturnMsg<Set<String>> getRoles() {
		return getSuccessMsg(shiroUtil.getRoles());
    }

    @ApiOperation(value="获取编辑下拉列表",notes="根据编辑类型获取编辑基本信息")
    @ApiImplicitParam(name="editorType",value="编辑类型（1：责任编辑 2：美术编辑 3：运营编辑 4：质检员 5：版权经理）",
    		required=true,paramType="query",dataType="int")
    @GetMapping("/user/listEditor")
    public ReturnMsg<List<BasicModel>> listEditorBasicInfo(Integer editorType) {
		return getSuccessMsg(userService.listEditorBasicModel(editorType));
	}
}
