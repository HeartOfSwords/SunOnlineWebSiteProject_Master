package com.sunonline.mooc.model;

import java.util.Date;

/**
 * 课程菜单条目bean
 * @author Administrator
 * 16.7.6
 */
public class CourseListItemBean {
	
	private Integer cl_id;				//课程条目id

	private String  cl_name;			//课程条目名称

	private String  cl_pic_url;			//课程条目截图url

	private String  cl_video_url;		//课程条目视频url
	
	private Integer  cl_play_time;		//课程播放次数

	private String  cl_video_intro;		//单节视频介绍
	
	private Date    cl_upload_time;		//视频上传时间

	private Integer  c_id;				//课程id

	private String c_path_url;			//路径url
	
	
	
	public String getC_path_url() {
		return c_path_url;
	}

	public void setC_path_url(String c_path_url) {
		this.c_path_url = c_path_url;
	}

	public CourseListItemBean() {
	}
	
	public CourseListItemBean(Integer cl_id, String cl_name, String cl_pic_url, String cl_video_url,
			Integer cl_play_time, String cl_video_intro, Date cl_upload_time, Integer c_id) {
		super();
		this.cl_id = cl_id;
		this.cl_name = cl_name;
		this.cl_pic_url = cl_pic_url;
		this.cl_video_url = cl_video_url;
		this.cl_play_time = cl_play_time;
		this.cl_video_intro = cl_video_intro;
		this.cl_upload_time = cl_upload_time;
		this.c_id = c_id;
	}



	public CourseListItemBean(Integer cl_id2, String cl_name2, String cl_pic_url2, String cl_video_url2,
			Integer cl_play_time2, String cl_video_intro2, java.sql.Date cl_upload_time2, Integer c_id2,
			String c_path_url2) {
		super();
		this.cl_id = cl_id2;
		this.cl_name = cl_name2;
		this.cl_pic_url = cl_pic_url2;
		this.cl_video_url = cl_video_url2;
		this.cl_play_time = cl_play_time2;
		this.cl_video_intro = cl_video_intro2;
		this.cl_upload_time = cl_upload_time2;
		this.c_id = c_id2;
		this.c_path_url = c_path_url2;
	}

	public Integer getCl_id() {
		return cl_id;
	}

	public void setCl_id(Integer cl_id) {
		this.cl_id = cl_id;
	}

	public String getCl_name() {
		return cl_name;
	}

	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}

	public String getCl_pic_url() {
		return cl_pic_url;
	}

	public void setCl_pic_url(String cl_pic_url) {
		this.cl_pic_url = cl_pic_url;
	}

	public String getCl_video_url() {
		return cl_video_url;
	}

	public void setCl_video_url(String cl_video_url) {
		this.cl_video_url = cl_video_url;
	}

	public Integer getCl_play_time() {
		return cl_play_time;
	}

	public void setCl_play_time(Integer cl_play_time) {
		this.cl_play_time = cl_play_time;
	}

	public String getCl_video_intro() {
		return cl_video_intro;
	}

	public void setCl_video_intro(String cl_video_intro) {
		this.cl_video_intro = cl_video_intro;
	}

	public Date getCl_upload_time() {
		return cl_upload_time;
	}

	public void setCl_upload_time(Date cl_upload_time) {
		this.cl_upload_time = cl_upload_time;
	}

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	
}
