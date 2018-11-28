package com.dfs.api.mapper.book;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.book.BookUnitEntity;
import com.dfs.api.model.RelationBasicModel;

/**
 * 图书与单位关联表数据处理
 * 
 * @author Ming
 * @date 2018-11-15
 */
@Mapper
public interface BookUnitMapper extends SimpleMapper<Long, BookUnitEntity> {

	/**
	 * 根据图书id获取图书与单位关联模型
	 * @param bookId 图书id
	 * @param unitType 单位类型
	 * @return
	 */
	List<RelationBasicModel> getRelationtBasicModelByBookId(@Param("bookId")Long bookId, @Param("unitType")Integer unitType);

}