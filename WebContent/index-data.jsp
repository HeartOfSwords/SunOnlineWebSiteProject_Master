<%@page import="com.sunonline.web.bean.OldDriverVideoBean"%>
<%@page import="com.sunonline.web.bean.CollegeVoiceVideoBean"%>
<%@page import="com.sunonline.web.bean.HigoVideoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>太阳在线官方网站</title>
</head>
<body>

<%
	//Higo列表
	List<HigoVideoBean> higoVideoBeans = (List<HigoVideoBean>)request.getAttribute("higoVideoBeans");
	//获取最强音列表
	List<CollegeVoiceVideoBean> collegeVoiceVideoBeans = (List<CollegeVoiceVideoBean>)request.getAttribute("collegeVoiceVideoBeans");
	//获取老司机列表
	List<OldDriverVideoBean> oldDriverVideoBeans = (List<OldDriverVideoBean>)request.getAttribute("oldDriverVideoBeans");
%>
<h1><a href="HigoPager">Higo大学季</a></h1>
<h2>higo第一条</h2>
<!-- Higo大学季第一条数据 -->
<%
	HigoVideoBean higoVideoBean = higoVideoBeans.get(0);
	String HvideoName = higoVideoBean.getHigoVideoName();
	String HvideoPicUrl = higoVideoBean.getHigoVideoPicUrl();
	Integer HplayTime = higoVideoBean.getHigoVideoPlayedNumber();
	String HvideoUrl = higoVideoBean.getHigoVideoUrl();
%>
<div>视频名<%=HvideoName %></div><br/>
<div>截图地址<%=HvideoPicUrl %></div><br/>
<div>播放次数<%=HplayTime %></div><br/>
<div>视频链接<%=HvideoUrl %></div><br/>
================
<h2>迭代剩余数据</h2>
<%
	if(higoVideoBeans != null && higoVideoBeans.size() > 0) {
		for(int i = 1; i < higoVideoBeans.size(); i++) {
%>
	
		<div>视频名<%=higoVideoBeans.get(i).getHigoVideoName() %></div><br/>
		<div>截图地址<%=higoVideoBeans.get(i).getHigoVideoPicUrl() %></div><br/>
		<div>播放次数<%=higoVideoBeans.get(i).getHigoVideoPlayedNumber() %></div><br/>
		<div>视频链接<%=higoVideoBeans.get(i).getHigoVideoUrl() %></div><br/>
<% 	
		}
	}
	
%>

<h1><a href="OldDriverPager">影视老司机</a></h1>
<h2>影视老司机第一条</h2>
<!-- 影视老司机第一条数据 -->
<%
	OldDriverVideoBean oldDriverVideoBean = oldDriverVideoBeans.get(0);
	String OvideoName = oldDriverVideoBean.getLSJ_video_name();
	String OvideoPicUrl = oldDriverVideoBean.getLSJ_video_pic_url();
	Integer OplayTime = oldDriverVideoBean.getLSJ_video_played_number();
	String OvideoUrl = oldDriverVideoBean.getLSJ_video_url();
	Integer OvideoId = oldDriverVideoBean.getLSJ_video_id();
%>
<div>视频名<%=OvideoName %></div><br/>
<div>截图地址<%=OvideoPicUrl %></div><br/>
<div>播放次数<%=OplayTime %></div><br/>
<div>视频链接<%=OvideoUrl %></div><br/>
================
<h2>迭代剩余数据</h2>
<%
	if(oldDriverVideoBeans != null && oldDriverVideoBeans.size() > 0) {
		for(int i = 1; i < oldDriverVideoBeans.size(); i++) {
%>
	
		<div>视频名<%=oldDriverVideoBeans.get(i).getLSJ_video_name() %></div><br/>
		<div>截图地址<%=oldDriverVideoBeans.get(i).getLSJ_video_pic_url() %></div><br/>
		<div>播放次数<%=oldDriverVideoBeans.get(i).getLSJ_video_played_number() %></div><br/>
		<div>视频链接<%=oldDriverVideoBeans.get(i).getLSJ_video_url() %></div><br/>
<% 	
		}
	}
	
%>
<h1><a href="CollegeVoiceVideoPager">高校最强音</a></h1>
<h2>高校最强音第一条</h2>
<!-- 高校最强音第一条数据 -->
<%
	CollegeVoiceVideoBean collegeVoiceVideoBean = collegeVoiceVideoBeans.get(0);
	String CvideoName = collegeVoiceVideoBean.getZqy_video_name();
	String CvideoPicUrl = collegeVoiceVideoBean.getZqy_video_pic_url();
	Integer CplayTime = collegeVoiceVideoBean.getZqy_video_played_number();
	String CvideoUrl = collegeVoiceVideoBean.getZqy_video_url();
	Integer CvideoId = collegeVoiceVideoBean.getZqy_video_id();
%>
<div>视频名<%=CvideoName %></div><br/>
<div>截图地址<%=CvideoPicUrl %></div><br/>
<div>播放次数<%=CplayTime %></div><br/>
================
<h2>迭代剩余数据</h2>
<%
	if(collegeVoiceVideoBeans != null && collegeVoiceVideoBeans.size() > 0) {
		for(int i = 1; i < collegeVoiceVideoBeans.size(); i++) {
%>
	
		<div>视频名<%=collegeVoiceVideoBeans.get(i).getZqy_video_name() %></div><br/>
		<div>截图地址<%=collegeVoiceVideoBeans.get(i).getZqy_video_pic_url() %></div><br/>
		<div>播放次数<%=collegeVoiceVideoBeans.get(i).getZqy_video_played_number() %></div><br/>
		<div>播放次数<%=collegeVoiceVideoBeans.get(i).getZqy_video_url() %></div><br/>
<% 	
		}
	}
	
%>
</body>

</html>