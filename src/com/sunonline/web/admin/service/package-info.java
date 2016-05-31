/**
 * <p>title:业务层包说明类</p>
 * <p>Copyright:Copyright(c)2016</p>
 * <p>Company:太阳在线</p>
 * <p>function:本包主要存放项目中的管理员业务层接口定义</p>
 * @author WuWenliang
 * 
 * @version $$Date:2016/04/26
 *
 */
package com.sunonline.web.admin.service;

/*
	AdminLoginVerifyServlet Post()方法的第二种简洁写法
	
	private String url = "/admin/login.jsp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设定字符集/编码格式 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		//验证登录 
		String adminName = request.getParameter("username");
		String adminPwd = request.getParameter("password");

		System.out.println(adminName + "=====>" + adminPwd);
		//使用AdminInfoDao验证是否是管理员 
		AdminInfoDao adminInfoDao = new AdminInfoDaoImpl();
		//登录成功请求转发至管理员主页 

		try {
			if (true == adminInfoDao.isAdmin(adminName, adminPwd)) {
				session = request.getSession();
				session.setAttribute("admin_name", adminName);
				url = "/admin/index.jsp";
			} else {
				//登录失败返回登录页重新登录 
				request.setAttribute("errorMsg", "管理员身份认证错误");
				request.setAttribute("admin_name", adminName);
			}

		} catch (Exception e) {
			System.out.println("身份认证失败");
		}
		request.getRequestDispatcher(url).forward(request, response);

	}
*/