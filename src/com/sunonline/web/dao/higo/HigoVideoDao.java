package com.sunonline.web.dao.higo;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sunonline.web.bean.HigoVideoBean;

/**
 * Higo大学季视频Dao
 * @author SnoWalker.wwl
 * <p>2016.5.31</p>
 */
public interface HigoVideoDao {
	
	//获取视频总条数
	public int fetchVideoRowsCount();
	//获取所有视频
	public List<HigoVideoBean> fetchAllVideos();
	//获取某一页所有视频
	public List<HigoVideoBean> fetchAllVideos(int current_pageNo);
	//根据id获取某一个视频的信息
	public HigoVideoBean getHigoVideoByID(int higoVideoID);
	//增加播放次数
	public void addPlayTimeNumber(int higoVideoID);
	//获取推荐视频
	public List<HigoVideoBean> getHigoVideoRecommendation();
}
