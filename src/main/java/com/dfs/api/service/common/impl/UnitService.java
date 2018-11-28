package com.dfs.api.service.common.impl;

import java.util.List;

import com.dfs.api.core.service.SimpleService;
import com.dfs.api.entity.common.UnitEntity;
import com.dfs.api.model.BasicModel;

/**
 * 单位服务接口
 * @author Ming
 * @date 2018年11月26日
 */
public interface UnitService extends SimpleService<Long, UnitEntity>{

	/**
	 * 根据单位类型列出单位信息
	 * @param unitType 单位类型
	 * @return
	 */
	List<BasicModel> listBasicInfo(Integer unitType);

}
