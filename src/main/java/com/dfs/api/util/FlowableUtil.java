package com.dfs.api.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dfs.api.entity.user.UserEntity;
import com.dfs.api.model.HttpResult;
import com.dfs.api.model.TokenModel;

/**
 * flowable工作流工具类
 * 
 * @author Ming
 * @date 2018年12月3日
 */
public class FlowableUtil {
	/** flowable 字符串 */
	private static final String FLOWABLE_PREFIX = "flowable-";
	/** flowable Process 根 */
	private static final String FLOWABLE_PROCESS_HOME = "/service";
	/** flowable IDM 根 */
	private static final String FLOWABLE_IDM_HOME = "/idm-api";
	/** flowable DMN 根 */
	private static final String FLOWABLE_DMN_HOME = "/dmn-api";
	/** flowable CMMN 根 */
	private static final String FLOWABLE_CMMN_HOME = "/cmmn-api";
	/** flowable FORM 根 */
	private static final String FLOWABLE_FORM_HOME = "/form-api";
	/** flowable CONTENT 根 */
	private static final String FLOWABLE_CONTENT_HOME = "/content-api";
	/** flowable APP 根 */
	private static final String FLOWABLE_APP_HOME = "/app-api";

	/** flowable 管理员 */
	private TokenModel admin;
	/** flowable rest 客户端 */
	private String client;

	/** flowable Process 客户端 */
	private String processClietn;
	/** flowable IDM 客户端 */
	private String idmClient;
	/** flowable DMN 客户端 */
	private String dmnClient;
	/** flowable CMMN 客户端 */
	private String cmmnClient;
	/** flowable Form 客户端 */
	private String formClient;
	/** flowable Content 客户端 */
	private String contentClient;
	/** flowable App 客户端 */
	private String appClient;

	/** 访问flowable rest api权限id */
	private String privalegeRestApiId;
	/** 访问flowable admin权限id */
	private String privalegeAdminId;
	/** 访问flowable idm权限id */
	private String privalegeIdmId;
	/** 访问flowable modeler权限id */
	private String privalegeModelerId;
	/** 访问flowable task权限id */
	private String privalegeTaskId;

	/** HttpClient服务工具类 */
	private HttpClientUtil httpClientUtil;

	/**
	 * 构造器
	 * 
	 * @param admin
	 * @param client
	 * @throws Exception
	 */
	public FlowableUtil(TokenModel admin, String client, HttpClientUtil httpClientUtil) throws Exception {
		super();
		this.admin = admin;
		this.client = client;
		this.processClietn = client + FLOWABLE_PROCESS_HOME;
		this.idmClient = client + FLOWABLE_IDM_HOME;
		this.dmnClient = client + FLOWABLE_DMN_HOME;
		this.cmmnClient = client + FLOWABLE_CMMN_HOME;
		this.formClient = client + FLOWABLE_FORM_HOME;
		this.contentClient = client + FLOWABLE_CONTENT_HOME;
		this.appClient = client + FLOWABLE_APP_HOME;
		this.httpClientUtil = httpClientUtil;
		initPrivaleges();
	}

	/**
	 * 初始化flowable权限id
	 * 
	 * @throws Exception
	 */
	private void initPrivaleges() throws Exception {
		// 请求flowable权限列表
		HttpResult result = privileges();
		// 200 请求成功，否则抛异常
		if (200 == result.getCode()) {
			// json解析权限列表
			JSONArray jsonArray = JSONArray.parseArray(JSONObject.parseObject(result.getBody()).get("data").toString());
			JSONObject jsonObject = null;
			// 赋值权限id
			for (Object object : jsonArray) {
				// 解析
				jsonObject = JSONObject.parseObject(object.toString());
				switch (jsonObject.get("name").toString()) {
				case "access-rest-api":
					this.privalegeRestApiId = jsonObject.getString("id");
					break;
				case "access-admin":
					this.privalegeAdminId = jsonObject.getString("id");
					break;
				case "access-idm":
					this.privalegeIdmId = jsonObject.getString("id");
					break;
				case "access-modeler":
					this.privalegeModelerId = jsonObject.getString("id");
					break;
				case "access-task":
					this.privalegeTaskId = jsonObject.getString("id");
					break;

				default:
					break;
				}
			}
		} else {
			throw new Exception();
		}
	}

	/**
	 * 获取flowable权限列表
	 * 
	 * @return code [200:获取列表成功]
	 * @throws Exception
	 */
	public HttpResult privileges() throws Exception {
		return httpClientUtil.doGet(idmClient + "/privileges", "rest-admin:test", null);
	}

	/**
	 * 创建flowable用户
	 * @param userId 用户id
	 * @param userName 用户名
	 * @param password 用户密码（MD5加密后）
	 * @return code [201:已创建用户]
	 * @throws Exception
	 */
	public HttpResult createFlowableUser(Long userId, String userName, String password) throws Exception {
		// 请求body参数
		JSONObject body = new JSONObject();
		body.put("id", getFlowableId(userId.toString()));
		body.put("firstName", userName);
		body.put("password", getFlowablePassword(password));
		// 调用flowable接口，创建flowable用户
		return httpClientUtil.doPost(idmClient + "/users",
				getAuthorization(ShiroUtil.getUserEntity()), body.toJSONString());
	}

	/**
	 * 更新flowable用户信息（null：不修改，"":置空）
	 * @param userId 用户id（require）
	 * @param userName
	 * @param password
	 * @return code [200:修改成功]
	 * @throws Exception
	 */
	public HttpResult updateFlowableUserSelected(Long userId, String userName, String password) throws Exception {
		// 请求body参数
		JSONObject body = new JSONObject();
		// 获取flowable专用id
		String id=getFlowableId(userId.toString());
		body.put("id", id);
		if (null!=userName) {
			body.put("lastName", userName);
		}
		if (null!=password) {
			body.put("password", getFlowablePassword(password));
		}
		// 调用flowable接口，更新flowable用户
		return httpClientUtil.doPut(idmClient + "/users/" + id,
				getAuthorization(ShiroUtil.getUserEntity()), body.toJSONString());
	}
	
	/**
	 * 删除flowable用户
	 * @param userId 用户id
	 * @return code [204：找到并成功删除]
	 * @throws Exception
	 */
	public HttpResult deleteFlowableUser(Long userId) throws Exception {
		// 调用flowable接口，更新flowable用户
		return httpClientUtil.doDelete(idmClient + "/users/" + getFlowableId(userId.toString()),
				getAuthorization(ShiroUtil.getUserEntity()), null);
	}
	
	/**
	 * 给用户授权
	 * @param userId 用户id
	 * @param privalegeId flowable权限id
	 * @return code [200:成功授权]
	 * @throws Exception
	 */
	public HttpResult givePrivalege(Long userId,String privalegeId) throws Exception {
		// 请求body参数
		JSONObject body = new JSONObject();
		// 获取flowable专用id
		String id=getFlowableId(userId.toString());
		body.put("userId", id);
		return httpClientUtil.doPost(idmClient + "/privileges/"+privalegeId+"/users",
				getAuthorization(ShiroUtil.getUserEntity()), body.toJSONString());
	}

	/**
	 * 获取flowable id
	 * 
	 * @param userId 用户id
	 * @return
	 */
	public static String getFlowableId(String userId) {
		return FLOWABLE_PREFIX + userId;
	}

	/**
	 * 获取flowable密码
	 * 
	 * @param userPassword 用户密码
	 * @return
	 */
	public static String getFlowablePassword(String userPassword) {
		return FLOWABLE_PREFIX + userPassword;
	}

	/**
	 * 获取flowable身份信息
	 * 
	 * @param userEntity 用户实体
	 * @return
	 */
	public static String getAuthorization(UserEntity userEntity) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(FLOWABLE_PREFIX);
		buffer.append(userEntity.getId());
		buffer.append(":");
		buffer.append(FLOWABLE_PREFIX);
		buffer.append(userEntity.getPassword());
		return buffer.toString();
	}

	/**
	 * 获取flowable管理员信息
	 * 
	 * @return
	 */
	public TokenModel getAdmin() {
		return admin;
	}

	/**
	 * 获取flowable rest 客户端
	 * 
	 * @return
	 */
	public String getClient() {
		return client;
	}

	/**
	 * 获取flowable Process 客户端
	 * 
	 * @return
	 */
	public String getProcessClietn() {
		return processClietn;
	}

	/**
	 * 获取flowable IDM 客户端
	 * 
	 * @return
	 */
	public String getIdmClient() {
		return idmClient;
	}

	/**
	 * 获取flowable DMN 客户端
	 * 
	 * @return
	 */
	public String getDmnClient() {
		return dmnClient;
	}

	/**
	 * 获取flowable CMMN 客户端
	 * 
	 * @return
	 */
	public String getCmmnClient() {
		return cmmnClient;
	}

	/**
	 * 获取flowable Form 客户端
	 * 
	 * @return
	 */
	public String getFormClient() {
		return formClient;
	}

	/**
	 * 获取flowable Content 客户端
	 * 
	 * @return
	 */
	public String getContentClient() {
		return contentClient;
	}

	/**
	 * 获取flowable App 客户端
	 * 
	 * @return
	 */
	public String getAppClient() {
		return appClient;
	}

	/**
	 * 获取访问flowable rest api权限id
	 * 
	 * @return
	 */
	public String getPrivalegeRestApiId() {
		return privalegeRestApiId;
	}

	/**
	 * 获取访问flowable admin权限id
	 * 
	 * @return
	 */
	public String getPrivalegeAdminId() {
		return privalegeAdminId;
	}

	/**
	 * 获取访问flowable idm权限id
	 * 
	 * @return
	 */
	public String getPrivalegeIdmId() {
		return privalegeIdmId;
	}

	/**
	 * 获取访问flowable modeler权限id
	 * 
	 * @return
	 */
	public String getPrivalegeModelerId() {
		return privalegeModelerId;
	}

	/**
	 * 获取访问flowable task权限id
	 * 
	 * @return
	 */
	public String getPrivalegeTaskId() {
		return privalegeTaskId;
	}
}
