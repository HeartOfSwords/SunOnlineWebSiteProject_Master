
<%@page import="com.sunonline.web.bean.pager.OldDriverPagerBean"%>
<%@page import="com.sunonline.web.bean.OldDriverVideoBean"%>
<%@page import="com.sunonline.web.dao.olddirver.OldDriverVideoDaoImpl"%>
<%@page import="com.sunonline.web.dao.olddirver.OldDriverVideoDao"%>
<%@page import="com.sunonline.web.bean.pager.HigoPagerBean"%>
<%@page import="com.sunonline.web.bean.HigoVideoBean"%>
<%@page import="com.sunonline.web.dao.higo.HigoVideoDaoImpl"%>
<%@page import="com.sunonline.web.dao.higo.HigoVideoDao"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	OldDriverVideoDao oldDirverVideoDao =  new OldDriverVideoDaoImpl();
	List<OldDriverVideoBean> oldDriverVideos = oldDirverVideoDao.fetchAllVideos();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/bootstrap.min.css">

<title>Insert title here</title>
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
		List<OldDriverVideoBean> oldDriverVideoBeans = (List<OldDriverVideoBean>) request.getAttribute("oldDriverVideoList");
		if (oldDriverVideoBeans != null && oldDriverVideoBeans.size() >0) {
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
			for (OldDriverVideoBean oldDriverVideoBean: oldDriverVideoBeans) {
		%>
		<tr>
			<td><%=oldDriverVideoBean.getLSJ_video_id()%></td>
			<td><a href="OldDriverVideoPlayPage?id=<%=oldDriverVideoBean.getLSJ_video_id()%>"><%=oldDriverVideoBean.getLSJ_video_name() %></a></td>
			<td><%=oldDriverVideoBean.getLSJ_video_date()%></td>
			<td><a href="<%=oldDriverVideoBean.getLSJ_video_url() %>"><%=oldDriverVideoBean.getLSJ_video_url() %></a></td>
			<td><a href="<%=oldDriverVideoBean.getLSJ_video_pic_url() %>"><%=oldDriverVideoBean.getLSJ_video_pic_url() %></a></td>
			<td><%=oldDriverVideoBean.getLSJ_video_played_number()%></td>
			<td><%=oldDriverVideoBean.getLSJ_video_intro() %></td>
			<td><%=oldDriverVideoBean.getLSJ_video_uploader() %></td>
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
			OldDriverPagerBean oldDriverPagerBean =  (OldDriverPagerBean) request.getAttribute("oldDriverPagerBean");
			if (oldDriverPagerBean != null) {
		%>
				<a href="OldDriverPager?current_pageno=1"><button type="button" class="btn btn-primary navbar-btn">首页</button></a>
				<a
				href="OldDriverPager?current_pageno=<%=oldDriverPagerBean.getCurPage() - 1%>"><button type="button" class="btn btn-success navbar-btn">上一页</button></a>
				<a
				href="OldDriverPager?current_pageno=<%=oldDriverPagerBean.getCurPage() + 1%>"><button type="button" class="btn btn-success navbar-btn">下一页</button></a>
				<a
				href="OldDriverPager?current_pageno=<%=oldDriverPagerBean.getMaxPage()%>"><button type="button" class="btn btn-primary navbar-btn">尾页</button></a>
				<form action="OldDriverPager">
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