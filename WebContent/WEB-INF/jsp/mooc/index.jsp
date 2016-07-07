<%@page import="com.sunonline.mooc.model.CoursesBean"%>
<%@page import="com.sunonline.mooc.dao.MoocVideoDaoImpl"%>
<%@page import="com.sunonline.mooc.dao.MoocVideoDao"%>
<%@page import="com.sunonline.mooc.model.TypeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%
	List<TypeBean> typeBeans = (List<TypeBean>)request.getAttribute("typeBeans");
	
	MoocVideoDao moocVideoDao = new MoocVideoDaoImpl();
%>
<body>
mooc主页
<%  
if (typeBeans != null && typeBeans.size() > 0) {
	for (TypeBean typeBean : typeBeans) {
		//遍历对应id下的课程列表
		List<CoursesBean> coursesBeans = moocVideoDao.getCoursesListByTypeID(typeBean.getT_id());
%>
	<hr>
	
	类型id:<%=typeBean.getT_id() %><br/>
	类型名：<%=typeBean.getT_name() %><br/>
	下属课程列表：<%
				if (coursesBeans != null && coursesBeans.size() > 0) {
					for (CoursesBean coursesBean : coursesBeans) {
			%>
			<hr>
			跳转分页<a href="CoursesVideoPager?current_pageno=1&c_id=<%=coursesBean.getC_id()%>">跳转</a>
			课程id：<%=coursesBean.getC_id() %><br/>
			课程名：<%=coursesBean.getC_name() %><br/>
			课程介绍：<%=coursesBean.getC_introduce() %><br/>
			图片url：<img alt="无效链接" src="<%=coursesBean.getC_pic_url() %>"><br/>
			讲师名：<%=coursesBean.getC_teacher_name() %><br/>
			讲师介绍：<%=coursesBean.getC_teacher_intro() %><br/>
			类别id：<%=coursesBean.getT_id() %><br/>
			<hr>
			<%}}%>
	<hr>
	
<%}} %>
</body>
</html>