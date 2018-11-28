package com.dfs.api.service.book.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.core.service.impl.SimpleServiceImpl;
import com.dfs.api.entity.book.SeriesEntity;
import com.dfs.api.mapper.author.WritingmodeMapper;
import com.dfs.api.mapper.book.SeriesMapper;
import com.dfs.api.mapper.user.UserMapper;
import com.dfs.api.model.book.SeriesModel;
import com.dfs.api.service.book.SeriesService;

/**
 * 丛书服务
 * @author Ming
 * @date 2018年11月19日
 */
@Service
public class SeriesServiceImpl extends SimpleServiceImpl<Long, SeriesEntity> implements SeriesService{
	/** 丛书mapper */
	@Autowired
	private SeriesMapper seriesMapper;
	/** 用户mapper */
	@Autowired
	private UserMapper userMapper;
	/** 著作方式mapper */
	@Autowired
	private WritingmodeMapper writingmodeMapper;
	
	@Override
	protected SimpleMapper<Long, SeriesEntity> getMapper() {
		return seriesMapper;
	}

	/**
	 * 获取丛书模型
	 * @param seriesId 丛书id
	 * @return
	 */
	@Override
	public SeriesModel getSeriesModel(Long seriesId) {
		// 获取丛书实体
		SeriesEntity entity=seriesMapper.selectByPrimaryKey(seriesId);
		// 创建模型
		SeriesModel model=new SeriesModel();
		
		// 设置模型基础信息
		model.setId(entity.getId());
		model.setName(entity.getName());
		
		// 设置丛书责任者模型
		model.setExecutor(userMapper.getBasicModel(entity.getExecutor()));
		// 设置丛书著作方式
		model.setWritingmode(writingmodeMapper.getBasicModel(entity.getWritingmode()));
		return model;
	}
}
