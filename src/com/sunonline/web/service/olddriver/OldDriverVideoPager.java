package com.sunonline.web.service.olddriver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.bean.OldDriverVideoBean;
import com.sunonline.web.bean.pager.OldDriverPagerBean;
import com.sunonline.web.dao.olddriver.OldDriverVideoDao;
import com.sunonline.web.dao.olddriver.OldDriverVideoDaoImpl;

/**
 * 影视老司机分页servlet
 * @author SnoWalker.wwl
 * <p>date：2016.6.1</p>
 */
public class OldDriverVideoPager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OldDriverVideoPager() {
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

		OldDriverVideoDao oldDriverVideoDao = new OldDriverVideoDaoImpl();
		//获取推荐视频
		List<OldDriverVideoBean> oldDriverRecommendation = oldDriverVideoDao.getOldDriverVideoRecommendation();
		//视频最大数目
		int oldDirverVideoRowsCount = oldDriverVideoDao.fetchVideoRowsCount();
		int max_page = (oldDirverVideoRowsCount % OldDriverPagerBean.PAGE_SIZE == 0)
				? (oldDirverVideoRowsCount / OldDriverPagerBean.PAGE_SIZE)
				: (oldDirverVideoRowsCount / OldDriverPagerBean.PAGE_SIZE + 1);
		//根据具体条件获取当前页面
		if (current_pageno < 1) {
			current_pageno = 1;
		}

		if (current_pageno > max_page) {
			current_pageno = max_page;
		}

		List<OldDriverVideoBean> oldDirverVideoList = oldDriverVideoDao.fetchAllVideos(current_pageno);
		//组装分页bean
		OldDriverPagerBean oldDriverPagerBean = new OldDriverPagerBean();
		oldDriverPagerBean.setCurPage(current_pageno);
		oldDriverPagerBean.setMaxPage(max_page);
	
		request.setAttribute("oldDriverRecommendation", oldDriverRecommendation);//设置推荐视频到request
		request.setAttribute("oldDriverPagerBean", oldDriverPagerBean);		//分页bean
		request.setAttribute("oldDriverVideoList", oldDirverVideoList);		//视频列表
		request.getRequestDispatcher("/WEB-INF/jsp/olddrivervideo/index.jsp").forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
