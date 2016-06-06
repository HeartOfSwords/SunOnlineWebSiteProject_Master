package com.sunonline.web.admin.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunonline.web.dao.AdminInfoDao;
import com.sunonline.web.daoImpl.AdminInfoDaoImpl;

/**
 * 验证管理员登录Servlet
 * @date 2016.5.11
 * @author 武文良
 *
 */
public class AdminLoginVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HttpSession session;

	public AdminLoginVerifyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 设定字符集/编码格式 */
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		/* 验证登录 */
		String adminName = request.getParameter("username");
		String adminPwd = request.getParameter("password");

		System.out.println(adminName + "=====>" + adminPwd);
		/* 使用AdminInfoDao验证是否是管理员 */
		AdminInfoDao adminInfoDao = new AdminInfoDaoImpl();
		/* 登录成功请求转发至管理员主页 */

		try {
			if (true == adminInfoDao.isAdmin(adminName, adminPwd)) {
				session = request.getSession();
				session.setAttribute("admin_name", adminName);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/index.jsp").forward(request, response);
			} else {
				/* 登录失败返回登录页重新登录 */
				request.setAttribute("errorMsg", "管理员身份认证错误");
				request.setAttribute("admin_name", adminName);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/login.jsp").forward(request, response);
			}

		} catch (Exception e) {
			System.out.println("身份认证失败");
			request.getRequestDispatcher("/WEB-INF/jsp/admin/login.jsp").forward(request, response);
		}
	}
}
