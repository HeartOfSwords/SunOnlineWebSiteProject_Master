package com.sunonline.web.dao;
/**
 * 用户Dao接口
 * @author snowalker
 * 16.7.15
 */
public interface UserDao {
	
	//用户注册
	public String UserRegister(String usernickname, String userpwd, String userMobile, String userEmail);
	//通过邮箱判断用户登录
	public String verifyUserEmail(String inputString, String userpwd);
	//通过用户手机判断用户登录
	public String verifyUserMobile(String inputString, String userpwd);
}
