<%@page import="com.sunonline.mooc.model.CoursesBean"%>
<%@page import="com.sunonline.mooc.bean.pager.CoursesPagerBean"%>
<%@page import="com.sunonline.mooc.model.CourseListItemBean"%>
<%@page import="java.util.List"%>
<%@page import="com.sunonline.mooc.dao.MoocVideoDaoImpl"%>
<%@page import="com.sunonline.mooc.dao.MoocVideoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//课程信息
	CoursesBean coursesBean = (CoursesBean)request.getAttribute("coursesBean");
	//获取用户昵称
	String userNickName = (String) session.getAttribute("usernickname");	
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>公益课堂视频菜单页</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/footer.css" />
		<link rel="stylesheet" type="text/css" href="css/publicClass_second.css" />
		<script src="js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
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
      				<a href="IndexRouter">
					<img src="img/logo.png" />
					</a>
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
		<!--顶部图片区域开始-->
		<div class="big-pic">
			<!--面包屑导航-->
			<ol class="breadcrumb">
				<li><a href="IndexRouter">首页</a></li>
				<li><a href="mooc">公益课堂</a></li>
				<li class="active"><%=coursesBean.getC_name() %></li>
			</ol>
			<!--大标题-->
			<div class="big-title">
				<span id="big-title"><%=coursesBean.getC_name() %></span>
			</div>

		</div>
		<!--顶部图片区域结束-->

		<!--课程列表开始-->
		<div class="class-list">
			<!--导航选项卡-->
			<ul class="nav nav-tabs">
				<li><a href="#class-list" data-toggle="tab">课程列表</a></li>
			</ul>
			<!--导航卡面板-->
			<div class="tab-content">
				<div class="tab-pane active" id="class-list">
					<div class="class-list-content">
						<div class="panel-group" id="according">
							<%
								List<CourseListItemBean> courseListItemBeans = (List<CourseListItemBean>)request.getAttribute("courseListItemList");
								//当前视频c_id
								Integer c_id = courseListItemBeans.get(0).getC_id();
								if (courseListItemBeans != null && courseListItemBeans.size() >0) {
									
									for (CourseListItemBean courseListItemBean : courseListItemBeans) {
							%>
							<!--单个课程开始-->
							<div class="panel panel-default">
								<!--触发元素-->
								<div class="panel-heading">
									<span class="glyphicon glyphicon-th-list"></span>
									<h4 class="panel-title">
										<!-- 视频链接及名称 -->
										<a href="MoocVideoPlayPage?cl_id=<%=courseListItemBean.getCl_id()%>&c_id=<%=courseListItemBean.getC_id() %>"><%=courseListItemBean.getCl_name() %></a>
									</h4>
									<h4 class="panel-title-right">
										<a data-toggle = "collapse" data-parent = "#according" href="#<%=courseListItemBean.getCl_id()%>">+</a>
									</h4>
								</div>
								<!--折叠内容-->
								<div id="<%=courseListItemBean.getCl_id()%>" class="panel-collapse collapse">
									<div class="panel-body">
										视频简介：<%=courseListItemBean.getCl_video_intro() %>
									</div>
								</div>
							</div>
							<!--单个课程结束-->
							<%
							}
						} else {%>
					
					<span>无数据</span>
					<%
						}
					%>
						</div>
					</div>
				</div>
			</div>
			<div class="divide-page">
				<!--分页部分开始 -->
				<div class="page_roll">
					<div class="btn-group">
					<%
						CoursesPagerBean coursesPagerBean =  (CoursesPagerBean) request.getAttribute("coursesPagerBean");
						if (coursesPagerBean != null) {
					%>
						<button type="button" class="btn btn-default" onclick="window.location.href='CoursesVideoPager?current_pageno=1&c_id=<%=c_id%>'"><span class="glyphicon glyphicon-home">首页</span></a></button>
						<button type="button" class="btn btn-default" onclick="window.location.href='CoursesVideoPager?current_pageno=<%=coursesPagerBean.getCurPage() - 1%>&c_id=<%=c_id%>'"><span class="glyphicon glyphicon-circle-arrow-left">上一页</span></button>
						<button type="button" class="btn btn-default" onclick="window.location.href='CoursesVideoPager?current_pageno=<%=coursesPagerBean.getCurPage() + 1%>&c_id=<%=c_id%>'"><span class="glyphicon glyphicon-circle-arrow-right">下一页</span></button>
						<button type="button" class="btn btn-default" style="margin-right: 10px;" onclick="window.location.href='CoursesVideoPager?current_pageno=<%=coursesPagerBean.getMaxPage()%>&c_id=<%=c_id%>'"><span class="glyphicon glyphicon-play">尾页</span></button>
						<span>
							<form action="CoursesVideoPager" method="post">
								<div class="input-group">
		  							<input type="text" name="current_pageno" class="form-control"  placeholder="跳转到"/>
		  							<input type="hidden" name="c_id" value="<%=c_id%>">
		 							<span class="input-group-btn">
		   								<button class="btn btn-success" type="submit">Go!</button>
		 					 		</span>
								</div>
							</form>
						<%
							} else {
								out.println("<font color='red'>获取列表失败</font>");
							}
						%>
						</span>
					</div>
				</div>
			<!--分页部分结束 -->
		</div>

		</div>
		<!--课程列表结束-->

		<!-- 引入footer.jsp -->
		<jsp:include page="/footer.jsp"></jsp:include>
		<!--foot部分结束-->
	</body>

</html>
