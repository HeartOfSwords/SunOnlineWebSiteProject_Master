package com.sunonline.web.dao;

import com.sunonline.web.bean.User;

/**
 * 用户Dao接口
 * @author snowalker
 * 16.7.15
 */
public interface UserDao {
	
	//用户注册
	public String UserRegister(String usernickname, String userpwd, String userMobile, String userEmail);
	//通过邮箱判断用户登录
	public User verifyUserEmail(String inputString, String userpwd);
	//通过用户手机判断用户登录
	public User verifyUserMobile(String inputString, String userpwd);
	//通过用户邮箱得到用户昵称
	public String getUserNickNameByUserEmail(String useremail);
	//通过用户邮箱得到用户全部信息
	public User fetchUserInfo(String useremail);
	//根据邮箱判断用户登录返回boolean类型
	public Boolean verifyUser(String useremail, String userpwd);
	//修改用户昵称
	public String modifyUserNickName(String userMobile, String newNickName);
	//用户修改密码,初始状态为登录
	public String userModifyUserPasswdDirectly(String userpwd, String userMobile);
	/*
	 * 用户修改密码，忘记密码
	 * 首先验证密码合法性
	 */
	public String userVerifyValidityBeforeModifyUserpwd(String userMobile);
	//通过用户手机查找旧密码
	public String getOldPasswd(String usermobile);
	//根据用户id上传用户头像url
	public String userAvatarUpload(String user_id, String userAvatar_url);
}
