package com.sunonline.web.dao.collegevoice;

import java.util.List;

import com.sunonline.web.bean.CollegeVoiceVideoBean;

/**
 * 高校最强音视频Dao
 * @author SnoWalker.wwl
 * <p>2016.5.31</p>
 */
public interface CollegeVoiceVideoDao {
	
	//通过id获取
	public CollegeVoiceVideoBean getVideoByID(int id);
	//获取所有视频
	@SuppressWarnings("unchecked")
	public List<CollegeVoiceVideoBean> fetchAllVideos();
	//获取视频数量
	public int fetchVideoRowsCount();
	//增加播放次数
	public void addPlayTimeNumber(int ZQY_video_id);
	//获取推荐视频
	public List<CollegeVoiceVideoBean> getCollegeVoiceVideoRecommendation();
	//分页获取
	public List<CollegeVoiceVideoBean> fetchAllVideos(int current_pageNo);
}
