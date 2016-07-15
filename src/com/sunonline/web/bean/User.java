package com.sunonline.web.bean;
/** 
 * @author 武文良
 * @date 2016.5.3
 * <p>function:用户注册bean</p>
 * modify: 2016.7.15
 */
public class User {
	
	private Integer user_id;				//用户id

	private String usernickName;			//用户昵称
	
	private String userPwd; 				//用户密码
	
	private String userMobile;				//用户注册手机
	
	private String userEmail;				//用户邮箱
	
	public User() {
	}
	
	public User(Integer user_id, String usernickName, String userPwd, String userMobile, String userEmail) {
		super();
		this.user_id = user_id;
		this.usernickName = usernickName;
		this.userPwd = userPwd;
		this.userMobile = userMobile;
		this.userEmail = userEmail;
	}

	public User(String usernickName, String userPwd, String userMobile, String userEmail) {
		super();
		this.usernickName = usernickName;
		this.userPwd = userPwd;
		this.userMobile = userMobile;
		this.userEmail = userEmail;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsernickName() {
		return usernickName;
	}

	public void setUsernickName(String usernickName) {
		this.usernickName = usernickName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
		
}
