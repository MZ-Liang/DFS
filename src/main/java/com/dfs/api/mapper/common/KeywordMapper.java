package com.dfs.api.mapper.common;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.common.KeywordEntity;
import com.dfs.api.model.BasicModel;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * CIP主题词表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface KeywordMapper extends SimpleMapper<Long, KeywordEntity> {

	/**
	 * 通过图书id获取CIP主题词基础模型
	 * @param bookId 图书id
	 * @return 主题词基础模型
	 */
	List<BasicModel> getBasicModelByBookId(Long bookId);

}