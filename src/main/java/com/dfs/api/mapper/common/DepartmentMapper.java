package com.dfs.api.mapper.common;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.common.DepartmentEntity;
import com.dfs.api.model.BasicModel;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 部门表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface DepartmentMapper extends SimpleMapper<Long, DepartmentEntity> {

	/**
	 * 根据图书id获取部门基础模型
	 * @param bookId 图书id
	 * @return
	 */
	List<BasicModel> getDepartmentBasicModelByBookId(Long bookId);

	/**
	 * 列出全部部门基本信息
	 * @return
	 */
	List<BasicModel> listBasicMode();

}