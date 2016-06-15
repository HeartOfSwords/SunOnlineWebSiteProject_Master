package com.sunonline.web.webapi.bean.videos;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.sunonline.web.webapi.bean.Bean;
/**
 * @author 武文良
 * @date 2016.5.3
 * <p>function:higo大学季视频bean For webservice</p>
 */
@XmlRootElement
public class HigoVideoBean extends Bean {
	
	private int VideoId;					//higoVideo视频ID
	private String VideoName;				//higoVideo视频名称
	private String VideoUrl;				//higoVideo视频链接
	private Date VideoDate;					//higoVideo视频发布时间
	private String VideoPicUrl;				//higoVideo视频截图链接
	private Integer VideoPlayedNumber;		//higoVideo视频播放次数
	private String VideoIntro;				//higoVideo视频简介
	private String VideoUploader;			//higoVideo视频上传者
	
	public HigoVideoBean() {
	}
	//有参构造
	public HigoVideoBean(int videoId, String videoName, String videoUrl, Date videoDate, String videoPicUrl,
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
