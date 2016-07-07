<%@page import="java.util.List"%>
<%@page import="com.sunonline.web.bean.HigoVideoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
    <%	
		//获取视频信息实体
		HigoVideoBean higoVideoBean = (HigoVideoBean)request.getAttribute("higoVideoInfo");
		//逐条获取视频信息
		int video_id = higoVideoBean.getHigoVideoId();
		String video_url = higoVideoBean.getHigoVideoUrl();
		String video_name = higoVideoBean.getHigoVideoName();
		Date upload_date = higoVideoBean.getHigoVideoDate();
		String pic_url = higoVideoBean.getHigoVideoPicUrl();
		int played_time = higoVideoBean.getHigoVideoPlayedNumber();
		String video_intro = higoVideoBean.getHigoVideoIntro();
		String video_uploader = higoVideoBean.getHigoVideoUploader();
		//获取推荐视频
		List<HigoVideoBean> higoVideoRecommendation = (List<HigoVideoBean>)request.getAttribute("higoVideoRecommendation");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/video-js.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/video.min.js"></script>
<title>Higo大学季-<%=video_name %></title>
</head>
<body>
		<div>
			<h2><p>播放器</p></h2>
		</div>
		<div class="video_player">
			<video id="player" class="video-js vjs-default-skin vjs-big-play-centered" controls preload="none" width="640" height="264" poster="http://video-js.zencoder.com/oceans-clip.png" data-setup="{}">
		    		<source id="mp4" src="<%=video_url %>" type="video/mp4"/>
    		</video>
		</div>
		<hr>
		<div>
			<h2><p>视频信息</p></h2>
		</div>
		<div class="video_message" onclick="getVideoDatas();">
			视频id:<span><%=String.valueOf(video_id)%></span><br/>
			视频名称:<span><%=video_name %></span><br/>
			上传日期:<span><%=new SimpleDateFormat().format(upload_date) %></span><br/>
			视频链接:<span><%=video_url %></span><br/>
			播放次数:<span><%=String.valueOf(played_time) %></span><br/>
			视频信息:<span><%=video_intro %></span>
			上传者:<span><%=video_uploader %></span>
			<%=pic_url %>
		</div>
		<div>
			<h2>推荐视频</h2>
		</div>
		<%
		for (HigoVideoBean higoVideoRecommendationElement : higoVideoRecommendation) {
			out.println("推荐视频如下：" + higoVideoRecommendationElement.getHigoVideoId() + higoVideoRecommendationElement.getHigoVideoIntro());
		}
		%>
		
		
</body>
</html>