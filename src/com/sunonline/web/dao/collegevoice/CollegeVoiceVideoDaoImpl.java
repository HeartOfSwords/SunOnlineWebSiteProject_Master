package com.sunonline.web.dao.collegevoice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sunonline.web.bean.CollegeVoiceVideoBean;
import com.sunonline.web.bean.HigoVideoBean;
import com.sunonline.web.bean.pager.CollegeVoicePagerBean;
import com.sunonline.web.utils.DBUtils;
import com.sunonline.web.utils.Hibernate4Util;

/**
 * 高校最强音视频Dao实现类
 * @author SnoWalker.wwl
 * <p>2016.5.31</p>
 */
public class CollegeVoiceVideoDaoImpl implements CollegeVoiceVideoDao {

		/**
		 * 通过id获取
		 */
		public CollegeVoiceVideoBean getVideoByID(int id) {
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
		/**
		 * 获取所有视频
		 */
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
		/**
		 * 获取视频数量
		 */
		public int fetchVideoRowsCount() {
			return this.fetchAllVideos().size();
		}
		/**
		 * 增加播放次数
		 */
		public void addPlayTimeNumber(int ZQY_video_id) {

			String sql = "UPDATE college_voice_video "
					+ "SET zqy_video_played_number=zqy_video_played_number+1 "
					+ "WHERE ZQY_video_id = ?;"; //通过id获取视频全部信息
			try {
				Connection connection = new DBUtils().getCon();
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, ZQY_video_id);
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
		
		/**
		 * 获取推荐视频
		 */
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
		/**
		 * 分页获取
		 */
		public List<CollegeVoiceVideoBean> fetchAllVideos(int current_pageNo) {
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
