package com.sunonline.web.service.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunonline.web.utils.TokenProccessor;
/**
 * 用户注册路由实现
 * @author snowalker
 * 16.7.15
 */
public class UserRegisterRouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRegisterRouter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Token创建并设值跳转
		String token = TokenProccessor.getInstance().makeToken();	//令牌创建
		request.getSession().setAttribute("token", token);
		//跳转
		request.getRequestDispatcher("/WEB-INF/jsp/user/loginAndRegister.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
