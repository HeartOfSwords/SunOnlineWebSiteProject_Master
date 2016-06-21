package com.sunonline.web.webapi.bean;

import java.util.List;

import com.sunonline.web.webapi.bean.videos.CollegeVoiceVideoBean;
import com.sunonline.web.webapi.bean.videos.HigoVideoBean;
import com.sunonline.web.webapi.bean.videos.OldDriverVideoBean;
import com.sunonline.web.webapi.bean.videos.Recommendation;

/**
 * 主页video节点Bean
 * 
 * @author SnoWalker.wwl
 *
 */
public class IndexApiNode {

	private String name;

	private String picUrl;

	private String intro;

	private String pagerUrl;
	
	private List<Recommendation> recommendations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPagerUrl() {
		return pagerUrl;
	}

	public void setPagerUrl(String pagerUrl) {
		this.pagerUrl = pagerUrl;
	}

	public List<Recommendation> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(List<Recommendation> recommendations) {
		this.recommendations = recommendations;
	}
	
	

	

}
