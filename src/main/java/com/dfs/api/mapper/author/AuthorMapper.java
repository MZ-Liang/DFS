package com.dfs.api.mapper.author;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.author.AuthorEntity;
import com.dfs.api.model.author.AuthorBasicModel;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 作者表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface AuthorMapper extends SimpleMapper<Long, AuthorEntity> {

	/**
	 * 根据图书id获取作者 
	 * @param bookId 图书id
	 * @param otherFlag 其他作者标识
	 * @return List<BasicModel>
	 */
	List<AuthorBasicModel> getBasicModelByBookId(@Param("bookId")Long bookId, @Param("otherFlag")Integer otherFlag);

}