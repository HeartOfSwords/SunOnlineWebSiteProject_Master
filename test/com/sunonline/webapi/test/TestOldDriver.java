package com.sunonline.webapi.test;

import org.junit.Test;

import com.sunonline.web.webapi.resource.OldDriverVideoResource;

public class TestOldDriver {
	
	@Test
	public void testGetByID() {
		System.out.println(new OldDriverVideoResource().getOldDriverVideoByID(1));
		System.out.println(new OldDriverVideoResource().getOldDriverVideoRecommendation().size());
	}
}
