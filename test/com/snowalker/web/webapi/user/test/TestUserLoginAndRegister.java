package com.snowalker.web.webapi.user.test;

import org.junit.Test;

import com.sunonline.web.dao.UserDaoImpl;

/**
 * 测试用户登录注册相关逻辑
 * @author snowalker
 * 16.7.15
 */
public class TestUserLoginAndRegister {
	
	@Test
	public void testUserLoginVerify() {
		System.out.println(new UserDaoImpl().verifyUserEmail("sunonliney1x@163.com", "123456"));
		System.out.println(new UserDaoImpl().verifyUserMobile("15201112222", "123456"));
	}
}
