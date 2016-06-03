package com.sunonline.web.service.higo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.dao.higo.HigoVideoDao;
import com.sunonline.web.dao.higo.HigoVideoDaoImpl;

/**
 * Higo大学季播放页三级重定向
 * @author SnoWalker.wwl
 * 2016.5.31
 */
public class HigoVideoPlayPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HigoVideoPlayPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解析url
		String id = request.getParameter("id");
		HigoVideoBean higoVideoBean= new HigoVideoBean();
		HigoVideoDao higoVideoDao = new HigoVideoDaoImpl();
		//获取HigoVideoBean实体
		higoVideoBean = higoVideoDao.getHigoVideoByID(Integer.parseInt(id));
		higoVideoDao.addPlayTimeNumber(Integer.parseInt(id));
		//获取推荐视频
		List<HigoVideoBean> higoVideoRecommendation = higoVideoDao.getHigoVideoRecommendation();
		//设置request中添加推荐视频
		request.setAttribute("higoVideoRecommendation", higoVideoRecommendation);
		request.setAttribute("higoVideoInfo", higoVideoBean);
		//重定向到对应id的播放页面
		request.getRequestDispatcher("/WEB-INF/jsp/higovideo/playpage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
