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
	//用户修改昵称
	public String userModifyUserNickName(String userMobile, String newNickName);
	/*
	 * 用户修改密码
	 * 用户初始状态为登录
	 * 只需要提供用户的信息及要更改的密码即可
	 */
	public String userModifyUserPasswdDirectly(String userpwd, String userMobile);
	/*
	 * 用户修改密码
	 * 用户初始状态为未登录
	 * 需要首先验证要验证用户合法性
	 * step:A
	 */
	public String userVerifyValidityBeforeModifyUserpwd(String userMobile);
	/*
	 * 如果验证 成功
	 * 则进入该阶段
	 * step:B
	 * 使用该手机号更改密码
	 */
	public String userModifyUserPasswdValidated(String userpwd, String userMobile);
	/**
	 * @param user_id
	 * @param userAvatar_url
	 * @return 
	 * 	成功：successfully uploading user avatar URL
	 *  失败：failed uploading user avatar URL
	 */
	public String userAvatarUpload(String user_id, String userAvatar_url);
}
