package com.sunonline.web.service.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunonline.web.bean.User;
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
		if (flag) {
			//登录成功获取对应的用户昵称
			String usernickname = userDao.getUserNickNameByUserEmail(useremail);
			//登录成功之后获取用户的全部信息
			//取出用户邮箱打回前台
			User user = userDao.fetchUserInfo(useremail);
			String userMobile = user.getUserMobile();
			session = request.getSession();
			//session设值
			session.setAttribute("usernickname", usernickname);
			session.setAttribute("usermobile", userMobile);
			System.out.println(user.getUsernickName());
			request.getRequestDispatcher("/IndexRouter").forward(request, response);
		} else {
			//登录失败回显
			request.setAttribute("useremail", useremail);
			String message = "登录失败，请核对信息";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/UserLoginRouter").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
