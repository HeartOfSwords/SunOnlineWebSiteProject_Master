package com.sunonline.web.webapi.bean;
/**
 * API链接信息
 * @author SnoWalker.wwl
 * 2016.6.2
 */
public class WebApiLinks {

	private String rel;

	private String href;

	private String title;

	private String type;
	
	private String picUrl;					//截图
	
	private String introduceMessage;		//简介

	public String getIntroduceMessage() {
		return introduceMessage;
	}

	public void setIntroduceMessage(String introduceMessage) {
		this.introduceMessage = introduceMessage;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getRel() {
		return this.rel;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getHref() {
		return this.href;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}
