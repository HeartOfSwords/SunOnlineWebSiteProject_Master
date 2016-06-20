package com.sunonline.web.dao.index;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunonline.web.bean.CollegeVoiceVideoBean;
import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.bean.OldDriverVideoBean;
import com.sunonline.web.utils.DBUtils;

/**
 * 网站首页视频Dao实现类
 * @author SnoWalker.wwl
 * <p>2016.6.20</p>
 */
public class IndexInfoDaoImpl implements IndexInfoDao {

	//获取Higo视频列表
	@Override
	public List<HigoVideoBean> fetchHigoList(int videoCount) {
		List<HigoVideoBean> higoVideoBeans = new ArrayList<>();
		//获取数据库中数据
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图
		String sql = "SELECT * FROM higo_video "
				+ "WHERE HIGO_video_id > "
				+ "(SELECT count(*) num FROM higo_video) - ? order by HIGO_video_id desc";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, videoCount);
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
	
	//获取高校最强音列表
	@Override
	public List<CollegeVoiceVideoBean> fetchCollegeVoiceList(int videoCount) {
		List<CollegeVoiceVideoBean> collegeVoiceVideoBeans = new ArrayList<>();
		//获取数据库中数据
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图
		String sql = "SELECT * FROM college_voice_video_view " +
					"WHERE ZQY_video_id > (SELECT count(*) num FROM college_voice_video) - ? ORDER BY ZQY_video_id DESC";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, videoCount);
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
	
	//获取老司机列表
	@Override
	public List<OldDriverVideoBean> fetchOldDriverList(int videoCount) {
		List<OldDriverVideoBean> oldDirverVideoBeans = new ArrayList<>();
		//获取数据库中数据
		Connection connection = new DBUtils().getCon();
		//构造SQL查询视图
		String sql = "SELECT * FROM old_driver_video_view "
				+ "WHERE LSJ_video_id > "
				+ "(SELECT count(*) num FROM old_driver_video_view) - ? order by LSJ_video_id desc";
		PreparedStatement pstmt;
		try {
			connection = new DBUtils().getCon();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, videoCount);
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

}
