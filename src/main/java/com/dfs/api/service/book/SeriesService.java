package com.dfs.api.service.book;

import com.dfs.api.core.service.SimpleService;
import com.dfs.api.entity.book.SeriesEntity;
import com.dfs.api.model.book.SeriesModel;

/**
 * 丛书服务
 * @author Ming
 * @date 2018年11月19日
 */
public interface SeriesService extends SimpleService<Long, SeriesEntity>{

	/**
	 * 获取丛书模型
	 * @param seriesId 丛书id
	 * @return
	 */
	SeriesModel getSeriesModel(Long seriesId);

}
