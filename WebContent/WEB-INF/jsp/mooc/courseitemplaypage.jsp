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
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/video-js.min.css" />
		<script src="js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/video.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" href="css/publicClass_third.css" />
		<title>公益课堂视频播放页<%=cl_name %></title>
	</head>
	<body>
		<!--导航条开始-->
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
      				</button>
					<img src="img/logo.png" />
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
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
								<li><a href="#">高校人物风采录</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">山西高校图片库</a></li>
								<li role="separator" class="divider"></li>
							</ul>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">注册</a></li>
						<li><a href="#">登录</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!--导航条结束-->

			<div class="col-xs-12 col-sm-12 col-md-12">
					<ol class="breadcrumb center">
						<span>当前位置：</span>
						<li><a href="IndexRouter">首页</a></li>
						<li><a href="mooc">公益课堂</a></li>
						<li><a href="CoursesVideoPager?current_pageno=1&c_id=<%=c_id%>"><%=coursesBean.getC_name() %></a></li>
						<li class="active"><%=cl_name %></li>
					</ol>
				</div>
				
		<%
			if(courseListItemBean != null) {
		%>

		<!--播放器部分开始-->
		<div class="video-player center">
			<video id="videojs" class="video-js vjs-default-skin vjs-big-play-centered" controls preload="auto" data-setup='' poster="<%=cl_pic_url %>" width="970px" height="540px">
				<source src="<%=cl_video_url %>" type="video/mp4"></source>
			</video>
		</div>
		
		<%} else {%>		
			<font color="red">视频数据加载错误，请联系管理员</font>
		<%
			}
		%>

		<!--播放器部分结束-->

		<!--下半部分评论和讲师区开始-->
		<div class="bottom_content center">
			<div class="review">
			   <div class="recommend_area">
				<div class="title">
					<span>评论区</span>
					<hr style="margin-top: 0px;" />
				</div>
			</div>

				<!-- 多说评论框 start -->
				<div class="ds-thread" data-thread-key="1" data-title="文章标题" data-url="请替换成文章的网址"></div>
				<!-- 多说评论框 end -->
				<!-- 多说公共JS代码 start (一个网页只需插入一次) -->
				<script type="text/javascript">
					var duoshuoQuery = {
						short_name: "sunonline"
					};
					(function() {
						var ds = document.createElement('script');
						ds.type = 'text/javascript';
						ds.async = true;
						ds.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') + '//static.duoshuo.com/embed.js';
						ds.charset = 'UTF-8';
						(document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(ds);
					})();
				</script>
			<!-- 多说公共JS代码 end -->
			</div>

			<div class="teacher_area">
				<div class="title">
					<span>讲师信息</span>
					<hr style="margin-top: 0px;" />
				</div>
				<div class="info">
					<div class="info_header">
						<div class="person_logo">
							<span class="glyphicon glyphicon-education"></span>
						</div>

						<div id="person_name">
							<span style="font-size: 24px;"><%=coursesBean.getC_teacher_name() %></span><br />
						</div>
						<hr />
						<div class="persion_detail">
							<%=coursesBean.getC_teacher_intro() %>
						</div>
					</div>
				</div>

			</div>

		</div>
		<!--下半部分评论和讲师区结束-->
		<!-- 引入footer.jsp -->
		<jsp:include page="/footer.jsp"></jsp:include>
	</body>
</html>
