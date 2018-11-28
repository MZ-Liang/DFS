package com.dfs.api.mapper.author;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.author.WritingmodeEntity;
import com.dfs.api.model.BasicModel;

import org.apache.ibatis.annotations.Mapper;

/**
 * 著作方式表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface WritingmodeMapper extends SimpleMapper<Long, WritingmodeEntity> {

	/**
	 * 获取著作方式基础模型
	 * @param id 著作方式id
	 * @return
	 */
	BasicModel getBasicModel(Long id);

}