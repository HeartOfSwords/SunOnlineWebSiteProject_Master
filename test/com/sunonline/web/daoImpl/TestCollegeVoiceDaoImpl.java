package com.sunonline.web.daoImpl;

import java.util.List;

import org.junit.Test;

import com.sunonline.web.dao.collegevoice.CollegeVoiceVideoDaoImpl;

public class TestCollegeVoiceDaoImpl {
	@Test
	public void testGetByID(){
		new CollegeVoiceVideoDaoImpl().getVideoByID(1);
	}
	
	@Test
	public void testFetchRowCounts() {
		System.out.println(new CollegeVoiceVideoDaoImpl().fetchVideoRowsCount());
	}
	
	@Test
	public void testAddPlayedTime() {
		new CollegeVoiceVideoDaoImpl().addPlayTimeNumber(6);
	}
	
	@Test
	public void testRecommendation() {
		System.out.println(new CollegeVoiceVideoDaoImpl().getCollegeVoiceVideoRecommendation().size());
	}
	
	@Test
	public void testGetAllByPage() {
		System.out.println(new CollegeVoiceVideoDaoImpl().fetchAllVideos(1).size());
	}
	
	@Test
	public void testFetchAllByPage() {
		System.out.println(new CollegeVoiceVideoDaoImpl().fetchAllVideos(1).size());
	}
}
