package com.dfs.api.model.book;

import java.io.Serializable;
import java.util.List;

import com.dfs.api.core.entity.Entity;
import com.dfs.api.model.common.FileModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图书多媒体文件模型
 * @author Ming
 * @date 2018年11月15日
 */
@ApiModel(value="BookMultimediaFileModel",description="图书多媒体文件模型")
public class BookMultimediaFileModel extends Entity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 音频文件
	 */
	@ApiModelProperty("音频文件")
	private List<FileModel> audioFiles;
	
	/**
	 * 视频文件
	 */
	@ApiModelProperty("视频文件")
	private List<FileModel> videoFiles;

	public List<FileModel> getAudioFiles() {
		return audioFiles;
	}

	public void setAudioFiles(List<FileModel> audioFiles) {
		this.audioFiles = audioFiles;
	}

	public List<FileModel> getVideoFiles() {
		return videoFiles;
	}

	public void setVideoFiles(List<FileModel> videoFiles) {
		this.videoFiles = videoFiles;
	}

	public BookMultimediaFileModel() {
		super();
	}

	@Override
	public String toString() {
		return "BookMultimediaFileModel [audioFiles=" + audioFiles + ", videoFiles=" + videoFiles + ", id=" + id + "]";
	}
	
}
