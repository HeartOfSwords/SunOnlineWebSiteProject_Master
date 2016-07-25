package com.sunonline.spider.gui.dao;

import java.util.List;
import com.sunonline.spider.gui.bean.EducationNews;

/**
 * 教育新闻数据访问层接口
 * @author snowalker
 * 16.7.25
 */

public interface EducationNewsDao {
	
	//按照id获取新闻实体
	public EducationNews getEduNewsById(int id);
	//获取全部新闻实体
	public List<EducationNews> getEduNewsList();
	//获取推荐新闻实体
	public List<EducationNews> getRecommendationNewsList();
}
