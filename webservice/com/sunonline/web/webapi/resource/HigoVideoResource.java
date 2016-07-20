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

import com.sunonline.web.bean.pager.HigoPagerBean;
import com.sunonline.web.dao.higo.HigoVideoDao;
import com.sunonline.web.dao.higo.HigoVideoDaoImpl;
import com.sunonline.web.utils.DBUtils;
import com.sunonline.web.webapi.bean.videos.HigoVideoBean;

/**
 * Higo大学季资源
 * @author SnoWalker.wwl
 * 2016.6.2
 */
@Path(value = "")
public class HigoVideoResource {
	
	/*
	 * 获取所有视频
	 * @see com.sunonline.web.dao.higo.HigoVideoDao#fetchAllVideos()
	 */
	@GET
	@Path("videos/higovideo/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HigoVideoBean> fetchAllVideos() {
		List<HigoVideoBean> higoVideoBeans = new ArrayList<>();
		//获取数据库中数据
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图
		String sql = "select * from higo_video_view order by HIGO_video_id desc";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {	
				int higoId = rs.getInt("HIGO_video_id");						//id
				String higoName = rs.getString("HIGO_video_name");				//视频名称
				String higoUrl = rs.getString("HIGO_video_url");				//视频播放url
				Date higoUploadDate = rs.getDate("HIGO_video_date");			//上传日期
				String higoPicUrl = rs.getString("HIGO_video_pic_url");			//视频截图url
				int higoPlayedTime = rs.getInt("HIGO_video_played_number");		//视频播放次数
				String higoVideoIntro = rs.getString("HIGO_video_intro");		//视频简介
				String higoVideoUploader = rs.getString("HIGO_video_uploader");	//视频上传者
				// 构造注入
				HigoVideoBean higoVideoBean = new HigoVideoBean(higoId, 
																higoName,
																higoUrl, 
																higoUploadDate, 
																higoPicUrl, 
																higoPlayedTime, 
																higoVideoIntro, 
																higoVideoUploader);
				higoVideoBeans.add(higoVideoBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return higoVideoBeans;
	}
	/**
	 * Higo大学季按照期数获取视频
	 * @param higoVideoID
	 * @return HigoVideoBean
	 */
	@GET
	@Path("videos/higovideo/all/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public HigoVideoBean getHigoVideoByID(@PathParam(value="id") int id) {
		HigoVideoBean higoVideoBean = null;
		String sql = "select * from higo_video_view where HIGO_video_id=?"; //通过id获取视频全部信息
		try {
			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int higoId = rs.getInt("HIGO_video_id");						//id
				String higoName = rs.getString("HIGO_video_name");				//视频名称
				String higoUrl = rs.getString("HIGO_video_url");				//视频播放url
				Date higoUploadDate = rs.getDate("HIGO_video_date");			//上传日期
				String higoPicUrl = rs.getString("HIGO_video_pic_url");			//视频截图url
				int higoPlayedTime = rs.getInt("HIGO_video_played_number");		//视频播放次数
				String higoVideoIntro = rs.getString("HIGO_video_intro");		//视频简介
				String higoVideoUploader = rs.getString("HIGO_video_uploader");	//视频上传者
				
				// 构造注入
			    higoVideoBean = new HigoVideoBean(higoId, 
												  higoName,
												  higoUrl, 
												  higoUploadDate, 
												  higoPicUrl, 
												  higoPlayedTime, 
												  higoVideoIntro, 
												  higoVideoUploader);
			}
		} catch (Exception e) {
			higoVideoBean = null;
		}
		return higoVideoBean;
	}
	
	/**
	 * Higo大学季推荐视频
	 * @param higoVideoID
	 * @return HigoVideoBean
	 */
	@GET
	@Path("videos/higovideo/all/recommendation")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HigoVideoBean> getHigoVideoRecommendation() {
		List<HigoVideoBean> higoVideoBeans = new ArrayList<>();
		//获取数据库中数据
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图
		String sql = "SELECT * FROM higo_video "
				+ "WHERE HIGO_video_id > "
				+ "(SELECT count(*) num FROM higo_video) - 4 order by HIGO_video_id desc";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {	
				int higoId = rs.getInt("HIGO_video_id");						//id
				String higoName = rs.getString("HIGO_video_name");				//视频名称
				String higoUrl = rs.getString("HIGO_video_url");				//视频播放url
				Date higoUploadDate = rs.getDate("HIGO_video_date");			//上传日期
				String higoPicUrl = rs.getString("HIGO_video_pic_url");			//视频截图url
				int higoPlayedTime = rs.getInt("HIGO_video_played_number");		//视频播放次数
				String higoVideoIntro = rs.getString("HIGO_video_intro");		//视频简介
				String higoVideoUploader = rs.getString("HIGO_video_uploader");	//视频上传者
				// 构造注入
				HigoVideoBean higoVideoBean = new HigoVideoBean(higoId, 
																higoName,
																higoUrl, 
																higoUploadDate, 
																higoPicUrl, 
																higoPlayedTime, 
																higoVideoIntro, 
																higoVideoUploader);
				higoVideoBeans.add(higoVideoBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return higoVideoBeans;

	}
	
	/*
	 * higo分页获取
	 */
	@GET
	@Path("videos/higovideo/pager")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HigoVideoBean> fetchAllVideos(@QueryParam("pageno") Integer current_pageNo) {
		//每页包含视频信息列表
		List<HigoVideoBean> higoVideolist = null;

		String sql = "select * from higo_video_view  order by HIGO_video_id desc limit ?,?";				 // 分页sql
		try {
			int startIndex = (current_pageNo - 1) * HigoPagerBean.PAGE_SIZE; // 起始下标
			int per_rows = HigoPagerBean.PAGE_SIZE; 						 // 每页数目

			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, startIndex);
			pstmt.setInt(2, per_rows);
			ResultSet rs = pstmt.executeQuery();

			higoVideolist = new ArrayList<>();
			while (rs.next()) {
				int higoId = rs.getInt("HIGO_video_id");						//id
				String higoName = rs.getString("HIGO_video_name");				//视频名称
				String higoUrl = rs.getString("HIGO_video_url");				//视频播放url
				Date higoUploadDate = rs.getDate("HIGO_video_date");			//上传日期
				String higoPicUrl = rs.getString("HIGO_video_pic_url");			//视频截图url
				int higoPlayedTime = rs.getInt("HIGO_video_played_number");		//视频播放次数
				String higoVideoIntro = rs.getString("HIGO_video_intro");		//视频简介
				String higoVideoUploader = rs.getString("HIGO_video_uploader");	//视频上传者

				// 构造注入
				HigoVideoBean higoVideoBean = new HigoVideoBean(higoId, 
						higoName,
						higoUrl, 
						higoUploadDate, 
						higoPicUrl, 
						higoPlayedTime, 
						higoVideoIntro, 
						higoVideoUploader);
				higoVideolist.add(higoVideoBean);	
			}
		} catch (Exception e) {
			higoVideolist = null;
		}
		return higoVideolist;
	}

}
