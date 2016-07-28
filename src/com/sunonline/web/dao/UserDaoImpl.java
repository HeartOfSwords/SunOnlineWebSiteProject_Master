 package com.sunonline.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sunonline.web.bean.User;
import com.sunonline.web.utils.DBUtils;
import com.sunonline.web.utils.StringEncodeUtils;

/**
 * 用户Dao实现类
 * @author snowalker
 * 16.7.15
 */ 
public class UserDaoImpl implements UserDao {

	private String userpwdInDB; //成员变量，从数据库中得到的用户密码
	@SuppressWarnings("unused")
	private String userNickName;//用户昵称成员变量
	private User user;			//用户实例成员变量
	private int flagNickName;	//昵称标记成员变量
	private int flagPwd;		//密码标记成员变量
	private String mobileInDB;	//用户手机号码成员变量
	private String passwdInDB;	//数据库中的用户密码成员变量
	private int flagAvatar;		//头像设置成功与否标志位		


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
	public User verifyUserEmail(String useremail, String userpwd) {
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
			return null;
		}
		//对账户密码进行比对
		
		//登录成功返回用户信息
		if (userpwdInDB != null && userpwdInDB != "" && userpwdInDB.equals(MD5EncodePwd)) {
			User successInfo = getUserInfoByUserEmail(useremail); 
			return successInfo;
		} else {
			return null;
		}
	}
	//通过用户邮箱返回用户信息
	@Override
	public User fetchUserInfo(String useremail) {
		return this.getUserInfoByUserEmail(useremail);
	}
	
	
	//成功返回用户信息，接受参数用户邮箱
	private User getUserInfoByUserEmail(String useremail) {
		//构造sql
		String sql = "SELECT * from userlogin_view where useremail=?";
		
		try {
			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, useremail);
			ResultSet rs = pstmt.executeQuery();
			//从数据库中遍历取出对应的密码
			while (rs.next()) {
				user = new User();
				//获取数据库中用户信息并封装
				Integer userId = rs.getInt("user_id");
				userNickName = rs.getString("usernickname");
				String userMobile = rs.getString("usermobile");
				String userEmail = rs.getString("useremail");
				String userAvatar = rs.getString("useravatar");
				
				user.setUser_id(userId);
				user.setUserEmail(userEmail);
				user.setUserAvatar(userAvatar);
				user.setUserMobile(userMobile);
				user.setUsernickName(userNickName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/*
	 * 根据用户手机号码决定用户登录
	 * @see com.sunonline.web.dao.UserDao#verifyUserMobile(java.lang.String, java.lang.String)
	 */
	@Override
	public User verifyUserMobile(String usermobile, String userpwd) {
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
			return null;
		}
		//对账户密码进行比对
		if (userpwdInDB != null && userpwdInDB != "" && userpwdInDB.equals(MD5EncodePwd)) {
			User successInfo = getUserInfoByUserMobile(usermobile); 
			return successInfo;
		} else {
			return null;
		}
	}
	
	//成功返回用户信息，通过参数用户手机
	private User getUserInfoByUserMobile(String usermobile) {
		//构造sql
		String sql = "SELECT * from userlogin_view where usermobile=?";

		try {
			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, usermobile);
			ResultSet rs = pstmt.executeQuery();
			//从数据库中遍历取出对应的密码
			while (rs.next()) {
				user = new User();
				//获取数据库中用户信息并封装
				Integer userId = rs.getInt("user_id");
				userNickName = rs.getString("usernickname");
				String userMobile = rs.getString("usermobile");
				String userEmail = rs.getString("useremail");
				String userAvatar = rs.getString("useravatar");

				user.setUser_id(userId);
				user.setUserEmail(userEmail);
				user.setUserAvatar(userAvatar);
				user.setUserMobile(userMobile);
				user.setUsernickName(userNickName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/*
	 * 通过用户邮箱得到用户昵称
	 */
	@Override
	public String getUserNickNameByUserEmail(String useremail) {
		//构造sql
		String sql = "SELECT usernickname from userlogin_view where useremail=?";
		
		try {
			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, useremail);
			ResultSet rs = pstmt.executeQuery();
			//从数据库中遍历取出对应的密码
			while (rs.next()) {
				//获取数据库中的用户昵称并且记录到成员变量之中
				userNickName = rs.getString("usernickname");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userNickName;
	}
	
	//根据邮箱判断用户登录返回boolean类型
	public Boolean verifyUser(String useremail, String userpwd) {
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
			return false;
		}
		//对账户密码进行比对
		if (userpwdInDB != null && userpwdInDB != "" && userpwdInDB.equals(MD5EncodePwd)) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * 修改用户昵称
	 * 接受参数为 ：
	 * 	登录的用户账号，要设置的用户昵称
	 * 此处手机号过长，因此使用long进行设值
	 * @see com.sunonline.web.dao.UserDao#modifyUserNickName(java.lang.String, java.lang.String)
	 */
	@Override
	public String modifyUserNickName(String userMobile, String newNickName) {
		//构造sql
		String sql = "update user set usernickname=? where usermobile=?";
		//转换手机号字符串为整形数
		Long mobileNum = Long.valueOf(userMobile);
		
		try {
			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			//sql设值
			pstmt.setString(1, newNickName);
			pstmt.setLong(2, mobileNum);
			
			flagNickName = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//flag结果判断
		if (flagNickName > 0) {
			return "昵称修改成功，新的昵称是:" + newNickName;
		} else {
			return "昵称修改失败";
		}
	}
	
	/*
	 * 用户修改密码，初始装填为直接登录
	 */
	public String userModifyUserPasswdDirectly(String userpwd, String userMobile) {
		//构造sql
		String sql = "update user set userpwd=? where usermobile=?";
		//转换手机号字符串为整形数
		Long mobileNum = Long.valueOf(userMobile);
		//对密码进行加密
		String userpwdEncode = StringEncodeUtils.EncodePassword(userpwd);

		try {
			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			//sql设值
			pstmt.setString(1, userpwdEncode);
			pstmt.setLong(2, mobileNum);

			flagPwd = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		//flag结果判断
		if (flagPwd > 0) {
			return "密码修改成功";
		} else {
			return "密码修改失败";
		}
	}

	//用户修改密码，忘记密码
	//首先验证密码合法性
	@Override
	public String userVerifyValidityBeforeModifyUserpwd(String userMobile) {
		String sql = "SELECT usermobile from userlogin_view where usermobile=?";
		//转换字符串为long型
		Long mobile = Long.valueOf(userMobile);
		try {
			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, mobile);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				mobileInDB = rs.getString("usermobile");
			}
		} catch (Exception e) {
			e.printStackTrace();;
		}
		//对账户密码进行比对
		if (mobileInDB != null && mobileInDB.equals(userMobile)) {
			return "用户合法性验证成功";
		} else {
			return "用户不存在，请核对信息后重试";
		}
	}
	
	//通过用户手机号查找用户密码
	public String getOldPasswd(String usermobile) {
		
		//转换字符串为long型
		Long mobile = Long.valueOf(usermobile);
		String sql = "SELECT userpwd from userlogin_view where usermobile=" + mobile;
		
		
		try {
			Connection connection = new DBUtils().getCon();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				passwdInDB = rs.getString("userpwd");
			}
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return passwdInDB;
		
	}

	
	//通过用户id上传用户头像地址实现方法
	//enjoy the candy
	@Override
	public String userAvatarUpload(String user_id, String userAvatar_url) {
		//转换用户id为整型变量
		int u_id = Integer.valueOf(user_id);
		//构造sql
		String sql = "update user set useravatar= '" + userAvatar_url + "' where user_id=" + u_id;
		try {
			Connection connection = new DBUtils().getCon();
			Statement statement = connection.createStatement();
			flagAvatar = statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//对执行结果进行判断
		if (flagAvatar > 0) {
			return "successfully set avatar URL";
		} else {
			return "failed to set avatar URL";
		}
	}
	
	
	public static void main(String[] args) {
		//System.out.println(new UserDaoImpl().getUserNickNameByUserEmail("1234@qq.com"));
		//System.out.println(new UserDaoImpl().modifyUserNickName("12345678900", "知行合一"));
		//System.out.println(new UserDaoImpl().userVerifyValidityBeforeModifyUserpwd("12345678900"));
		//System.out.println(new UserDaoImpl().fetchUserInfo("1234555@qq.com").getUsernickName());
		//System.out.println(new UserDaoImpl().userModifyUserPasswdDirectly("123456", "13545677654"));
		//System.out.println(new UserDaoImpl().getOldPasswd("13545677654"));
		System.out.println(new UserDaoImpl().userAvatarUpload("20", "http://whatthefxxxxxk.com/1.png"));
	}
	
}
