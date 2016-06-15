package com.sunonline.web.bean;

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
	
	private int zqy_video_id;				//最强音id
	private String zqy_video_name;			//最强音视频名称
	private String zqy_video_url;			//最强音视频链接
	private Date zqy_video_date;			//最强音视频发布日期
	private String zqy_video_pic_url;		//最强音视频截图
	private int zqy_video_played_number;	//最强音视频播放次数
	private String zqy_video_intro;			//最强音视频简介
	private String zqy_video_uploader;		//最强音上传者
	private String zqy_player_name;		//选手姓名
	
	public CollegeVoiceVideoBean() {
	}

	
	public CollegeVoiceVideoBean(int zqy_video_id, String zqy_video_name, String zqy_video_url, Date zqy_video_date,
			String zqy_video_pic_url, int zqy_video_played_number, String zqy_video_intro, String zqy_video_uploader,
			String zqy_player_name) {
		super();
		this.zqy_video_id = zqy_video_id;
		this.zqy_video_name = zqy_video_name;
		this.zqy_video_url = zqy_video_url;
		this.zqy_video_date = zqy_video_date;
		this.zqy_video_pic_url = zqy_video_pic_url;
		this.zqy_video_played_number = zqy_video_played_number;
		this.zqy_video_intro = zqy_video_intro;
		this.zqy_video_uploader = zqy_video_uploader;
		this.zqy_player_name = zqy_player_name;
	}


	public int getZqy_video_id() {
		return zqy_video_id;
	}
	public void setZqy_video_id(int zqy_video_id) {
		this.zqy_video_id = zqy_video_id;
	}
	public String getZqy_video_name() {
		return zqy_video_name;
	}
	public void setZqy_video_name(String zqy_video_name) {
		this.zqy_video_name = zqy_video_name;
	}
	public String getZqy_video_url() {
		return zqy_video_url;
	}
	public void setZqy_video_url(String zqy_video_url) {
		this.zqy_video_url = zqy_video_url;
	}
	public Date getZqy_video_date() {
		return zqy_video_date;
	}
	public void setZqy_video_date(Date zqy_video_date) {
		this.zqy_video_date = zqy_video_date;
	}
	public String getZqy_video_pic_url() {
		return zqy_video_pic_url;
	}
	public void setZqy_video_pic_url(String zqy_video_pic_url) {
		this.zqy_video_pic_url = zqy_video_pic_url;
	}
	public int getZqy_video_played_number() {
		return zqy_video_played_number;
	}
	public void setZqy_video_played_number(int zqy_video_played_number) {
		this.zqy_video_played_number = zqy_video_played_number;
	}
	public String getZqy_video_intro() {
		return zqy_video_intro;
	}
	public void setZqy_video_intro(String zqy_video_intro) {
		this.zqy_video_intro = zqy_video_intro;
	}
	public String getZqy_video_uploader() {
		return zqy_video_uploader;
	}
	public void setZqy_video_uploader(String zqy_video_uploader) {
		this.zqy_video_uploader = zqy_video_uploader;
	}
	public String getZqy_player_name() {
		return zqy_player_name;
	}
	public void setZqy_player_name(String zqy_player_name) {
		this.zqy_player_name = zqy_player_name;
	}
	

	
}
