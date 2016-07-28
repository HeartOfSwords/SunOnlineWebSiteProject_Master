package com.sunonline.web.utils;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * 
 * @author 武文良
 *
 */
public class TestStringEncodeUtils {

	@Test
	public void test() {
		assertEquals("80a19f669b02edfbc208a5386ab5036b", StringEncodeUtils.EncodePassword("admin"));
		System.out.println(StringEncodeUtils.EncodePassword("snowalker"));
	}
	
	@Test
	public void testBase64Token() {
		for (int i = 0; i < 100; i++) {
			System.out.println(TokenProccessor.getInstance().makeToken());
		}
	}
}
