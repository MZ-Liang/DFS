package com.dfs.api.service.common.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.core.service.impl.SimpleServiceImpl;
import com.dfs.api.entity.common.DepartmentEntity;
import com.dfs.api.mapper.common.DepartmentMapper;
import com.dfs.api.model.BasicModel;
import com.dfs.api.service.common.DepartmentService;

/**
 * 部门服务
 * @author Ming
 * @date 2018年11月21日
 */
@Service
public class DepartmentServiceImpl extends SimpleServiceImpl<Long, DepartmentEntity> implements DepartmentService{
	/** 部门mapper */
	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	protected SimpleMapper<Long, DepartmentEntity> getMapper() {
		return departmentMapper;
	}

	/**
	 * 列出全部部门基本信息
	 * @return
	 */
	@Override
	public List<BasicModel> listBasicInfo() {
		List<BasicModel> list=departmentMapper.listBasicMode();
		return list;
	}

}
