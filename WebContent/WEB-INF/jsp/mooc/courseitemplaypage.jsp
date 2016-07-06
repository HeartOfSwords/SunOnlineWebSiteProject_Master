<%@page import="com.sunonline.mooc.model.CoursesBean"%>
<%@page import="java.util.Date"%>
<%@page import="com.sunonline.mooc.model.CourseListItemBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//从request中获取课程单体实体
	CourseListItemBean courseListItemBean = (CourseListItemBean)request.getAttribute("courseListItemBean");
	//拆分实体
	Integer cl_id = courseListItemBean.getCl_id(); //课程条目id
	String cl_name = courseListItemBean.getCl_name(); //课程条目名称
	String cl_pic_url = courseListItemBean.getCl_pic_url(); //课程条目截图url
	String cl_video_url = courseListItemBean.getCl_video_url(); //课程条目视频url
	Integer cl_play_time = courseListItemBean.getCl_play_time(); //课程播放次数
	String cl_video_intro = courseListItemBean.getCl_video_intro(); //单节视频介绍
	Date cl_upload_time = courseListItemBean.getCl_upload_time(); //视频上传时间
	Integer c_id = courseListItemBean.getC_id(); //课程id
	
	//获取讲师信息
	CoursesBean coursesBean = (CoursesBean)request.getAttribute("coursesBean");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
mooc播放页
<h1>单体视频数据</h1>
	<%
		if(courseListItemBean != null) {
	%>
		课程条目id：<%=cl_id %><br/>
		课程条目名称：<%=cl_name %><br/>
		课程条目截图url：<%=cl_pic_url %><br/>
		课程条目视频url：<%=cl_video_url %><br/>
		课程播放次数：<%=cl_play_time %><br/>
		单节视频介绍：<%=cl_video_intro %><br/>
		视频上传时间：<%=cl_upload_time %><br/>
		课程id：<%=cl_id %><br/>

	<%} else {%>		
		<font color="red">视频数据加载错误，请联系管理员</font>
	<%
		}
	%>
	<h1>讲师信息</h1>
	讲师昵称：<%=coursesBean.getC_teacher_name() %><br/>
	讲师介绍：<%=coursesBean.getC_teacher_intro() %><br/>
</body>
</html>