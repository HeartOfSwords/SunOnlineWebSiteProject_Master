package com.sunonline.web.service.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunonline.web.dao.UserDao;
import com.sunonline.web.dao.UserDaoImpl;
/**
 * 用户登录后台逻辑
 * @author snowalker
 * 16.7.15
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//声明用户DAO
	private UserDao userDao;
	private HttpSession session;
       
    public UserLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * 设定字符集
		 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取登录邮箱密码
		String useremail = request.getParameter("useremail");
		String userpwd = request.getParameter("userpwd");
		System.out.println(useremail + " " + userpwd);
		//实例化用户dao
		userDao = new UserDaoImpl();
		Boolean flag = userDao.verifyUser(useremail, userpwd);
		System.out.println(flag);
		if (flag) {
			//登录成功获取对应的用户昵称
			String usernickname = userDao.getUserNickNameByUserEmail(useremail);
			session = request.getSession();
			session.setAttribute("usernickname", usernickname);
			System.out.println("测试成功");
			request.getRequestDispatcher("/IndexRouter").forward(request, response);
		} else {
			//登录失败回显
			request.setAttribute("useremail", useremail);
			request.getRequestDispatcher("/UserLoginRouter").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
