package com.sunonline.web.dao.higo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.bean.pager.HigoPagerBean;
import com.sunonline.web.utils.DBUtils;

/**
 * Higo大学季视频Dao实现类
 * @author SnoWalker.wwl
 * <p>2016.5.31</p>
 */
public class HigoVideoDaoImpl implements HigoVideoDao {
	
	/*
	 * 获取视频总条数
	 * @see com.sunonline.web.dao.higo.HigoVideoDao#fetchVideoRowsCount()
	 */
	@Override
	public int fetchVideoRowsCount() {
		return this.fetchAllVideos().size();
	}
	
	/*
	 * 获取所有视频
	 * @see com.sunonline.web.dao.higo.HigoVideoDao#fetchAllVideos()
	 */
	@Override
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
	
	/*
	 * 获取某一页所有视频
	 * @see com.sunonline.web.dao.higo.HigoVideoDao#fetchAllVideos(int)
	 */
	@Override
	public List<HigoVideoBean> fetchAllVideos(int current_pageNo) {
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
	
	/*
	 * 根据id获取某一个视频的信息
	 * @see com.sunonline.web.dao.higo.HigoVideoDao#getHigoVideoByID()
	 */
	@Override
	public HigoVideoBean getHigoVideoByID(int higoVideoID) {
		HigoVideoBean higoVideoBean = null;
		String sql = "select * from higo_video_view where HIGO_video_id=?"; //通过id获取视频全部信息
		try {
			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, higoVideoID);
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
	
	/*
	 * 增加播放次数
	 */
	@Override
	public void addPlayTimeNumber(int higoVideoID) {
		String sql = "UPDATE higo_video "
				+ "SET HIGO_video_played_number=HIGO_video_played_number+1 "
				+ "WHERE HIGO_video_id = ?;"; //通过id获取视频全部信息
		try {
			Connection connection = new DBUtils().getCon();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, higoVideoID);
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
	/*
	 * 获取推荐视频
	 */
	@Override
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
	
}
