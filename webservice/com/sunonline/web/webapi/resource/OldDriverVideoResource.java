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

import com.sunonline.web.bean.CollegeVoiceVideoBean;
import com.sunonline.web.bean.pager.CollegeVoicePagerBean;
import com.sunonline.web.bean.pager.OldDriverPagerBean;
import com.sunonline.web.utils.DBUtils;
import com.sunonline.web.webapi.bean.videos.OldDriverVideoBean;

/**
 * 影视老司机资源
 * @author SnoWalker.wwl
 * 2016.6.7
 */
@Path(value = "")
public class OldDriverVideoResource  {
	
	/*
	 * 获取所有视频
	 * @see com.sunonline.web.dao.higo.HigoVideoDao#fetchAllVideos()
	 */
	@GET
	@Path("videos/olddriver/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OldDriverVideoBean> fetchAllVideos() {
		List<OldDriverVideoBean> oldDriverVideoBeans = new ArrayList<>();
		//获取数据库中数据
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图
		String sql = "select * from old_driver_video_view order by LSJ_video_id desc";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {	
				int    oldDirverVideoId = rs.getInt("LSJ_video_id");						//id
				String oldDirverVideoName = rs.getString("LSJ_video_name");					//视频名称
				String oldDirverVideoUrl = rs.getString("LSJ_video_url");					//视频播放url
				Date   oldDirverVideoUploadDate = rs.getDate("LSJ_video_date");				//上传日期
				String oldDirverVideoPicUrl = rs.getString("LSJ_video_pic_url");			//视频截图url
				Integer   oldDirverVideoPlayedTime = rs.getInt("LSJ_video_played_number");	//视频播放次数
				String oldDirverVideoIntro = rs.getString("LSJ_video_intro");		    	//视频简介
				String oldDirverVideoUploader = rs.getString("LSJ_video_uploader");			//视频上传者
				// 构造注入
				OldDriverVideoBean oldDriverVideoBean = 
						new OldDriverVideoBean(oldDirverVideoId,
											oldDirverVideoName, 
											oldDirverVideoUrl, 
											oldDirverVideoUploadDate, 
											oldDirverVideoPicUrl, 
											oldDirverVideoPlayedTime, 
											oldDirverVideoIntro, 
											oldDirverVideoUploader);
				
				oldDriverVideoBeans.add(oldDriverVideoBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return oldDriverVideoBeans;
	}
	/**
	 * 按照期数获取视频
	 * @param higoVideoID
	 * @return HigoVideoBean
	 */
	@GET
	@Path("videos/olddriver/all/{oldDriverVideoID}")
	@Produces(MediaType.APPLICATION_JSON)
	public OldDriverVideoBean getOldDriverVideoByID(@PathParam(value="oldDriverVideoID") int oldDriverVideoID) {
		OldDriverVideoBean oldDriverVideoBean = null;
		String sql = "select * from old_driver_video_view where LSJ_video_id=?"; //通过id获取视频全部信息
		try {
			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, oldDriverVideoID);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int     oldDirverVideoId = rs.getInt("LSJ_video_id");						//id
				String  oldDirverVideoName = rs.getString("LSJ_video_name");					//视频名称
				String  oldDirverVideoUrl = rs.getString("LSJ_video_url");					//视频播放url
				Date    oldDirverVideoUploadDate = rs.getDate("LSJ_video_date");				//上传日期
				String 	oldDirverVideoPicUrl = rs.getString("LSJ_video_pic_url");			//视频截图url
				Integer oldDirverVideoPlayedTime = rs.getInt("LSJ_video_played_number");	//视频播放次数
				String  oldDirverVideoIntro = rs.getString("LSJ_video_intro");		    	//视频简介
				String  oldDirverVideoUploader = rs.getString("LSJ_video_uploader");			//视频上传者
				
				// 构造注入
				oldDriverVideoBean = 
						new OldDriverVideoBean(oldDirverVideoId,
											oldDirverVideoName, 
											oldDirverVideoUrl, 
											oldDirverVideoUploadDate, 
											oldDirverVideoPicUrl, 
											oldDirverVideoPlayedTime, 
											oldDirverVideoIntro, 
											oldDirverVideoUploader);
			}
		} catch (Exception e) {
			oldDriverVideoBean = null;
		}
		return oldDriverVideoBean;
	}
	
	/**
	 *影视老司机推荐视频
	 * @return List<OldDriverVideoBean>
	 */
	@GET
	@Path("videos/olddriver/all/recommendation")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OldDriverVideoBean> getOldDriverVideoRecommendation() {
		List<OldDriverVideoBean> oldDirverVideoBeans = new ArrayList<>();
		//获取数据库中数据
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图
		String sql = "SELECT * FROM old_driver_video_view "
				+ "WHERE LSJ_video_id > "
				+ "(SELECT count(*) num FROM old_driver_video_view) - 4 order by LSJ_video_id desc";
		PreparedStatement pstmt;
		try {
			connection = new DBUtils().getCon();
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int     oldDirverVideoId = rs.getInt("LSJ_video_id");						//id
				String  oldDirverVideoName = rs.getString("LSJ_video_name");					//视频名称
				String  oldDirverVideoUrl = rs.getString("LSJ_video_url");					//视频播放url
				Date    oldDirverVideoUploadDate = rs.getDate("LSJ_video_date");				//上传日期
				String 	oldDirverVideoPicUrl = rs.getString("LSJ_video_pic_url");			//视频截图url
				Integer oldDirverVideoPlayedTime = rs.getInt("LSJ_video_played_number");	//视频播放次数
				String  oldDirverVideoIntro = rs.getString("LSJ_video_intro");		    	//视频简介
				String  oldDirverVideoUploader = rs.getString("LSJ_video_uploader");			//视频上传者
				
				// 构造注入
				OldDriverVideoBean oldDriverVideoBean = 
						new OldDriverVideoBean(oldDirverVideoId,
											oldDirverVideoName, 
											oldDirverVideoUrl, 
											oldDirverVideoUploadDate, 
											oldDirverVideoPicUrl, 
											oldDirverVideoPlayedTime, 
											oldDirverVideoIntro, 
											oldDirverVideoUploader);
				oldDirverVideoBeans.add(oldDriverVideoBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return oldDirverVideoBeans;

	}
	
	/*
	 * 分页获取
	 */
	@GET
	@Path("videos/olddriver/pager")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OldDriverVideoBean> fetchAllVideos(@QueryParam("pageno") Integer current_pageNo) {
		//每页包含视频信息列表
		List<OldDriverVideoBean> oldDriverVideoList = null;

		String sql = "select * from old_driver_video_view order by LSJ_video_id desc limit ?,?";				 // 分页sql
		try {
			int startIndex = (current_pageNo - 1) * OldDriverPagerBean.PAGE_SIZE; // 起始下标
			int per_rows = OldDriverPagerBean.PAGE_SIZE; 						 // 每页数目

			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, startIndex);
			pstmt.setInt(2, per_rows);
			ResultSet rs = pstmt.executeQuery();

			oldDriverVideoList = new ArrayList<>();
			while (rs.next()) {
				int     oldDirverVideoId = rs.getInt("LSJ_video_id");						//id
				String  oldDirverVideoName = rs.getString("LSJ_video_name");					//视频名称
				String  oldDirverVideoUrl = rs.getString("LSJ_video_url");					//视频播放url
				Date    oldDirverVideoUploadDate = rs.getDate("LSJ_video_date");				//上传日期
				String 	oldDirverVideoPicUrl = rs.getString("LSJ_video_pic_url");			//视频截图url
				Integer oldDirverVideoPlayedTime = rs.getInt("LSJ_video_played_number");	//视频播放次数
				String  oldDirverVideoIntro = rs.getString("LSJ_video_intro");		    	//视频简介
				String  oldDirverVideoUploader = rs.getString("LSJ_video_uploader");			//视频上传者

				// 构造注入
				OldDriverVideoBean oldDriverVideoBean = 
						new OldDriverVideoBean(oldDirverVideoId,
								oldDirverVideoName, 
								oldDirverVideoUrl, 
								oldDirverVideoUploadDate, 
								oldDirverVideoPicUrl, 
								oldDirverVideoPlayedTime, 
								oldDirverVideoIntro, 
								oldDirverVideoUploader);

				oldDriverVideoList.add(oldDriverVideoBean);	
			}
		} catch (Exception e) {
			oldDriverVideoList = null;
		}
		return oldDriverVideoList;
	}

}
