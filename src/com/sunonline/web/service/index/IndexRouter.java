package com.sunonline.web.service.index;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

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
       
    @Override
    public void init() throws ServletException {
    	super.init();
    	//获取路径名
    	String path = getServletContext().getRealPath("/");
    	String profile = path + getInitParameter("propfile");
    	//配置log4j环境
    	PropertyConfigurator.configure(profile);
    }
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
		//获取远程主机ip及主机名并写入日志
		String remoteHostAddress = request.getRemoteAddr();
		String remoteHostName = request.getRemoteHost();
		//lOG4J获取日志
		Logger logger = Logger.getLogger("logger");
		logger.info("远程主机ip:" + remoteHostAddress + "远程主机名：" + remoteHostName);
		System.out.println("===========================================================");
		//获取数据
		getVideoInfos(request);
		//页面重定向
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	private void getVideoInfos(HttpServletRequest request) {
		IndexInfoDao indexInfoDao = new IndexInfoDaoImpl();
		//获取Higo列表
		List<HigoVideoBean> higoVideoBeans = indexInfoDao.fetchHigoList(8);
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
