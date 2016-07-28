<%@page import="com.sunonline.spider.gui.bean.EducationNews"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//从后台获取教育新闻列表
	List<EducationNews> educationNewsList = (List<EducationNews>) request.getAttribute("educationNewslist");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻资讯列表页</title>
</head>
<body>
<h1>新闻资讯列表</h1>
<%
	if(educationNewsList != null && educationNewsList.size() > 0) {
		for (EducationNews educationNews : educationNewsList) {
%>
		
		新闻id:<%=educationNews.getId() %><br/>
		新闻题目:<a href="EduNewsContentRouter?id=<%=educationNews.getId() %>"><%=educationNews.getTitle() %></a><br/>
		上传时间:<%=educationNews.getUpload_date() %><br/>
		转载自:<%=educationNews.getSource() %><br/>
		<hr>
<%			
		}
	}
%>
</body>
</html>