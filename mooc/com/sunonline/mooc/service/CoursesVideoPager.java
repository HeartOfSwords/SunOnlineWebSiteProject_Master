package com.sunonline.mooc.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunonline.mooc.bean.pager.CoursesPagerBean;
import com.sunonline.mooc.dao.MoocVideoDao;
import com.sunonline.mooc.dao.MoocVideoDaoImpl;
import com.sunonline.mooc.model.CourseListItemBean;
import com.sunonline.mooc.model.CoursesBean;
import com.sunonline.web.bean.OldDriverVideoBean;
import com.sunonline.web.bean.pager.OldDriverPagerBean;
import com.sunonline.web.dao.olddriver.OldDriverVideoDao;
import com.sunonline.web.dao.olddriver.OldDriverVideoDaoImpl;
/**
 * 课程二级分页
 * @author snowalker
 * 16.7.6
 */
public class CoursesVideoPager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoursesVideoPager() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 设定字符集
		 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取当前页码
		String pagenoString = request.getParameter("current_pageno");

		int current_pageno = 1;

		try {
			current_pageno = Integer.parseInt(pagenoString);
		} catch (Exception e) {
			e.printStackTrace();
		}

		MoocVideoDao moocVideoDao = new MoocVideoDaoImpl();
		//解析当前视频所属分类id
		String c_idString = request.getParameter("c_id");
		Integer c_id = Integer.parseInt(c_idString);
		//视频最大数目
		int videoRowsCount = moocVideoDao.fetchVideoRowsCount(c_id);
		int max_page = (videoRowsCount % CoursesPagerBean.PAGE_SIZE == 0)
				? (videoRowsCount / CoursesPagerBean.PAGE_SIZE)
				: (videoRowsCount / CoursesPagerBean.PAGE_SIZE + 1);
		//根据具体条件获取当前页面
		if (current_pageno < 1) {
			current_pageno = 1;
		}

		if (current_pageno > max_page) {
			current_pageno = max_page;
		}
		
		//获取某一页面下分页数据
		List<CourseListItemBean> courseListItemList = moocVideoDao.fetchAllVideos(current_pageno, c_id);
		//通过c_id获取讲师信息及课程信息
		CoursesBean coursesBean = moocVideoDao.getCourseInfoByID(Integer.valueOf(c_id));
		//组装分页bean
		CoursesPagerBean coursesPagerBean = new CoursesPagerBean();
		coursesPagerBean.setCurPage(current_pageno);	//当前页码
		coursesPagerBean.setMaxPage(max_page);			//最大页码数量
		
		request.setAttribute("coursesBean", coursesBean);
		request.setAttribute("coursesPagerBean", coursesPagerBean);			//分页bean
		request.setAttribute("courseListItemList", courseListItemList);		//视频列表
		request.getRequestDispatcher("/WEB-INF/jsp/mooc/coursemenupage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
