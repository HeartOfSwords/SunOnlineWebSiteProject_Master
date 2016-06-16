-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2016-06-15 08:37:34
-- 服务器版本： 10.0.17-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sunonlinedb`
--
CREATE DATABASE IF NOT EXISTS `sunonlinedb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sunonlinedb`;

-- --------------------------------------------------------

--
-- 表的结构 `administrator`
--
-- 创建时间： 2016-04-28 06:26:13
--

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `admin_pwd` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 表的关联 `administrator`:
--

--
-- 转存表中的数据 `administrator`
--

INSERT INTO `administrator` (`admin_id`, `admin_name`, `admin_pwd`) VALUES
(1, 'admin1', 'cb28e00ef51374b841fb5c189b2b91c9'),
(2, 'snowalker', '1bc9462209f3e08508ec564586c90c80');

-- --------------------------------------------------------

--
-- 表的结构 `college_pinoeer_intro`
--
-- 创建时间： 2016-04-28 06:26:13
--

DROP TABLE IF EXISTS `college_pinoeer_intro`;
CREATE TABLE `college_pinoeer_intro` (
  `fcl_id` int(11) NOT NULL,
  `fcl_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `fcl_url` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `fcl_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 表的关联 `college_pinoeer_intro`:
--

-- --------------------------------------------------------

--
-- 表的结构 `college_voice_player`
--
-- 创建时间： 2016-05-28 07:17:39
--

DROP TABLE IF EXISTS `college_voice_player`;
CREATE TABLE `college_voice_player` (
  `player_number` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `player_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `player_gender` tinyint(1) NOT NULL,
  `player_school` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 表的关联 `college_voice_player`:
--

--
-- 转存表中的数据 `college_voice_player`
--

INSERT INTO `college_voice_player` (`player_number`, `player_name`, `player_gender`, `player_school`) VALUES
('001', '张婕妤', 0, '空'),
('002', '卞西墨', 1, '空'),
('003', '张婕妤', 0, '空'),
('004', '武文良', 1, '空');

-- --------------------------------------------------------

--
-- 表的结构 `college_voice_video`
--
-- 创建时间： 2016-06-15 05:49:41
--

DROP TABLE IF EXISTS `college_voice_video`;
CREATE TABLE `college_voice_video` (
  `ZQY_video_id` int(11) NOT NULL,
  `ZQY_video_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ZQY_video_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ZQY_video_date` date NOT NULL,
  `ZQY_video_pic_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `zqy_video_played_number` int(11) NOT NULL DEFAULT '0',
  `player_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `zqy_video_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `zqy_video_uploader` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 表的关联 `college_voice_video`:
--

--
-- 转存表中的数据 `college_voice_video`
--

INSERT INTO `college_voice_video` (`ZQY_video_id`, `ZQY_video_name`, `ZQY_video_url`, `ZQY_video_date`, `ZQY_video_pic_url`, `zqy_video_played_number`, `player_name`, `zqy_video_intro`, `zqy_video_uploader`) VALUES
(1, '《回家》演唱张婕妤', 'http://221.204.210.203/xdispatch/o7zv69viu.bkt.clouddn.com/%E6%9C%80%E5%BC%BA%E9%9F%B3%E3%80%8A%E5%9B%9E%E5%AE%B6%E3%80%8B%E6%BC%94%E5%94%B1%E5%BC%A0%E5%A9%95%E5%A6%A4.mp4', '2016-06-15', 'http://o7zv69viu.bkt.clouddn.com/%E6%9C%80%E5%BC%BA%E9%9F%B3%E3%80%8A%E5%9B%9E%E5%AE%B6%E3%80%8B%E6%BC%94%E5%94%B1%E5%BC%A0%E5%A9%95%E5%A6%A4_pic.png', 1, '张婕妤', '回家道不尽多少愁肠', '管理员'),
(2, '《我用所有报答爱》演唱张婕妤', 'http://221.204.210.203/xdispatch/o7zv69viu.bkt.clouddn.com/%E6%9C%80%E5%BC%BA%E9%9F%B3%E3%80%8A%E6%88%91%E7%94%A8%E6%89%80%E6%9C%89%E6%8A%A5%E7%AD%94%E7%88%B1%E3%80%8B%E6%BC%94%E5%94%B1%E5%BC%A0%E5%A9%95%E5%A6%A4.mp4', '2016-06-15', 'http://o7zv69viu.bkt.clouddn.com/%E6%9C%80%E5%BC%BA%E9%9F%B3%E3%80%8A%E6%88%91%E7%94%A8%E6%89%80%E6%9C%89%E6%8A%A5%E7%AD%94%E7%88%B1%E3%80%8B%E6%BC%94%E5%94%B1%E5%BC%A0%E5%A9%95%E5%A6%A4_pic.png', 1, '张婕妤', '我用所有报答爱', '管理员'),
(3, '《凤凰花开的路口》演唱卞西墨', 'http://o7zv69viu.bkt.clouddn.com/%E6%9C%80%E5%BC%BA%E9%9F%B3%E3%80%8A%E5%87%A4%E5%87%B0%E8%8A%B1%E5%BC%80%E7%9A%84%E8%B7%AF%E5%8F%A3%E3%80%8B%E6%BC%94%E5%94%B1%E5%8D%9E%E8%A5%BF%E5%A2%A8.mp4', '2016-06-15', 'http://o7zv69viu.bkt.clouddn.com/%E6%9C%80%E5%BC%BA%E9%9F%B3%E3%80%8A%E5%87%A4%E5%87%B0%E8%8A%B1%E5%BC%80%E7%9A%84%E8%B7%AF%E5%8F%A3%E3%80%8B%E6%BC%94%E5%94%B1%E5%8D%9E%E8%A5%BF%E5%A2%A8_pic.png', 1, '卞西墨', '凤凰花开的路口', '管理员'),
(4, '《光辉岁月》演唱武文良', 'http://221.204.210.203/xdispatch/o7zv69viu.bkt.clouddn.com/%E6%9C%80%E5%BC%BA%E9%9F%B3%E3%80%8A%E5%85%89%E8%BE%89%E5%B2%81%E6%9C%88%E3%80%8B%E6%BC%94%E5%94%B1%E6%AD%A6%E6%96%87%E8%89%AF.mp4', '2016-06-15', 'http://o7zv69viu.bkt.clouddn.com/%E6%9C%80%E5%BC%BA%E9%9F%B3%E3%80%8A%E5%85%89%E8%BE%89%E5%B2%81%E6%9C%88%E3%80%8B%E6%BC%94%E5%94%B1%E6%AD%A6%E6%96%87%E8%89%AF_pic.png', 1, '武文良', '永远的家驹，永远的beyond,纪念曼德拉，纪念家驹', '管理员');

-- --------------------------------------------------------

--
-- 替换视图以便查看 `college_voice_video_view`
--
DROP VIEW IF EXISTS `college_voice_video_view`;
CREATE TABLE `college_voice_video_view` (
`ZQY_video_id` int(11)
,`ZQY_video_name` varchar(45)
,`ZQY_video_url` varchar(500)
,`ZQY_video_date` date
,`ZQY_video_pic_url` varchar(500)
,`zqy_video_played_number` int(11)
,`player_name` varchar(20)
,`zqy_video_intro` varchar(255)
,`zqy_video_uploader` varchar(50)
);

-- --------------------------------------------------------

--
-- 表的结构 `higo_video`
--
-- 创建时间： 2016-05-31 09:18:45
--

DROP TABLE IF EXISTS `higo_video`;
CREATE TABLE `higo_video` (
  `HIGO_video_id` int(11) NOT NULL,
  `HIGO_video_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `HIGO_video_url` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `HIGO_video_date` date NOT NULL,
  `HIGO_video_pic_url` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `HIGO_video_played_number` int(11) NOT NULL DEFAULT '0',
  `HIGO_video_intro` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HIGO_video_uploader` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 表的关联 `higo_video`:
--

--
-- 转存表中的数据 `higo_video`
--

INSERT INTO `higo_video` (`HIGO_video_id`, `HIGO_video_name`, `HIGO_video_url`, `HIGO_video_date`, `HIGO_video_pic_url`, `HIGO_video_played_number`, `HIGO_video_intro`, `HIGO_video_uploader`) VALUES
(1, 'Higo大学季第一期', 'http://o7zv69viu.bkt.clouddn.com/higovideo_1.mp4', '2016-06-02', 'http://o7zv69viu.bkt.clouddn.com/higovideo_pic_1.png', 98, ' 太阳在线的各位后期大咖们来到了我们的节目当中，平时每天忙碌工作的他们，生活中的他们是什么样的呢？  都说后期的各位大咖们都是游戏行家,当杨阿凤遇上大神王晓宁又会擦出怎样的火花呢？赶紧来看本期的节目！\r\n', '管理员'),
(2, 'Higo大学季第二期', 'http://o7zv69viu.bkt.clouddn.com/%E5%A4%AA%E9%98%B3%E5%9C%A8%E7%BA%BFhigo%E5%A4%A7%E5%AD%A6%E5%AD%A3%E7%AC%AC%E4%BA%8C%E6%9C%9F.mp4', '2016-06-02', 'http://o7zv69viu.bkt.clouddn.com/higovideo_pic_2.png', 116, 'Higo大学季第二期节目精彩看点：当校园男神女神们来到节目当中，他们的表现又是如何呢？听说本期节目的游戏环节惩罚极其可怕，到底是什么的游戏惩罚让我们的男神女神们直呼受不了，哎呀，我的天呐，到底发什么了什么？来看本期的节目喽！', '管理员');

-- --------------------------------------------------------

--
-- 替换视图以便查看 `higo_video_view`
--
DROP VIEW IF EXISTS `higo_video_view`;
CREATE TABLE `higo_video_view` (
`HIGO_video_id` int(11)
,`HIGO_video_name` varchar(45)
,`HIGO_video_url` varchar(500)
,`HIGO_video_date` date
,`HIGO_video_pic_url` varchar(500)
,`HIGO_video_played_number` int(11)
,`HIGO_video_intro` varchar(255)
,`HIGO_video_uploader` varchar(50)
);

-- --------------------------------------------------------

--
-- 表的结构 `old_driver_video`
--
-- 创建时间： 2016-06-01 02:59:19
--

DROP TABLE IF EXISTS `old_driver_video`;
CREATE TABLE `old_driver_video` (
  `LSJ_video_id` int(11) NOT NULL,
  `LSJ_video_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `LSJ_video_url` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `LSJ_video_date` date NOT NULL,
  `LSJ_video_pic_url` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `LSJ_video_played_number` int(11) NOT NULL DEFAULT '0',
  `LSJ_video_intro` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LSJ_video_uploader` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 表的关联 `old_driver_video`:
--

--
-- 转存表中的数据 `old_driver_video`
--

INSERT INTO `old_driver_video` (`LSJ_video_id`, `LSJ_video_name`, `LSJ_video_url`, `LSJ_video_date`, `LSJ_video_pic_url`, `LSJ_video_played_number`, `LSJ_video_intro`, `LSJ_video_uploader`) VALUES
(1, '影视老司机第一期《荒野猎人》', 'http://o7zv69viu.bkt.clouddn.com/%E5%BD%B1%E8%A7%86%E8%80%81%E5%8F%B8%E6%9C%BA%E7%AC%AC%E4%B8%80%E6%9C%9F%E3%80%8A%E8%8D%92%E9%87%8E%E7%8C%8E%E4%BA%BA%E3%80%8B.mp4', '2016-06-07', 'http://o7zv69viu.bkt.clouddn.com/old_dirver_pic_01.png', 16, '《荒野猎人》是2015年亚利桑德罗·冈萨雷斯·伊纳里多执导的剧情电影，由莱昂纳多·迪卡普里奥、汤姆·哈迪、威尔·保尔特 、多姆纳尔·格利森、保罗·安德森等主演。《荒野猎人》根据迈克尔·彭克同名长篇小说改编，故事讲述19世纪一名皮草猎人被熊所伤并被其他猎人抢走财物抛弃荒野，猎人经历痛苦奇迹存活后开始复仇的故事。', '管理员'),
(2, '影视老司机第二期《疯狂动物城》', 'http://o7zv69viu.bkt.clouddn.com/%E5%BD%B1%E8%A7%86%E8%80%81%E5%8F%B8%E6%9C%BA%E7%AC%AC%E4%BA%8C%E6%9C%9F%E3%80%8A%E7%96%AF%E7%8B%82%E5%8A%A8%E7%89%A9%E5%9F%8E%E3%80%8B.mp4', '2016-06-07', 'http://o7zv69viu.bkt.clouddn.com/old_dirver_pic_02.png', 12, '《疯狂动物城》由迪士尼影业出品的3D动画片,该片讲述了在一个所有动物和平共处的动物城市，兔子朱迪通过自己努力奋斗完成自己儿时的梦想，成为动物警察的故事。', '管理员'),
(3, '影视老司机第三期《超人大战蝙蝠侠》', 'http://o7zv69viu.bkt.clouddn.com/%E5%BD%B1%E8%A7%86%E8%80%81%E5%8F%B8%E6%9C%BA%E7%AC%AC%E4%B8%89%E6%9C%9F%E3%80%8A%E8%B6%85%E4%BA%BA%E5%A4%A7%E6%88%98%E8%9D%99%E8%9D%A0%E4%BE%A0%E3%80%8B.mp4', '2016-06-07', 'http://o7zv69viu.bkt.clouddn.com/old_dirver_pic_03.png', 8, '《蝙蝠侠大战超人：正义黎明》故事背景设定在《超人：钢铁之躯》结尾大战后，围绕着蝙蝠侠和超人之间激增的矛盾而展开，讲述了超人帮助人类解决了很多问题，成为了人类的神，却引起了莱克斯·卢瑟的嫉妒，从而挑拨蝙蝠侠与超人之间战斗的故事。', '管理员'),
(4, '影视老司机第四期《小王子》', 'http://o7zv69viu.bkt.clouddn.com/%E5%BD%B1%E8%A7%86%E8%80%81%E5%8F%B8%E6%9C%BA%E7%AC%AC%E5%9B%9B%E6%9C%9F%E3%80%8A%E5%B0%8F%E7%8E%8B%E5%AD%90%E3%80%8B.mp4', '2016-06-07', 'http://o7zv69viu.bkt.clouddn.com/old_dirver_pic_04.png', 2, '《小王子》是法国On Entertainment2015年出品的奇幻动画电影，改编自安东尼·德·圣-埃克苏佩里创作的同名文学作品，讲述了一个小女孩偶然与年老的飞行员相识，并根据他回忆的指引开启了探索小王子世界的旅程。', '管理员'),
(5, '影视老司机第五期《再次出发》', 'http://o7zv69viu.bkt.clouddn.com/%E5%BD%B1%E8%A7%86%E8%80%81%E5%8F%B8%E6%9C%BA%E7%AC%AC%E4%BA%94%E6%9C%9F%E3%80%8A%E5%86%8D%E6%AC%A1%E5%87%BA%E5%8F%91%E3%80%8B.mp4', '2016-06-07', 'http://o7zv69viu.bkt.clouddn.com/old_dirver_pic_05.png', 8, '《再次出发》讲述了来自英国的“傲娇妞”（凯拉·奈特莉饰）和美国的“落魄大叔”（马克·鲁法诺饰）在纽约遇见，彼时失意的两人重振旗鼓再次出发，共同踏上一段浪漫而激情的旅程，他们组建的“另类乐队”更是成为彼此人生新的开始。', '管理员'),
(6, '影视老司机第六期《垫底辣妹》', 'http://o7zv69viu.bkt.clouddn.com/%E5%BD%B1%E8%A7%86%E8%80%81%E5%8F%B8%E6%9C%BA%E7%AC%AC%E5%85%AD%E6%9C%9F%E3%80%8A%E5%9E%AB%E5%BA%95%E8%BE%A3%E5%A6%B9%E3%80%8B.mp4', '2016-06-07', 'http://o7zv69viu.bkt.clouddn.com/old_dirver_pic_06.png', 6, '《垫底辣妹》是由日本Film Face制作，东宝发行的117分钟的剧情影片。改编自坪田信贵所著小说，讲述了学年垫底的女高中生用一年时间将偏差值提高40，并考入庆应大学的故事。 ', '管理员');

-- --------------------------------------------------------

--
-- 替换视图以便查看 `old_driver_video_view`
--
DROP VIEW IF EXISTS `old_driver_video_view`;
CREATE TABLE `old_driver_video_view` (
`LSJ_video_id` int(11)
,`LSJ_video_name` varchar(45)
,`LSJ_video_url` varchar(300)
,`LSJ_video_date` date
,`LSJ_video_pic_url` varchar(300)
,`LSJ_video_played_number` int(11)
,`LSJ_video_intro` varchar(255)
,`LSJ_video_uploader` varchar(50)
);

-- --------------------------------------------------------

--
-- 表的结构 `sx_school_pic_library`
--
-- 创建时间： 2016-04-29 08:03:28
--

DROP TABLE IF EXISTS `sx_school_pic_library`;
CREATE TABLE `sx_school_pic_library` (
  `pic_lib_id` int(11) NOT NULL,
  `pic_lib_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `pic_lib_url` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `HDpic_lib_url` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `pic_lib_school` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '图片所属院校名称',
  `pic_lib_uploader` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `pic_lib_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 表的关联 `sx_school_pic_library`:
--

-- --------------------------------------------------------

--
-- 表的结构 `user_login`
--
-- 创建时间： 2016-04-28 06:26:12
--

DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `user_pwd` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `user_mobile` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 表的关联 `user_login`:
--

-- --------------------------------------------------------

--
-- 视图结构 `college_voice_video_view`
--
DROP TABLE IF EXISTS `college_voice_video_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `college_voice_video_view`  AS  select `college_voice_video`.`ZQY_video_id` AS `ZQY_video_id`,`college_voice_video`.`ZQY_video_name` AS `ZQY_video_name`,`college_voice_video`.`ZQY_video_url` AS `ZQY_video_url`,`college_voice_video`.`ZQY_video_date` AS `ZQY_video_date`,`college_voice_video`.`ZQY_video_pic_url` AS `ZQY_video_pic_url`,`college_voice_video`.`zqy_video_played_number` AS `zqy_video_played_number`,`college_voice_video`.`player_name` AS `player_name`,`college_voice_video`.`zqy_video_intro` AS `zqy_video_intro`,`college_voice_video`.`zqy_video_uploader` AS `zqy_video_uploader` from `college_voice_video` ;

-- --------------------------------------------------------

--
-- 视图结构 `higo_video_view`
--
DROP TABLE IF EXISTS `higo_video_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `higo_video_view`  AS  select `higo_video`.`HIGO_video_id` AS `HIGO_video_id`,`higo_video`.`HIGO_video_name` AS `HIGO_video_name`,`higo_video`.`HIGO_video_url` AS `HIGO_video_url`,`higo_video`.`HIGO_video_date` AS `HIGO_video_date`,`higo_video`.`HIGO_video_pic_url` AS `HIGO_video_pic_url`,`higo_video`.`HIGO_video_played_number` AS `HIGO_video_played_number`,`higo_video`.`HIGO_video_intro` AS `HIGO_video_intro`,`higo_video`.`HIGO_video_uploader` AS `HIGO_video_uploader` from `higo_video` ;

-- --------------------------------------------------------

--
-- 视图结构 `old_driver_video_view`
--
DROP TABLE IF EXISTS `old_driver_video_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `old_driver_video_view`  AS  select `old_driver_video`.`LSJ_video_id` AS `LSJ_video_id`,`old_driver_video`.`LSJ_video_name` AS `LSJ_video_name`,`old_driver_video`.`LSJ_video_url` AS `LSJ_video_url`,`old_driver_video`.`LSJ_video_date` AS `LSJ_video_date`,`old_driver_video`.`LSJ_video_pic_url` AS `LSJ_video_pic_url`,`old_driver_video`.`LSJ_video_played_number` AS `LSJ_video_played_number`,`old_driver_video`.`LSJ_video_intro` AS `LSJ_video_intro`,`old_driver_video`.`LSJ_video_uploader` AS `LSJ_video_uploader` from `old_driver_video` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`admin_id`),
  ADD UNIQUE KEY `admin_id_UNIQUE` (`admin_id`),
  ADD UNIQUE KEY `admin_name_UNIQUE` (`admin_name`);

--
-- Indexes for table `college_pinoeer_intro`
--
ALTER TABLE `college_pinoeer_intro`
  ADD PRIMARY KEY (`fcl_id`),
  ADD UNIQUE KEY `fcl_id_UNIQUE` (`fcl_id`),
  ADD UNIQUE KEY `fcl_name_UNIQUE` (`fcl_name`),
  ADD UNIQUE KEY `fcl_url_UNIQUE` (`fcl_url`);

--
-- Indexes for table `college_voice_player`
--
ALTER TABLE `college_voice_player`
  ADD PRIMARY KEY (`player_number`),
  ADD UNIQUE KEY `player_number_UNIQUE` (`player_number`);

--
-- Indexes for table `college_voice_video`
--
ALTER TABLE `college_voice_video`
  ADD PRIMARY KEY (`ZQY_video_id`),
  ADD UNIQUE KEY `video_id_UNIQUE` (`ZQY_video_id`);

--
-- Indexes for table `higo_video`
--
ALTER TABLE `higo_video`
  ADD PRIMARY KEY (`HIGO_video_id`),
  ADD UNIQUE KEY `video_id_UNIQUE` (`HIGO_video_id`);

--
-- Indexes for table `old_driver_video`
--
ALTER TABLE `old_driver_video`
  ADD PRIMARY KEY (`LSJ_video_id`),
  ADD UNIQUE KEY `video_id_UNIQUE` (`LSJ_video_id`);

--
-- Indexes for table `sx_school_pic_library`
--
ALTER TABLE `sx_school_pic_library`
  ADD PRIMARY KEY (`pic_lib_id`),
  ADD UNIQUE KEY `library_pic_id_UNIQUE` (`pic_lib_id`),
  ADD UNIQUE KEY `library_pic_name_UNIQUE` (`pic_lib_name`),
  ADD UNIQUE KEY `library_pic_url_UNIQUE` (`pic_lib_url`),
  ADD UNIQUE KEY `library_HDpic_url_UNIQUE` (`HDpic_lib_url`);

--
-- Indexes for table `user_login`
--
ALTER TABLE `user_login`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  ADD UNIQUE KEY `user_name_UNIQUE` (`user_name`),
  ADD UNIQUE KEY `user_mobile_UNIQUE` (`user_mobile`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrator`
--
ALTER TABLE `administrator`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `college_pinoeer_intro`
--
ALTER TABLE `college_pinoeer_intro`
  MODIFY `fcl_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `college_voice_video`
--
ALTER TABLE `college_voice_video`
  MODIFY `ZQY_video_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `higo_video`
--
ALTER TABLE `higo_video`
  MODIFY `HIGO_video_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `old_driver_video`
--
ALTER TABLE `old_driver_video`
  MODIFY `LSJ_video_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `sx_school_pic_library`
--
ALTER TABLE `sx_school_pic_library`
  MODIFY `pic_lib_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_login`
--
ALTER TABLE `user_login`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
