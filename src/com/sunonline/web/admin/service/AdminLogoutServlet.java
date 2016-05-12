package com.sunonline.web.admin.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>管理员注销登录</p>
 * @author 武文良
 * @date 2016.5.12
 */
public class AdminLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminLogoutServlet() {
        super();  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//移除session中的管理员会话属性确保注销
		HttpSession session = request.getSession();
		session.removeAttribute("admin_name");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
