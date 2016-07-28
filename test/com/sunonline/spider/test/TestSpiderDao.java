package com.sunonline.spider.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import com.sunonline.spider.gui.dao.EducationNewsDaoImpl;

public class TestSpiderDao {

	@Test
	public void test() {
		System.out.println(new EducationNewsDaoImpl().getEduNewsById(1).getContent());
	}
	
	//测试返回全部数据
	@Test
	public void testGetList() {
		System.out.println(new EducationNewsDaoImpl().getEduNewsList().size());
		System.out.println(new EducationNewsDaoImpl().getRecommendationNewsList().size());
	}
}
