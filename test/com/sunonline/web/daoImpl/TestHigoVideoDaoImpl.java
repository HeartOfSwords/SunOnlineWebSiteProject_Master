package com.sunonline.web.daoImpl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.dao.higo.HigoVideoDaoImpl;

public class TestHigoVideoDaoImpl {

	@Test
	public void testfetchAllVideos() {
		System.out.println(new HigoVideoDaoImpl().fetchVideoRowsCount());
	}
	
	@Test
	public void testFetchAllVideoByPageNo() {
		List<HigoVideoBean> lBeans = new HigoVideoDaoImpl().fetchAllVideos(1);
		System.out.println(lBeans.size());
	}
	
	@Test
	public void testGetByID() {
		HigoVideoBean higoVideoBean = new HigoVideoDaoImpl().getHigoVideoByID(1);
		System.out.println(higoVideoBean.getHigoVideoIntro() + 
				new SimpleDateFormat().format(higoVideoBean.getHigoVideoDate()));
	}
	
	@Test
	public void testAddPlayTime() {
		new HigoVideoDaoImpl().addPlayTimeNumber(1);
	}

}
