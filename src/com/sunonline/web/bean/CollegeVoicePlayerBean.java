package com.sunonline.web.bean;

import java.util.HashSet;
import java.util.Set;

import com.sunonline.web.webapi.bean.Bean;

/**
 * @author 武文良
 * @date 2016.5.3
 * <p>function:高校最强音选手bean</p>
 */
public class CollegeVoicePlayerBean  {
	
	private String playerNumber;		//选手编号
	
	private String playerName;			//选手姓名
	
	private Integer playerGender;		//选手性别
	
	private String playerSchool;		//选手学校
	
	private Set<CollegeVoiceVideoBean> collegeVoiceVideos = new HashSet<CollegeVoiceVideoBean>();
	

	public Set<CollegeVoiceVideoBean> getCollegeVoiceVideos() {
		return collegeVoiceVideos;
	}
	public void setCollegeVoiceVideos(Set<CollegeVoiceVideoBean> collegeVoiceVideos) {
		this.collegeVoiceVideos = collegeVoiceVideos;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Integer getPlayerGender() {
		return playerGender;
	}
	public void setPlayerGender(Integer playerGender) {
		this.playerGender = playerGender;
	}
	public String getPlayerSchool() {
		return playerSchool;
	}
	public void setPlayerSchool(String playerSchool) {
		this.playerSchool = playerSchool;
	}
	public String getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = playerNumber;
	}
	
	
}
