package com.sunonline.mooc.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunonline.mooc.dao.MoocVideoDao;
import com.sunonline.mooc.dao.MoocVideoDaoImpl;
import com.sunonline.mooc.model.TypeBean;
import com.sunonline.web.webapi.bean.mooc.MediasAfter;
import com.sunonline.web.webapi.bean.mooc.RadioInterview;
import com.sunonline.web.webapi.bean.mooc.SoftwareDeveloping;
import com.sunonline.web.webapi.resource.MoocResource;
/**
 * 公益课堂主页路由
 * @author snowalker
 * 16.7.6
 */
public class MoocIndexPager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MoocIndexPager() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 设定字符集
		 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取课程类型
		MoocVideoDao moocVideoDao = new MoocVideoDaoImpl();
		
		List<TypeBean> typeBeans = moocVideoDao.fetchCoursesTypeList();
		//获取软件开发列表
		List<SoftwareDeveloping> softwareDevelopings = new MoocResource().getSoftwareDevCoursesList();
		//获取播音主持列表
		List<RadioInterview> radioInterviews = new MoocResource().getRadioInterviewCoursesList();
		//获取后期制作列表
		List<MediasAfter> mediasAfters = new MoocResource().getMediasAfterCoursesList();
		//返回类型列表
		request.setAttribute("typeBeans", typeBeans);
		//返回类目视频列表
		request.setAttribute("softwareDevelopings", softwareDevelopings);
		request.setAttribute("radioInterviews", radioInterviews);
		request.setAttribute("mediasAfters", mediasAfters);
		// 重定向到对应id的播放页面
		request.getRequestDispatcher("/WEB-INF/jsp/mooc/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
