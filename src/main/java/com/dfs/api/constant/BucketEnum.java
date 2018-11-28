package com.dfs.api.constant;

/**
 * minio存储的bucket枚举，模块枚举
 * @author Ming
 * @date 2018年11月20日
 */
public enum BucketEnum {
	/** 图书 */
	BOOK("book",1),
	/** 文集 */
	CORPUS("corpus",2),
	/** 论文 */
	THESIS("thesis",3),
	/** 图片 */
	IMAGE("image",4),
	/** 音频 */
	RADIO("radio",5),
	/** 视频 */
	VIDEO("video",6);
	
	private String name;
	private Integer index;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	private BucketEnum(String name,Integer index) {
		this.name=name;
		this.index=index;
	}
	
	/**
	   *   根据index获取枚举name
	 * @param index
	 * @return
	 */
	public static String getName(Integer index) {
		for (BucketEnum bucketEnum : BucketEnum.values()) {
			if (bucketEnum.getIndex()==index) {
				return bucketEnum.getName();
			}
		}
		return null;
	}
}
