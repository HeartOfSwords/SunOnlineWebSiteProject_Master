package com.sunonline.web.service.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.sunonline.web.dao.UserDao;
import com.sunonline.web.dao.UserDaoImpl;
/**
 * 修改用户昵称
 * @author snowalker
 * 16.7.20
 */
public class ModifyUserNickName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
       
    public ModifyUserNickName() {
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
		String userNickName = request.getParameter("usernickname");
		String userMobile = request.getParameter("usermobile");
		//修改昵称逻辑
		userDao = new UserDaoImpl();
		String returnflag = userDao.modifyUserNickName(userMobile, userNickName);
		//session设值
		String flag = returnflag + "\n重新登陆查看您的新昵称";
		request.getSession().setAttribute("flag", flag);
		//重定向到修改页
		request.getRequestDispatcher("IndexRouter").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
