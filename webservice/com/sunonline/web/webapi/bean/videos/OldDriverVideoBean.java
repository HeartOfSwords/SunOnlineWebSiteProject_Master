package com.sunonline.web.webapi.bean.videos;

import java.sql.Date;

import com.sunonline.web.webapi.bean.Bean;
/**
 * @author 武文良
 * @date 2016.5.3
 * <p>function:影视老司机bean For webservice</p>
 */
public class OldDriverVideoBean extends Bean {
	              
	private int 	videoId;					//老司机视频id	
	private String  videoName;					//老司机视频名称
	private String  videoUrl;					//老司机视频链接
	private Date    videoDate;					//老司机视频上传时间
	private String  videoPicUrl;				//老司机视频图片截图链接
	private Integer videoPlayedNumber;	    	//老司机视频播放次数
	private String  videoIntro;					//老司机视频简介
	private String  videoUploader;				//老司机视频上传者
	
	public OldDriverVideoBean() {
	}

	public OldDriverVideoBean(int videoId, String videoName, String videoUrl, Date videoDate, String videoPicUrl,
			Integer videoPlayedNumber, String videoIntro, String videoUploader) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		this.videoUrl = videoUrl;
		this.videoDate = videoDate;
		this.videoPicUrl = videoPicUrl;
		this.videoPlayedNumber = videoPlayedNumber;
		this.videoIntro = videoIntro;
		this.videoUploader = videoUploader;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Date getVideoDate() {
		return videoDate;
	}

	public void setVideoDate(Date videoDate) {
		this.videoDate = videoDate;
	}

	public String getVideoPicUrl() {
		return videoPicUrl;
	}

	public void setVideoPicUrl(String videoPicUrl) {
		this.videoPicUrl = videoPicUrl;
	}

	public Integer getVideoPlayedNumber() {
		return videoPlayedNumber;
	}

	public void setVideoPlayedNumber(Integer videoPlayedNumber) {
		this.videoPlayedNumber = videoPlayedNumber;
	}

	public String getVideoIntro() {
		return videoIntro;
	}

	public void setVideoIntro(String videoIntro) {
		this.videoIntro = videoIntro;
	}

	public String getVideoUploader() {
		return videoUploader;
	}

	public void setVideoUploader(String videoUploader) {
		this.videoUploader = videoUploader;
	}

	
}
