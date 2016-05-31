package com.sunonline.web.utils;

import java.sql.SQLException;

import org.junit.Test;
/**
 * 
 * @author 武文良
 *
 */
public class TestConnection {

	@Test
	public void test() throws SQLException {
		DBUtils dbUtils = new DBUtils();
		System.out.println(dbUtils.getCon().getClass());
//		dbUtils.closeCon(dbUtils.getCon(), null, null, null);
	}

}
