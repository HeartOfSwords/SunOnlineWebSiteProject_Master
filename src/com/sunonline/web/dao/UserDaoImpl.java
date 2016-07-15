package com.sunonline.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunonline.web.bean.OldDriverVideoBean;
import com.sunonline.web.utils.DBUtils;
import com.sunonline.web.utils.StringEncodeUtils;

/**
 * 用户Dao实现类
 * @author snowalker
 * 16.7.15
 */ 
public class UserDaoImpl implements UserDao {

	private String userpwdInDB;


	//用户注册
	@Override
	public String UserRegister(String usernickname, String userpwd, String userMobile, String userEmail) {
		//获取数据库中数据
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图
		String sql = "insert into user(usernickname,userpwd,usermobile,useremail) "
				+ " values (?,?,?,?)";
		PreparedStatement pstmt;
		//对密码进行加密
		String userpwdEncode = StringEncodeUtils.EncodePassword(userpwd);
		try {
			pstmt = connection.prepareStatement(sql);
			//参数注入
			pstmt.setString(1, usernickname);
			pstmt.setString(2, userpwdEncode);	//传入经过加密的密码
			pstmt.setString(3, userMobile);
			pstmt.setString(4, userEmail);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				return "successfully creating user";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "failed creating user";
	}

	/*
	 * 根据用户邮箱判断用户登录
	 * @see com.sunonline.web.dao.UserDao#verifyUserEmail(java.lang.String, java.lang.String)
	 */
	@Override
	public String verifyUserEmail(String useremail, String userpwd) {
		/*注意登录判断对数据进行MD5加密之后再进行比较
		 *构造查询sql 获取对应账户下的密码并对输入的密码进行加密处理
		 *之后与取出的密码进行比对
		 *如果相等则登录成功否则登录失败
		 */
		String sql = "SELECT userpwd from userlogin_view where useremail=?";
		//对输入的密码进行MD5加密
		String MD5EncodePwd = StringEncodeUtils.EncodePassword(userpwd);
		try {
			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, useremail);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				//获取数据库中的用户密码并记录到成员变量之中
				userpwdInDB = rs.getString("userpwd");
			}
		} catch (Exception e) {
			return "invalid user account";
		}
		//对账户密码进行比对
		if (userpwdInDB != null && userpwdInDB != "" && userpwdInDB.equals(MD5EncodePwd)) {
			return "Login Successfully";
		} else {
			return "Login failed";
		}
	}


	/*
	 * 根据用户手机号码决定用户登录
	 * @see com.sunonline.web.dao.UserDao#verifyUserMobile(java.lang.String, java.lang.String)
	 */
	@Override
	public String verifyUserMobile(String usermobile, String userpwd) {
		/*注意登录判断对数据进行MD5加密之后再进行比较
		 *构造查询sql 获取对应账户下的密码并对输入的密码进行加密处理
		 *之后与取出的密码进行比对
		 *如果相等则登录成功否则登录失败
		 */
		String sql = "SELECT userpwd from userlogin_view where usermobile=?";
		//对输入的密码进行MD5加密
		String MD5EncodePwd = StringEncodeUtils.EncodePassword(userpwd);
		try {
			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, usermobile);
			ResultSet rs = pstmt.executeQuery();
			//从数据库中遍历取出对应的密码
			while (rs.next()) {
				//获取数据库中的用户密码并记录到成员变量之中
				userpwdInDB = rs.getString("userpwd");
			}
		} catch (Exception e) {
			return "invalid user account";
		}
		//对账户密码进行比对
		if (userpwdInDB != null && userpwdInDB != "" && userpwdInDB.equals(MD5EncodePwd)) {
			return "Login Successfully";
		} else {
			return "Login failed";
		}
	}
}
