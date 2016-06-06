package com.sunonline.web.service.higo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.bean.pager.HigoPagerBean;
import com.sunonline.web.dao.higo.HigoVideoDao;
import com.sunonline.web.dao.higo.HigoVideoDaoImpl;

/**
 * Higo大学季分页servlet
 * @author SnoWalker.wwl
 * <p>date：2016.5.31</p>
 */
public class HigoVideoPager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HigoVideoPager() {
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

		HigoVideoDao higoVideoDao = new HigoVideoDaoImpl();
		//获取推荐视频
		List<HigoVideoBean> higoVideoRecommendation = higoVideoDao.getHigoVideoRecommendation();
		//视频最大数目
		int higoVideoRowsCount = higoVideoDao.fetchVideoRowsCount();
		int max_page = (higoVideoRowsCount % HigoPagerBean.PAGE_SIZE == 0)
				? (higoVideoRowsCount / HigoPagerBean.PAGE_SIZE)
				: (higoVideoRowsCount / HigoPagerBean.PAGE_SIZE + 1);
		//根据具体条件获取当前页面
		if (current_pageno < 1) {
			current_pageno = 1;
		}

		if (current_pageno > max_page) {
			current_pageno = max_page;
		}

		List<HigoVideoBean> higoVideoList = higoVideoDao.fetchAllVideos(current_pageno);
		HigoPagerBean higoPagerBean = new HigoPagerBean();
		higoPagerBean.setCurPage(current_pageno);
		higoPagerBean.setMaxPage(max_page);
		//request中设置推荐视频
		
		request.setAttribute("higoVideoRecommendation", higoVideoRecommendation);
		request.setAttribute("higoPagerBean", higoPagerBean);		//分页bean
		request.setAttribute("higoVideoList", higoVideoList);		//视频列表
		request.getRequestDispatcher("/WEB-INF/jsp/higovideo/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
