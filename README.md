# SunOnlineWebSiteProject_Master
太阳在线网站主分支
##分支

1. master
2. taxuewwl
3. lppking
4. duanjigui 

##5.11日志

1. 解决注销之后点击返回仍能回到前一页，使用了js中的window.history.foward(1);
2. 未解决直接输入目标网址即直接登录的bug(管理员主页)，修复方式：配置过滤器Filter
## 5.12日志
1. 修复css不能加载的问题，重新设置开发新的管理登录
2. 提交新的主分支

## 5.31日志

1. 通过在sql链接的URL后添加“&zeroDateTimeBehavior=convertToNull”解决
抛出“Value ‘0000-00-00 can not be represented as java.sql.date’”

## 6.2日志

1. 选择higo大学季最新四条视频（选取id大于总数-4的所有视频）
SELECT
	*
FROM
	video
WHERE
	video_id > (
		SELECT
			count(*)
		FROM
			video
	) - 4;
	
## 6.3日志

1. 添加favicon 
<link rel="icon" href="img/favicon.ico" type=”image/x-icon”>

## 6.7日志
视频大小更改video标签属性添加width="970px" height="540px"

## 6.8访问老司机空指针异常
## 7.9打包部署到ubuntu server之后运行报错

	Unsupported major.minor version 52.0

解决方法：
	
	Properties-->JAVA Compiler-中的Compiler compliance level从1.8改成1.7，之后就可以运行了。

## 7.11笔记

webapi中添加功能：获取每一个课程类别下的最新一条数据通过

	SELECT a.* 
	 
	FROM smooc_courselist a 
	 
	WHERE 
	 
	( 
	  SELECT COUNT(*) 
	 
	  FROM smooc_courselist 
	 
	  WHERE c_id= a.c_id
	 
	  AND cl_id < a.cl_id 
	 
	) < 1 
实现