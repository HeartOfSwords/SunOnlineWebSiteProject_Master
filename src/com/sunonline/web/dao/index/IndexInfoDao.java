package com.sunonline.web.dao.index;

import java.util.List;

import com.sunonline.web.bean.CollegeVoiceVideoBean;
import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.bean.OldDriverVideoBean;

/**
 * 网站首页视频Dao
 * @author SnoWalker.wwl
 * <p>2016.6.20</p>
 */
public interface IndexInfoDao {
	
	//获取Higo视频列表
	public List<HigoVideoBean> fetchHigoList(int videoCount);
	//获取高校最强音列表
	public List<CollegeVoiceVideoBean> fetchCollegeVoiceList(int videoCount);
	//获取老司机列表
	public List<OldDriverVideoBean> fetchOldDriverList(int videoCount);
}
