package com.sunonline.web.webapi.bean.mooc;
/**
 * 慕课所属类型bean
 * @author snowalker
 * 16.7.6
 */
public class TypeBean {
	
	private Integer t_id;		//部门类型id
	
	private String  t_name;		//部门类型名称
	
	public TypeBean() {
	}

	public TypeBean(Integer t_id, String t_name) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
	}

	public Integer getT_id() {
		return t_id;
	}

	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	
	
}
