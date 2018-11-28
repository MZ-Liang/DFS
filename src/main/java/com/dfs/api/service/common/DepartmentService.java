package com.dfs.api.service.common;

import java.util.List;

import com.dfs.api.core.service.SimpleService;
import com.dfs.api.entity.common.DepartmentEntity;
import com.dfs.api.model.BasicModel;

/**
 * 部门服务
 * @author Ming
 * @date 2018年11月21日
 */
public interface DepartmentService extends SimpleService<Long, DepartmentEntity>{

	/**
	 * 列出全部部门基本信息
	 * @return
	 */
	List<BasicModel> listBasicInfo();

}
