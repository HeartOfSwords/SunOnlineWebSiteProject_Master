package com.sunonline.web.webapi.bean.mooc;

/**
 * 影视后期bean
 * 
 * @author snowalker 16.7.7
 */
public class MediasAfter {

	private Integer c_id; // 课程条目id

	private String c_name; // 课程条目名称

	private String c_introduce; // 课程介绍

	private String c_pic_url; // 课程截图

	private String c_teacher_name; // 讲师名

	private String c_teacher_intro; // 讲师介绍

	private Integer t_id; // 分类id

	private String c_path_url; // API路径url
	
	public MediasAfter() {
	}
	
	public MediasAfter(Integer c_id, String c_name, String c_introduce, String c_pic_url, String c_teacher_name,
			String c_teacher_intro, Integer t_id, String c_path_url) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_introduce = c_introduce;
		this.c_pic_url = c_pic_url;
		this.c_teacher_name = c_teacher_name;
		this.c_teacher_intro = c_teacher_intro;
		this.t_id = t_id;
		this.c_path_url = c_path_url;
	}


	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_introduce() {
		return c_introduce;
	}

	public void setC_introduce(String c_introduce) {
		this.c_introduce = c_introduce;
	}

	public String getC_pic_url() {
		return c_pic_url;
	}

	public void setC_pic_url(String c_pic_url) {
		this.c_pic_url = c_pic_url;
	}

	public String getC_teacher_name() {
		return c_teacher_name;
	}

	public void setC_teacher_name(String c_teacher_name) {
		this.c_teacher_name = c_teacher_name;
	}

	public String getC_teacher_intro() {
		return c_teacher_intro;
	}

	public void setC_teacher_intro(String c_teacher_intro) {
		this.c_teacher_intro = c_teacher_intro;
	}

	public Integer getT_id() {
		return t_id;
	}

	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}

	public String getC_path_url() {
		return c_path_url;
	}

	public void setC_path_url(String c_path_url) {
		this.c_path_url = c_path_url;
	}

}
