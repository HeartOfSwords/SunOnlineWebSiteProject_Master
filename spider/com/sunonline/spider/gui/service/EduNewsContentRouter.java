package com.sunonline.spider.gui.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunonline.spider.gui.bean.EducationNews;
import com.sunonline.spider.gui.dao.EducationNewsDao;
import com.sunonline.spider.gui.dao.EducationNewsDaoImpl;
/**
 * 教育新闻内容详情页展示页路由
 * @author snowalker
 * 16.7.25
 */
public class EduNewsContentRouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EducationNewsDao educationNewsDao;
	private EducationNews educationNews;
       
    public EduNewsContentRouter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 设置编码集合
		 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		educationNewsDao = new EducationNewsDaoImpl();
		//获取参数
		int id = Integer.valueOf(request.getParameter("id"));
		if (id > 0) {
			educationNews = educationNewsDao.getEduNewsById(id);
		}
		//request设值返回新闻列表
		request.setAttribute("educationNews", educationNews);

		request.getRequestDispatcher("/WEB-INF/jsp/spider/newspage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
