package com.sunonline.web.daoImpl;

import java.util.List;
import org.junit.Test;
import com.sunonline.web.bean.OldDriverVideoBean;
import com.sunonline.web.dao.olddriver.OldDriverVideoDaoImpl;

public class TestOldDriverVideoDaoImpl {

	@Test
	public void testfetchAllVideos() {
		System.out.println(new OldDriverVideoDaoImpl().fetchVideoRowsCount());
	}
	
	@Test
	public void testFetchAllVideoByPageNo() {
		List<OldDriverVideoBean> lBeans = new OldDriverVideoDaoImpl().fetchAllVideos(1);
		System.out.println(lBeans.size());
	}
	
	@Test
	public void testGetByID() {
		OldDriverVideoBean oldDriverVideoBean = new OldDriverVideoDaoImpl().getOldDriverVideoByID(1);
		System.out.println(oldDriverVideoBean.getLSJ_video_intro());
	}
	
	@Test
	public void testPlayTimeAdd() {
		new OldDriverVideoDaoImpl().addPlayTimeNumber(1);
	}
	
	@Test
	public void testRecommendation() {
		System.out.println(new OldDriverVideoDaoImpl().getOldDriverVideoRecommendation().size());
		
	}

}
