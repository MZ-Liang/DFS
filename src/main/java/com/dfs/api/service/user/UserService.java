package com.dfs.api.service.user;

import java.util.List;
import java.util.Set;

import com.dfs.api.core.service.SimpleService;
import com.dfs.api.entity.user.UserEntity;
import com.dfs.api.model.BasicModel;


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
	 * 根据用户名查找用户
	 * @param userName 用户名
	 * @return
	 */
	UserEntity findByUserName(String userName);

	/**
	 * 根据编辑类型获取编辑基本模型
	 * @param editorType 编辑类型
	 * @return
	 */
	List<BasicModel> listEditorBasicModel(Integer editorType);

}
