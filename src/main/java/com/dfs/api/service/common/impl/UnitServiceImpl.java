package com.dfs.api.service.common.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.core.service.impl.SimpleServiceImpl;
import com.dfs.api.entity.common.UnitEntity;
import com.dfs.api.mapper.common.UnitMapper;
import com.dfs.api.model.BasicModel;

/**
 * 单位服务
 * @author Ming
 * @date 2018年11月26日
 */
@Service
public class UnitServiceImpl extends SimpleServiceImpl<Long, UnitEntity> implements UnitService {
	/** 单位mapper */
	@Autowired
	private UnitMapper unitMapper;

	@Override
	protected SimpleMapper<Long, UnitEntity> getMapper() {
		return unitMapper;
	}

	/**
	 * 根据单位类型列出单位信息
	 * @param unitType 单位类型
	 * @return
	 */
	@Override
	public List<BasicModel> listBasicInfo(Integer unitType) {
		return unitMapper.listBasicInfo(unitType);
	}

}
