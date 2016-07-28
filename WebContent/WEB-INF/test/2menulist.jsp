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
<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<style type="text/css">
			body {
				margin-top: 60px;
			}
		</style>
		<link rel="stylesheet" type="text/css" href="css/header.css"/>
		<link rel="stylesheet" type="text/css" href="css/footer-news.css"/>
		<link rel="stylesheet" type="text/css" href="css/news-list.css"/>
		<link rel="icon" href="img/favicon.ico" type="image/x-icon">
		<script src="js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<title>教育咨询</title>
</head>

<body>
	<!--文章列表模块-->
		<div class="aritcle-block">
			<!--面包屑导航-->
			<div class="video-rode-nav">
				<ol class="breadcrumb">
					<li><a href="IndexRouter">网站首页</a></li>
					<li class="active">咨询列表</li>
				</ol>
			</div>
			<!--文章列表-->
			<div class="article-list">
				<div class="article-list-content">
					<div class="article-list-header">
						<span class="glyphicon glyphicon-flag"></span>
						<span class="title">欢迎浏览教育咨询板块</span>
					</div>
					<div class="article-list-body">
					<%
						if(educationNewsList != null && educationNewsList.size() > 0) {
							for (EducationNews educationNews : educationNewsList) {
					%>
						<!--单篇文章的样式开始-->
						<div class="article">
							<span class="article-icon glyphicon glyphicon-star"></span>
							<a href="EduNewsContentRouter?id=<%=educationNews.getId() %>"><span class="article-title"><%=educationNews.getTitle() %></span></a>
							<!--上传者信息-->
							<div class="article-owner">
								<i class="glyphicon glyphicon-user"></i>
								<span class="">出处：<%=educationNews.getSource() %></span>
							</div>
							<!--上传日期-->
							<div class="article-date">
								<i class="glyphicon glyphicon-time"></i>
								<span class=""><%=educationNews.getUpload_date() %></span>
							</div>
							<!--阅读次数-->
							<div class="article-times">
								<i class="glyphicon glyphicon-play-circle"></i>
								<span class="">id:<%=educationNews.getId() %></span>
							</div>
						</div>
						<!--单篇文章的样式结束-->
						<%			
							}
						}
					%>
					</div>
					
					<!--分页部分开始 -->
					<div class="page_roll article-list-divider">
						<div class="btn-group" style="width: 840px;" >
							<button type="button" class="btn btn-default"><a href="#"><span class="glyphicon glyphicon-home">首页</span></a></button>
							<button type="button" class="btn btn-default"><a href="#"><span class="glyphicon glyphicon-circle-arrow-left">上一页</span></a></button>
							<button type="button" class="btn btn-default"><a href="#"><span class="glyphicon glyphicon-circle-arrow-right">下一页</span></a></button>
							<button type="button" class="btn btn-default" style="margin-right: 10px;"><a href="#"><span class="glyphicon glyphicon-play">尾页</span></a></button>
							<span>
								<form action="" method="post">
									<div class="input-group">
		      							<input type="text" class="form-control"  placeholder="跳转到"/>
		     							<span class="input-group-btn">
		       								<button class="btn btn-success" type="submit">Go!</button>
		     					 		</span>
									</div>
								</form>
							</span>
						</div>
					</div>
					<!--分页部分结束 -->
			</div>
		</div>
		</div>
		<!--文章列表结束-->
		<div class="blank-content">

		</div>

</body>
</html>