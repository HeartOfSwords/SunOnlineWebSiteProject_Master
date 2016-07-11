<%@page import="com.sunonline.web.webapi.bean.mooc.MediasAfter"%>
<%@page import="com.sunonline.web.webapi.bean.mooc.RadioInterview"%>
<%@page import="com.sunonline.web.webapi.bean.mooc.SoftwareDeveloping"%>
<%@page import="com.sunonline.mooc.model.CoursesBean"%>
<%@page import="com.sunonline.mooc.dao.MoocVideoDaoImpl"%>
<%@page import="com.sunonline.mooc.dao.MoocVideoDao"%>
<%@page import="com.sunonline.mooc.model.TypeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<TypeBean> typeBeans = (List<TypeBean>)request.getAttribute("typeBeans");
	//获取软件开发列表
	List<SoftwareDeveloping> softwareDevelopings = (List<SoftwareDeveloping>)request.getAttribute("softwareDevelopings");
	//获取播音主持列表
	List<RadioInterview> radioInterviews = (List<RadioInterview>)request.getAttribute("radioInterviews");
	//获取影视后期列表
	List<MediasAfter> mediasAfters = (List<MediasAfter>)request.getAttribute("mediasAfters");
	
	MoocVideoDao moocVideoDao = new MoocVideoDaoImpl();
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/studentGuide.css" />
		<link rel="stylesheet" type="text/css" href="css/publicClass.css" />
		<script src="js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<title>公益课堂</title>
	</head>
	<script>
		$(function() {
			$(".recommment_part").hover(function() {
				$(this).find(".content_part").animate({
					bottom: "45px"
				}, 300);
				$(this).css("box-shadow", "0px 0px 15px #000606");
			}, function() {
				$(this).find(".content_part").animate({
					bottom: "0px"
				}, 300);
				$(this).css("box-shadow", "0px 0px 2px #000606");
			});

		});
	</script>

	<body data-target="#selector" data-spy="scroll" id="top">
		
		<!--侧边导航条开始-->
		<nav class="nav navbar-default side-navbar" role="navigation" id="selector">
			<ul class="nav navbar-nav">
				<a href="#top"><span class="return-top">返回顶部</span></a>
				<li class="active distance-top style-common"><a href="#module_1">软件开发</a></li>
				<li class="style-common"><a href="#module_2">影视后期</a></li>
				<li class="style-common style-common-bottom"><a href="#module_3">播音主持</a></li>
			</ul>
		</nav>
		<!--侧边导航条结束-->
		
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

		<!--大图区-->
		<div class="big-pic">

		</div>
		<!--大图区-->
		<!--技术板块一区-->
		<div class="combo-block block-1" id="module_1">
			<div class="container">
				<!--面包屑导航-->
				<div class="col-xs-12 col-sm-12 col-md-12">
					<ol class="breadcrumb">
						<li><a href="IndexRouter">首页</a></li>
						<li><a href="mooc">公益课堂</a></li>
						<li class="active">软件开发</li>
					</ol>
				</div>
				<!--套餐列表-->
				<div class="body_width center recommment">
				<!-- 遍历软件开发列表 -->
				<%
					if(softwareDevelopings != null && softwareDevelopings.size() > 0) {
						for (SoftwareDeveloping softwareDeveloping : softwareDevelopings) {
					
				%>
				<a href="CoursesVideoPager?current_pageno=1&c_id=<%=softwareDeveloping.getC_id()%>">
					<div class="recommment_part">
						<img src="<%=softwareDeveloping.getC_pic_url() %>" style="display: inline-block;" width="252px" height="124px" />
						<div class="content_part">
							<p><%=softwareDeveloping.getC_name() %></p>
							<p class="small_content"><%=softwareDeveloping.getC_introduce() %></p>
						</div>
						<div class="price_info">
							<span class="price">free</span>
							<span class="num">开始学习吧！</span>
						</div>
					</div>
				</a>
				<%}} %>
					
				</div>
			</div>
		</div>
		<!--技术板块一区-->

		<!--技术板块二区-->
		<div class="combo-block block-2" id="module_2">
			<div class="container">
				<!--面包屑导航-->
				<div class="col-xs-12 col-sm-12 col-md-12">
					<ol class="breadcrumb">
						<li><a href="IndexRouter">首页</a></li>
						<li><a href="mooc">公益课堂</a></li>
						<li class="active">影视后期</li>
					</ol>
				</div>
				<!--套餐列表-->
				
				<div class="body_width center recommment">
				<!-- 遍历影视后期列表 -->
				<%
					if(mediasAfters != null && mediasAfters.size() > 0) {
						for (MediasAfter mediasAfter : mediasAfters) {
					
				%>
					<a href="CoursesVideoPager?current_pageno=1&c_id=<%=mediasAfter.getC_id()%>">
						<div class="recommment_part">
							<img src="<%=mediasAfter.getC_pic_url() %>" style="display: inline-block;" width="252px" height="124px" />
							<div class="content_part">
								<p><%=mediasAfter.getC_name() %></p>
								<p class="small_content"><%=mediasAfter.getC_introduce() %></p>
							</div>
							<div class="price_info">
								<span class="price">free</span>
								<span class="num">开始学习吧！</span>
							</div>
						</div>
					</a>
				<%} }else { %>
					<div class="recommment_part">
						<img src="img/a.jpg" style="display: inline-block;" width="252px" height="124px" />
						<div class="content_part">
							<p> HTML5 移动Web App阅读器</p>
							<p class="small_content"> 用HTML5、ES6、Ajax异步、Touch事件等技术，开发商业Web APP </p>
						</div>
						<div class="price_info">
							<span class="price">￥2000</span>
							<span class="num">5000人在学</span>
						</div>

					</div>
				<%} %>

				</div>
			</div>
		</div>
		<!--技术板块二区-->

		<!--技术板块三区-->
		<div class="combo-block block-3" id="module_3">
			<div class="container">
				<!--面包屑导航-->
				<div class="col-xs-12 col-sm-12 col-md-12">
					<ol class="breadcrumb">
						<li><a href="IndexRouter">首页</a></li>
						<li><a href="mooc">公益课堂</a></li>
						<li class="active">播音主持</li>
					</ol>
				</div>
				<!--套餐列表-->
				<div class="body_width center recommment">
					<%
					if(radioInterviews != null && radioInterviews.size() > 0) {
						for (RadioInterview radioInterview : radioInterviews) {
					
				%>
				<a href="CoursesVideoPager?current_pageno=1&c_id=<%=radioInterview .getC_id()%>">
					<div class="recommment_part">
						<img src="<%=radioInterview .getC_pic_url() %>" style="display: inline-block;" width="252px" height="124px" />
						<div class="content_part">
							<p><%=radioInterview .getC_name() %></p>
							<p class="small_content"><%=radioInterview .getC_introduce() %></p>
						</div>
						<div class="price_info">
							<span class="price">free</span>
							<span class="num">开始学习吧！</span>
						</div>
					</div>
				</a>
				<%} }else { %>
					<div class="recommment_part">
						<img src="img/a.jpg" style="display: inline-block;" width="252px" height="124px" />
						<div class="content_part">
							<p> HTML5 移动Web App阅读器</p>
							<p class="small_content"> 用HTML5、ES6、Ajax异步、Touch事件等技术，开发商业Web APP </p>
						</div>
						<div class="price_info">
							<span class="price">￥2000</span>
							<span class="num">5000人在学</span>
						</div>

					</div>
				<%} %>

				</div>
			</div>
		</div>
		<!--技术板块三区-->
		<!-- 引入footer.jsp -->
		<jsp:include page="/footer.jsp"></jsp:include>
	</body>

</html>