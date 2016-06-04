<!-- author：李鹏鹏、段吉贵 -->
<!-- 引入相关包 -->
<%@page import="java.util.List"%>
<%@page import="com.sunonline.web.bean.HigoVideoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<!-- 获取HigoVideoBean实体 -->
    <%	
		//获取视频信息实体
		HigoVideoBean higoVideoBean = (HigoVideoBean)request.getAttribute("higoVideoInfo");
		//逐条获取视频信息
		int video_id = higoVideoBean.getHigoVideoId();						//视频id
		String video_url = higoVideoBean.getHigoVideoUrl();					//视频链接
		String video_name = higoVideoBean.getHigoVideoName();				//视频名称
		Date upload_date = higoVideoBean.getHigoVideoDate();				//上传时间
		String pic_url = higoVideoBean.getHigoVideoPicUrl();				//图片url
		int played_time = higoVideoBean.getHigoVideoPlayedNumber();			//播放次数
		String video_intro = higoVideoBean.getHigoVideoIntro();				//视频简介
		String video_uploader = higoVideoBean.getHigoVideoUploader();		//上传者
		//获取推荐视频
		List<HigoVideoBean> higoVideoRecommendation = (List<HigoVideoBean>)request.getAttribute("higoVideoRecommendation");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HIGO大学季-<%=video_name %></title>
		<meta charset="utf-8">
		<meta http-equiv="Expires" content="0">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-control" content="no-cache">
		<meta http-equiv="Cache" content="no-cache">
		<link rel="icon" href="img/favicon.ico" type=”image/x-icon”>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/higovideo_header.css" />
		<link rel="stylesheet" type="text/css" href="css/footer.css" />
		<link rel="stylesheet" type="text/css" href="css/video-js.min.css" />
		<link rel="stylesheet" href="css/content.css" />
		<script src="js/video.min.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
	<!--标题导航栏开始   -->
		<!-- 毛玻璃过滤部分-->
		<div class="nav_back"></div>
		<!-- 毛玻璃过滤结束部分-->
		<div class="header">
			<div class="nav-content">
				<img src="img/logo.png" width="180px" height="50px" alt="太阳在线" class="nav-style" />
				<ul class="list-unstyled list-inline nav-style" id="logo_right">
					<li><a href="index.jsp">首页</a></li>
					<li><a href="HigoPage">HIGO大学季</a></li>
					<li><a href="#">影视老司机</a></li>
					<li><a href="#">高校最强音</a></li>
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
	
	<!-- higo_playpage.jsp开始 -->
		<!-- 专栏logo栏开始-->
		<div class="column_logo ">
		</div>
		<!-- 专栏logo栏结束-->

		<!-- 中间部分开始-->
		<div class="content">
			<!--视频播放部分开始-->
			<div class="content-vedio-play">
				<div class="video-title">
					<div class="video-title-logo">
						<span class="glyphicon glyphicon-home video-title-logo-icon"></span>
						<span class="video-title-logo-img">
							</span>
					</div>
					<div class="video-rode-nav">
						<ol class="breadcrumb">
							<li><a href="index.jsp">首页</a></li>
							<li><a href="HigoPager">HIGO大学季</a></li>
							<li class="active"><%=video_name %></li>
						</ol>
					</div>
					<div class="video-info">
						<i class="glyphicon glyphicon-user"></i>
						<!-- 上传者 -->
						<span><%=video_uploader %></span>
						<i class="glyphicon glyphicon-play-circle left-move"></i>
						<!-- 播放次数 -->
						<span><%=String.valueOf(played_time) %></span>
						<i class="glyphicon glyphicon-time left-move"></i>
						<!-- 上传日期 -->
						<span><%=new SimpleDateFormat().format(upload_date) %></span>
					</div>
					<!--上方广告位预留开始-->
					<div class="video-advertisement-top">

					</div>
					<!--上方广告位预留结束-->
				</div>
				<!--video.js播放器开始-->
				<div class="video-player">
					<video id="videojs" class="video-js vjs-default-skin vjs-big-play-centered" controls preload="auto" data-setup='' poster="<%=pic_url %>">
						<source id="mp4" src="<%=video_url %>" type="video/mp4"/>
					</video>
				</div>
				<!--video.js播放器结束-->
				<!--固定定位广告预留位开始-->
				<!--左方预留位-->
				<div class="fixed-advertisement-left">

				</div>
				<!--右方预留位-->
				<div class="fixed-advertisement-right">

				</div>
				<!--固定定位广告预留位结束-->
			</div>
			<!--视频播放部分结束-->
			<!--视频简介部分开始-->
			<div class="content-video-intro">
				<hr />
				<div class="video-intro-control">
					<div>
						<strong>
							视频简介：
						</strong>
					</div>
					<div class="control-words">
						<%=video_intro %>
					</div>
				</div>
				<hr />
			</div>
			<!--视频简介部分结束-->
			<!--评论框、视频推荐部分开始-->
			<div class="content-review-recommend container">
				<div class="row">
					<div class="review col-md-8">
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
					
					<!-- 推荐视频区域 -->
					<div class="recommend col-md-4">
						<div class="recommend-logo">
							<i class="glyphicon glyphicon-star recommend-logo-icon"></i>
							<span class="recommend-logo-img"></span>
						</div>
						
						<!--分隔线-->
						<div class="divider"></div>
						
						<%  
							if (higoVideoRecommendation != null) {
								for (HigoVideoBean higoVideoRecommendationElement : higoVideoRecommendation) {
						%>
						<!--分隔线-->
						
						<div class="recommend-content">
							<a href="HigoVideoPlayPage?id=<%=higoVideoRecommendationElement.getHigoVideoId()%>">
								<div class="recommend-content-img">
									<img src="<%=higoVideoRecommendationElement.getHigoVideoPicUrl() %>"/>
								</div>
								<div class="recommend-content-title">
									<!-- 推荐视频名称 -->
									<span><%=higoVideoRecommendationElement.getHigoVideoName() %></span>
								</div>
							</a>
						</div>
						<div class="divider divider-top"></div>
						<% 		} 
							} else { %>
								<div class="divider"></div>
								<div class="recommend-content">
									<a href="#">
										<div class="recommend-content-img">
											<img src="" />
										</div>
										<div class="recommend-content-title">
											<span>获取视频失败</span>
										</div>
									</a>
								</div>
						<% } %>				
						
					</div>
				</div>
			</div>
			<!--评论框、视频推荐部分结束-->
		</div>
		<!-- 中间部分结束-->
	<!-- higo_playpage.jsp结束 -->
	
	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>