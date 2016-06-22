package com.sunonline.web.service.collegevoice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunonline.web.bean.CollegeVoiceVideoBean;
import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.bean.pager.CollegeVoicePagerBean;
import com.sunonline.web.bean.pager.HigoPagerBean;
import com.sunonline.web.dao.collegevoice.CollegeVoiceVideoDao;
import com.sunonline.web.dao.collegevoice.CollegeVoiceVideoDaoImpl;
import com.sunonline.web.dao.higo.HigoVideoDao;
import com.sunonline.web.dao.higo.HigoVideoDaoImpl;

/**
 * 高校最强音分页servlet
 * @author SnoWalker.wwl
 * <p>date：2016.6.13</p>
 */
public class CollegeVoiceVideoPager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CollegeVoiceVideoPager() {
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

		CollegeVoiceVideoDao collegeVoiceVideoDao = new CollegeVoiceVideoDaoImpl();
		//获取推荐视频
		List<CollegeVoiceVideoBean> collegeVoiceVideoRecommendation = collegeVoiceVideoDao.getCollegeVoiceVideoRecommendation();
		//视频最大数目
		int collegeVoiceVideoRowsCount = collegeVoiceVideoDao.fetchVideoRowsCount();
		int max_page = (collegeVoiceVideoRowsCount % CollegeVoicePagerBean.PAGE_SIZE == 0)
				? (collegeVoiceVideoRowsCount / CollegeVoicePagerBean.PAGE_SIZE)
				: (collegeVoiceVideoRowsCount / CollegeVoicePagerBean.PAGE_SIZE + 1);
		//根据具体条件获取当前页面
		if (current_pageno < 1) {
			current_pageno = 1;
		}

		if (current_pageno > max_page) {
			current_pageno = max_page;
		}
		//获取视频播放列表
		List<CollegeVoiceVideoBean> collegeVoiceVideoList = collegeVoiceVideoDao.fetchAllVideos(current_pageno);
		CollegeVoicePagerBean collegeVoicePagerBean = new CollegeVoicePagerBean();
		collegeVoicePagerBean.setCurPage(current_pageno);
		collegeVoicePagerBean.setMaxPage(max_page);
	
		//request中设置推荐视频	
		request.setAttribute("collegeVoiceVideoRecommendation", collegeVoiceVideoRecommendation);	//返回推荐视频
		request.setAttribute("collegeVoicePagerBean", collegeVoicePagerBean);						//分页bean
		request.setAttribute("collegeVoiceVideoList", collegeVoiceVideoList);						//视频列表
		request.getRequestDispatcher("/WEB-INF/jsp/collegevoicevideo/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
