package com.sunonline.webapi.test;

import org.junit.Test;

import com.sunonline.web.webapi.resource.CollegeVoiceVideoResource;

public class TestCollegeVoice {
	
	@Test
	public void testGetByID() {
		//System.out.println(new CollegeVoiceVideoResource().getCollegeVoiceVideoRecommendation().size());
		//System.out.println(new CollegeVoiceVideoResource().fetchAllVideos().size());
		//System.out.println(new CollegeVoiceVideoResource().getVideoByID(1).getVideoId());
		System.out.println(new CollegeVoiceVideoResource().getCollegeVoiceVideoRecommendation().size());
	}
}
