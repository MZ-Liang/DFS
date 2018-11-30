package com.dfs.api.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.core.service.impl.SimpleServiceImpl;
import com.dfs.api.entity.user.RoleEntity;
import com.dfs.api.mapper.user.RoleMapper;
import com.dfs.api.mapper.user.UserRoleMapper;
import com.dfs.api.model.PageInfo;
import com.dfs.api.service.user.RoleService;
import com.github.pagehelper.PageHelper;

/**
 * 角色服务
 * @author Ming
 * @date 2018年11月30日
 */
@Service
public class RoleServiceImpl extends SimpleServiceImpl<Long, RoleEntity> implements RoleService {
	/** 角色mapper */
	@Autowired
	private RoleMapper roleMapper;
	/** 用户与角色关联mapper */
	@Autowired
	private UserRoleMapper userRoleMapper;
	

	@Override
	protected SimpleMapper<Long, RoleEntity> getMapper() {
		return roleMapper;
	}

	/**
	 * 获取角色列表（可进行分页）
	 * @param pageNum 当前页数
	 * @param pageSize 每页大小
	 * @return
	 */
	@Override
	public PageInfo<RoleEntity> listRoles(Integer pageNum, Integer pageSize) {
		// 查询条件
		RoleEntity condition=new RoleEntity();
		
		// 是否分页由pageSize判断，为0全查
		PageHelper.startPage(pageNum, pageSize, pageSize==0?false:true);
		List<RoleEntity> list=roleMapper.selectByCondition(condition);
		return new PageInfo<RoleEntity>(list);
	}

}
