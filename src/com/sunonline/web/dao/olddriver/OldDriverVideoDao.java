package com.sunonline.web.dao.olddriver;

import java.util.List;

import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.bean.OldDriverVideoBean;

/**
 * 影视老司机大学季视频Dao
 * @author SnoWalker.wwl
 * <p>2016.6.1</p>
 */
public interface OldDriverVideoDao {
	
		//获取视频总条数
		public int fetchVideoRowsCount();
		//获取所有视频
		public List<OldDriverVideoBean> fetchAllVideos();
		//获取某一页所有视频
		public List<OldDriverVideoBean> fetchAllVideos(int current_pageNo);
		//根据id获取某一个视频的信息
		public OldDriverVideoBean getOldDriverVideoByID(int oldDirverVideoID);
		//增加播放次数
		public void addPlayTimeNumber(int oldDirverVideoID);
		//获取推荐视频
		public List<OldDriverVideoBean> getOldDriverVideoRecommendation();
}
