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