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
 * 教育资讯菜单页路由
 * @author snowalker
 * 16.7.25
 */
public class EduNewsMenuRouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EduNewsMenuRouter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//打包数据
		EducationNewsDao educationNewsDao = new EducationNewsDaoImpl();
		//获取新闻资讯列表
		List<EducationNews> educationNewslist = educationNewsDao.getEduNewsList();
		//获取新闻推荐列表
		List<EducationNews> recommendationNews = educationNewsDao.getRecommendationNewsList();
		//request设值返回推荐新闻列表
		request.setAttribute("recommendationNews", recommendationNews);
		//包装列表
		request.setAttribute("educationNewslist", educationNewslist);
		//请求转发
		request.getRequestDispatcher("/WEB-INF/jsp/spider/menulist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
