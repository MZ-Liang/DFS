package com.dfs.api.mapper.user;

import com.dfs.api.core.mapper.SimpleMapper;
import com.dfs.api.entity.user.UserEntity;
import com.dfs.api.model.BasicModel;
import com.dfs.api.model.user.EditorModel;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表数据处理
 * 
 * @author Ming
 * @date 2018-11-13
 */
@Mapper
public interface UserMapper extends SimpleMapper<Long, UserEntity> {

	/**
	 * 获取用户基础模型
	 * @param id 用户id
	 * @return
	 */
	BasicModel getBasicModel(Long id);

	/**
	 * 获取图书的编辑用户基础模型
	 * @param bookId 图书id
	 * @param editorType 编辑类型
	 * @return
	 */
	List<EditorModel> getEditorModelByBookIdAndEditorType(@Param("bookId")Long bookId, @Param("editorType")Integer editorType);


	/**
	 * 根据编辑类型获取编辑基本模型
	 * @param editorType 编辑类型
	 * @return
	 */
	List<BasicModel> listEditorBasicModel(Integer editorType);

}