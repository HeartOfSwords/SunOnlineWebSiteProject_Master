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

<h1><a href="OldDriverPager">影视老司机</a></h1>
<h1><a href="CollegeVoiceVideoPager">高校最强音</a></h1>
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
	String videoName = higoVideoBean.getHigoVideoName();
	String videoPicUrl = higoVideoBean.getHigoVideoPicUrl();
	Integer playTime = higoVideoBean.getHigoVideoPlayedNumber();
%>
<div>视频名<%=videoName %></div><br/>
<div>截图地址<%=videoPicUrl %></div><br/>
<div>播放次数<%=playTime %></div><br/>
================
<h2>迭代剩余数据</h2>
<%
	if(higoVideoBeans != null && higoVideoBeans.size() > 0) {
		for(int i = 1; i < higoVideoBeans.size(); i++) {
%>
	
		<div>视频名<%=higoVideoBeans.get(i).getHigoVideoName() %></div><br/>
		<div>截图地址<%=higoVideoBeans.get(i).getHigoVideoPicUrl() %></div><br/>
		<div>播放次数<%=higoVideoBeans.get(i).getHigoVideoPlayedNumber() %></div><br/>
<% 	
		}
	}
	
%>
</body>

</html>