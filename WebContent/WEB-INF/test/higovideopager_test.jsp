<%@page import="com.sunonline.web.bean.pager.HigoPagerBean"%>
<%@page import="com.sunonline.web.bean.HigoVideoBean"%>
<%@page import="com.sunonline.web.dao.higo.HigoVideoDaoImpl"%>
<%@page import="com.sunonline.web.dao.higo.HigoVideoDao"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	HigoVideoDao higoVideoDao = new HigoVideoDaoImpl();
	List<HigoVideoBean> higoVideos = higoVideoDao.fetchAllVideos();
	
	//获取推荐视频
	List<HigoVideoBean> higoVideoRecommendation = (List<HigoVideoBean>)request.getAttribute("higoVideoRecommendation");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">


<link rel="stylesheet" href="css/bootstrap.min.css">

<title>Higo大学季</title>
<style type="text/css">
	list{
		float:left;
	}
	#title {
		margin-top: 100px;
	}
</style>
</head>
<body>
		
	<h1>分页获取</h1><hr>
	<%
		List<HigoVideoBean> higoVideoBeans = (List<HigoVideoBean>) request.getAttribute("higoVideoList");
		if (higoVideoBeans != null && higoVideoBeans.size() >0) {
	%>
	<table>
		<tr>
			<td>视频id</td>
			<td>视频名称</td>
			<td>上传日期</td>
			<td>url</td>
			<td>截图url</td>
			<td>播放次数</td>
			<td>视频简介</td>
			<td>上传者</td>
		</tr>
		<%
			for (HigoVideoBean higoVideoBean : higoVideoBeans) {
		%>
		<tr>
			<td><%=higoVideoBean.getHigoVideoId()%></td>
			<td><a href="HigoVideoPlayPage?id=<%=higoVideoBean.getHigoVideoId()%>"><%=higoVideoBean.getHigoVideoName()%></a></td>
			<td><%=higoVideoBean.getHigoVideoDate()%></td>
			<td><a href="<%=higoVideoBean.getHigoVideoUrl() %>"><%=higoVideoBean.getHigoVideoUrl() %></a></td>
			<td><a href="<%=higoVideoBean.getHigoVideoPicUrl() %>"><%=higoVideoBean.getHigoVideoPicUrl() %></a></td>
			<td><%=higoVideoBean.getHigoVideoPlayedNumber() %></td>
			<td><%=higoVideoBean.getHigoVideoIntro() %></td>
			<td><%=higoVideoBean.getHigoVideoUploader() %></td>
		</tr>
		<%
			}
			} else {
		%>
		<tr>
			<td colspan="3">无数据</td>
		</tr>

		<%
			}
		%>
	</table>
	
	
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
						
	<h2>页码</h2>
		<%
			HigoPagerBean higoVideoPagerBean = (HigoPagerBean) request.getAttribute("higoPagerBean");
			if (higoVideoPagerBean != null) {
		%>
				<button type="button" class="btn btn-primary navbar-btn">首页</button></a>
				<a
				href="HigoPager?current_pageno=<%=higoVideoPagerBean.getCurPage() - 1%>"><button type="button" class="btn btn-success navbar-btn" onclick="window.location.href='HigoPager?current_pageno=<%=higoVideoPagerBean.getCurPage() - 1%>'">上一页</button></a>
				
				<a
				href="HigoPager?current_pageno=<%=higoVideoPagerBean.getCurPage() + 1%>"><button type="button" class="btn btn-success navbar-btn">下一页</button></a>
				<a
				href="HigoPager?current_pageno=<%=higoVideoPagerBean.getMaxPage()%>"><button type="button" class="btn btn-primary navbar-btn">尾页</button></a>
				<form action="HigoPager">
					跳转到<input type="text" name="current_pageno" size="2" maxlength="2"/>页
					<button type="submit" class="btn btn-primary navbar-btn" data-toggle="tooltip" title="提交">Go</button>
				</form> 
		<%
			}
		%>
		
		<script type="text/javascript" src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>