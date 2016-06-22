package com.sunonline.web.webapi.bean.videos;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.sunonline.web.webapi.bean.Bean;
/**
 * @author 武文良
 * @date 2016.5.3
 * <p>function:高校最强音视频bean</p>
 */
@XmlRootElement
public class CollegeVoiceVideoBean extends Bean  {
	
	private int videoId;				//最强音id
	private String videoName;			//最强音视频名称
	private String videoUrl;			//最强音视频链接
	private Date videoDate;			//最强音视频发布日期
	private String videoPicUrl;		//最强音视频截图
	private int videoPlayedNumber;	//最强音视频播放次数
	private String videoIntro;			//最强音视频简介
	private String videoUploader;		//最强音上传者
	private String videoPlayerName;		//选手姓名
	
	public CollegeVoiceVideoBean() {
	}

	public CollegeVoiceVideoBean(int videoId, String videoName, String videoUrl, Date videoDate, String videoPicUrl,
			int videoPlayedNumber, String videoIntro, String videoUploader, String videoPlayerName) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		this.videoUrl = videoUrl;
		this.videoDate = videoDate;
		this.videoPicUrl = videoPicUrl;
		this.videoPlayedNumber = videoPlayedNumber;
		this.videoIntro = videoIntro;
		this.videoUploader = videoUploader;
		this.videoPlayerName = videoPlayerName;
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

	public int getVideoPlayedNumber() {
		return videoPlayedNumber;
	}

	public void setVideoPlayedNumber(int videoPlayedNumber) {
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

	public String getVideoPlayerName() {
		return videoPlayerName;
	}

	public void setVideoPlayerName(String videoPlayerName) {
		this.videoPlayerName = videoPlayerName;
	}

	
	
}