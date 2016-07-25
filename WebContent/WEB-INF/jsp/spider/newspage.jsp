<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.sunonline.spider.gui.bean.EducationNews"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	EducationNews educationNews = (EducationNews) request.getAttribute("educationNews");
	//实体拆分
	String title = educationNews.getTitle();
	String content = educationNews.getContent();
	String source = educationNews.getSource();
	Date upload_date = educationNews.getUpload_date();
	//获取用户昵称
	String userNickName = (String) session.getAttribute("usernickname");	
%>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<title>${articleBean.getW_title()}</title>
		<link rel="stylesheet" type="text/css" href="css/news.css" />
		<link rel="stylesheet" type="text/css" href="css/footer-news.css"/>
	</head>
	<script>
		$('#myModal').modal('toggle');
	</script>
	<body>
		<!--导航条开始-->
		<nav class="navbar navbar-default navbar-fixed-top navbar-inverse ">
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
		
		<!--面包屑导航-->
		<div class="video-rode-nav">
			<ol class="breadcrumb">
				<li><a href="IndexRouter">首页</a></li>
				<li><a href="EduNewsMenuRouter">资讯列表</a></li>
				<li class="active">文章标题</li>
			</ol>
		</div>
		<!--内容部分开始-->
		<div class="content">
			<div class="article content">
				<!--标题-->
				<div class="article-title">
					<span><%=title %></span>
				</div>
				<!--文章信息，包括作者，阅读次数-->
				<div class="article-info">
					<span class="author">
						<i class="glyphicon glyphicon-user"></i>文章来源：<%=source %>
					</span>
				</div>
				<!--文章内容-->
				<div class="article-body">
					<%=content %>
				</div>
				<!--文章信息，上传时间-->
				<div class="article-info">
					<span class="date">
						<%=new SimpleDateFormat("yyyy-MM-dd").format(upload_date) %>
					</span>
				</div>
			</div>
		</div>
		<!--内容部分结束-->

		<!--50px占位符-->
		<div class="blank-content">

		</div>

		<!--footer部分开始-->
		<jsp:include page="footer.jsp"></jsp:include>
		<!--footer部分结束-->
	</body>

</html>
