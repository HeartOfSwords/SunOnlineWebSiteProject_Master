package com.sunonline.web.service.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunonline.web.dao.UserDao;
import com.sunonline.web.dao.UserDaoImpl;
import com.sunonline.web.utils.StringEncodeUtils;

/**
 * 用户密码修改
 * @author snowalker
 * 16.7.21
 */
public class ModifyUserpwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private String flag;
       
    public ModifyUserpwd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 设定字符集
		 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取参数
		String usermobile = request.getParameter("usermobile");
		String oldPasswd = request.getParameter("olduserpwd");
		String newPasswd = request.getParameter("newuserpwd");
		//对密码进行MD5加密
		String MD5EncodedOldPasswd = StringEncodeUtils.EncodePassword(oldPasswd);
		userDao = new UserDaoImpl();
		//判断旧密码是否和数据库中的数据相同
		if (MD5EncodedOldPasswd.equals(getOldPasswd(usermobile))) {
			String result = userDao.userModifyUserPasswdDirectly(newPasswd, usermobile);
			flag = result + ",下次登录请使用新密码";
			System.out.println(flag);
			request.getSession().setAttribute("passwdflag", flag);
		} else {
			flag = "密码修改失败，请核对您的信息";
			System.out.println(flag);
			request.getSession().setAttribute("passwdflag", flag);
		}
		request.getRequestDispatcher("IndexRouter").forward(request, response);
	}
	//获取旧密码
	//enjoy the candy
	private String getOldPasswd(String usermobile) {
		
		userDao = new UserDaoImpl();
		return userDao.getOldPasswd(usermobile);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
