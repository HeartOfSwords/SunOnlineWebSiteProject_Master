package com.sunonline.web.service.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunonline.web.dao.UserDao;
import com.sunonline.web.dao.UserDaoImpl;
/**
 * 用户注册逻辑实现
 * @author snowalker
 * 16.7.15
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;	//声明用户数据访问层
       
    public UserRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 设定字符集
		 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获取表单提交数据
		String usernickname = request.getParameter("usernickname");
		String userpwd = request.getParameter("userpwd");
		String usermobile = request.getParameter("usermobile");
		String useremail = request.getParameter("useremail");
		//提交数据到数据库
		userDao = new UserDaoImpl();
		String flag = userDao.UserRegister(usernickname, userpwd, usermobile, useremail);
		if ("successfully creating user".equals(flag)) {
			String rMessage = "注册成功，请登录";
			request.setAttribute("rMessage", rMessage);
			request.getRequestDispatcher("UserLoginRouter").forward(request, response);
		} else {
			String rMessage = "注册失败，请重新注册";
			request.setAttribute("rMessage", rMessage);
			request.getRequestDispatcher("UserLoginRouter").forward(request, response);
		}
		System.out.println(usernickname + " " + userpwd + " " + usermobile + " " + useremail + " ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
