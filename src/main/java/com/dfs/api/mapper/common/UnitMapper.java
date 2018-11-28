package com.dfs.api.mapper.common;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.common.UnitEntity;
import com.dfs.api.model.BasicModel;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 单位合表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface UnitMapper extends SimpleMapper<Long, UnitEntity> {

	/**
	 * 通过图书id获取单位基础模型
	 * @param bookId 图书id
	 * @param unitType 单位类型(UNrequired)
	 * @return
	 */
	List<BasicModel> getBasicModelByBookId(@Param("bookId")Long bookId, @Param("unitType")Integer unitType);
	
	/**
	 * 通过单位id获取单位基础模型
	 * @param id 单位id
	 * @return
	 */
	BasicModel getBasicModelById(Long id);

	/**
	 * 根据单位类型列出单位信息
	 * @param unitType 单位类型
	 * @return
	 */
	List<BasicModel> listBasicInfo(Integer unitType);

}