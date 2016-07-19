package com.sunonline.web.service.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 用户注销
 * @author snowalker
 * 16.7.19
 */
public class UserLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserLogout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session
		HttpSession session = request.getSession();
		//移除用户信息
		session.removeAttribute("usernickname");
		//重定向
		request.getRequestDispatcher("IndexRouter").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
