package com.dfs.api.entity.author;

import java.io.Serializable;

import com.dfs.api.core.entity.Entity;

/**
 * 作者表实体
 * 
 * @author Ming
 * @date 2018-11-13
 */
public class AuthorEntity extends Entity implements Serializable {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 作者名称 */
	private String authorName;

	/** 性别 */
	private String sex;

	/** 状态(1:编辑中 2:待发布 3:已发布 4:已删除) */
	private Integer status;

	/** 作者类型(0:个人 1:机构) */
	private Long authorType;

	/** 国籍 */
	private Long nationality;

	/** 朝代 */
	private Long dynasty;

	/** 是否签约(0:否 1:是) */
	private Integer contracted;

	/** 头像 */
	private Long image;

	/** 简介视频 */
	private Long introductionVidio;

	/** 移动电话 */
	private String phone;

	/** 座机 */
	private String tellphone;

	/** 传真 */
	private String fax;

	/** QQ */
	private String qq;

	/** 微信 */
	private String wechar;

	/** 微信公众号 */
	private String wecharNumber;

	/** 职称 */
	private String professionName;

	/** 通讯地址 */
	private String address;

	/** 所属部门 */
	private Long department;

	/** 创建者 */
	private Long creator;

	/** 更新者 */
	private Long regenerator;

	/** 创建时间 */
	private Long createTime;

	/** 更新时间 */
	private Long updateTime;

	/** 出版时间 */
	private Long publishTime;

	/** 发版时间 */
	private Long issueTime;

	/** 删除时间 */
	private Long deleteTime;

	/** 简介 */
	private String introduction;

	/**
	 * 取得作者名称
	 * 
	 * @return 作者名称
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * 设定作者名称
	 * 
	 * @param authorName 作者名称
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * 取得性别
	 * 
	 * @return 性别
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设定性别
	 * 
	 * @param sex 性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 取得状态(1:编辑中 2:待发布 3:已发布 4:已删除)
	 * 
	 * @return 状态(1:编辑中 2:待发布 3:已发布 4:已删除)
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设定状态(1:编辑中 2:待发布 3:已发布 4:已删除)
	 * 
	 * @param status 状态(1:编辑中 2:待发布 3:已发布 4:已删除)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 取得作者类型(0:个人 1:机构)
	 * 
	 * @return 作者类型(0:个人 1:机构)
	 */
	public Long getAuthorType() {
		return authorType;
	}

	/**
	 * 设定作者类型(0:个人 1:机构)
	 * 
	 * @param authorType 作者类型(0:个人 1:机构)
	 */
	public void setAuthorType(Long authorType) {
		this.authorType = authorType;
	}

	/**
	 * 取得国籍
	 * 
	 * @return 国籍
	 */
	public Long getNationality() {
		return nationality;
	}

	/**
	 * 设定国籍
	 * 
	 * @param nationality 国籍
	 */
	public void setNationality(Long nationality) {
		this.nationality = nationality;
	}

	/**
	 * 取得朝代
	 * 
	 * @return 朝代
	 */
	public Long getDynasty() {
		return dynasty;
	}

	/**
	 * 设定朝代
	 * 
	 * @param dynasty 朝代
	 */
	public void setDynasty(Long dynasty) {
		this.dynasty = dynasty;
	}

	/**
	 * 取得是否签约(0:否 1:是)
	 * 
	 * @return 是否签约(0:否 1:是)
	 */
	public Integer getContracted() {
		return contracted;
	}

	/**
	 * 设定是否签约(0:否 1:是)
	 * 
	 * @param contracted 是否签约(0:否 1:是)
	 */
	public void setContracted(Integer contracted) {
		this.contracted = contracted;
	}

	/**
	 * 取得头像
	 * 
	 * @return 头像
	 */
	public Long getImage() {
		return image;
	}

	/**
	 * 设定头像
	 * 
	 * @param image 头像
	 */
	public void setImage(Long image) {
		this.image = image;
	}

	/**
	 * 取得简介视频
	 * 
	 * @return 简介视频
	 */
	public Long getIntroductionVidio() {
		return introductionVidio;
	}

	/**
	 * 设定简介视频
	 * 
	 * @param introductionVidio 简介视频
	 */
	public void setIntroductionVidio(Long introductionVidio) {
		this.introductionVidio = introductionVidio;
	}

	/**
	 * 取得移动电话
	 * 
	 * @return 移动电话
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设定移动电话
	 * 
	 * @param phone 移动电话
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	/**
	 * 取得座机
	 * 
	 * @return 座机
	 */
	public String getTellphone() {
		return tellphone;
	}

	/**
	 * 设定座机
	 * 
	 * @param tellphone 座机
	 */
	public void setTellphone(String tellphone) {
		this.tellphone = tellphone == null ? null : tellphone.trim();
	}

	/**
	 * 取得传真
	 * 
	 * @return 传真
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * 设定传真
	 * 
	 * @param fax 传真
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * 取得QQ
	 * 
	 * @return QQ
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * 设定QQ
	 * 
	 * @param qq QQ
	 */
	public void setQq(String qq) {
		this.qq = qq == null ? null : qq.trim();
	}

	/**
	 * 取得微信
	 * 
	 * @return 微信
	 */
	public String getWechar() {
		return wechar;
	}

	/**
	 * 设定微信
	 * 
	 * @param wechar 微信
	 */
	public void setWechar(String wechar) {
		this.wechar = wechar == null ? null : wechar.trim();
	}

	/**
	 * 取得微信公众号
	 * 
	 * @return 微信公众号
	 */
	public String getWecharNumber() {
		return wecharNumber;
	}

	/**
	 * 设定微信公众号
	 * 
	 * @param wecharNumber 微信公众号
	 */
	public void setWecharNumber(String wecharNumber) {
		this.wecharNumber = wecharNumber == null ? null : wecharNumber.trim();
	}

	/**
	 * 取得职称
	 * 
	 * @return 职称
	 */
	public String getProfessionName() {
		return professionName;
	}

	/**
	 * 设定职称
	 * 
	 * @param professionName 职称
	 */
	public void setProfessionName(String professionName) {
		this.professionName = professionName == null ? null : professionName.trim();
	}

	/**
	 * 取得通讯地址
	 * 
	 * @return 通讯地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设定通讯地址
	 * 
	 * @param address 通讯地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 取得所属部门
	 * 
	 * @return 所属部门
	 */
	public Long getDepartment() {
		return department;
	}

	/**
	 * 设定所属部门
	 * 
	 * @param department 所属部门
	 */
	public void setDepartment(Long department) {
		this.department = department;
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
	 * 取得出版时间
	 * 
	 * @return 出版时间
	 */
	public Long getPublishTime() {
		return publishTime;
	}

	/**
	 * 设定出版时间
	 * 
	 * @param publishTime 出版时间
	 */
	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * 取得发版时间
	 * 
	 * @return 发版时间
	 */
	public Long getIssueTime() {
		return issueTime;
	}

	/**
	 * 设定发版时间
	 * 
	 * @param issueTime 发版时间
	 */
	public void setIssueTime(Long issueTime) {
		this.issueTime = issueTime;
	}

	/**
	 * 取得删除时间
	 * 
	 * @return 删除时间
	 */
	public Long getDeleteTime() {
		return deleteTime;
	}

	/**
	 * 设定删除时间
	 * 
	 * @param deleteTime 删除时间
	 */
	public void setDeleteTime(Long deleteTime) {
		this.deleteTime = deleteTime;
	}

	/**
	 * 取得简介
	 * 
	 * @return 简介
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * 设定简介
	 * 
	 * @param introduction 简介
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * 取得作者表实体字符串
	 * 
	 * @return 作者表实体字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", authorName=").append(authorName);
		sb.append(", sex=").append(sex);
		sb.append(", status=").append(status);
		sb.append(", authorType=").append(authorType);
		sb.append(", nationality=").append(nationality);
		sb.append(", dynasty=").append(dynasty);
		sb.append(", contracted=").append(contracted);
		sb.append(", image=").append(image);
		sb.append(", introductionVidio=").append(introductionVidio);
		sb.append(", phone=").append(phone);
		sb.append(", tellphone=").append(tellphone);
		sb.append(", fax=").append(fax);
		sb.append(", qq=").append(qq);
		sb.append(", wechar=").append(wechar);
		sb.append(", wecharNumber=").append(wecharNumber);
		sb.append(", professionName=").append(professionName);
		sb.append(", address=").append(address);
		sb.append(", department=").append(department);
		sb.append(", creator=").append(creator);
		sb.append(", regenerator=").append(regenerator);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", publishTime=").append(publishTime);
		sb.append(", issueTime=").append(issueTime);
		sb.append(", deleteTime=").append(deleteTime);
		sb.append(", introduction=").append(introduction);
		sb.append("]");
		return sb.toString();
	}
}