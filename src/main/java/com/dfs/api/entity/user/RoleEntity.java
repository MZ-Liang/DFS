package com.dfs.api.entity.user;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 角色表实体
 * 
 * @author Ming
 * @date 2018-11-20
 */
public class RoleEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 角色名 */
	private String roleName;

	/** 创建者 */
	private Long creator;

	/** 创建时间 */
	private Long createTime;

	/** 更新者 */
	private Long regenerator;

	/** 更新时间 */
	private Long updateTime;

	/** 描述 */
	private String description;

	/**
	 * 取得角色名
	 * 
	 * @return 角色名
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 设定角色名
	 * 
	 * @param roleName 角色名
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	/**
	 * 取得创建者
	 * 
	 * @return 创建者
	 */
	public Long getCreator() {
		return creator;
	}

	/**
	 * 设定创建者
	 * 
	 * @param creator 创建者
	 */
	public void setCreator(Long creator) {
		this.creator = creator;
	}

	/**
	 * 取得创建时间
	 * 
	 * @return 创建时间
	 */
	public Long getCreateTime() {
		return createTime;
	}

	/**
	 * 设定创建时间
	 * 
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	/**
	 * 取得更新者
	 * 
	 * @return 更新者
	 */
	public Long getRegenerator() {
		return regenerator;
	}

	/**
	 * 设定更新者
	 * 
	 * @param regenerator 更新者
	 */
	public void setRegenerator(Long regenerator) {
		this.regenerator = regenerator;
	}

	/**
	 * 取得更新时间
	 * 
	 * @return 更新时间
	 */
	public Long getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设定更新时间
	 * 
	 * @param updateTime 更新时间
	 */
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 取得描述
	 * 
	 * @return 描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设定描述
	 * 
	 * @param description 描述
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * 取得角色表实体字符串
	 * 
	 * @return 角色表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", roleName=").append(roleName);
		sb.append(", creator=").append(creator);
		sb.append(", createTime=").append(createTime);
		sb.append(", regenerator=").append(regenerator);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", description=").append(description);
		sb.append("]");
		return sb.toString();
	}
}