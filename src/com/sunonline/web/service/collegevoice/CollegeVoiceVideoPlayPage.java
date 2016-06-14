package com.sunonline.web.service.collegevoice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunonline.web.bean.CollegeVoiceVideoBean;
import com.sunonline.web.dao.collegevoice.CollegeVoiceVideoDao;
import com.sunonline.web.dao.collegevoice.CollegeVoiceVideoDaoImpl;

/**
 * 高校最强音播放页三级重定向
 * 
 * @author SnoWalker.wwl 2016.6.13
 */
public class CollegeVoiceVideoPlayPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CollegeVoiceVideoPlayPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解析url
		String id = request.getParameter("id");
		CollegeVoiceVideoBean collegeVoiceVideoBean = new CollegeVoiceVideoBean();
		CollegeVoiceVideoDao collegeVoiceVideoDao = new CollegeVoiceVideoDaoImpl();
		// 获取collegeVoiceVideoBean实体
		collegeVoiceVideoBean = collegeVoiceVideoDao.getVideoByID(Integer.valueOf(id));
		// 增加播放次数
		collegeVoiceVideoDao.addPlayTimeNumber(Integer.parseInt(id));
		// 获取推荐视频
		List<CollegeVoiceVideoBean> collegeVoiceVideoRecommendation = collegeVoiceVideoDao.getCollegeVoiceVideoRecommendation();
		// 设置request中添加推荐视频
		request.setAttribute("collegeVoiceVideoRecommendation", collegeVoiceVideoRecommendation);
		request.setAttribute("collegeVoiceVideoInfo", collegeVoiceVideoBean);
		// 重定向到对应id的播放页面
		request.getRequestDispatcher("/WEB-INF/jsp/collegevoicevideo/playpage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
