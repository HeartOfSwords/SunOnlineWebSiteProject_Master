package com.sunonline.web.webapi.resource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sunonline.mooc.model.CourseListItemBean;
import com.sunonline.web.utils.DBUtils;
import com.sunonline.web.webapi.bean.mooc.IndexRoot;
import com.sunonline.web.webapi.bean.mooc.MediasAfter;
import com.sunonline.web.webapi.bean.mooc.RadioInterview;
import com.sunonline.web.webapi.bean.mooc.SoftwareDeveloping;
import com.sunonline.web.webapi.bean.videos.HigoVideoBean;

/**
 * mooc资源
 * @author SnoWalker.wwl
 * 2016.7.7
 */
@Path(value = "")
public class MoocResource {
	
	//软件开发类型id
	private final static Integer SOFTWARE_DEVELOPING_ID = 3;
	//影视后期类型id
	private final static Integer MEDIA_AFTER_ID = 2;
	//播音主持类型id
	private final static Integer RADIO_INTERVIEW_ID = 1;
	
	/*
	 * 获取所有分类及其视频总列表
	 */
	@GET
	@Path("mooc/index")
	@Produces(MediaType.APPLICATION_JSON)
	public IndexRoot fetchAllVideos() {
		//首页根容器
		IndexRoot indexRoot = new IndexRoot();
		
		/*分别组装json*/
		
		//软件开发
		List<SoftwareDeveloping> softwareDevelopings = getSoftwareDevCoursesList();
		//影视后期
		List<MediasAfter> mediasAfters = getMediasAfterCoursesList();
		//播音主持
		List<RadioInterview> radioInterviews = getRadioInterviewCoursesList();
		
		//将所有的列表注入根容器
		indexRoot.setSoftwareDeveloping(softwareDevelopings);
		indexRoot.setMediasAfter(mediasAfters);
		indexRoot.setRadioInterview(radioInterviews);
		
		return indexRoot;
		
	}
	//软件开发组装数据回调
	public List<SoftwareDeveloping> getSoftwareDevCoursesList() {
		
		List<SoftwareDeveloping> softwareDevelopings = new ArrayList<>();
		//获取数据库中数据
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图返回某一个课程号下的所有视频
		String sql = "select * from smooc_courses_view where t_id=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			//注意注入参数的顺序
			pstmt.setInt(1, SOFTWARE_DEVELOPING_ID);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {	
				Integer c_id			= rs.getInt("c_id");				//课程条目id
				String c_name			= rs.getString("c_name");			//课程条目名称
				String c_introduce		= rs.getString("c_introduce");		//课程介绍
				String c_pic_url		= rs.getString("c_pic_url");		//课程截图
				String c_teacher_name	= rs.getString("c_teacher_name");	//讲师名
				String c_teacher_intro	= rs.getString("c_teacher_intro");	//讲师介绍
				Integer t_id			= rs.getInt("t_id");				//分类id
				String c_path_url		= "webapi/mooc/index/" + c_id;
				// 构造注入
				SoftwareDeveloping softwareDeveloping = 
											new SoftwareDeveloping(c_id, 
													c_name, 
													c_introduce, 
													c_pic_url, 
													c_teacher_name, 
													c_teacher_intro, 
													t_id,
													c_path_url);
				softwareDevelopings.add(softwareDeveloping);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return softwareDevelopings;
	}
	//影视后期组装数据回调
	public List<MediasAfter> getMediasAfterCoursesList() {

		List<MediasAfter> mediasAfters = new ArrayList<>();
		//获取数据库中数据
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图返回某一个课程号下的所有视频
		String sql = "select * from smooc_courses_view where t_id=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			//注意注入参数的顺序
			pstmt.setInt(1, MEDIA_AFTER_ID);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {	
				Integer c_id			= rs.getInt("c_id");				//课程条目id
				String c_name			= rs.getString("c_name");			//课程条目名称
				String c_introduce		= rs.getString("c_introduce");		//课程介绍
				String c_pic_url		= rs.getString("c_pic_url");		//课程截图
				String c_teacher_name	= rs.getString("c_teacher_name");	//讲师名
				String c_teacher_intro	= rs.getString("c_teacher_intro");	//讲师介绍
				Integer t_id			= rs.getInt("t_id");				//分类id
				String c_path_url		= "webapi/mooc/index/" + c_id;	//webapi相对路径
				// 构造注入
				MediasAfter mediasAfter = 
						new MediasAfter(c_id, 
								c_name, 
								c_introduce, 
								c_pic_url, 
								c_teacher_name, 
								c_teacher_intro, 
								t_id,
								c_path_url);
				mediasAfters.add(mediasAfter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mediasAfters;
	}
	//播音主持组装数据回调
	public List<RadioInterview> getRadioInterviewCoursesList() {

		List<RadioInterview> radioInterviews = new ArrayList<>();
		//获取数据库中数据
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图返回某一个课程号下的所有视频
		String sql = "select * from smooc_courses_view where t_id=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			//注意注入参数的顺序
			pstmt.setInt(1, RADIO_INTERVIEW_ID);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {	
				Integer c_id			= rs.getInt("c_id");				//课程条目id
				String c_name			= rs.getString("c_name");			//课程条目名称
				String c_introduce		= rs.getString("c_introduce");		//课程介绍
				String c_pic_url		= rs.getString("c_pic_url");		//课程截图
				String c_teacher_name	= rs.getString("c_teacher_name");	//讲师名
				String c_teacher_intro	= rs.getString("c_teacher_intro");	//讲师介绍
				Integer t_id			= rs.getInt("t_id");				//分类id
				String c_path_url		= "webapi/mooc/index/" + c_id;
				// 构造注入
				RadioInterview radioInterview = 
						new RadioInterview(c_id, 
								c_name, 
								c_introduce, 
								c_pic_url, 
								c_teacher_name, 
								c_teacher_intro, 
								t_id,
								c_path_url);
				radioInterviews.add(radioInterview);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return radioInterviews;
	}
	
	
}
