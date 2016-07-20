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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sunonline.web.bean.pager.CollegeVoicePagerBean;
import com.sunonline.web.dao.collegevoice.CollegeVoiceVideoDao;
import com.sunonline.web.dao.collegevoice.CollegeVoiceVideoDaoImpl;
import com.sunonline.web.utils.DBUtils;
import com.sunonline.web.webapi.bean.videos.CollegeVoiceVideoBean;
import com.sunonline.web.webapi.bean.videos.HigoVideoBean;

/**
 * 高校最强音资源
 * @author SnoWalker.wwl
 * 2016.6.2
 */
@Path(value = "")
public class CollegeVoiceVideoResource  {
	
	/*
	 * 按照期数获取
	 */
	@GET
	@Path("videos/collegevoice/all/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CollegeVoiceVideoBean getVideoByID(@PathParam(value="id") int id) {
		CollegeVoiceVideoBean collegeVoiceVideoBean = null;
		String sql = "select * from college_voice_video_view where ZQY_video_id=?"; //通过id获取视频全部信息
		try {
			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int zqy_video_id = rs.getInt("ZQY_video_id");							//id
				String zqy_video_name = rs.getString("ZQY_video_name");					//视频名称
				String zqy_video_url = rs.getString("ZQY_video_url");					//视频播放url
				Date zqy_video_date = rs.getDate("ZQY_video_date");						//上传日期
				String zqy_video_pic_url = rs.getString("ZQY_video_pic_url");			//视频截图url
				int zqy_video_played_number = rs.getInt("zqy_video_played_number");		//视频播放次数
				String zqy_video_intro = rs.getString("zqy_video_intro");				//视频简介
				String zqy_video_uploader = rs.getString("zqy_video_uploader");			//视频上传者
				String zqy_player_name = rs.getString("player_name");				//选手姓名
				
				// 构造注入
				collegeVoiceVideoBean = new CollegeVoiceVideoBean(zqy_video_id, 
						zqy_video_name, 
						zqy_video_url, 
						zqy_video_date, 
						zqy_video_pic_url, 
						zqy_video_played_number, 
						zqy_video_intro, 
						zqy_video_uploader, 
						zqy_player_name);
				
			}
		} catch (Exception e) {
			collegeVoiceVideoBean = null;
		}
		return collegeVoiceVideoBean;
	}
	/*
	 * 获取所有视频
	 */
	@GET
	@Path("videos/collegevoice/all")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<CollegeVoiceVideoBean> fetchAllVideos() {
		
		List<CollegeVoiceVideoBean> collegeVoiceVideoBeans = new ArrayList<>();
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图
		String sql = "select * from college_voice_video_view order by ZQY_video_id desc";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {	
				int zqy_video_id = rs.getInt("ZQY_video_id");							//id
				String zqy_video_name = rs.getString("ZQY_video_name");					//视频名称
				String zqy_video_url = rs.getString("ZQY_video_url");					//视频播放url
				Date zqy_video_date = rs.getDate("ZQY_video_date");						//上传日期
				String zqy_video_pic_url = rs.getString("ZQY_video_pic_url");			//视频截图url
				int zqy_video_played_number = rs.getInt("zqy_video_played_number");		//视频播放次数
				String zqy_video_intro = rs.getString("zqy_video_intro");				//视频简介
				String zqy_video_uploader = rs.getString("zqy_video_uploader");			//视频上传者
				String zqy_player_name = rs.getString("player_name");				//选手姓名
				// 构造注入
			    CollegeVoiceVideoBean collegeVoiceVideoBean = new CollegeVoiceVideoBean(zqy_video_id, 
						zqy_video_name, 
						zqy_video_url, 
						zqy_video_date, 
						zqy_video_pic_url, 
						zqy_video_played_number, 
						zqy_video_intro, 
						zqy_video_uploader, 
						zqy_player_name);
			    
			    collegeVoiceVideoBeans.add(collegeVoiceVideoBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return collegeVoiceVideoBeans;
	}
	

	
	/*
	 * 获取推荐
	 */
	@GET
	@Path("videos/collegevoice/all/recommendation")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CollegeVoiceVideoBean> getCollegeVoiceVideoRecommendation() {
		List<CollegeVoiceVideoBean> collegeVoiceVideoBeans = new ArrayList<>();
		//获取数据库中数据
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图
		String sql = "SELECT * FROM college_voice_video_view " +
					"WHERE ZQY_video_id > (SELECT count(*) num FROM college_voice_video) - 4 ORDER BY ZQY_video_id DESC";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {		
				int zqy_video_id = rs.getInt("ZQY_video_id");							//id
				String zqy_video_name = rs.getString("ZQY_video_name");					//视频名称
				String zqy_video_url = rs.getString("ZQY_video_url");					//视频播放url
				Date zqy_video_date = rs.getDate("ZQY_video_date");						//上传日期
				String zqy_video_pic_url = rs.getString("ZQY_video_pic_url");			//视频截图url
				int zqy_video_played_number = rs.getInt("zqy_video_played_number");		//视频播放次数
				String zqy_video_intro = rs.getString("zqy_video_intro");				//视频简介
				String zqy_video_uploader = rs.getString("zqy_video_uploader");			//视频上传者
				String zqy_player_name = rs.getString("player_name");				//选手姓名
				
				// 构造注入
				CollegeVoiceVideoBean collegeVoiceVideoBean = new CollegeVoiceVideoBean(zqy_video_id, 
						zqy_video_name, 
						zqy_video_url, 
						zqy_video_date, 
						zqy_video_pic_url, 
						zqy_video_played_number, 
						zqy_video_intro, 
						zqy_video_uploader, 
						zqy_player_name);
				
				collegeVoiceVideoBeans.add(collegeVoiceVideoBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return collegeVoiceVideoBeans;

	}
	
	/*
	 * 分页获取视频
	 * 直接调用Dao层方法
	 */
	/*
	 * 获取所有视频
	 */
	@GET
	@Path("videos/collegevoice/pager")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<CollegeVoiceVideoBean> fetchAllVideos(@QueryParam("pageno") Integer current_pageNo) {
		
		//每页包含视频信息列表
		List<CollegeVoiceVideoBean> collegeVoiceVideoBeans = null;
		
		String sql = "select * from college_voice_video_view  order by ZQY_video_id desc limit ?,?";				 // 分页sql
		try {
			int startIndex = (current_pageNo - 1) * CollegeVoicePagerBean.PAGE_SIZE; // 起始下标
			int per_rows = CollegeVoicePagerBean.PAGE_SIZE; 						 // 每页数目

			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, startIndex);
			pstmt.setInt(2, per_rows);
			ResultSet rs = pstmt.executeQuery();

			collegeVoiceVideoBeans = new ArrayList<>();
			while (rs.next()) {
				int zqy_video_id = rs.getInt("ZQY_video_id");							//id
				String zqy_video_name = rs.getString("ZQY_video_name");					//视频名称
				String zqy_video_url = rs.getString("ZQY_video_url");					//视频播放url
				Date zqy_video_date = rs.getDate("ZQY_video_date");						//上传日期
				String zqy_video_pic_url = rs.getString("ZQY_video_pic_url");			//视频截图url
				int zqy_video_played_number = rs.getInt("zqy_video_played_number");		//视频播放次数
				String zqy_video_intro = rs.getString("zqy_video_intro");				//视频简介
				String zqy_video_uploader = rs.getString("zqy_video_uploader");			//视频上传者
				String zqy_player_name = rs.getString("player_name");				//选手姓名
				
				// 构造注入
				CollegeVoiceVideoBean collegeVoiceVideoBean = new CollegeVoiceVideoBean(zqy_video_id, 
						zqy_video_name, 
						zqy_video_url, 
						zqy_video_date, 
						zqy_video_pic_url, 
						zqy_video_played_number, 
						zqy_video_intro, 
						zqy_video_uploader, 
						zqy_player_name);
				

				
				collegeVoiceVideoBeans.add(collegeVoiceVideoBean);
			}
		} catch (Exception e) {
			collegeVoiceVideoBeans = null;
		}
		return collegeVoiceVideoBeans;
	}

}
