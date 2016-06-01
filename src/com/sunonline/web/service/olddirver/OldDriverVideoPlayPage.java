package com.sunonline.web.service.olddirver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.bean.OldDriverVideoBean;
import com.sunonline.web.bean.pager.OldDriverPagerBean;
import com.sunonline.web.dao.higo.HigoVideoDao;
import com.sunonline.web.dao.higo.HigoVideoDaoImpl;
import com.sunonline.web.dao.olddirver.OldDriverVideoDao;
import com.sunonline.web.dao.olddirver.OldDriverVideoDaoImpl;

/**
 * 影视老司机播放页三级重定向
 * 
 * @author SnoWalker.wwl 2016.6.1
 */
public class OldDriverVideoPlayPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OldDriverVideoPlayPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解析url
		String id = request.getParameter("id");
		OldDriverVideoBean oldDriverVideoBean = new OldDriverVideoBean();
		OldDriverVideoDao oldDirverVideoDao = new OldDriverVideoDaoImpl();
		// 根据id获取HigoVideoBean实体
		oldDriverVideoBean = oldDirverVideoDao.getOldDriverVideoByID(Integer.parseInt(id));
		request.setAttribute("oldDriverVideoInfo", oldDriverVideoBean);
		// 重定向到对应id的播放页面
		request.getRequestDispatcher("/WEB-INF/jsp/olddrivervideo/playpage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
