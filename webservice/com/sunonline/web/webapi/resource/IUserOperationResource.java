package com.sunonline.web.webapi.resource;

import com.sunonline.web.bean.User;

/**
 * 用户操作资源接口
 * @author snowalker
 * 16.7.15
 */
public interface IUserOperationResource {
	
	/*
	 * 用户注册
	 * 数据库中写入用户登录密码、手机号、邮箱号
	 * 用户昵称随机生成
	 * 可以修改
	 */
	public String userRegister(String pwd, String usermobile, String useremail);
	//用户登录，通过邮箱/手机号
	//参数中的inputString不确定，做判断之后再根据具体是什么数据进行判断
	public User userLoginVerifyByMobileOrEmail(String inputString, String userpwd);
	//用户修改用户名
	public String userModifyUsername();
}
