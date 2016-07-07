package com.sunonline.web.webapi.bean.mooc;

import java.util.List;
/**
 * json主页根类
 * @author snowalker
 * 16.7.7
 */
public class IndexRoot {
	
	//播音主持
	private List<RadioInterview> RadioInterview ;
	//影视后期
	private List<MediasAfter> MediasAfter ;
	//软件开发
	private List<SoftwareDeveloping> SoftwareDeveloping ;

	public void setRadioInterview(List<RadioInterview> RadioInterview){
		this.RadioInterview = RadioInterview;
	}
	public List<RadioInterview> getRadioInterview(){
		return this.RadioInterview;
	}
	public void setMediasAfter(List<MediasAfter> MediasAfter){
		this.MediasAfter = MediasAfter;
	}
	public List<MediasAfter> getMediasAfter(){
		return this.MediasAfter;
	}
	public void setSoftwareDeveloping(List<SoftwareDeveloping> SoftwareDeveloping){
		this.SoftwareDeveloping = SoftwareDeveloping;
	}
	public List<SoftwareDeveloping> getSoftwareDeveloping(){
		return this.SoftwareDeveloping;
	}
}
