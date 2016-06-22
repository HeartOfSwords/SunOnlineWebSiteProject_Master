package com.sunonline.web.daoImpl;

import org.junit.Test;

import com.sunonline.web.dao.index.IndexInfoDaoImpl;

public class TestIndexDaoImpl {
	@Test
	public void testGetByID(){
		
		System.out.println("高校最强音数量" + new IndexInfoDaoImpl().fetchCollegeVoiceList(7).size());
		System.out.println("Higo数量" + new IndexInfoDaoImpl().fetchHigoList(7).size());
		System.out.println("老司机数量" + new IndexInfoDaoImpl().fetchOldDriverList(7).size());
	}
	
	

}
