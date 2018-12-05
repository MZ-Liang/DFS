package com.dfs.api.service.user;

import java.util.List;
import java.util.Set;

import com.dfs.api.core.service.SimpleService;
import com.dfs.api.entity.user.UserEntity;
import com.dfs.api.model.BasicModel;
import com.dfs.api.model.user.UserModel;


/**
 * 用户服务接口
 *
 */
public interface UserService extends SimpleService<Long, UserEntity>{
	
	/**
	 * 根据用户id获取角色名称
	 * @param id 用户id
	 * @return
	 */
	Set<String> findRoleName(Long id);

	/**
	 * 根据用户id获取权限path
	 * @param id 用户id
	 * @return
	 */
	Set<String> findPermissionPath(Long id);

	/**
	 * 根据用户名和状态查找用户
	 * @param userName 用户名
	 * @param status 状态
	 * @return
	 */
	UserEntity findByUserName(String userName,Integer status);

	/**
	 * 根据编辑类型获取编辑基本模型
	 * @param editorType 编辑类型
	 * @return
	 */
	List<BasicModel> listEditorBasicModel(Integer editorType);

	/**
	 * 创建或保存用户
	 * @param userModel 用户模型
	 * @return
	 * @throws Exception 
	 */
	UserModel saveOrUpdate(UserModel userModel) throws Exception;

	/**
	 * 批量删除用户（逻辑处理）
	 * @param ids 用户id集合
	 * @return
	 */
	Boolean delete(List<Long> ids) throws Exception ;

	/**
	 * 更新用户密码
	 * @param condition 条件
	 * @return
	 */
	Boolean updatePassword(UserEntity condition) throws Exception ;

}
