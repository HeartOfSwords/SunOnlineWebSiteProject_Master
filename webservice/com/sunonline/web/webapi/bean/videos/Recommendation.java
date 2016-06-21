package com.sunonline.web.webapi.bean.videos;

import java.util.Date;

public class Recommendation {
	
	private int VideoId;					//Video视频ID
	private String VideoName;				//Video视频名称
	private String VideoUrl;				//Video视频链接
	private Date VideoDate;					//Video视频发布时间
	private String VideoPicUrl;				//Video视频截图链接
	private Integer VideoPlayedNumber;		//Video视频播放次数
	private String VideoIntro;				//Video视频简介
	private String VideoUploader;			//Video视频上传者
	
	
	public Recommendation() {
		super();
	}
	public Recommendation(int videoId, String videoName, String videoUrl, Date videoDate, String videoPicUrl,
			Integer videoPlayedNumber, String videoIntro, String videoUploader) {
		super();
		VideoId = videoId;
		VideoName = videoName;
		VideoUrl = videoUrl;
		VideoDate = videoDate;
		VideoPicUrl = videoPicUrl;
		VideoPlayedNumber = videoPlayedNumber;
		VideoIntro = videoIntro;
		VideoUploader = videoUploader;
	}
	public int getVideoId() {
		return VideoId;
	}
	public void setVideoId(int videoId) {
		VideoId = videoId;
	}
	public String getVideoName() {
		return VideoName;
	}
	public void setVideoName(String videoName) {
		VideoName = videoName;
	}
	public String getVideoUrl() {
		return VideoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		VideoUrl = videoUrl;
	}
	public Date getVideoDate() {
		return VideoDate;
	}
	public void setVideoDate(Date videoDate) {
		VideoDate = videoDate;
	}
	public String getVideoPicUrl() {
		return VideoPicUrl;
	}
	public void setVideoPicUrl(String videoPicUrl) {
		VideoPicUrl = videoPicUrl;
	}
	public Integer getVideoPlayedNumber() {
		return VideoPlayedNumber;
	}
	public void setVideoPlayedNumber(Integer videoPlayedNumber) {
		VideoPlayedNumber = videoPlayedNumber;
	}
	public String getVideoIntro() {
		return VideoIntro;
	}
	public void setVideoIntro(String videoIntro) {
		VideoIntro = videoIntro;
	}
	public String getVideoUploader() {
		return VideoUploader;
	}
	public void setVideoUploader(String videoUploader) {
		VideoUploader = videoUploader;
	}
	
	
}
