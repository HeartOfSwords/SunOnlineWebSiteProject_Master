<%@page import="com.sunonline.web.bean.pager.CollegeVoicePagerBean"%>
<%@page import="com.sunonline.web.bean.CollegeVoiceVideoBean"%>
<%@page import="com.sunonline.web.dao.collegevoice.CollegeVoiceVideoDaoImpl"%>
<%@page import="com.sunonline.web.dao.collegevoice.CollegeVoiceVideoDao"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//获取视频列表
	CollegeVoiceVideoDao collegeVoiceVideoDao =  new CollegeVoiceVideoDaoImpl();
	List<CollegeVoiceVideoBean> collegeVoiceVideoVideos = collegeVoiceVideoDao.fetchAllVideos();
	//推荐视频
	List<CollegeVoiceVideoBean> collegeVoiceVideoRecommendation = (List<CollegeVoiceVideoBean>)request.getAttribute("collegeVoiceVideoRecommendation");
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>高校最强音</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/video_header.css" />
		<link rel="stylesheet" href="css/video_list.css" />
		<link rel="stylesheet" type="text/css" href="css/footer.css" />		
		<link rel="icon" href="img/favicon.ico" type="image/x-icon">
		<style>
		/**
		 * 将毛玻璃的背景图和顶部背景图提取为公共属性
		 * 将每个模块的特有的Logo提取为公共属性
		 */
		
		.nav_back {
			background-image: url(img/strongestVoice_title.png);
		}
		
		.column_logo {
			background-image: url(img/strongestVoice_title.png);
		}
		
		.video-title-logo-img {
			background-image: url(img/oldDriver_logo.png);
		}
		
		.nav-content>ul>li a {
			color: #fff;
		}
		.recommend-logo-img{
				background-image: url(img/oldDriver_second_rec.png);
		}
	</style>

	</head>
	<style>

	</style>

	<body>
		<!--标题导航栏开始   -->
		<!-- 毛玻璃过滤部分-->
		<div class="nav_back"></div>
		<!-- 毛玻璃过滤结束部分-->
		<div class="header">
			<div class="nav-content">
				<img src="img/logo_light.png" width="180px" height="50px" alt="太阳在线" class="nav-style" />
				<ul class="list-unstyled list-inline nav-style" id="logo_right">
					<li><a href="index.jsp">首页</a></li>
					<li><a href="HigoPager">HIGO大学季</a></li>
					<li><a href="OldDriverPager">影视老司机</a></li>
					<li><a href="CollegeVoiceVideoPager">高校最强音</a></li>
					<li><a href="#">高校人物风采录</a></li>
					<li><a href="#">山西高校图片库</a></li>
					<li><a href="#">其它</a></li>
				</ul>
				<ul class="list-unstyled list-inline nav-style right_float">
					<li><a href="#">登录</a></li>|
					<li><a href="#">注册</a></li>
				</ul>
			</div>

		</div>
		<!-- 标题导航栏结束-->
		<!-- 专栏logo栏结束-->
		<div class="column_logo ">
		</div>
		<!-- 专栏logo栏结束-->

		<!-- 内容列表开始-->
		<div class="content">
			<!-- 路径部分开始-->
			<div class="nav-content min_height">
				<ol class="breadcrumb">
					<li><a href="index.jsp">首页</a></li>
					<li class="active">高校最强音</li>
				</ol>

			</div>

			<!-- 路径部分结束-->
			<div id="lunbo">
				<!-- 轮播start-->
				<div id="myCarousel" class="carousel slide">
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
					</ol>
					
					<div class="carousel-inner">
						<div class="item active">
							<img src="http://o7zv69viu.bkt.clouddn.com/higovideo_pic_1.png" alt="">
							<div class="carousel-caption">
								<h4></h4>
								<p></p>
							</div>
						</div>
						<%  
							if (collegeVoiceVideoRecommendation != null) {
								for (CollegeVoiceVideoBean collegeVoiceVideoRecommendationElement : collegeVoiceVideoRecommendation) {
						%>
						<div class="item">
							<img src="<%=collegeVoiceVideoRecommendationElement.getZqy_video_pic_url() %>" alt="">
							<div class="carousel-caption">
								<h4></h4>
								<p></p>
							</div>
						</div>
						<%  }
						} %>
					</div>
					<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
					<a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
				</div>

				<!-- 轮播end-->

			</div>
			<!-- 视频列表开始-->	
				<!-- 传递视频id -->
				<div id="left">
				<!-- 获取视频主列表 -->
				<%
				List<CollegeVoiceVideoBean> collegeVoiceVideoBeans = (List<CollegeVoiceVideoBean>)request.getAttribute("collegeVoiceVideoList");
					if (collegeVoiceVideoBeans != null && collegeVoiceVideoBeans.size() >0) {
					
						for (CollegeVoiceVideoBean collegeVoiceVideoBean : collegeVoiceVideoBeans) {
					
				%>
					<!--内容部分-->
					<a href="CollegeVoiceVideoPlayPage?id=<%=collegeVoiceVideoBean.getZqy_video_id()%>">
					<div class="left_item">
						<div class="demo-img">
							<!-- 视频截图url -->
							<img src="<%=collegeVoiceVideoBean.getZqy_video_pic_url() %>" />
						</div>
						<div class="demo-content">
						<!-- 视频标题 -->
							<div class="demo-content-title"><%=collegeVoiceVideoBean.getZqy_video_name()%></div>
							<!-- 视频简介 -->
							<div class="demo-content-intro">
								<%=collegeVoiceVideoBean.getZqy_video_intro() %>
							</div>
							<div class="demo-content-foot">
								<i class="glyphicon glyphicon-user demo-foot-usericon"></i>
								<!-- 上传者 -->
								<span class="demo-foot-username"><%=collegeVoiceVideoBean.getZqy_video_uploader() %></span>
								<!-- 播放次数 -->
								<i class="glyphicon glyphicon-play-circle demo-foot-usericon demo-foot-playtime"></i>
								<span class="demo-foot-username"><%=collegeVoiceVideoBean.getZqy_video_played_number() %></span>
							</div>
						</div>
					</div>
			</a>
			<%
					}
				} else {
					out.println("<font color='red'>视频列表加载失败，请刷新重试！</font>");
				}
			%>
				
			<!--内容结束部分-->
			<!--分页部分开始 -->
			<div class="page_roll">
				<div class="btn-group">
				<%
						CollegeVoicePagerBean collegeVoicePagerBean =  (CollegeVoicePagerBean) request.getAttribute("collegeVoicePagerBean");
						if (collegeVoicePagerBean != null) {
				%>
					<button type="button" class="btn btn-default" onclick="window.location.href='CollegeVoiceVideoPager?current_pageno=1'"><span class="glyphicon glyphicon-home">首页</span></a></button>
					<button type="button" class="btn btn-default" onclick="window.location.href='CollegeVoiceVideoPager?current_pageno=<%=collegeVoicePagerBean.getCurPage() - 1%>'"><span class="glyphicon glyphicon-circle-arrow-left">上一页</span></button>
					<button type="button" class="btn btn-default" onclick="window.location.href='CollegeVoiceVideoPager?current_pageno=<%=collegeVoicePagerBean.getCurPage() + 1%>'"><span class="glyphicon glyphicon-circle-arrow-right">下一页</span></button>
					<button type="button" class="btn btn-default" style="margin-right: 10px;" onclick="window.location.href='CollegeVoiceVideoPager?current_pageno=<%=collegeVoicePagerBean.getMaxPage()%>'"><span class="glyphicon glyphicon-play">尾页</span></button>
					<span>
							<form action="CollegeVoiceVideoPager" method="post">
							<div class="input-group">
      							<input type="text" class="form-control" name="current_pageno" size="2" maxlength="2"  placeholder="跳转到" maxlength="3"/>
     							<span class="input-group-btn">
       								<button class="btn btn-success" type="submit">Go!</button>
     					 		</span>
							</div>
							</form>
					</span>
				<%
					}
				%>
				</div>

			</div>
			<!--分页部分结束 -->
		</div>

		<!-- 视频列表结束-->
		<!--推荐部分开始-->
		<div id="right">
			<div id="recommend">
				<div class="recommend-logo">
					<i class="glyphicon glyphicon-star recommend-logo-icon"></i>
					<span class="recommend-logo-img"></span>
				</div>
				<!-- 推荐视频获取 -->
				<%  
					if (collegeVoiceVideoRecommendation != null) {
						for (CollegeVoiceVideoBean collegeVoiceVideoRecommendationElement : collegeVoiceVideoRecommendation) {
				%>
				<!-- 推荐视频链接 -->
				<a href="CollegeVoiceVideoPlayPage?id=<%=collegeVoiceVideoRecommendationElement.getZqy_video_id()%>">
					<dl>
						<!-- 视频截图 -->
						<dt><img src="<%=collegeVoiceVideoRecommendationElement.getZqy_video_pic_url() %>" width="220px" height="85px" alt="sss"></dt>
						<!-- 视频名称 -->
						<dd><%=collegeVoiceVideoRecommendationElement.getZqy_video_name() %></dd>
					</dl>
				</a>		
				<% 		} 
					} else { %>
				<a href="#">
					<dl>
						<dt><img src="img/recomdation_notfound.jpg" width="220px" height="85px" alt="sss"></dt>
						<dd>推荐视频获取失败请刷新页面</dd>
					</dl>
				</a>	
				<% } %>			
			</div>
			
			
			<!--广告位开始 -->
			<div class="adviertisement">
			</div>
			<!--广告位结束 -->

		</div>

		</div>
		<!--推荐部分结束-->
		<!-- 内容列表结束-->
		</div><!-- 此div界定了footer的范围 -->
		<!--foot部分开始-->
		<div class="footer">
			<!--上层-->
			<div class="footer-content">
				<div class="footer-first-level">
					<div class="first-level">
						<i class="glyphicon glyphicon-plane"></i>
						<span class="footer-title">新手上路</span>
						<ul class="nav">
							<li class="nav-divider"></li>
							<li>会员注册</li>
							<li>会员分类</li>
							<li>注册太阳在线会员</li>
							<li>网站浏览手册</li>
						</ul>
					</div>
					<div class="first-level">
						<i class="glyphicon glyphicon-duplicate"></i>
						<span class="footer-title">会员须知</span>
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
						<i class="glyphicon glyphicon-thumbs-up"></i>
						<span class="footer-title">服务保障</span>
						<ul class="nav">
							<li class="nav-divider"></li>
							<li>隐私保护</li>
							<li>十大保障</li>
							<li>24小时客服</li>
						</ul>
					</div>
					<div class="first-level">
						<i class="glyphicon glyphicon-user"></i>
						<span class="footer-title">关于我们</span>
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
						<img src="img/erweima.png" />
						<img src="img/erweima2.png" class="footer-img-control" /><br />
						<span>扫二维码，关注太阳在线官方微信平台</span>
					</div>
				</div>
				<div class="footer-second-level">
					(c)2015-2016 山西太阳在线 SYSTEM All Rights Reserved
				</div>
			</div>
		</div>

		
		<!--foot部分结束-->

		<script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script>
			//设置自适应效果【中间内容】
			$(function() {
				var height = $("html").width() - $(".content").width();
				$(".content").css("margin-left", height / 2 + "px");
				$(window).resize(function() {
					height = $("html").width() - $(".content").width();
					if (height > 0) {
						$(".content").css("margin-left", height / 2 + "px");
					}
				});
				//
				$('.carousel').carousel(); //轮播
			});
		</script>
	</body>

</html>