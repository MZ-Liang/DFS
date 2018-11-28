package com.dfs.api.model.author;

import java.io.Serializable;

import com.dfs.api.model.RelationBasicModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 作者基础模型
 * @author Ming
 * @date 2018年11月21日
 */
@ApiModel(value="AuthorBasicModel",description="作者基础模型")
public class AuthorBasicModel extends RelationBasicModel implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("作者简介")
	private String introduction;

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public AuthorBasicModel() {
		super();
	}

	@Override
	public String toString() {
		return "AuthorBasicModel [introduction=" + introduction + ", relationId=" + relationId + ", parentId="
				+ parentId + ", name=" + name + ", id=" + id + "]";
	}

}
