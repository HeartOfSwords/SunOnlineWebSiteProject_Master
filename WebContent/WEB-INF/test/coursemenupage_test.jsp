<%@page import="com.sunonline.mooc.bean.pager.CoursesPagerBean"%>
<%@page import="com.sunonline.mooc.model.CourseListItemBean"%>
<%@page import="java.util.List"%>
<%@page import="com.sunonline.mooc.dao.MoocVideoDaoImpl"%>
<%@page import="com.sunonline.mooc.dao.MoocVideoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/bootstrap.min.css">

<title>mooc单体菜单页</title>
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
	
	
	List<CourseListItemBean> courseListItemBeans = (List<CourseListItemBean>)request.getAttribute("courseListItemList");
		//当前视频c_id
		Integer c_id = courseListItemBeans.get(0).getC_id();
		if (courseListItemBeans != null && courseListItemBeans.size() >0) {
	%>
	<table>
		
		<%
			for (CourseListItemBean courseListItemBean : courseListItemBeans) {
		%>
		<tr>
			<hr>
			课程条目id<%=courseListItemBean.getCl_id()%></br>
			课程条目名称<a href="MoocVideoPlayPage?cl_id=<%=courseListItemBean.getCl_id()%>&c_id=<%=courseListItemBean.getC_id() %>"><%=courseListItemBean.getCl_name() %></a></br>
			课程条目截图url<%=courseListItemBean.getCl_pic_url()%></br>
			课程条目视频url<a href="<%=courseListItemBean.getCl_video_url() %>"><%=courseListItemBean.getCl_video_url() %></a></br>
			课程播放次数<%=courseListItemBean.getCl_play_time() %></br>
			单节视频介绍<%=courseListItemBean.getCl_video_intro()%></br>
			视频上传时间<%=courseListItemBean.getCl_upload_time() %></br>
			课程id<%=courseListItemBean.getC_id() %></br>
			<hr>
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
			CoursesPagerBean coursesPagerBean =  (CoursesPagerBean) request.getAttribute("coursesPagerBean");
			if (coursesPagerBean != null) {
		%>
				<a href="CoursesVideoPager?current_pageno=1&c_id=<%=c_id%>"><button type="button" class="btn btn-primary navbar-btn">首页</button></a>
				<a
				href="CoursesVideoPager?current_pageno=<%=coursesPagerBean.getCurPage() - 1%>&c_id=<%=c_id%>"><button type="button" class="btn btn-success navbar-btn">上一页</button></a>
				<a
				href="CoursesVideoPager?current_pageno=<%=coursesPagerBean.getCurPage() + 1%>&c_id=<%=c_id%>"><button type="button" class="btn btn-success navbar-btn">下一页</button></a>
				<a
				href="CoursesVideoPager?current_pageno=<%=coursesPagerBean.getMaxPage()%>&c_id=<%=c_id%>"><button type="button" class="btn btn-primary navbar-btn">尾页</button></a>
				
				
				<form action="CoursesVideoPager">
					跳转到<input type="text" name="current_pageno" size="2" maxlength="2"/>页
					<input type="hidden" name="c_id" value="<%=c_id%>">
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
