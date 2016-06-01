package com.sunonline.web.dao.olddirver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.bean.OldDriverVideoBean;
import com.sunonline.web.bean.pager.HigoPagerBean;
import com.sunonline.web.bean.pager.OldDriverPagerBean;
import com.sunonline.web.utils.DBUtils;
/**
 * 影视老司机视频Dao实现类
 * @author SnoWalker.wwl
 * <p>2016.6.1</p>
 */
public class OldDriverVideoDaoImpl implements OldDriverVideoDao {

	/*
	 * 获取视频总条数
	 * @see com.sunonline.web.dao.olddirver.OldDirverVideoDao#fetchVideoRowsCount()
	 */
	@Override
	public int fetchVideoRowsCount() {
		return this.fetchAllVideos().size();
	}

	/*
	 * 获取所有视频
	 * @see com.sunonline.web.dao.olddirver.OldDirverVideoDao#fetchAllVideos()
	 */
	@Override
	public List<OldDriverVideoBean> fetchAllVideos() {
		
		List<OldDriverVideoBean> oldDriverVideoBeans = new ArrayList<>();
		//获取数据库中数据
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图
		String sql = "select * from old_dirver_video_view";
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
	
	/*
	 * 获取某一页所有视频
	 * @see com.sunonline.web.dao.olddirver.OldDirverVideoDao#fetchAllVideos(int)
	 */
	@Override
	public List<OldDriverVideoBean> fetchAllVideos(int current_pageNo) {
		//每页包含视频信息列表
		List<OldDriverVideoBean> oldDriverVideoList = null;
		
		String sql = "select * from old_dirver_video_view limit ?,?";				 // 分页sql
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
	
	/*
	 * 根据id获取某一个视频的信息
	 * @see com.sunonline.web.dao.olddirver.OldDirverVideoDao#getOldDirverVideoByID(int)
	 */
	@Override
	public OldDriverVideoBean getOldDriverVideoByID(int oldDriverVideoID) {
		
		OldDriverVideoBean oldDriverVideoBean = null;
		String sql = "select * from old_dirver_video_view where LSJ_video_id=?"; //通过id获取视频全部信息
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


}
