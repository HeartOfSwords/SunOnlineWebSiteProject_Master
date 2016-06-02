package com.sunonline.web.bean;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.sunonline.web.webapi.bean.Bean;
/**
 * @author 武文良
 * @date 2016.5.3
 * <p>function:higo大学季视频bean</p>
 */
@XmlRootElement
public class HigoVideoBean extends Bean {
	
	private int higoVideoId;					//higoVideo视频ID
	private String higoVideoName;				//higoVideo视频名称
	private String higoVideoUrl;				//higoVideo视频链接
	private Date higoVideoDate;					//higoVideo视频发布时间
	private String higoVideoPicUrl;				//higoVideo视频截图链接
	private Integer higoVideoPlayedNumber;		//higoVideo视频播放次数
	private String higoVideoIntro;				//higoVideo视频简介
	private String higoVideoUploader;			//higoVideo视频上传者
	
	public HigoVideoBean() {
	}
	
	//有参构造
	public HigoVideoBean(int higoVideoId, String higoVideoName, String higoVideoUrl, Date higoVideoDate,
			String higoVideoPicUrl, Integer higoVideoPlayedNumber, String higoVideoIntro, String higoVideoUploader) {
		super();
		this.higoVideoId = higoVideoId;
		this.higoVideoName = higoVideoName;
		this.higoVideoUrl = higoVideoUrl;
		this.higoVideoDate = higoVideoDate;
		this.higoVideoPicUrl = higoVideoPicUrl;
		this.higoVideoPlayedNumber = higoVideoPlayedNumber;
		this.higoVideoIntro = higoVideoIntro;
		this.higoVideoUploader = higoVideoUploader;
	}
	
	public String getHigoVideoIntro() {
		return higoVideoIntro;
	}
	
	public void setHigoVideoIntro(String higoVideoIntro) {
		this.higoVideoIntro = higoVideoIntro;
	}
	public String getHigoVideoUploader() {
		return higoVideoUploader;
	}
	public void setHigoVideoUploader(String higoVideoUploader) {
		this.higoVideoUploader = higoVideoUploader;
	}
	public String getHigoVideoName() {
		return higoVideoName;
	}
	public void setHigoVideoName(String higoVideoName) {
		this.higoVideoName = higoVideoName;
	}
	public String getHigoVideoUrl() {
		return higoVideoUrl;
	}
	public void setHigoVideoUrl(String higoVideoUrl) {
		this.higoVideoUrl = higoVideoUrl;
	}
	public Date getHigoVideoDate() {
		return higoVideoDate;
	}
	public void setHigoVideoDate(Date higoVideoDate) {
		this.higoVideoDate = higoVideoDate;
	}
	public String getHigoVideoPicUrl() {
		return higoVideoPicUrl;
	}
	public void setHigoVideoPicUrl(String higoVideoPicUrl) {
		this.higoVideoPicUrl = higoVideoPicUrl;
	}
	public Integer getHigoVideoPlayedNumber() {
		return higoVideoPlayedNumber;
	}
	public void setHigoVideoPlayedNumber(Integer higoVideoPlayedNumber) {
		this.higoVideoPlayedNumber = higoVideoPlayedNumber;
	}
	public int getHigoVideoId() {
		return higoVideoId;
	}
	public void setHigoVideoId(int higoVideoId) {
		this.higoVideoId = higoVideoId;
	}

}
