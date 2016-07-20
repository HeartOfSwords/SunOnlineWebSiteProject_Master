package com.sunonline.web.webapi.resource;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.sunonline.web.global.StringGlobal;
import com.sunonline.web.webapi.bean.IndexApiNode;
import com.sunonline.web.webapi.bean.videos.CollegeVoiceVideoBean;
import com.sunonline.web.webapi.bean.videos.HigoVideoBean;
import com.sunonline.web.webapi.bean.videos.OldDriverVideoBean;
import com.sunonline.web.webapi.bean.videos.Recommendation;

/**
 * 主页资源
 * 
 * @author SnoWalker.wwl 2016.6.21
 */
@Path(value = "")
public class IndexResource {

	/**
	 * 返回主页main路径下的目录推荐Json文档 通过Recommendation作为中间变量 分别通过遍历接受各个列表的实体数据
	 * 重新组装并装入主页的IndexApiNode中成为推荐Node的 子节点中的列表数据
	 */
	@Path("videos/main")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<IndexApiNode> getIndexVideoInfos() {

		List<IndexApiNode> indexApiNodes = new ArrayList<>();
		// 组装higolist
		IndexApiNode higoLists = getHigoListNodes();
		indexApiNodes.add(higoLists);
		// 组装老司机list
		IndexApiNode oldDriverList = getOldDriverListNodes();
		indexApiNodes.add(oldDriverList);
		// 组装最强音list
		IndexApiNode collegeVideoList = getCollegeVoiceListNodes();
		indexApiNodes.add(collegeVideoList);

		return indexApiNodes;

	}

	// 获取最强音列表部分
	private IndexApiNode getCollegeVoiceListNodes() {
		IndexApiNode collegeVoiceLists = new IndexApiNode();

		collegeVoiceLists.setName("高校最强音");
		collegeVoiceLists.setPicUrl("http://o95fizdxg.bkt.clouddn.com/iPhone%E6%9C%80%E5%BC%BA%E9%9F%B3.png");
		collegeVoiceLists.setIntro("最强音介绍");
		collegeVoiceLists.setPagerUrl(StringGlobal.STRING_IP_HOSTNAME + "/webapi/videos/collegevoice/pager?pageno=");

		// 组装最强音推荐列表
		List<Recommendation> collegeVoiceRecommendations = buildcollegeVoiceRecommendation();
		collegeVoiceLists.setRecommendations(collegeVoiceRecommendations);
		return collegeVoiceLists;
	}

	// 组装最强音推荐列表
	private List<Recommendation> buildcollegeVoiceRecommendation() {
		// 最强音推荐
		List<Recommendation> collegeVoiceRecommendations = new ArrayList<>();
		
		
		// 最强音列表读取
		List<CollegeVoiceVideoBean> collegeVoiceBeans = new CollegeVoiceVideoResource()
				.getCollegeVoiceVideoRecommendation();
		for (CollegeVoiceVideoBean collegeVoiceVideoBean : collegeVoiceBeans) {
			
			// Recommendation实体
			Recommendation recommendation = new Recommendation();
			// 遍历原始数据重新组装bean
			recommendation.setVideoDate(collegeVoiceVideoBean.getVideoDate());
			recommendation.setVideoId(collegeVoiceVideoBean.getVideoId());
			recommendation.setVideoIntro(collegeVoiceVideoBean.getVideoIntro());
			recommendation.setVideoName(collegeVoiceVideoBean.getVideoName());
			recommendation.setVideoPicUrl(collegeVoiceVideoBean.getVideoPicUrl());
			recommendation.setVideoPlayedNumber(collegeVoiceVideoBean.getVideoPlayedNumber());
			recommendation.setVideoUploader(collegeVoiceVideoBean.getVideoUploader());
			recommendation.setVideoUrl(collegeVoiceVideoBean.getVideoUrl());

			collegeVoiceRecommendations.add(recommendation);
		}
		return collegeVoiceRecommendations;
	}

	// 获取老司机列表部分
	private IndexApiNode getOldDriverListNodes() {
		IndexApiNode oldDriverLists = new IndexApiNode();

		oldDriverLists.setName("影视老司机");
		oldDriverLists.setPicUrl("http://o95fizdxg.bkt.clouddn.com/iPhone%E8%80%81%E5%8F%B8%E6%9C%BA.png");
		oldDriverLists.setIntro("老司机介绍");
		oldDriverLists.setPagerUrl(StringGlobal.STRING_IP_HOSTNAME + "/webapi/videos/olddriver/pager?pageno=");
		List<Recommendation> oldDriverRecommendations = buildOldDriverRecommendation();
		oldDriverLists.setRecommendations(oldDriverRecommendations);
		return oldDriverLists;
	}

	// 组装老司机推荐列表
	private List<Recommendation> buildOldDriverRecommendation() {
		// 老司机推荐
		List<Recommendation> oldDriverRecommendations = new ArrayList<>();
		
		// 老司机列表读取
		List<OldDriverVideoBean> higoVideoBeans = new OldDriverVideoResource().getOldDriverVideoRecommendation();
		for (OldDriverVideoBean oldDriverVideoBean : higoVideoBeans) {
			// Recommendation实体
			Recommendation recommendation = new Recommendation();
			// 遍历原始数据重新组装bean
			recommendation.setVideoDate(oldDriverVideoBean.getVideoDate());
			recommendation.setVideoId(oldDriverVideoBean.getVideoId());
			recommendation.setVideoIntro(oldDriverVideoBean.getVideoIntro());
			recommendation.setVideoName(oldDriverVideoBean.getVideoName());
			recommendation.setVideoPicUrl(oldDriverVideoBean.getVideoPicUrl());
			recommendation.setVideoPlayedNumber(oldDriverVideoBean.getVideoPlayedNumber());
			recommendation.setVideoUploader(oldDriverVideoBean.getVideoUploader());
			recommendation.setVideoUrl(oldDriverVideoBean.getVideoUrl());

			oldDriverRecommendations.add(recommendation);
		}
		return oldDriverRecommendations;
	}

	// 获取higo列表部分
	private IndexApiNode getHigoListNodes() {
		IndexApiNode higoLists = new IndexApiNode();

		higoLists.setName("Higo大学季");
		higoLists.setPicUrl("http://o95fizdxg.bkt.clouddn.com/iPhone%E5%A4%A7%E5%AD%A6%E5%AD%A3.png");
		higoLists.setIntro("Higo大学季介绍");
		higoLists.setPagerUrl(StringGlobal.STRING_IP_HOSTNAME + "/webapi/videos/higovideo/pager?pageno=");
		List<Recommendation> higoRecommendations = buildHigoRecommendation();
		higoLists.setRecommendations(higoRecommendations);
		return higoLists;
	}

	// 组装higo推荐列表
	private List<Recommendation> buildHigoRecommendation() {
		// higo推荐
		List<Recommendation> higoRecommendations = new ArrayList<>();
		
		// higo列表读取
		List<HigoVideoBean> higoVideoBeans = new HigoVideoResource().getHigoVideoRecommendation();
		for (HigoVideoBean higoVideoBean : higoVideoBeans) {
			// Recommendation实体
			Recommendation recommendation = new Recommendation();
			// 遍历原始数据重新组装bean
			recommendation.setVideoDate(higoVideoBean.getVideoDate());
			recommendation.setVideoId(higoVideoBean.getVideoId());
			recommendation.setVideoIntro(higoVideoBean.getVideoIntro());
			recommendation.setVideoName(higoVideoBean.getVideoName());
			recommendation.setVideoPicUrl(higoVideoBean.getVideoPicUrl());
			recommendation.setVideoPlayedNumber(higoVideoBean.getVideoPlayedNumber());
			recommendation.setVideoUploader(higoVideoBean.getVideoUploader());
			recommendation.setVideoUrl(higoVideoBean.getVideoUrl());

			higoRecommendations.add(recommendation);
		}
		return higoRecommendations;
	}

}
