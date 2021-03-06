<%@page import="com.sunonline.web.bean.OldDriverVideoBean"%>
<%@page import="com.sunonline.web.bean.HigoVideoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
    <%	
		//获取视频信息实体
		OldDriverVideoBean oldDriverVideoBean = (OldDriverVideoBean)request.getAttribute("oldDriverVideoInfo");
		//逐条获取视频信息
		int video_id = oldDriverVideoBean.getLSJ_video_id();
		String video_url = oldDriverVideoBean.getLSJ_video_url();
		String video_name = oldDriverVideoBean.getLSJ_video_name();
		Date upload_date = oldDriverVideoBean.getLSJ_video_date();
		String pic_url = oldDriverVideoBean.getLSJ_video_pic_url();
		int played_time = oldDriverVideoBean.getLSJ_video_played_number();
		String video_intro = oldDriverVideoBean.getLSJ_video_intro();
		String video_uploader = oldDriverVideoBean.getLSJ_video_uploader();
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/video-js.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/video.min.js"></script>
<title>影视老司机-<%=video_name %></title>
</head>
<body>
<div>
	<h2><p>播放器</p></h2>
		</div>
		<div class="video_player">
			<video id="player" class="video-js vjs-default-skin vjs-big-play-centered" controls preload="none" width="640" height="264" poster="http://video-js.zencoder.com/oceans-clip.png" data-setup="{}">
		    		<source id="mp4" src="<%=video_url %>"/>
		    		<source src="<%=video_url %>" type='video/webm' />
		    		<track kind="captions" src="demo.captions.vtt" srclang="en" label="English"></track><!-- Tracks need an ending tag thanks to IE9 -->
		    		<track kind="subtitles" src="demo.captions.vtt" srclang="en" label="English"></track><!-- Tracks need an ending tag thanks to IE9 -->	
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
		</div>
		
</body>
</html>