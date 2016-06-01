package com.sunonline.web.bean;

import java.sql.Date;

import com.sunonline.web.webapi.bean.Bean;
/**
 * @author 武文良
 * @date 2016.5.3
 * <p>function:影视老司机bean</p>
 */
public class OldDriverVideoBean extends Bean {
	              
	private int 	LSJ_video_id;					//老司机视频id	
	private String  LSJ_video_name;					//老司机视频名称
	private String  LSJ_video_url;					//老司机视频链接
	private Date    LSJ_video_date;					//老司机视频上传时间
	private String  LSJ_video_pic_url;				//老司机视频图片截图链接
	private Integer LSJ_video_played_number;	    //老司机视频播放次数
	private String  LSJ_video_intro;				//老司机视频简介
	private String  LSJ_video_uploader;				//老司机视频上传者
	
	public OldDriverVideoBean() {
	}

	public OldDriverVideoBean(int LSJ_video_id, String lSJ_video_name, String lSJ_video_url, Date lSJ_video_date,
			String lSJ_video_pic_url, Integer lSJ_video_played_number, String lSJ_video_intro,
			String lSJ_video_uploader) {
		super();
		this.LSJ_video_id = LSJ_video_id;
		LSJ_video_name = lSJ_video_name;
		LSJ_video_url = lSJ_video_url;
		LSJ_video_date = lSJ_video_date;
		LSJ_video_pic_url = lSJ_video_pic_url;
		LSJ_video_played_number = lSJ_video_played_number;
		LSJ_video_intro = lSJ_video_intro;
		LSJ_video_uploader = lSJ_video_uploader;
	}

	public int getLSJ_video_id() {
		return LSJ_video_id;
	}

	public void setLSJ_video_id(int lSJ_video_id) {
		LSJ_video_id = lSJ_video_id;
	}

	public String getLSJ_video_name() {
		return LSJ_video_name;
	}

	public void setLSJ_video_name(String lSJ_video_name) {
		LSJ_video_name = lSJ_video_name;
	}

	public String getLSJ_video_url() {
		return LSJ_video_url;
	}

	public void setLSJ_video_url(String lSJ_video_url) {
		LSJ_video_url = lSJ_video_url;
	}

	public Date getLSJ_video_date() {
		return LSJ_video_date;
	}

	public void setLSJ_video_date(Date lSJ_video_date) {
		LSJ_video_date = lSJ_video_date;
	}

	public String getLSJ_video_pic_url() {
		return LSJ_video_pic_url;
	}

	public void setLSJ_video_pic_url(String lSJ_video_pic_url) {
		LSJ_video_pic_url = lSJ_video_pic_url;
	}

	public Integer getLSJ_video_played_number() {
		return LSJ_video_played_number;
	}

	public void setLSJ_video_played_number(Integer lSJ_video_played_number) {
		LSJ_video_played_number = lSJ_video_played_number;
	}

	public String getLSJ_video_intro() {
		return LSJ_video_intro;
	}

	public void setLSJ_video_intro(String lSJ_video_intro) {
		LSJ_video_intro = lSJ_video_intro;
	}

	public String getLSJ_video_uploader() {
		return LSJ_video_uploader;
	}

	public void setLSJ_video_uploader(String lSJ_video_uploader) {
		LSJ_video_uploader = lSJ_video_uploader;
	}
	
}
