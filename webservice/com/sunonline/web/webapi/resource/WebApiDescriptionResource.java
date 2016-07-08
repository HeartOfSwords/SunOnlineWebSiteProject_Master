package com.sunonline.web.webapi.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sunonline.web.webapi.bean.WebApiLinks;
import com.sunonline.web.webapi.bean.WebApiRoot;

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
		videos.setRel("description, webapi/videos");
		videos.setHref("webapi/videos");
		videos.setTitle("太阳在线视频API根路径");
		videos.setType("MediaType.APPLICATION_JSON");
		links.add(videos);
		//按课程id和页码获取课程列表
		WebApiLinks mooc = new WebApiLinks();	
		mooc.setRel("description, webapi/mooc");
		mooc.setHref("webapi/mooc");
		mooc.setTitle("太阳在线公益课堂API根路径");
		mooc.setType("MediaType.APPLICATION_JSON");
		links.add(mooc);
		//按照课程id和某一节课具体的id获取课程单体信息
		WebApiLinks images = new WebApiLinks();	
		images.setRel("collection, /webapi/images");
		images.setHref("/webapi/images");
		images.setTitle("太阳在线图片API路径");
		images.setType("MediaType.APPLICATION_JSON");
		links.add(images);
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
		higoPathDescription.setRel("collection, webapi/videos/higovideo");
		higoPathDescription.setHref("webapi/videos/higovideo");
		higoPathDescription.setTitle("Higo大学季");
		higoPathDescription.setType("MediaType.APPLICATION_JSON");
		higoPathDescription.setPicUrl("");
		higoPathDescription.setIntroduceMessage("");
		links.add(higoPathDescription);
		//老司机项
		WebApiLinks oldDriverVideoPathDescription = new WebApiLinks();	
		oldDriverVideoPathDescription.setRel("collection, webapi/videos/olddriver");
		oldDriverVideoPathDescription.setHref("webapi/videos/olddriver");
		oldDriverVideoPathDescription.setTitle("影视老司机");
		oldDriverVideoPathDescription.setType("MediaType.APPLICATION_JSON");
		oldDriverVideoPathDescription.setPicUrl("");
		oldDriverVideoPathDescription.setIntroduceMessage("");
		links.add(oldDriverVideoPathDescription);
		//高校最强音列表项
		WebApiLinks collegeVoicePathDescription = new WebApiLinks();
		collegeVoicePathDescription.setRel("collection, webapi/videos/collegevoice");
		collegeVoicePathDescription.setHref("webapi/videos/collegevoice");
		collegeVoicePathDescription.setTitle("高校最强音");
		collegeVoicePathDescription.setType("MediaType.APPLICATION_JSON");
		collegeVoicePathDescription.setPicUrl("");
		collegeVoicePathDescription.setIntroduceMessage("");
		links.add(collegeVoicePathDescription);
		
		//主页推荐列表项
		WebApiLinks indexPathDescription = new WebApiLinks();
		indexPathDescription.setRel("collection, webapi/videos/main");
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
		shanXiCollegePicLibraryDescription.setRel("collection, webapi/images/sxcollegepiclib");
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
		videos.setRel("collection, webapi/videos/higovideo/all");
		videos.setHref("webapi/videos/higovideo/all");
		videos.setTitle("Higo大学季获取所有视频列表");
		videos.setType("MediaType.APPLICATION_JSON");
		links.add(videos);
		//按id/期数获取视频
		WebApiLinks videoById = new WebApiLinks();	
		videoById.setRel("collection, webapi/videos/higovideo/all/{id}");
		videoById.setHref("webapi/videos/higovideo/all/{id}");
		videoById.setTitle("Higo大学季按照期数获取视频");
		videoById.setType("MediaType.APPLICATION_JSON");
		links.add(videoById);
		//获取推荐视频
		WebApiLinks recommendVideos = new WebApiLinks();
		recommendVideos.setRel("collection, webapi/videos/higovideo/all/recommendation");
		recommendVideos.setHref("webapi/videos/higovideo/all/recommendation");
		recommendVideos.setTitle("Higo大学季推荐视频");
		recommendVideos.setType("MediaType.APPLICATION_JSON");
		links.add(recommendVideos);
		
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
		videos.setRel("collection, webapi/videos/olddriver/all");
		videos.setHref("webapi/videos/olddriver/all");
		videos.setTitle("影视老司机获取所有视频列表");
		videos.setType("MediaType.APPLICATION_JSON");
		links.add(videos);
		//按id/期数获取视频
		WebApiLinks videoById = new WebApiLinks();	
		videoById.setRel("collection, webapi/videos/olddriver/all/{id}");
		videoById.setHref("webapi/videos/olddriver/all/{id}");
		videoById.setTitle("影视老司机按照期数获取视频");
		videoById.setType("MediaType.APPLICATION_JSON");
		links.add(videoById);
		//获取推荐视频
		WebApiLinks recommendVideos = new WebApiLinks();
		recommendVideos.setRel("collection, webapi/videos/olddriver/all/recommendation");
		recommendVideos.setHref("webapi/videos/olddriver/all/recommendation");
		recommendVideos.setTitle("影视老司机推荐视频");
		recommendVideos.setType("MediaType.APPLICATION_JSON");
		links.add(recommendVideos);
		
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
		videos.setRel("collection, webapi/videos/collegevoice/all");
		videos.setHref("webapi/videos/collegevoice/all");
		videos.setTitle("高校最强音获取所有视频列表");
		videos.setType("MediaType.APPLICATION_JSON");
		links.add(videos);
		//按id/期数获取视频
		WebApiLinks videoById = new WebApiLinks();	
		videoById.setRel("collection, webapi/videos/collegevoice/all/{id}");
		videoById.setHref("webapi/videos/collegevoice/all/{id}");
		videoById.setTitle("高校最强音按照期数获取视频");
		videoById.setType("MediaType.APPLICATION_JSON");
		links.add(videoById);
		//获取推荐视频
		WebApiLinks recommendVideos = new WebApiLinks();
		recommendVideos.setRel("collection, webapi/videos/collegevoice/all/recommendation");
		recommendVideos.setHref("webapi/videos/collegevoice/all/recommendation");
		recommendVideos.setTitle("高校最强音推荐视频");
		recommendVideos.setType("MediaType.APPLICATION_JSON");
		links.add(recommendVideos);
		
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
		schools.setRel("collection, webapi/images/sxcollegepiclib/schools");
		schools.setHref("webapi/images/sxcollegepiclib/schools");
		schools.setTitle("山西高校图片库所有学校列表");
		schools.setType("MediaType.APPLICATION_JSON");
		links.add(schools);
		//按学校名称获取对应学校的图片
		WebApiLinks picsBySchoolName = new WebApiLinks();	
		picsBySchoolName.setRel("collection, webapi/images/sxcollegepiclib/pictures/{schoolname}");
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
		index.setRel("collection, webapi/mooc/index");
		index.setHref("webapi/mooc/index");
		index.setTitle("公益课堂所有分类及其之下的视频列表");
		index.setType("MediaType.APPLICATION_JSON");
		links.add(index);
		//按课程id和页码获取课程列表
		WebApiLinks courselists = new WebApiLinks();	
		courselists.setRel("collection, webapi/mooc/index/courselists?c_pageno=?&c_id=?");
		courselists.setHref("webapi/mooc/index/courselists?c_pageno=?&c_id=?");
		courselists.setTitle("分页获取某一个具体课程下的课程列表");
		courselists.setType("MediaType.APPLICATION_JSON");
		links.add(courselists);
		//按照课程id和某一节课具体的id获取课程单体信息
		WebApiLinks courseitem = new WebApiLinks();	
		courseitem.setRel("single, /webapi/mooc/index/courseitem?itemid=?&c_id=?");
		courseitem.setHref("/webapi/mooc/index/courseitem?itemid=?&c_id=?");
		courseitem.setTitle("按照课程id和某一节课具体的id获取课程单体信息即播放页信息,同时增加视频播放次数");
		courseitem.setType("MediaType.APPLICATION_JSON");
		links.add(courseitem);
		webApiRoot.setLinks(links);
		return webApiRoot;
	}
	
}
