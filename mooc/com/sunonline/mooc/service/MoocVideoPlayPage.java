package com.sunonline.mooc.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunonline.mooc.dao.MoocVideoDao;
import com.sunonline.mooc.dao.MoocVideoDaoImpl;
import com.sunonline.mooc.model.CourseListItemBean;
import com.sunonline.mooc.model.CoursesBean;
import com.sunonline.web.bean.OldDriverVideoBean;
import com.sunonline.web.dao.olddriver.OldDriverVideoDao;
import com.sunonline.web.dao.olddriver.OldDriverVideoDaoImpl;
/**
 * 公益课堂播放页三级重定向
 * 
 * @author SnoWalker.wwl 2016.6.1
 */
public class MoocVideoPlayPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MoocVideoPlayPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		fetchInfo(request, response);
	}

	private void fetchInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解析url
		String cl_id = request.getParameter("cl_id");	//课程项id
		String c_id = request.getParameter("c_id");		//课程分类id
		CourseListItemBean courseListItemBean = new CourseListItemBean();
		MoocVideoDao moocVideoDao = new MoocVideoDaoImpl();
		//通过c_id获取讲师信息及课程信息
		CoursesBean coursesBean = moocVideoDao.getCourseInfoByID(Integer.valueOf(c_id));
		// 根据id获取courseListItemBean实体
		courseListItemBean = moocVideoDao.getMoocVideoItemByID(Integer.parseInt(cl_id));
		//增加视频播放次数
		moocVideoDao.addPlayTimeNumber(Integer.parseInt(cl_id));
		//设置request中添加推荐视频
		request.setAttribute("courseListItemBean", courseListItemBean);
		//设置request中添加讲师信息
		request.setAttribute("coursesBean", coursesBean);
		// 重定向到对应id的播放页面
		request.getRequestDispatcher("/WEB-INF/jsp/mooc/courseitemplaypage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
