<%@page import="com.sunonline.web.bean.pager.CollegeVoicePagerBean"%>
<%@page import="com.sunonline.web.bean.CollegeVoiceVideoBean"%>
<%@page import="com.sunonline.web.dao.collegevoice.CollegeVoiceVideoDaoImpl"%>
<%@page import="com.sunonline.web.dao.collegevoice.CollegeVoiceVideoDao"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CollegeVoiceVideoDao collegeVoiceVideoDao =  new CollegeVoiceVideoDaoImpl();
	List<CollegeVoiceVideoBean> collegeVoiceVideoVideos = collegeVoiceVideoDao.fetchAllVideos();
	
	List<CollegeVoiceVideoBean> collegeVoiceVideoRecommendation = (List<CollegeVoiceVideoBean>)request.getAttribute("collegeVoiceVideoRecommendation");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/bootstrap.min.css">

<title>高校最强音老司机</title>
<style type="text/css">
	list{
		float:left;
	}
	#title {
		margin-top: 100px;
	}
</style>
</head>
<body>
		
	<h1>分页获取</h1><hr>
	<%
	List<CollegeVoiceVideoBean> collegeVoiceVideoBeans = (List<CollegeVoiceVideoBean>)request.getAttribute("collegeVoiceVideoList");
		if (collegeVoiceVideoBeans != null && collegeVoiceVideoBeans.size() >0) {
	%>
	<table>
		<tr>
			<td>视频id</td>
			<td>视频名称</td>
			<td>上传日期</td>
			<td>url</td>
			<td>截图url</td>
			<td>播放次数</td>
			<td>视频简介</td>
			<td>上传者</td>
		</tr>
		<%
			for (CollegeVoiceVideoBean collegeVoiceVideoBean : collegeVoiceVideoBeans) {
		%>
		<tr>
			<td><%=collegeVoiceVideoBean.getZqy_video_id()%></td>
			<td><a href="CollegeVoiceVideoPlayPage?id=<%=collegeVoiceVideoBean.getZqy_video_id()%>"><%=collegeVoiceVideoBean.getZqy_video_name() %></a></td>
			<td><%=collegeVoiceVideoBean.getZqy_video_date()%></td>
			<td><a href="<%=collegeVoiceVideoBean.getZqy_video_url() %>"><%=collegeVoiceVideoBean.getZqy_video_url() %></a></td>
			<td><a href="<%=collegeVoiceVideoBean.getZqy_video_pic_url() %>"><%=collegeVoiceVideoBean.getZqy_video_pic_url() %></a></td>
			<td><%=collegeVoiceVideoBean.getZqy_video_played_number()%></td>
			<td><%=collegeVoiceVideoBean.getZqy_video_intro() %></td>
			<td><%=collegeVoiceVideoBean.getZqy_video_uploader() %></td>
		</tr>
		<%
				}
			} else {
		%>
		<tr>
			<td colspan="3">无数据</td>
		</tr>

		<%
			}
		%>
	</table>
	<h2>页码</h2>
		<%
			CollegeVoicePagerBean collegeVoicePagerBean =  (CollegeVoicePagerBean) request.getAttribute("collegeVoicePagerBean");
			if (collegeVoicePagerBean != null) {
		%>
				<a href="CollegeVoiceVideoPager?current_pageno=1"><button type="button" class="btn btn-primary navbar-btn">首页</button></a>
				<a
				href="CollegeVoiceVideoPager?current_pageno=<%=collegeVoicePagerBean.getCurPage() - 1%>"><button type="button" class="btn btn-success navbar-btn">上一页</button></a>
				<a
				href="CollegeVoiceVideoPager?current_pageno=<%=collegeVoicePagerBean.getCurPage() + 1%>"><button type="button" class="btn btn-success navbar-btn">下一页</button></a>
				<a
				href="CollegeVoiceVideoPager?current_pageno=<%=collegeVoicePagerBean.getMaxPage()%>"><button type="button" class="btn btn-primary navbar-btn">尾页</button></a>
				<form action="CollegeVoiceVideoPager">
					跳转到<input type="text" name="current_pageno" size="2" maxlength="2"/>页
					<button type="submit" class="btn btn-primary navbar-btn" data-toggle="tooltip" title="提交">Go</button>
				</form> 
		<%
			} else {
				out.println("");
			}
		%>
		
		<script type="text/javascript" src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
</body>
</html>