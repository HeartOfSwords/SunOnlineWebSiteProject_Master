package com.sunonline.spider.gui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunonline.spider.gui.bean.EducationNews;
import com.sunonline.web.utils.DBUtils;

/**
 * 教育新闻数据访问层实现类
 * @author snowalker
 * 16.7.25
 */
public class EducationNewsDaoImpl implements EducationNewsDao {
	
	//数据库连接公共变量
	private static Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	//实体属性公共变量
	private int id_db;
	private String title;
	private Date date;
	private String content;
	private String source;
	//实体公共变量
	private EducationNews educationNews;
	private List<EducationNews> educationNewsList;
	//单例形式连接
	private static Connection getConnectionInstance() {
		if (connection == null) {
			return new DBUtils().getCon();
		}
		return connection;
	}

	//通过id获取新闻实体
	@Override
	public EducationNews getEduNewsById(int id) {
		
		//sql构造
		String sql = "select * from edu_news where id=?";
		connection = getConnectionInstance();
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			//遍历结果集
			while (rs.next()) {
				id_db = rs.getInt("id");
				title = rs.getString("title");
				date = rs.getDate("upload_date");
				content = rs.getString("content");
				source = rs.getString("source");
				
				educationNews = new EducationNews(id_db, title, date, content, source);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return educationNews;
	}

	//获取新闻列表
	@Override
	public List<EducationNews> getEduNewsList() {
		//实例化列表
		educationNewsList = new ArrayList<>();
		//构造sql
		String sql = "select * from edu_news order by id desc";
		connection = getConnectionInstance();
		try {
			pstmt = connection.prepareStatement(sql);
 			rs = pstmt.executeQuery();
 			
 			while (rs.next()) {
 				id_db = rs.getInt("id");
				title = rs.getString("title");
				date = rs.getDate("upload_date");
				content = rs.getString("content");
				source = rs.getString("source");
				//构造注入
				educationNews = new EducationNews(id_db, title, date, content, source);
				//组装列表
				educationNewsList.add(educationNews);
 			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return educationNewsList;
	}

	//获取新闻推荐列表
	@Override
	public List<EducationNews> getRecommendationNewsList() {
		//实例化列表
		educationNewsList = new ArrayList<>();
		//构造sql
		String sql = "SELECT * FROM edu_news WHERE id > (( SELECT count(*) FROM edu_news) - 4) order by id desc";
		//获取连接
		connection = getConnectionInstance();
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				id_db = rs.getInt("id");
				title = rs.getString("title");
				date = rs.getDate("upload_date");
				content = rs.getString("content");
				source = rs.getString("source");
				//构造注入
				educationNews = new EducationNews(id_db, title, date, content, source);
				//组装列表
				educationNewsList.add(educationNews);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return educationNewsList;
	}
	
}
