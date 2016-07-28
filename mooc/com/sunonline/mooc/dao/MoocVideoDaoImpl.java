package com.sunonline.mooc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sunonline.mooc.bean.pager.CoursesPagerBean;
import com.sunonline.mooc.model.CourseListItemBean;
import com.sunonline.mooc.model.CoursesBean;
import com.sunonline.mooc.model.TypeBean;
import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.bean.OldDriverVideoBean;
import com.sunonline.web.bean.pager.HigoPagerBean;
import com.sunonline.web.utils.DBUtils;

/**
 * 公益课堂dao层实现
 * @author snowalker
 * 16.7.6
 */
public class MoocVideoDaoImpl implements MoocVideoDao {
	
	//全局静态连接
	private static Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;

	//单例形式连接
	private static Connection getConnectionInstance() {
		if (connection == null) {
			return new DBUtils().getCon();
		}
		return connection;
	}
	
	//获取某一课程类目下的某一个具体视频信息
	public CourseListItemBean getMoocVideoItemByID(int c_id, int itemID) {

		CourseListItemBean courseListItemBean = null;
		String sql = "select * from smooc_courselist_view where c_id=? and cl_id=?;"; //通过id获取视频全部信息
		try {
			connection = getConnectionInstance();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, c_id);
			pstmt.setInt(2, itemID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Integer cl_id 			= rs.getInt("cl_id");				//课程条目id
				String  cl_name 		= rs.getString("cl_name");			//课程条目名称
				String  cl_pic_url 		= rs.getString("cl_pic_url");		//课程条目截图url
				String  cl_video_url 	= rs.getString("cl_video_url");		//课程条目视频url
				Integer cl_play_time	= rs.getInt("cl_play_time");		//课程播放次数
				String  cl_video_intro  = rs.getString("cl_video_intro");	//单节视频介绍
				Date    cl_upload_time  = rs.getDate("cl_upload_time");		//视频上传时间

				// 构造注入
				courseListItemBean = new CourseListItemBean(cl_id, 
						cl_name,
						cl_pic_url, 
						cl_video_url, 
						cl_play_time, 
						cl_video_intro, 
						cl_upload_time, 
						c_id);
			}
		} catch (Exception e) {
			courseListItemBean = null;
		}
		return courseListItemBean;
	}
	
	//通过视频id获取单个视频信息
	public CourseListItemBean getMoocVideoItemByID(int itemID) {
		
		CourseListItemBean courseListItemBean = null;
		String sql = "select * from smooc_courselist_view where cl_id=?"; //通过id获取视频全部信息
		try {
			connection = getConnectionInstance();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, itemID);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Integer cl_id 			= rs.getInt("cl_id");				//课程条目id
				String  cl_name 		= rs.getString("cl_name");			//课程条目名称
				String  cl_pic_url 		= rs.getString("cl_pic_url");		//课程条目截图url
				String  cl_video_url 	= rs.getString("cl_video_url");		//课程条目视频url
				Integer cl_play_time	= rs.getInt("cl_play_time");		//课程播放次数
				String  cl_video_intro  = rs.getString("cl_video_intro");	//单节视频介绍
				Date    cl_upload_time  = rs.getDate("cl_upload_time");		//视频上传时间
				Integer c_id			= rs.getInt("c_id");				//课程id
				
				// 构造注入
				courseListItemBean = new CourseListItemBean(cl_id, 
															cl_name,
															cl_pic_url, 
															cl_video_url, 
															cl_play_time, 
															cl_video_intro, 
															cl_upload_time, 
															c_id);
			}
		} catch (Exception e) {
			courseListItemBean = null;
		}
		return courseListItemBean;
	}
	
	//添加播放次数
	public void addPlayTimeNumber(int itemID) {
		String sql = "UPDATE smooc_courselist "
				+ "SET cl_play_time=cl_play_time+1 "
				+ "WHERE cl_id = ?;"; //通过id获取视频全部信息
		try {
			connection = getConnectionInstance();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, itemID);
			int returnNum = pstmt.executeUpdate();
			
			if (returnNum > 0) {
				System.out.println("设置成功");
			} else {
				System.out.println("设置失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取视频总条数
	public int fetchVideoRowsCount(Integer c_id) {
		return this.fetchAllVideos(c_id).size();
	}
	
	//获取所有视频列表
	public List<CourseListItemBean> fetchAllVideos(Integer c_id) {
		
		List<CourseListItemBean> courseListItemBeans = new ArrayList<>();
		//获取数据库中数据
		connection = getConnectionInstance();
		//构造SQL查询视图返回某一个课程号下的所有视频
		String sql = "select * from smooc_courselist where c_id=? order by cl_id desc";
		try {
			pstmt = connection.prepareStatement(sql);
			//注意注入参数的顺序
			pstmt.setInt(1, c_id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {	
				Integer cl_id 			= rs.getInt("cl_id");				//课程条目id
				String  cl_name 		= rs.getString("cl_name");			//课程条目名称
				String  cl_pic_url 		= rs.getString("cl_pic_url");		//课程条目截图url
				String  cl_video_url 	= rs.getString("cl_video_url");		//课程条目视频url
				Integer cl_play_time	= rs.getInt("cl_play_time");		//课程播放次数
				String  cl_video_intro  = rs.getString("cl_video_intro");	//单节视频介绍
				Date    cl_upload_time  = rs.getDate("cl_upload_time");		//视频上传时间
				Integer c_id2			= rs.getInt("c_id");				//课程id
				// 构造注入
				CourseListItemBean courseListItemBean = 
										new CourseListItemBean(cl_id, 
																cl_name,
																cl_pic_url, 
																cl_video_url, 
																cl_play_time, 
																cl_video_intro, 
																cl_upload_time, 
																c_id2);
				courseListItemBeans.add(courseListItemBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return courseListItemBeans;
	}
	
	//获取指定类目下的视频总数,分页获取
	@Override
	public List<CourseListItemBean> fetchAllVideos(int current_pageno, Integer c_id) {
		//每页包含视频信息列表
		List<CourseListItemBean> courseListItemBeans = null;

		String sql = "select * from smooc_courselist_view where c_id=? order by cl_id desc limit ?,?;";				 // 分页sql
		try {
			//其实下标 每行数量
			int startIndex = (current_pageno - 1) * CoursesPagerBean.PAGE_SIZE; // 起始下标
			int per_rows = CoursesPagerBean.PAGE_SIZE; 						 // 每页数目

			connection = getConnectionInstance();
			pstmt = connection.prepareStatement(sql);
			//查询参数注入sql语句
			pstmt.setInt(1, c_id);
			pstmt.setInt(2, startIndex);
			pstmt.setInt(3, per_rows);
			rs = pstmt.executeQuery();

			courseListItemBeans = new ArrayList<>();
			while (rs.next()) {
				Integer cl_id 			= rs.getInt("cl_id");				//课程条目id
				String  cl_name 		= rs.getString("cl_name");			//课程条目名称
				String  cl_pic_url 		= rs.getString("cl_pic_url");		//课程条目截图url
				String  cl_video_url 	= rs.getString("cl_video_url");		//课程条目视频url
				Integer cl_play_time	= rs.getInt("cl_play_time");		//课程播放次数
				String  cl_video_intro  = rs.getString("cl_video_intro");	//单节视频介绍
				Date    cl_upload_time  = rs.getDate("cl_upload_time");		//视频上传时间
				Integer c_id2			= rs.getInt("c_id");				//课程id
				
				// 构造注入
				CourseListItemBean courseListItemBean = 
										new CourseListItemBean(cl_id, 
																cl_name,
																cl_pic_url, 
																cl_video_url, 
																cl_play_time, 
																cl_video_intro, 
																cl_upload_time, 
																c_id2);
				courseListItemBeans.add(courseListItemBean);
			}
		} catch (Exception e) {
			courseListItemBeans = null;
		}
		return courseListItemBeans;
	}
	
	//获取所有课程的类型表列
	public List<TypeBean> fetchCoursesTypeList() {
		
		List<TypeBean> typeBeans = null;
		//获取数据库中数据
		connection = getConnectionInstance();
		//构造SQL查询视图返回某一个课程号下的所有视频
		String sql = "select * from smooc_type_view";
		try {
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			typeBeans = new ArrayList<>();
			while (rs.next()) {	
				Integer t_id   = rs.getInt("t_id");				//课程类型id
				String  t_name = rs.getString("t_name");		//课程类型名称
				// 构造注入
				TypeBean typeBean = new TypeBean(t_id, t_name);
				typeBeans.add(typeBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return typeBeans;
	}
	
	//通过类型id获取对应的课程列表
	public List<CoursesBean> getCoursesListByTypeID(Integer t_id) {
		
		List<CoursesBean> coursesBeans = null;
		//获取数据库中数据
		connection = getConnectionInstance();
		//构造SQL查询视图返回某一个课程号下的所有视频
		String sql = "SELECT * from smooc_courses_view where t_id = ?;";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, t_id);
			rs = pstmt.executeQuery();
			coursesBeans = new ArrayList<>();
			while (rs.next()) {	
				Integer c_id		    = rs.getInt("c_id");	            //课程id
				String  c_name		    = rs.getString("c_name");	        //课程 名称
				String  c_introduce	    = rs.getString("c_introduce");	    //课程介绍
				String  c_pic_url	    = rs.getString("c_pic_url");	    //视频截图url
				String  c_teacher_name  = rs.getString("c_teacher_name");	//讲师姓名
				String  c_teacher_intro	= rs.getString("c_teacher_intro");	//讲师介绍
				Integer t_idtemp		= rs.getInt("t_id"); 	        //视频所属类型id
				CoursesBean coursesBean = new CoursesBean(c_id, c_name, c_introduce, c_pic_url, c_teacher_name, c_teacher_intro, t_idtemp);
				coursesBeans.add(coursesBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return coursesBeans;
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println(new MoocVideoDaoImpl().fetchAllVideos(1, 3).size());
		System.out.println(new MoocVideoDaoImpl().fetchCoursesTypeList().size());
		System.out.println("获取类型下的视频个数" + new MoocVideoDaoImpl().getCoursesListByTypeID(3));
		System.out.println(new MoocVideoDaoImpl().getAllCoursesInfo().size());
	}

	//通过课程ID获取讲师信息
	@Override
	public CoursesBean getCourseInfoByID(Integer c_id) {

		CoursesBean coursesBean = null;
		//获取数据库中数据
		connection = getConnectionInstance();
		//构造SQL查询视图返回某一个课程号下的所有视频
		String sql = "SELECT * from smooc_courses_view where c_id = ?;";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, c_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {	
				Integer c_idtemp		= rs.getInt("c_id");	            //课程id
				String  c_name		    = rs.getString("c_name");	        //课程 名称
				String  c_introduce	    = rs.getString("c_introduce");	    //课程介绍
				String  c_pic_url	    = rs.getString("c_pic_url");	    //视频截图url
				String  c_teacher_name  = rs.getString("c_teacher_name");	//讲师姓名
				String  c_teacher_intro	= rs.getString("c_teacher_intro");	//讲师介绍
				Integer t_id		    = rs.getInt("t_id"); 	        //视频所属类型id
				coursesBean = new CoursesBean(c_idtemp, c_name, c_introduce, c_pic_url, c_teacher_name, c_teacher_intro, t_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return coursesBean;
	}

	@Override
	public List<CoursesBean> getAllCoursesInfo() {
		List<CoursesBean> coursesBeans = new ArrayList<>();
		CoursesBean coursesBean = null;
		//获取数据库中数据
		connection = getConnectionInstance();
		//构造SQL查询视图返回某一个课程号下的所有视频
		String sql = "SELECT * from smooc_courses_view;";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {	
				Integer c_idtemp		= rs.getInt("c_id");	            //课程id
				String  c_name		    = rs.getString("c_name");	        //课程 名称
				String  c_introduce	    = rs.getString("c_introduce");	    //课程介绍
				String  c_pic_url	    = rs.getString("c_pic_url");	    //视频截图url
				String  c_teacher_name  = rs.getString("c_teacher_name");	//讲师姓名
				String  c_teacher_intro	= rs.getString("c_teacher_intro");	//讲师介绍
				Integer t_id		    = rs.getInt("t_id"); 	        //视频所属类型id
				coursesBean = new CoursesBean(c_idtemp, c_name, c_introduce, c_pic_url, c_teacher_name, c_teacher_intro, t_id);
				coursesBeans.add(coursesBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return coursesBeans;
	}
	
	//获取某一个课程分类下的某一节课程
	
}
