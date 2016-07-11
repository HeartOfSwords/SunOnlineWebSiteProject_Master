package com.sunonline.web.webapi.resource;

import java.util.List;

import com.sunonline.mooc.model.CourseListItemBean;
import com.sunonline.web.webapi.bean.mooc.IndexRoot;

/**
 * 公益课堂接口定义
 * @author snowalker
 *
 */
public interface IMoocResource {
	
	/*获取所有分类及其视频总列表*/
	public IndexRoot fetchAllVideos();
	/*通过c_id即课程id获取对应id下的课程列表 */
	public List<CourseListItemBean> fetchCourseListVideos(int current_pageno, Integer c_id);
	/*通过每一节课的单独id获取每一个courseItem*/
	public CourseListItemBean getMoocVideoItemByID(int c_id, int itemID);
	/*获取每一个门类的最后课程*/
	public List<CourseListItemBean> fetchCoursesRecommendation();

}
