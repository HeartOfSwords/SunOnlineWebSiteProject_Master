package com.sunonline.web.service.index;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunonline.web.bean.CollegeVoiceVideoBean;
import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.bean.OldDriverVideoBean;
import com.sunonline.web.dao.index.IndexInfoDao;
import com.sunonline.web.dao.index.IndexInfoDaoImpl;

/**
 * 主页路由servlet
 * @author SnoWalker.wwl
 * <p>date：2016.6.1</p>
 */
public class IndexRouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public IndexRouter() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 设定字符集
		 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取数据
		getVideoInfos(request);
		//页面重定向
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	private void getVideoInfos(HttpServletRequest request) {
		IndexInfoDao indexInfoDao = new IndexInfoDaoImpl();
		//获取Higo列表
		List<HigoVideoBean> higoVideoBeans = indexInfoDao.fetchHigoList(7);
		//获取最强音列表
		List<CollegeVoiceVideoBean> collegeVoiceVideoBeans = indexInfoDao.fetchCollegeVoiceList(7);
		//获取老司机列表
		List<OldDriverVideoBean> oldDriverVideoBeans = indexInfoDao.fetchOldDriverList(7);
		
		//返回数据
		request.setAttribute("higoVideoBeans", higoVideoBeans);
		request.setAttribute("collegeVoiceVideoBeans", collegeVoiceVideoBeans);
		request.setAttribute("oldDriverVideoBeans", oldDriverVideoBeans);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
