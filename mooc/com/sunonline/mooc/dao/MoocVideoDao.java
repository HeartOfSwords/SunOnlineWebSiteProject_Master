package com.sunonline.mooc.dao;

import java.sql.SQLException;
import java.util.List;
import com.sunonline.mooc.model.CourseListItemBean;
import com.sunonline.mooc.model.CoursesBean;
import com.sunonline.mooc.model.TypeBean;

/**
 * 公益课堂dao层接口
 * @author snowalker
 * 16.7.6
 */
public interface MoocVideoDao {
	
	//获取某一课程类目下的某一个具体视频信息
	public CourseListItemBean getMoocVideoItemByID(int c_id, int itemID);
	//通过视频id获取单个视频信息
	public CourseListItemBean getMoocVideoItemByID(int itemID);
	//添加播放次数
	public void addPlayTimeNumber(int itemID);
	//获取视频总条数
	public int fetchVideoRowsCount(Integer c_id);
	//获取某一具体id所有视频
	public List<CourseListItemBean> fetchAllVideos(Integer c_id);
	//获取某一视频组下某一分页的所有视频
	public List<CourseListItemBean> fetchAllVideos(int current_pageno, Integer c_id);
	//获取所有课程的类型表列
	public List<TypeBean> fetchCoursesTypeList(); 
	//通过类型id获取对应的课程列表
	public List<CoursesBean> getCoursesListByTypeID(Integer t_id);
	//获取讲师信息以及课程信息
	public CoursesBean getCourseInfoByID(Integer c_id);
	//获取所有的课程信息，二级主课程列表
	public List<CoursesBean> getAllCoursesInfo();

}
