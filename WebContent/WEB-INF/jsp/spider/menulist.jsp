<%@page import="com.sunonline.spider.gui.bean.EducationNews"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//从后台获取教育新闻列表
	List<EducationNews> educationNewsList = (List<EducationNews>) request.getAttribute("educationNewslist");
	//获取新闻推荐列表
	List<EducationNews> educationNewsRecommendation = (List<EducationNews>) request.getAttribute("recommendationNews");
	//获取用户昵称
	String userNickName = (String) session.getAttribute("usernickname");	
%>
<!DOCTYPE html>
<html>

		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<style type="text/css">
			body {
				margin-top: 60px;
			}
			.navbar-inverse {
					background-color: rgba(0, 0, 0, 0.87);
			}
			.navbar {
			    position: fixed;
			}
		</style>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/header.css"/>
		<style type="text/css">
			.navbar-nav li {
			    padding-left: 8px;
			}
		</style>
		<link rel="stylesheet" type="text/css" href="css/footer-news.css"/>
		<link rel="stylesheet" type="text/css" href="css/studentGuide.css" />
		<link rel="stylesheet" type="text/css" href="css/publicClass.css" />
		<link rel="icon" href="img/favicon.ico" type="image/x-icon">
		<style type="text/css">
			.navbar {
			    position: fixed;
			}
			.h1, h1 {
			    font-size: 18px;
			    margin-top: 7px;
			    margin-bottom: 10px;
			}
		</style>
		<script src="js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/eggShell.js" type="text/javascript" charset="utf-8"></script>
		<title>教育咨询</title>
	<body>
	<!--导航条开始-->
		<nav class="navbar navbar-fixed-top navbar-inverse ">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
      				</button>
      				<a href="IndexRouter">
						<img src="img/logo_light.png" />
					</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav nav-deverse">
						<li><a href="IndexRouter">首页</a></li>
						<li><a href="studentGuide.html">新生指南</a></li>
						<li><a href="mooc">公益课堂</a></li>
						<li><a href="HigoPager">HIGO大学季</a></li>
						<li><a href="OldDriverPager">影视老司机</a></li>
						<li><a href="CollegeVoiceVideoPager">高校最强音</a></li>
						<li><a href="aboutUs.html">关于我们</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="EduNewsMenuRouter">教育资讯</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">高校人物风采录</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">山西高校图片库</a></li>
								<li role="separator" class="divider"></li>
							</ul>
						</li>
					</ul>
					
					<%
						if (userNickName != null && userNickName.length() > 0) {
					%>
                    <!-- 登陆之后显示 -->
                    <ul class="nav navbar-nav navbar-right">
						<li><a>用户名：<strong><%=userNickName %></strong></a></li>
						<li><a href="UserLogout" style="color: blue;">注销</a></li>
					</ul>

					<%
						} else {
					%>

                    <ul class="nav navbar-nav navbar-right">
						<li><a href="UserLoginRouter">登录</a></li>
						<li><a href="UserRegisterRouter">注册</a></li>
					</ul>

					<%
						}
					%>
				</div>
			</div>
		</nav>
		<!--导航条结束-->
		<!--内容部分开始-->
		<div class="content">
			<!--文章列表-->
			<div class="article-list">
				<div class="article-list-logo">
					<span class="glyphicon glyphicon-home words"></span>
					<span class="words">&nbsp;新闻海洋</span>
					<hr style="margin-top: -1px"/>
					
				</div>
				<!--渤海畅游文章列表开始-->
				
				<div class="article-list-content">
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
							<span class="">转自：<%=educationNews.getSource() %></span>
						</div>
						<!--上传日期-->
						<div class="article-date">
							<i class="glyphicon glyphicon-time"></i>
							<span class=""><%=educationNews.getUpload_date() %></span>
						</div>
						<!--阅读次数-->
						<div class="article-times">
							<i class="glyphicon glyphicon-play-circle"></i>
							<span class="">编号:<%=educationNews.getId() %></span>
						</div>
					</div>
					<!--单篇文章的样式结束-->
					<% } %>
				<% }  %>
				</div>
				<!--渤海畅游文章列表结束-->
			</div>
			<!--版块栏和推荐栏-->
			<div class="type-recommand">
				<div class="article-type">
					<div class="article-type-logo">
						<span class="glyphicon glyphicon-send words"></span>
						<span class="words">&nbsp;版块直通车</span>
						<hr style="margin-top: -1px"/>
					</div>
					
					<div class="article-type-content">
						<div class="type-common">
							<div class="type-logo">
								<span class="glyphicon glyphicon-list"></span>
							</div>
							<div class="type-name">
								<span>公益课堂</span>
								<a href="mooc"><span class="glyphicon glyphicon-play button"></span></a>
							</div>
						</div>
					</div>
					
					<div class="article-type-content">
						<div class="type-common">
							<div class="type-logo">
								<span class="glyphicon glyphicon-list"></span>
							</div>
							<div class="type-name">
								<span>Higo大学季</span>
								<a href="HigoPager"><span class="glyphicon glyphicon-play button"></span></a>
							</div>
						</div>
					</div>
					
					<div class="article-type-content">
						<div class="type-common">
							<div class="type-logo">
								<span class="glyphicon glyphicon-list"></span>
							</div>
							<div class="type-name">
								<span>影视老司机</span>
								<a href="OldDriverPager"><span class="glyphicon glyphicon-play button"></span></a>
							</div>
						</div>
					</div>
					
					<div class="article-type-content">
						<div class="type-common">
							<div class="type-logo">
								<span class="glyphicon glyphicon-list"></span>
							</div>
							<div class="type-name">
								<span>高校最强音</span>
								<a href="CollegeVoiceVideoPager"><span class="glyphicon glyphicon-play button"></span></a>
							</div>
						</div>
					</div>
					
					<div class="article-type-morebutton">
						<button data-toggle="modal" data-target="#myModal" class="btn btn-primary">更多版块</button>
					</div>
				</div>
				<div class="article-recommand">
					<div class="article-recommand-logo">
						<span class="glyphicon glyphicon-fire words"></span>
						<span class="words">&nbsp;热门推荐</span>
					</div>
					<div class="article-recommand-content">
					<hr />
					<%
					if (educationNewsRecommendation != null && educationNewsRecommendation.size() > 0) {
		
						for (EducationNews educationNews : educationNewsRecommendation) {
					%>
					
						<!--热门推荐单条开始-->
						<div class="article-recommand-style">
							<span class="hot">热</span>
							<a href="EduNewsContentRouter?id=<%=educationNews.getId() %>"><span class="hot-title"><%=educationNews.getTitle() %></span></a>
							<div class="hot-article-owner">
								<i class="glyphicon glyphicon-user"></i>
								<span class="">出处：<%=educationNews.getSource()%></span>
							</div>
						</div>
						<hr />
						<%}} %>
						<!--热门推荐单条结束-->
					</div>
				</div>
			</div>
		</div>
		<!--50px占位符-->
		<div class="blank-content">
			
		</div>
		<!--内容部分结束-->
		<!--footer部分开始-->
		<jsp:include page="footer.jsp"></jsp:include>
		<!--footer部分结束-->
		
		<!--弹窗内容-->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h3>版块列表</h3>
					</div>
					<div class="modal-body">
					
						<a href="studentGuide.html">
							<span class="modal-span">新生指南</span>
						</a>
						
						<a href="mooc">
							<span class="modal-span">公益课堂</span>
						</a>
						
						<a href="HigoPager">
							<span class="modal-span">Higo大学季</span>
						</a>
						
						<a href="OldDriverPager">
							<span class="modal-span">影视老司机</span>
						</a>
						
						<a href="CollegeVoiceVideoPager">
							<span class="modal-span">高校最强音</span>
						</a>
						
						<a href="aboutUs.html">
							<span class="modal-span">关于我们</span>
						</a>
					
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal" style="width: 100px;">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<!--弹窗内容-->
		
		
	</body>

</html>