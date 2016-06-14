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
			//开启session
			Session session = Hibernate4Util.getSession();
			
			//获取视频
			CollegeVoiceVideoBean collegeVoiceVideoBean;
			collegeVoiceVideoBean = (CollegeVoiceVideoBean) session.get(CollegeVoiceVideoBean.class, id);
			
			System.out.println(collegeVoiceVideoBean.toString());
				
			//关闭session
			session.close();
			return collegeVoiceVideoBean;
			
		}
		/**
		 * 获取所有视频
		 */
		@SuppressWarnings("unchecked")
		public List<CollegeVoiceVideoBean> fetchAllVideos() {
			
			List<CollegeVoiceVideoBean> collegeVoiceVideoBeans = new ArrayList<>();
			Session session = Hibernate4Util.getSession();
			
			//HQL
			String hql = "from CollegeVoiceVideoBean";
			Query query = session.createQuery(hql);
			
			collegeVoiceVideoBeans = query.list();
			
			session.close();
			
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

			//开启事务
			Session session = Hibernate4Util.getSession();
			Transaction transaction = session.beginTransaction();
			
			//设置次数，先查询后修改
			CollegeVoiceVideoBean collegeVoiceVideoBean = (CollegeVoiceVideoBean) session.get(CollegeVoiceVideoBean.class, ZQY_video_id);
			collegeVoiceVideoBean.setZqy_video_played_number(collegeVoiceVideoBean.getZqy_video_played_number() + 1);
			
			transaction.commit();
			session.close();
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
					String zqy_player_Number = rs.getString("player_number");				//选手编号
					// set注入
					CollegeVoiceVideoBean collegeVoiceVideoBean = new CollegeVoiceVideoBean();
					collegeVoiceVideoBean.setZqy_video_id(zqy_video_id);
					collegeVoiceVideoBean.setZqy_video_name(zqy_video_name);
					collegeVoiceVideoBean.setZqy_video_url(zqy_video_url);
					collegeVoiceVideoBean.setZqy_video_date(zqy_video_date);
					collegeVoiceVideoBean.setZqy_video_pic_url(zqy_video_pic_url);
					collegeVoiceVideoBean.setZqy_video_played_number(zqy_video_played_number);
					collegeVoiceVideoBean.setZqy_video_intro(zqy_video_intro);
					collegeVoiceVideoBean.setZqy_video_uploader(zqy_video_uploader);
					collegeVoiceVideoBean.setZqy_player_Number(zqy_player_Number);

					
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
					String zqy_player_Number = rs.getString("player_number");				//选手编号
					// set注入
					CollegeVoiceVideoBean collegeVoiceVideoBean = new CollegeVoiceVideoBean();
					collegeVoiceVideoBean.setZqy_video_id(zqy_video_id);
					collegeVoiceVideoBean.setZqy_video_name(zqy_video_name);
					collegeVoiceVideoBean.setZqy_video_url(zqy_video_url);
					collegeVoiceVideoBean.setZqy_video_date(zqy_video_date);
					collegeVoiceVideoBean.setZqy_video_pic_url(zqy_video_pic_url);
					collegeVoiceVideoBean.setZqy_video_played_number(zqy_video_played_number);
					collegeVoiceVideoBean.setZqy_video_intro(zqy_video_intro);
					collegeVoiceVideoBean.setZqy_video_uploader(zqy_video_uploader);
					collegeVoiceVideoBean.setZqy_player_Number(zqy_player_Number);

					
					collegeVoiceVideoBeans.add(collegeVoiceVideoBean);
				}
			} catch (Exception e) {
				collegeVoiceVideoBeans = null;
			}
			return collegeVoiceVideoBeans;
		}
}
