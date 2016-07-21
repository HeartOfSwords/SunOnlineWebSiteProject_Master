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
		//判断用户是否是重复提交
		boolean b = isRepeatSubmit(request);
		if(b==true){
			System.out.println("请不要重复提交");
//			request.getSession().setAttribute("warning-message", "请不要重复提交表单，请重新访问注册页面");
			request.getRequestDispatcher("UserRegisterRouter").forward(request, response);
			return;
		}
		request.getSession().removeAttribute("token");//移除session中的token

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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	 /**
	  * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
	  * @param request
	  * @return 
	  *         true 用户重复提交了表单 
	  *         false 用户没有重复提交表单
	  */
	private boolean isRepeatSubmit(HttpServletRequest request) {
		String client_token = request.getParameter("token");
		//1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
		if(client_token==null){
			return true;
		}
		//取出存储在Session中的token
		String server_token = (String) request.getSession().getAttribute("token");
		//2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
		if(server_token==null){
			return true;
		}
		//3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
		if(!client_token.equals(server_token)){
			return true;
		}

		return false;
	}

}
