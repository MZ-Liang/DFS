package com.dfs.api.constant;

/**
 * 文件前缀枚举（与FileType常量集对应）
 * @author Ming
 * @date 2018年11月20日
 */
public enum FilePrefixEnum {
	/** 编辑原稿 */
	PRIFIX_1("edit_manuscript",1),
	/** 正文排版文件 */
	PRIFIX_2("text_typesetting_file",2),
	/** 封面扉页设计文件 */
	PRIFIX_3("cover_page_design_file",3),
	/** 设计素材文件 */
	PRIFIX_4("design_material_file",4),
	/** 其他排版设计文件 */
	PRIFIX_5("other_typesetting_design",5),
	/** 条形码 */
	PRIFIX_6("bar_code",6),
	/** 封面扉页印刷文件 */
	PRIFIX_7("printed_cover_page_file",7),
	/** 版权页文件 */
	PRIFIX_8("copyright_page_file",8),
	/** 付型文件 */
	PRIFIX_9("payment_file",9),
	/** 其他印刷文件 */
	PRIFIX_10("other_printed_file",10),
	/** 封面(缩略图) */
	PRIFIX_11("cover_thumbnail",11),
	/** 扉页(缩略图) */
	PRIFIX_12("flyleaf_thumbnail",12),
	/** PDF文件 */
	PRIFIX_13("pdf_file",13),
	/** EPUB文件 */
	PRIFIX_14("epub_file",14),
	/** 音频文件 */
	PRIFIX_15("radio_file",15),
	/** 视频文件 */
	PRIFIX_16("video_file",16),
	/** 出版合同 */
	PRIFIX_17("publication_contract",17),
	/** 获奖证书 */
	PRIFIX_18("awards_file",18),
	/** 封面 */
	PRIFIX_19("cover",19);
	
	
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
	
	private FilePrefixEnum(String name, Integer index) {
		this.name = name;
		this.index = index;
	}
	
	/**
	   *   根据index获取枚举name
	 * @param index
	 * @return
	 */
	public static String getName(Integer index) {
		for (FilePrefixEnum prefixEnum : FilePrefixEnum.values()) {
			if (prefixEnum.getIndex()==index) {
				return prefixEnum.getName();
			}
		}
		return null;
	}
}
