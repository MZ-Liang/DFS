package com.dfs.api.service.user;

import com.dfs.api.core.service.SimpleService;
import com.dfs.api.entity.user.RoleEntity;
import com.dfs.api.model.PageInfo;

/**
 * 角色服务
 * @author Ming
 * @date 2018年11月30日
 */
public interface RoleService extends SimpleService<Long, RoleEntity> {

	/**
	 * 获取角色列表（可进行分页）
	 * @param pageNum 当前页数
	 * @param pageSize 每页大小
	 * @return
	 */
	PageInfo<RoleEntity> listRoles(Integer pageNum, Integer pageSize);

}
