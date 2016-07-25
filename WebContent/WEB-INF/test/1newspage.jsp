<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.sunonline.spider.gui.bean.EducationNews"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	EducationNews educationNews = (EducationNews) request.getAttribute("educationNews");
	//实体拆分
	String title = educationNews.getTitle();
	String content = educationNews.getContent();
	String source = educationNews.getSource();
	Date upload_date = educationNews.getUpload_date();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻详情页</title>
</head>
<body>
<p>题目：<%=title %></p>
<p>内容：<%=content %></p>
<p>来源：<%=source %></p>
<p>上传时间<%=new SimpleDateFormat("yyyy-MM-dd").format(upload_date) %></p>
</body>
</html>