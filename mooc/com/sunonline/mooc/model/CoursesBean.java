package com.sunonline.mooc.model;
/**
 * 课程列表bean
 * @author snowalker
 * 16.7.6
 */
public class CoursesBean {
	
	private Integer c_id;				//课程id
		
	private String  c_name;				//课程 名称
	
	private String  c_introduce;		//课程介绍
	
	private String  c_pic_url;			//视频截图url
	
	private String  c_teacher_name;		//讲师姓名
	
	private String  c_teacher_intro;	//讲师介绍
	
	private Integer  t_id;				//视频所属类型id
	
	public CoursesBean() {
	}

	public CoursesBean(Integer c_id, String c_name, String c_introduce, String c_pic_url, String c_teacher_name,
			String c_teacher_intro, Integer t_id) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_introduce = c_introduce;
		this.c_pic_url = c_pic_url;
		this.c_teacher_name = c_teacher_name;
		this.c_teacher_intro = c_teacher_intro;
		this.t_id = t_id;
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

	
}
