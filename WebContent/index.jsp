<%@page import="com.sunonline.web.bean.User"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sunonline.mooc.model.CoursesBean"%>
<%@page import="com.sunonline.web.bean.OldDriverVideoBean"%>
<%@page import="com.sunonline.web.bean.CollegeVoiceVideoBean"%>
<%@page import="com.sunonline.web.bean.HigoVideoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	*获取所有视频列表
	*/
	//Higo列表
	List<HigoVideoBean> higoVideoBeans = (List<HigoVideoBean>)request.getAttribute("higoVideoBeans");
	//获取最强音列表
	List<CollegeVoiceVideoBean> collegeVoiceVideoBeans = (List<CollegeVoiceVideoBean>)request.getAttribute("collegeVoiceVideoBeans");
	//获取老司机列表
	List<OldDriverVideoBean> oldDriverVideoBeans = (List<OldDriverVideoBean>)request.getAttribute("oldDriverVideoBeans");
	//获取公益课堂列表
	List<CoursesBean> coursesBeans = (List<CoursesBean>)request.getAttribute("coursesBeans");
	//获取用户昵称
	String userNickName = (String) session.getAttribute("usernickname");
	//获取用户手机号
	String usermobile = (String) session.getAttribute("usermobile");
	//获取用户昵称修改标记
	String usernameModifyFlag = (String) session.getAttribute("flag");
	
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>欢迎光临太阳在线</title>
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/video_header.css" />
		<link rel="stylesheet" type="text/css" href="css/footer.css" />
		<link rel="icon" href="img/favicon.ico" type="image/x-icon">
		<script src="js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/jquery.mousewheel.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/navbar_scroll.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/eggShell.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<style>
		/**
		 * 将毛玻璃的背景图和顶部背景图提取为公共属性
		 * 将每个模块的特有的Logo提取为公共属性
		 */
		
		.nav_back {
			/*background-image: url(img/oldDriver_title.png);*/
		}
		
		.column_logo {}
		
		.carousel {
			height: 450px;
			background-color: #000000
		}
		
		.carousel .item {
			height: 450px;
			background-color: #000000;
		}
		
		.item img {
			height: 450px;
			width: 100%;
		}
		.modal-header {
		    background: orchid;
		}
		.h2, h2 {
		    font-size: 30px;
		    color: white;
		}
	</style>

	<body>
		<!--标题导航栏开始   -->
		<!-- 毛玻璃过滤部分-->
		<div class="nav_back"></div>
		<!-- 毛玻璃过滤结束部分-->

		<div class="header">
			<div class="nav-content">
				<a href="IndexRouter">
					<img src="img/logo.png" width="180px" height="50px" alt="太阳在线" class="nav-style" />
				</a>
				<ul class="list-unstyled list-inline nav-style" id="logo_right">
					<li><a href="IndexRouter">首页</a></li>
					<li><a href="studentGuide.html">新生指南</a></li>
					<li><a href="mooc">公益课堂</a></li>
					<li><a href="HigoPager">HIGO大学季</a></li>
					<li><a href="OldDriverPager">影视老司机</a></li>
					<li><a href="CollegeVoiceVideoPager">高校最强音</a></li>
					<li><a href="aboutUs.html">关于我们</a></li>
					<li class="nav_downSelect"><a href="#">其它</a>
						<div class="nav_select">
							<p><a href="#">高校人物风采录</a></p>
							<p><a href="#">山西高校图片库</a></p>
						</div>
					</li>
				</ul>
			<%
				if (userNickName != null && userNickName.length() > 0) {
			%>
			<!-- 登陆之后 -->
			<ul
				class="list-unstyled list-inline nav-style right_float right_float_hidden">
				<li><a data-toggle="modal" data-target="#userinfo" style="cursor: pointer;color: black;">用户名：<strong><%=userNickName %></strong></a></li>
				<li><a href="UserLogout" style="color: red;">注销</a></li>
			</ul>

			<%
				} else {
			%>

			<ul class="list-unstyled list-inline nav-style right_float">
				<li><a href="UserLoginRouter">登录</a></li>
				<li><a href="UserRegisterRouter">注册</a></li>
			</ul>

			<%
				}
			%>


			</div>
		</div>
		<div class="dynamic_header header">
			<div class="nav-content">
				<img src="img/logo.png" width="180px" height="50px" alt="太阳在线" class="nav-style" />
				<ul class="list-unstyled list-inline nav-style" id="logo_right">
					<li><a href="IndexRouter">首页</a></li>
					<li><a href="studentGuide.html">新生指南</a></li>
					<li><a href="mooc">公益课堂</a></li>
					<li><a href="HigoPager">HIGO大学季</a></li>
					<li><a href="OldDriverPager">影视老司机</a></li>
					<li><a href="CollegeVoiceVideoPager">高校最强音</a></li>
					<li><a href="aboutUs.html">关于我们</a></li>
					<li class="nav_downSelect"><a href="#">其它</a>
						<div class="nav_select">
							<p><a href="#">高校人物风采录</a></p>
							<p><a href="#">山西高校图片库</a></p>
						</div>
					</li>
				</ul>
	
				<%
					if (userNickName != null && userNickName.length() > 0) {
				%>
				<!-- 登陆之后 -->
				<ul
					class="list-unstyled list-inline nav-style right_float right_float_hidden">
					<li><a data-toggle="modal" data-target="#userinfo" style="cursor: pointer;color: black;">用户名：<strong><%=userNickName %></strong></a></li>
					<li><a href="UserLogout" style="color: red;">注销</a></li>
				</ul>
	
				<%
					} else {
				%>
	
				<ul class="list-unstyled list-inline nav-style right_float">
					<li><a href="UserLoginRouter">登录</a></li>
					<li><a href="UserRegisterRouter">注册</a></li>
				</ul>
				<%
					}
				%>
			</div>
		</div>
		<!-- 标题导航栏结束-->
		<!-- 专栏logo栏结束-->
		<!--<div class="column_logo ">
		</div>-->
		<!-- 专栏logo栏结束-->

		<div style="height: 50px; width: 100%;"></div>

		<!--图片轮播开始-->
		<div class="carousel-container">
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				<!--对应轮播区下面中间的几个点-->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					<li data-target="#carousel-example-generic" data-slide-to="3"></li>
				</ol>
				<!--对应于轮播组件的内容-->
				<div class="carousel-inner" role="listbox">
					<!--第一张图片-->
					<div class="item active">
						<img src="img/index_1.png" alt="">
						<div class="carousel-caption">
							<!--在图片上加入相关内容-->
						</div>
					</div>
					<!--第二张图片-->
					<div class="item">
						<img src="img/index_2.png" alt="">
						<div class="carousel-caption">
						</div>
					</div>
					<!--第三张图片-->
					<div class="item">
						<img src="img/index_3.png" alt="">
						<div class="carousel-caption">
						</div>
					</div>
					<!--第四张图片-->
					<div class="item">
						<img src="img/index_4.png" alt="">
						<div class="carousel-caption">
						</div>
					</div>
				</div>
				<!--对应于轮播组件向左和向右的按钮-->
				<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">上一页</span>
				</a>
				<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">下一页</span>
				</a>
			</div>
		</div>

		<!--图片轮播结束-->
		<!--占位-->
		<div class="blank-content">

		</div>
		<!--占位-->
		<!--Higo大学季版块开始-->
		<div class="column center">
			<div class="column_header">
				<span class="column_header_logo">
					<img alt="加载失败" src="img/mooc_index_logo.png" width="40px" hei>
				</span>
				<div class="column_title_more">
					<span class="column_title">公益课堂</span>
					<div class="column_more">
						<a href="mooc">更多</a>
						<span class="glyphicon glyphicon-chevron-right"></span>
					</div>
				</div>
			</div>
			<div class="divider"></div>
			<div class="column_body">

				<!--大图栏目-->
				
				<!-- 公益课堂第一条数据 -->
				<%
					CoursesBean coursesBean = coursesBeans.get(0);
					
					Integer c_id			= coursesBean.getC_id();				//课程id
					String  c_name			= coursesBean.getC_name();				//课程 名称
					String  c_introduce		= coursesBean.getC_introduce();  		//课程介绍
					String  c_pic_url		= coursesBean.getC_pic_url();			//视频截图url
					String  c_teacher_name  = coursesBean.getC_teacher_name(); 		//讲师姓名
					String  c_teacher_intro = coursesBean.getC_teacher_intro();		//讲师介绍
					Integer t_id			= coursesBean.getT_id();				//视频所属类型id
					
					
				%>
				<a href="CoursesVideoPager?current_pageno=1&c_id=<%=c_id%>">
					<dl class="column_body_big">
						<dt>
						<img src="<%=c_pic_url%>"  width="336px"  height="263px" alt="推荐视频"/>
						<span class="player_num">
							<div class="player_flag"></div>
							<!-- 播放次数 -->
						</span>
					</dt>
						<dd><%=c_name %>
						</dd>

					</dl>

				</a>
				<!-- 普通栏目 -->
				<%
					if(coursesBeans != null && coursesBeans.size() > 0) {
						for(int i = 1; i < coursesBeans.size(); i++) {
				%>
			
						<a href="CoursesVideoPager?current_pageno=1&c_id=<%=coursesBeans.get(i).getC_id()%>">
							<dl class="column_body_normal">
								<dt>
								<img src="<%=coursesBeans.get(i).getC_pic_url() %>"  width="200px"  height="101px" alt="推荐视频"/>
								<span class="player_num">
									<div class="player_flag"></div>
								</span>
							</dt>
								<dd><%=coursesBeans.get(i).getC_teacher_name()%></dd>
							</dl>

						</a>
				
				
				<% 	
						}
					}
					
				%>


				<!--栏目引导位置-->
				<a href="mooc">
					<dl class="column_body_normal column_body_normal_end_green">
						<div class="column_tip">进入公益课堂>></div>
					</dl>

				</a>

			</div>
		</div>
		<!--公益课堂版块结束-->
		<!--Higo大学季版块开始-->
		<div class="column center">
			<div class="column_header">
				<span class="column_header_logo">
					<img alt="加载失败" src="img/higo_index_logo.png" width="40px" height="40px">
				</span>
				<div class="column_title_more">
					<span class="column_title">HIGO大学季</span>
					<div class="column_more">
						<a href="HigoPager">更多</a>
						<span class="glyphicon glyphicon-chevron-right"></span>
					</div>
				</div>
			</div>
			<div class="divider"></div>
			<div class="column_body">
				<!-- Higo大学季第一条数据 -->
				<%
					HigoVideoBean higoVideoBean = higoVideoBeans.get(0);
					String HvideoName = higoVideoBean.getHigoVideoName();
					String HvideoPicUrl = higoVideoBean.getHigoVideoPicUrl();
					Integer HplayTime = higoVideoBean.getHigoVideoPlayedNumber();
					String HvideoUrl = higoVideoBean.getHigoVideoUrl();
					Integer HvideoId = higoVideoBean.getHigoVideoId();
				%>
				<a href="HigoVideoPlayPage?id=<%=HvideoId%>">
					<dl class="column_body_big">
						<dt>
						<img src="<%=HvideoPicUrl %>"  width="336px"  height="263px" alt="推荐视频"/>
						<span class="player_num">
							<div class="player_flag"></div>
							<!-- 播放次数 -->
							<%=HplayTime %>
						</span>
					</dt>
						<dd><%=HvideoName %>
						</dd>

					</dl>

				</a>
				<!-- 普通栏目 -->
				<%
					if(higoVideoBeans != null && higoVideoBeans.size() > 0) {
						for(int i = 1; i < higoVideoBeans.size(); i++) {
				%>
			
						<a href="HigoVideoPlayPage?id=<%=higoVideoBeans.get(i).getHigoVideoId()%>">
							<dl class="column_body_normal">
								<dt>
								<img src="<%=higoVideoBeans.get(i).getHigoVideoPicUrl() %>"  width="200px"  height="101px" alt="推荐视频"/>
								<span class="player_num">
									<div class="player_flag"></div>
									<%=higoVideoBeans.get(i).getHigoVideoPlayedNumber() %>
								</span>
							</dt>
								<dd><%=higoVideoBeans.get(i).getHigoVideoName() %></dd>
							</dl>

						</a>
				
				
				<% 	
						}
					}
					
				%>


				<!--栏目引导位置-->
				<a href="HigoPager">
					<dl class="column_body_normal column_body_normal_end_green">
						<div class="column_tip">进入HIGO大学季>></div>
					</dl>

				</a>

			</div>
		</div>
		<!--Higo大学季版块结束-->

		<!--影视老司机版块开始-->
		<div class="column center">
			<div class="column_header">
				<span class="column_header_logo">
					<img alt="加载失败" src="img/old_driver_index_logo.png" width="40px" height="40px">
				</span>
				<div class="column_title_more">
					<span class="column_title">影视老司机</span>
					<div class="column_more">
						<a href="OldDriverPager">更多</a>
						<span class="glyphicon glyphicon-chevron-right"></span>
					</div>
				</div>
			</div>
			<div class="divider"></div>
			<div class="column_body">

				<!--大图栏目-->
				<!-- 影视老司机第一条数据 -->
				<%
					OldDriverVideoBean oldDriverVideoBean = oldDriverVideoBeans.get(0);
					String OvideoName = oldDriverVideoBean.getLSJ_video_name();
					String OvideoPicUrl = oldDriverVideoBean.getLSJ_video_pic_url();
					Integer OplayTime = oldDriverVideoBean.getLSJ_video_played_number();
					String OvideoUrl = oldDriverVideoBean.getLSJ_video_url();
					Integer OvideoId = oldDriverVideoBean.getLSJ_video_id();
				%>
				<a href="OldDriverVideoPlayPage?id=<%=OvideoId%>">
					<dl class="column_body_big">
						<dt>
						<img src="<%=OvideoPicUrl%>"  width="336px"  height="263px" alt="推荐视频"/>
						<span class="player_num">
							<div class="player_flag"></div>
							<%=OplayTime %>
						</span>
					</dt>
						<dd><%=OvideoName %>
						</dd>

					</dl>

				</a>
				<!-- 普通栏目 -->
				
				<%
					if(oldDriverVideoBeans != null && oldDriverVideoBeans.size() > 0) {
						for(int i = 1; i < oldDriverVideoBeans.size(); i++) {
				%>
					<a href="OldDriverVideoPlayPage?id=<%=oldDriverVideoBeans.get(i).getLSJ_video_id() %>">
					<dl class="column_body_normal">
						<dt>
						<img src="<%=oldDriverVideoBeans.get(i).getLSJ_video_pic_url() %>"  width="200px"  height="101px" alt="推荐视频"/>
						<span class="player_num">
							<div class="player_flag"></div>
							<%=oldDriverVideoBeans.get(i).getLSJ_video_played_number() %>
						</span>
					</dt>
						<dd><%=oldDriverVideoBeans.get(i).getLSJ_video_name() %></dd>
					</dl>

				</a>
				<% 	
						}
					}
					
				%>
				<a href="#">
					<dl class="column_body_normal">
						<dt>
						<img src="img/erweima.png"  width="200px"  height="101px" alt="推荐视频"/>
						<span class="player_num">
							<div class="player_flag"></div>
							120
						</span>
					</dt>
						<dd>精彩敬请期待</dd>
					</dl>

				</a>

						<a href="#">
					<dl class="column_body_normal">
						<dt>
						<img src="img/erweima.png"  width="200px"  height="101px" alt="推荐视频"/>
						<span class="player_num">
							<div class="player_flag"></div>
							120
						</span>
					</dt>
						<dd>精彩敬请期待</dd>
					</dl>

				</a>

				<!--栏目引导位置-->
				<a href="OldDriverPager">
					<dl class="column_body_normal column_body_normal_end_orange">
						<div class="column_tip">进入影视老司机>></div>
					</dl>

				</a>

			</div>
		</div>
		<!--影视老司机版块结束-->
		
		<!--最强音版块开始-->
		<div class="column center">
			<div class="column_header">
				<span class="column_header_logo">	
					<img alt="加载失败" src="img/collegevoice_index_logo.png" width="40px" height="40px">
				</span>
				<div class="column_title_more">
					<span class="column_title">高校最强音</span>
					<div class="column_more">
						<a href="CollegeVoiceVideoPager">更多</a>
						<span class="glyphicon glyphicon-chevron-right"></span>
					</div>
				</div>
			</div>
			<div class="divider"></div>
			<div class="column_body">

				<!--大图栏目-->
				<!-- 高校最强音第一条数据 -->
				<%
					CollegeVoiceVideoBean collegeVoiceVideoBean = collegeVoiceVideoBeans.get(0);
					String CvideoName = collegeVoiceVideoBean.getZqy_video_name();
					String CvideoPicUrl = collegeVoiceVideoBean.getZqy_video_pic_url();
					Integer CplayTime = collegeVoiceVideoBean.getZqy_video_played_number();
					String CvideoUrl = collegeVoiceVideoBean.getZqy_video_url();
					Integer CvideoId = collegeVoiceVideoBean.getZqy_video_id();
				%>
				<a href="CollegeVoiceVideoPlayPage?id=<%=CvideoId%>">
					<dl class="column_body_big">
						<dt>
						<img src="<%=CvideoPicUrl %>"  width="336px"  height="263px" alt="推荐视频"/>
						<span class="player_num">
							<div class="player_flag"></div>
							<%=CplayTime %>
						</span>
					</dt>
						<dd><%=CvideoName %>
						</dd>

					</dl>

				</a>
				<!-- 普通栏目 -->
				<%
					if(collegeVoiceVideoBeans != null && collegeVoiceVideoBeans.size() > 0) {
						for(int i = 1; i < collegeVoiceVideoBeans.size(); i++) {
				%>
						<a href="CollegeVoiceVideoPlayPage?id=<%=collegeVoiceVideoBeans.get(i).getZqy_video_id() %>">
						<dl class="column_body_normal">
							<dt>
							<img src="<%=collegeVoiceVideoBeans.get(i).getZqy_video_pic_url() %>"  width="200px"  height="101px" alt="推荐视频"/>
							<span class="player_num">
								<div class="player_flag"></div>
								<%=collegeVoiceVideoBeans.get(i).getZqy_video_played_number() %>
							</span>
						</dt>
							<dd><%=collegeVoiceVideoBeans.get(i).getZqy_video_name() %></dd>
						</dl>
	
						</a>
				<% 	
						}
					}
					
				%>

				

				<!--栏目引导位置-->
				<a href="CollegeVoiceVideoPager">
					<dl class="column_body_normal column_body_normal_end_blue">
						<div class="column_tip">进入高校最强音>></div>
					</dl>

				</a>

			</div>
		</div>
		<!--最强音版块结束-->

	

	<!-- 模态框（Modal） -->
	<div class="userinfo-modal">
		<div class="modal fade" id="userinfo" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h2 class="modal-title" id="myModalLabel">
							<!-- 如果修改用户昵称标记不为空则显示该成功标记否则不显示-->
						<%
							if (usernameModifyFlag == null ) {
						%>
								<center>用户信息</center>
						<%
							} else {
						%>					
								<center>用户信息</center>
								<small><b>
									<font color="red"><%=usernameModifyFlag %></font>
								</b></small>
						<%} %>			
						</h2>
					</div>
					<div class="modal-body">
						<table class="table table-bordered table-striped table-hover">
							<tr>
								<form action="ModifyUserNickName" method="post">
									<td class="infoname">用户昵称</td>
									<td>
										<font color="blue">
											<input type="hidden" name="usermobile" value="<%=usermobile%>"/>
											<input type="text" class="form-control" name="usernickname" value="<%=userNickName%>">
										</font>
									</td>
									<td>
										<button type="submit" class="btn btn-primary btn-lg">修改</button>
									</td>
								</form>
							</tr>

							<tr>
								<td class="infoname">登录时间</td>
								<td><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%></td>
								<td></td>
							</tr>
							
							<tr>
								<form action="ModifyUserpwd" method="post">	
									<td class="infoname">密码修改</td>
									<td>
										<input type="hidden" name="usermobile" value="<%=usermobile%>"/>
										<input type="password" class="form-control" name="olduserpwd"  placeholder="请输入原密码">
										<input type="password" class="form-control" name="newuserpwd"  placeholder="请输入新密码">
										<input type="password" class="form-control" name="renewuserpwd"  placeholder="请再次输入新密码">
									</td>
									<td>
										<button type="submit" class="btn btn-primary btn-lg">修改</button>
									</td>
								</form>
							</tr>
							<%
									if (session.getAttribute("passwdflag") != null) {
							%>
							<tr>
								<td colspan="3">
									<span><font color="red"><%=session.getAttribute("passwdflag") %></font></span>
								</td>
							</tr>
							<%
								}
							%>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning btn-lg" data-dismiss="modal">关闭</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>


		<!--foot部分开始-->
		<div class="footer">
			<!--上层-->
			<div class="footer-content">
				<div class="footer-first-level">
					<div class="first-level">
						<i class="glyphicon glyphicon-plane"></i> <span
							class="footer-title">新手上路</span>
						<ul class="nav">
							<li class="nav-divider"></li>
							<li>会员注册</li>
							<li>会员分类</li>
							<li>注册太阳在线会员</li>
							<li>网站浏览手册</li>
						</ul>
					</div>
					<div class="first-level">
						<i class="glyphicon glyphicon-duplicate"></i> <span
							class="footer-title">会员须知</span>
						<ul class="nav">
							<li class="nav-divider"></li>
							<li>用户协议</li>
							<li>注意事项</li>
							<li>免责条框</li>
							<li>法律声明</li>
							<li>关于会员卡</li>
						</ul>
					</div>
					<div class="first-level">
						<i class="glyphicon glyphicon-thumbs-up"></i> <span
							class="footer-title">服务保障</span>
						<ul class="nav">
							<li class="nav-divider"></li>
							<li>隐私保护</li>
							<li>十大保障</li>
							<li>24小时客服</li>
						</ul>
					</div>
					<div class="first-level">
						<i class="glyphicon glyphicon-user"></i> <span
							class="footer-title">关于我们</span>
						<ul class="nav">
							<li class="nav-divider"></li>
							<li>关于我们</li>
							<li>加入我们</li>
							<li>联系我们</li>
							<li>电商加盟</li>
							<li>广告服务</li>
						</ul>
					</div>
					<div class="first-level first-level-5">
						<img src="img/erweima.png" /> <img src="img/erweima2.png"
							class="footer-img-control" /><br /> <span>扫二维码，关注太阳在线官方微信平台</span>
					</div>
				</div>
				<div class="footer-second-level">(c)2015-2016 山西太阳在线 SYSTEM
					All Rights Reserved</div>
			</div>
		</div>
		<!--foot部分结束-->

</body>

</html>