package com.sunonline.web.utils;

import java.util.Random;

/**
 * 用户工具类
 * @author snowalker
 * 16.7.15
 */
public class UserUtils {
	
	//定义初始用户名集合
	private static String[] usernames = new String[] {
		"潇湘书笛", "邀月对影", "心源清波", "大道无心", "锦瑟迷音",
		"长发为君留", "梦寻千古香", "庭前暮雨过", "坐听松风寒", "后庭花破子",
		"剪水燕", "青丝锁", "风满袖", "疑云袖", "花解语",
		"Allure Love", "Koreyoshi", "Rosemarry", "Cinderella", "PsEuDO",
		"猫的薛定谔", "特斯拉蒸汽朋克", "黑洞尽头", "月黑之时", "日珥边缘",
		"淋雪落虹", "白云玉月", "飘逸春秋", "秋风落叶", "浮云孤蓬",
		"往事如烟", "古道西风", "独狼", "游魂", "残花败柳 ",
		"谁堪共语 ", "乘风破浪", "心飞飘雨", "静听飞涛溅瀑声", "多事从来笑汉疏",
		"夜雨", "夜来寒雨朝送晴", "烟蓑笠", "浪迹红尘乐未央", "风尘一布衣",
		"与美徘徊水石间", "不妨啸傲过平生  ", "诗若", "蒹葭苍苍", "飞泉鸣玉",
		"寒霜之刃", "不眠之魂", "澄澈之眼", "风霜之剑", "狂热之灵"
	};
  	//生成随机用户名
	public static String generateRandomUsername() {
		Random rand = new Random();		//随机数生成器
		int index = rand.nextInt(19);	//生成0-19以内的下标
		int StringAfter = rand.nextInt(100000);
		return usernames[index] + "@" + StringAfter;		//返回指定下标的预设用户昵称
	}
	
	public static void main(String[] args) {
		System.out.println(UserUtils.generateRandomUsername());
	}
}
