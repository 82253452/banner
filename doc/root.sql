/*
SQLyog Community v11.1 (64 bit)
MySQL - 5.6.24 : Database - root
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`root` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `root`;

/*Table structure for table `ly_buttom` */

DROP TABLE IF EXISTS `ly_buttom`;

CREATE TABLE `ly_buttom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `buttom` varchar(200) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `ly_buttom` */

insert  into `ly_buttom`(`id`,`name`,`buttom`,`description`) values (1,'新增','<button type=\"button\" id=\"addFun\" class=\"btn btn-primary marR10\">新增</button>',''),(2,'编辑','<button type=\"button\" id=\"editFun\" class=\"btn btn-info marR10\">编辑</button>',NULL),(3,'删除','<button type=\"button\" id=\"delFun\" class=\"btn btn-danger marR10\">删除</button>',NULL),(4,'上传','<button type=\"button\" id=\"upLoad\" class=\"btn btn-primary marR10\">上传</button>',NULL),(5,'下载','<button type=\"button\" id=\"downLoad\" class=\"btn btn-primary marR10\">下载</button>',NULL),(6,'上移','<button type=\"button\" id=\"lyGridUp\" class=\"btn btn-success marR10\">上移</button>',NULL),(7,'下移','<button type=\"button\" id=\"lyGridDown\" class=\"btn btn btn-grey marR10\">下移</button>',NULL),(8,'分配权限','<button type=\"button\" id=\"permissions\" class=\"btn btn btn-grey marR10\">分配权限</button>',NULL);

/*Table structure for table `ly_goods` */

DROP TABLE IF EXISTS `ly_goods`;

CREATE TABLE `ly_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(50) DEFAULT NULL,
  `goodsNum` int(10) DEFAULT NULL,
  `goodsPrice` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ly_goods` */

/*Table structure for table `ly_goods_type` */

DROP TABLE IF EXISTS `ly_goods_type`;

CREATE TABLE `ly_goods_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(50) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `parentId` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ly_goods_type` */

/*Table structure for table `ly_log` */

DROP TABLE IF EXISTS `ly_log`;

CREATE TABLE `ly_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountName` varchar(30) DEFAULT NULL,
  `module` varchar(30) DEFAULT NULL,
  `methods` varchar(30) DEFAULT NULL,
  `actionTime` varchar(30) DEFAULT NULL,
  `userIP` varchar(30) DEFAULT NULL,
  `operTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8;

/*Data for the table `ly_log` */

insert  into `ly_log`(`id`,`accountName`,`module`,`methods`,`actionTime`,`userIP`,`operTime`,`description`) values (135,'admin','系统管理','资源管理-新增资源','18','0:0:0:0:0:0:0:1','2015-08-08 17:37:38','执行成功!'),(136,'admin','系统管理','资源管理-新增资源','15','0:0:0:0:0:0:0:1','2015-08-08 17:38:24','执行成功!'),(137,'admin','系统管理','资源管理-修改资源','17','0:0:0:0:0:0:0:1','2015-08-08 18:21:06','执行成功!'),(138,'admin','系统管理','用户管理/组管理-修改权限','24','0:0:0:0:0:0:0:1','2015-08-08 18:24:51','执行成功!'),(139,'admin','系统管理','资源管理-新增资源','23','0:0:0:0:0:0:0:1','2015-08-08 18:44:09','执行成功!'),(140,'admin','系统管理','用户管理/组管理-修改权限','17','0:0:0:0:0:0:0:1','2015-08-08 18:44:40','执行成功!'),(141,'admin','系统管理','资源管理-新增资源','14','0:0:0:0:0:0:0:1','2015-08-08 18:46:14','执行成功!'),(142,'admin','系统管理','用户管理-新增用户','74','0:0:0:0:0:0:0:1','2015-08-08 18:57:47','执行成功!'),(143,'admin','系统管理','微信管理-新增微信','16','0:0:0:0:0:0:0:1','2015-08-08 19:00:39','执行成功!'),(144,'admin','系统管理','用户管理/组管理-修改权限','26','0:0:0:0:0:0:0:1','2015-08-08 19:06:31','执行成功!'),(145,'admin','系统管理','用户管理-修改用户','19','0:0:0:0:0:0:0:1','2015-08-08 19:17:33','执行成功!'),(146,'admin','系统管理','用户管理-修改用户','13','0:0:0:0:0:0:0:1','2015-08-08 19:19:08','执行成功!'),(147,'admin','系统管理','微信管理-新增微信','21','0:0:0:0:0:0:0:1','2015-08-08 19:47:07','执行成功!'),(148,'admin','系统管理','微信管理-新增微信','28','0:0:0:0:0:0:0:1','2015-08-08 21:17:05','执行成功!'),(149,'admin','系统管理','微信管理-新增微信','40','0:0:0:0:0:0:0:1','2015-08-08 21:27:02','执行成功!'),(150,'admin','系统管理','微信管理-新增微信','25','0:0:0:0:0:0:0:1','2015-08-08 21:29:28','执行成功!'),(151,'admin','系统管理','用户管理-修改用户','428','0:0:0:0:0:0:0:1','2015-08-08 22:49:22','执行成功!'),(152,'admin','系统管理','用户管理-修改用户','134','0:0:0:0:0:0:0:1','2015-08-08 22:56:37','执行成功!'),(153,'admin','系统管理','用户管理-修改用户','108','0:0:0:0:0:0:0:1','2015-08-08 23:04:27','执行成功!'),(154,'admin','系统管理','用户管理-修改用户','123','0:0:0:0:0:0:0:1','2015-08-08 23:11:41','执行成功!'),(155,'admin','系统管理','用户管理-修改用户','12','0:0:0:0:0:0:0:1','2015-08-09 00:44:46','执行成功!'),(156,'admin','系统管理','用户管理-修改用户','13','0:0:0:0:0:0:0:1','2015-08-09 00:49:01','执行成功!'),(157,'admin','系统管理','用户管理-修改用户','18','0:0:0:0:0:0:0:1','2015-08-09 00:50:40','执行成功!'),(158,'admin','系统管理','资源管理-新增资源','22','0:0:0:0:0:0:0:1','2015-08-09 00:52:32','执行成功!'),(159,'admin','系统管理','用户管理/组管理-修改权限','27','0:0:0:0:0:0:0:1','2015-08-09 00:52:44','执行成功!'),(160,'admin','系统管理','微信管理-删除微信','4','0:0:0:0:0:0:0:1','2015-08-09 00:53:02','执行成功!'),(161,'admin','系统管理','微信管理-删除微信','7','0:0:0:0:0:0:0:1','2015-08-09 18:18:23','执行成功!'),(162,'admin','系统管理','用户管理-修改用户','22','0:0:0:0:0:0:0:1','2015-08-11 17:05:19','执行成功!'),(163,'admin','系统管理','用户管理-修改用户','18','0:0:0:0:0:0:0:1','2015-08-11 17:13:07','执行成功!'),(164,'admin','系统管理','用户管理-修改用户','1317','0:0:0:0:0:0:0:1','2015-08-12 17:27:24','执行成功!'),(165,'admin','系统管理','用户管理-修改用户','1292','0:0:0:0:0:0:0:1','2015-08-12 17:30:41','执行成功!'),(166,'admin','系统管理','用户管理-修改用户','3679','0:0:0:0:0:0:0:1','2015-08-12 17:35:30','执行成功!'),(167,'admin','系统管理','用户管理-修改用户','2732','0:0:0:0:0:0:0:1','2015-08-12 17:39:15','执行成功!'),(168,'admin','系统管理','用户管理-修改用户','173','0:0:0:0:0:0:0:1','2015-08-12 17:43:43','执行成功!'),(169,'admin','系统管理','用户管理-修改用户','207','0:0:0:0:0:0:0:1','2015-08-12 17:50:12','执行成功!'),(170,'admin','系统管理','用户管理-修改用户','3386','0:0:0:0:0:0:0:1','2015-08-13 10:42:08','执行成功!'),(171,'admin','系统管理','微信管理-新增微信','6301','0:0:0:0:0:0:0:1','2015-08-13 17:13:43','执行成功!'),(172,'admin','系统管理','微信管理-新增微信','3201','0:0:0:0:0:0:0:1','2015-08-13 17:17:45','执行成功!'),(173,'admin','系统管理','微信管理-新增微信','80903','0:0:0:0:0:0:0:1','2015-08-13 17:18:43','执行成功!'),(174,'admin','系统管理','用户管理-修改用户','3338','0:0:0:0:0:0:0:1','2015-08-14 22:02:47','执行成功!'),(175,'admin','系统管理','用户管理-修改用户','6556','0:0:0:0:0:0:0:1','2015-10-11 19:00:45','执行成功!'),(176,'admin','系统管理','用户管理-修改用户','3553','0:0:0:0:0:0:0:1','2015-10-18 14:56:43','执行成功!'),(177,'admin','系统管理','用户管理-修改用户','1753','0:0:0:0:0:0:0:1','2015-10-18 14:56:44','执行成功!'),(178,'admin','系统管理','用户管理-修改用户','2192','0:0:0:0:0:0:0:1','2015-10-18 15:08:24','执行成功!'),(179,'admin','系统管理','用户管理-修改用户','440','0:0:0:0:0:0:0:1','2015-10-18 15:11:43','执行成功!'),(180,'admin','系统管理','用户管理-修改用户','2727','0:0:0:0:0:0:0:1','2015-10-18 15:13:08','执行成功!'),(181,'admin','系统管理','用户管理-修改用户','1402','0:0:0:0:0:0:0:1','2015-10-18 15:14:00','执行成功!'),(182,'admin','系统管理','资源管理-新增资源','15','0:0:0:0:0:0:0:1','2015-10-18 15:41:27','执行成功!'),(183,'admin','系统管理','用户管理-修改用户','2033','0:0:0:0:0:0:0:1','2015-10-18 17:28:24','执行成功!'),(184,'admin','系统管理','用户管理-修改用户','2293','0:0:0:0:0:0:0:1','2015-10-18 17:32:14','执行成功!'),(185,'admin','系统管理','用户管理-修改用户','2072','0:0:0:0:0:0:0:1','2015-10-18 22:33:18','执行成功!'),(186,'admin','系统管理','用户管理-修改用户','2022','0:0:0:0:0:0:0:1','2015-10-18 22:37:10','执行成功!'),(187,'admin','系统管理','用户管理-修改用户','33','0:0:0:0:0:0:0:1','2015-10-18 22:39:35','执行成功!'),(188,'admin','系统管理','用户管理-修改用户','2199','0:0:0:0:0:0:0:1','2015-10-18 23:16:39','执行成功!'),(189,'admin','系统管理','用户管理-修改用户','524','0:0:0:0:0:0:0:1','2015-10-18 23:48:53','执行成功!');

/*Table structure for table `ly_pro_goods` */

DROP TABLE IF EXISTS `ly_pro_goods`;

CREATE TABLE `ly_pro_goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(50) DEFAULT NULL,
  `goodsNum` int(8) DEFAULT NULL,
  `goodsDes` varchar(255) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `ly_pro_goods` */

insert  into `ly_pro_goods`(`id`,`goodsName`,`goodsNum`,`goodsDes`,`createTime`) values (1,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL),(3,NULL,NULL,NULL,NULL),(4,NULL,NULL,NULL,NULL),(5,NULL,NULL,NULL,NULL),(6,NULL,NULL,NULL,NULL),(7,'1',1,NULL,NULL),(8,'123',123,NULL,NULL),(9,'222',222,NULL,NULL),(10,'666',666,NULL,'2015-07-19 04:37:11'),(11,'666',666,NULL,'2015-07-19 04:37:29'),(12,'666',666,NULL,'2015-07-19 04:37:43'),(13,'123',1,NULL,'2015-07-19 11:00:54');

/*Table structure for table `ly_res_user` */

DROP TABLE IF EXISTS `ly_res_user`;

CREATE TABLE `ly_res_user` (
  `resId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`resId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ly_res_user` */

insert  into `ly_res_user`(`resId`,`userId`) values (1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),(9,3),(10,3),(11,3),(25,3),(26,3),(27,3),(28,3),(29,3),(30,3),(31,3),(32,3),(33,3),(34,3),(35,3),(37,3),(38,3),(39,3),(40,3),(41,3);

/*Table structure for table `ly_resources` */

DROP TABLE IF EXISTS `ly_resources`;

CREATE TABLE `ly_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `resKey` varchar(50) DEFAULT NULL,
  `type` varchar(40) DEFAULT NULL,
  `resUrl` varchar(200) DEFAULT NULL,
  `level` int(4) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `ishide` int(3) DEFAULT '0',
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `ly_resources` */

insert  into `ly_resources`(`id`,`name`,`parentId`,`resKey`,`type`,`resUrl`,`level`,`icon`,`ishide`,`description`) values (1,'系统基础管理',0,'system','0','system',1,'fa-desktop',0,'系统基础管理'),(2,'用户管理',1,'account','1','/user/list.shtml',2,NULL,0,NULL),(3,'角色管理',1,'role','1','/role/list.shtml',7,'fa-list',0,'组管理'),(4,'菜单管理',1,'ly_resources','1','/resources/list.shtml',12,'fa-list-alt',0,'菜单管理'),(5,'新增用户',2,'account_add','2','/user/addUI.shtml',3,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;addAccount&quot;&nbsp;class=&quot;btn&nbsp;btn-primary&nbsp;marR10&quot;&gt;新增&lt;/button&gt;'),(6,'修改用户',2,'account_edit','2','/user/editUI.shtml',4,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;editAccount&quot;&nbsp;class=&quot;btn&nbsp;btn-info&nbsp;marR10&quot;&gt;编辑&lt;/button&gt;'),(7,'删除用户',2,'account_delete','2','/user/deleteById.shtml',5,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;delAccount&quot;&nbsp;class=&quot;btn&nbsp;btn-danger&nbsp;marR10&quot;&gt;删除&lt;/button&gt;'),(8,'新增角色',3,'role_add','2','/role/addUI.shtml',8,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;addRole&quot;&nbsp;class=&quot;btn&nbsp;btn-primary&nbsp;marR10&quot;&gt;新增&lt;/button&gt;'),(9,'修改角色',3,'role_edit','2','/role/editUI.shtml',9,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;editRole&quot;&nbsp;class=&quot;btn&nbsp;btn-info&nbsp;marR10&quot;&gt;编辑&lt;/button&gt;'),(10,'删除角色',3,'role_delete','2','/role/delete.shtml',10,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;delRole&quot;&nbsp;class=&quot;btn&nbsp;btn-danger&nbsp;marR10&quot;&gt;删除&lt;/button&gt;'),(11,'分配权限',3,'role_perss','2','/resources/permissions.shtml',11,'无',0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;permissions&quot;&nbsp;class=&quot;btn&nbsp;btn&nbsp;btn-grey&nbsp;marR10&quot;&gt;分配权限&lt;/button&gt;'),(25,'登陆信息管理',0,'ly_login','0','ly_login',18,'fa-calendar',0,'登陆信息管理'),(26,'用户登录记录',25,'ly_log_list','1','/userlogin/listUI.shtml',19,NULL,0,'用户登录记录'),(27,'操作日志管理',0,'ly_log','0','ly_log',20,'fa-picture-o',1,'操作日志管理'),(28,'日志查询',27,'ly_log','1','/log/list.shtml',21,NULL,0,NULL),(29,'新增菜单资源',4,'ly_resources_add','2','/resources/addUI.shtml',13,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;addFun&quot;&nbsp;class=&quot;btn&nbsp;btn-primary&nbsp;marR10&quot;&gt;新增&lt;/button&gt;'),(30,'修改菜单资源',4,'ly_resources_edit','2','/resources/editUI.shtml',14,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;editFun&quot;&nbsp;class=&quot;btn&nbsp;btn-info&nbsp;marR10&quot;&gt;编辑&lt;/button&gt;'),(31,'删除菜单资源',4,'ly_resources_delete','2','/resources/delete.shtml',15,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;delFun&quot;&nbsp;class=&quot;btn&nbsp;btn-danger&nbsp;marR10&quot;&gt;删除&lt;/button&gt;'),(32,'系统监控管理',0,'monitor','0','monitor',16,'fa-tag',0,'系统监控管理'),(33,'实时监控',32,'sysmonitor','1','/monitor/monitor.shtml',17,NULL,0,'实时监控'),(34,'分配权限',2,'permissions','2','/resources/permissions.shtml',6,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;permissions&quot;&nbsp;class=&quot;btn&nbsp;btn&nbsp;btn-grey&nbsp;marR10&quot;&gt;分配权限&lt;/button&gt;'),(35,'告警列表',32,'monitor_warn','1','/monitor/list.shtml',NULL,NULL,0,'告警列表'),(37,'发布平台',0,'show','0','none',NULL,NULL,0,NULL),(38,'微信发布客户端',37,'userWEClient','1','/wechat/list.shtml',NULL,NULL,0,NULL),(39,'新增网站',38,'addWWW','2','/rwechat/addUI.shtml',NULL,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;addAccount&quot;&nbsp;class=&quot;btn&nbsp;btn-primary&nbsp;marR10&quot;&gt;新增网站&lt;/button&gt;'),(40,'编辑网站',38,'editwww','2','/wechat/editUI.shtml',NULL,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;editAccount&quot;&nbsp;class=&quot;btn&nbsp;btn-info&nbsp;marR10&quot;&gt;编辑网站&lt;/button&gt;'),(41,'删除网站',38,'deletewww','2','/wechat/deleteById.shtml',NULL,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;delAccount&quot;&nbsp;class=&quot;btn&nbsp;btn-danger&nbsp;marR10&quot;&gt;删除网站&lt;/button&gt;'),(42,'清理图片库',38,'ClearImg','2','/wechat/clearImg',NULL,NULL,0,'&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;lyGridDown&quot;&nbsp;class=&quot;btn&nbsp;btn&nbsp;btn-grey&nbsp;marR10&quot;&gt;清理图片库&lt;/button&gt;');

/*Table structure for table `ly_role` */

DROP TABLE IF EXISTS `ly_role`;

CREATE TABLE `ly_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `state` varchar(3) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `roleKey` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `ly_role` */

insert  into `ly_role`(`id`,`state`,`name`,`roleKey`,`description`) values (1,'0','管理员','admin','管理员'),(2,'0','普通角色','simple','普通角色'),(3,'0','超级管理员','SUPER','超级管理员');

/*Table structure for table `ly_server_info` */

DROP TABLE IF EXISTS `ly_server_info`;

CREATE TABLE `ly_server_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `cpuUsage` varchar(255) DEFAULT NULL,
  `setCpuUsage` varchar(255) DEFAULT NULL,
  `jvmUsage` varchar(255) DEFAULT NULL,
  `setJvmUsage` varchar(255) DEFAULT NULL,
  `ramUsage` varchar(255) DEFAULT NULL,
  `setRamUsage` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `operTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `mark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `ly_server_info` */

insert  into `ly_server_info`(`id`,`cpuUsage`,`setCpuUsage`,`jvmUsage`,`setJvmUsage`,`ramUsage`,`setRamUsage`,`email`,`operTime`,`mark`) values (5,'18','40','49','40','71','40','121261494@qq.com','2015-04-25 18:07:02','<font color=\"red\">JVM当前：49%,超出预设值 40%<br>内存当前：71%,超出预设值  40%</font>'),(6,'3','40','50','40','71','40','121261494@qq.com','2015-04-25 18:08:03','<font color=\"red\">JVM当前：50%,超出预设值 40%<br>内存当前：71%,超出预设值  40%</font>'),(7,'5','40','50','40','70','40','121261494@qq.com','2015-04-25 18:09:02','<font color=\"red\">JVM当前：50%,超出预设值 40%<br>内存当前：70%,超出预设值  40%</font>'),(8,'5','40','52','40','69','40','121261494@qq.com','2015-04-25 18:10:03','<font color=\"red\">JVM当前：52%,超出预设值 40%<br>内存当前：69%,超出预设值  40%</font>'),(9,'2','40','52','40','68','40','121261494@qq.com','2015-04-25 18:11:02','<font color=\"red\">JVM当前：52%,超出预设值 40%<br>内存当前：68%,超出预设值  40%</font>'),(10,'7','40','53','40','67','40','121261494@qq.com','2015-04-25 18:12:02','<font color=\"red\">JVM当前：53%,超出预设值 40%<br>内存当前：67%,超出预设值  40%</font>'),(11,'5','40','54','40','67','40','121261494@qq.com','2015-04-25 18:13:02','<font color=\"red\">JVM当前：54%,超出预设值 40%<br>内存当前：67%,超出预设值  40%</font>'),(12,'16','40','55','40','66','40','121261494@qq.com','2015-04-25 18:14:02','<font color=\"red\">JVM当前：55%,超出预设值 40%<br>内存当前：66%,超出预设值  40%</font>'),(13,'5','40','56','40','65','40','121261494@qq.com','2015-04-25 18:15:02','<font color=\"red\">JVM当前：56%,超出预设值 40%<br>内存当前：65%,超出预设值  40%</font>'),(14,'8','40','57','40','64','40','121261494@qq.com','2015-04-25 18:16:02','<font color=\"red\">JVM当前：57%,超出预设值 40%<br>内存当前：64%,超出预设值  40%</font>'),(15,'3','40','58','40','63','40','121261494@qq.com','2015-04-25 18:17:02','<font color=\"red\">JVM当前：58%,超出预设值 40%<br>内存当前：63%,超出预设值  40%</font>'),(16,'6','40','59','40','62','40','121261494@qq.com','2015-04-25 18:18:03','<font color=\"red\">JVM当前：59%,超出预设值 40%<br>内存当前：62%,超出预设值  40%</font>'),(17,'1','40','60','40','61','40','121261494@qq.com','2015-04-25 18:19:02','<font color=\"red\">JVM当前：60%,超出预设值 40%<br>内存当前：61%,超出预设值  40%</font>'),(18,'5','40','61','40','61','40','121261494@qq.com','2015-04-25 18:20:02','<font color=\"red\">JVM当前：61%,超出预设值 40%<br>内存当前：61%,超出预设值  40%</font>'),(19,'5','40','38','40','61','40','121261494@qq.com','2015-04-25 18:21:02','<font color=\"red\">内存当前：61%,超出预设值  40%</font>'),(20,'5','40','39','40','60','40','121261494@qq.com','2015-04-25 18:22:02','<font color=\"red\">内存当前：60%,超出预设值  40%</font>'),(21,'4','40','40','40','59','40','121261494@qq.com','2015-04-25 18:23:02','<font color=\"red\">内存当前：59%,超出预设值  40%</font>'),(22,'32','80','41','80','81','80','121261494@qq.com','2015-04-26 01:43:05','<font color=\"red\">内存当前：81%,超出预设值  80%</font>'),(23,'55','80','55','80','81','80','121261494@qq.com','2015-04-26 01:50:03','<font color=\"red\">内存当前：81%,超出预设值  80%</font>'),(24,'13','80','53','80','81','80','121261494@qq.com','2015-04-26 01:59:08','<font color=\"red\">内存当前：81%,超出预设值  80%</font>'),(25,'85','80','58','80','72','80','121261494@qq.com','2015-04-26 02:46:06','<font color=\"red\">CPU当前：85%,超出预设值  80%<br></font>'),(26,'34','80','59','80','81','80','121261494@qq.com','2015-04-27 00:29:06','<font color=\"red\">内存当前：81%,超出预设值  80%</font>'),(27,'92','80','47','80','64','80','121261494@qq.com','2015-04-27 00:44:07','<font color=\"red\">CPU当前：92%,超出预设值  80%<br></font>'),(28,'85','80','49','80','68','80','121261494@qq.com','2015-04-27 23:38:04','<font color=\"red\">CPU当前：85%,超出预设值  80%<br></font>'),(29,'94','80','69','80','73','80','121261494@qq.com','2015-04-28 01:35:03','<font color=\"red\">CPU当前：94%,超出预设值  80%<br></font>'),(30,'6','80','43','80','87','80','121261494@qq.com','2015-05-09 00:00:08','<font color=\"red\">内存当前：87%,超出预设值  80%</font>'),(31,'88','80','59','80','87','80','121261494@qq.com','2015-05-09 00:01:14','<font color=\"red\">CPU当前：88%,超出预设值  80%<br>内存当前：87%,超出预设值  80%</font>');

/*Table structure for table `ly_user` */

DROP TABLE IF EXISTS `ly_user`;

CREATE TABLE `ly_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `accountName` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `credentialsSalt` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `locked` varchar(3) DEFAULT '0',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletestatus` int(1) DEFAULT '0' COMMENT '逻辑删除状态0:存在1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `ly_user` */

insert  into `ly_user`(`id`,`userName`,`accountName`,`password`,`credentialsSalt`,`description`,`locked`,`createTime`,`deletestatus`) values (1,'蓝缘','simple','78e21a6eb88529eab722793a448ed394','4157c3feef4a6ed91b2c28cf4392f2d1','0','1','2015-05-17 22:23:15',0),(2,'超级管理员','ROOT','78e21a6eb88529eab722793a448ed394','4157c3feef4a6ed91b2c28cf4392f2d1','0000','1','2015-05-23 17:39:37',0),(3,'管理员','admin','78e21a6eb88529eab722793a448ed394','4157c3feef4a6ed91b2c28cf4392f2d1','3434','1','2015-05-23 17:39:39',0),(4,NULL,NULL,'13f963b8e93156bcfefd7fa1abdae671','9469d18b9aa99e9c91a19ab7b2f40914',NULL,'0','2015-08-08 18:57:47',0);

/*Table structure for table `ly_user_role` */

DROP TABLE IF EXISTS `ly_user_role`;

CREATE TABLE `ly_user_role` (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ly_user_role` */

insert  into `ly_user_role`(`userId`,`roleId`) values (1,2),(2,3),(3,1);

/*Table structure for table `ly_userlogin` */

DROP TABLE IF EXISTS `ly_userlogin`;

CREATE TABLE `ly_userlogin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `accountName` varchar(20) DEFAULT NULL,
  `loginTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `loginIP` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ly_user_loginlist` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=243 DEFAULT CHARSET=utf8;

/*Data for the table `ly_userlogin` */

insert  into `ly_userlogin`(`id`,`userId`,`accountName`,`loginTime`,`loginIP`) values (143,3,'admin','2015-08-08 17:36:31','0:0:0:0:0:0:0:1'),(144,3,'admin','2015-08-08 18:20:32','0:0:0:0:0:0:0:1'),(145,3,'admin','2015-08-08 18:24:30','0:0:0:0:0:0:0:1'),(146,3,'admin','2015-08-08 18:28:56','0:0:0:0:0:0:0:1'),(147,3,'admin','2015-08-08 18:31:53','0:0:0:0:0:0:0:1'),(148,3,'admin','2015-08-08 18:42:39','0:0:0:0:0:0:0:1'),(149,3,'admin','2015-08-08 18:49:14','0:0:0:0:0:0:0:1'),(150,3,'admin','2015-08-08 18:52:23','0:0:0:0:0:0:0:1'),(151,3,'admin','2015-08-08 19:00:07','0:0:0:0:0:0:0:1'),(152,3,'admin','2015-08-08 19:06:16','0:0:0:0:0:0:0:1'),(153,3,'admin','2015-08-08 19:15:41','0:0:0:0:0:0:0:1'),(154,3,'admin','2015-08-08 19:46:24','0:0:0:0:0:0:0:1'),(155,3,'admin','2015-08-08 21:16:29','0:0:0:0:0:0:0:1'),(156,3,'admin','2015-08-08 21:29:01','0:0:0:0:0:0:0:1'),(157,3,'admin','2015-08-08 21:35:50','0:0:0:0:0:0:0:1'),(158,3,'admin','2015-08-08 22:33:52','0:0:0:0:0:0:0:1'),(159,3,'admin','2015-08-08 22:43:10','0:0:0:0:0:0:0:1'),(160,3,'admin','2015-08-08 22:45:46','0:0:0:0:0:0:0:1'),(161,3,'admin','2015-08-08 22:56:27','0:0:0:0:0:0:0:1'),(162,3,'admin','2015-08-08 23:00:49','0:0:0:0:0:0:0:1'),(163,3,'admin','2015-08-08 23:02:02','0:0:0:0:0:0:0:1'),(164,3,'admin','2015-08-08 23:04:00','0:0:0:0:0:0:0:1'),(165,3,'admin','2015-08-08 23:08:41','0:0:0:0:0:0:0:1'),(166,3,'admin','2015-08-08 23:10:17','0:0:0:0:0:0:0:1'),(167,3,'admin','2015-08-08 23:11:18','0:0:0:0:0:0:0:1'),(168,3,'admin','2015-08-09 00:42:10','0:0:0:0:0:0:0:1'),(169,3,'admin','2015-08-09 00:48:04','0:0:0:0:0:0:0:1'),(170,3,'admin','2015-08-09 15:41:13','0:0:0:0:0:0:0:1'),(171,3,'admin','2015-08-09 15:56:37','0:0:0:0:0:0:0:1'),(172,3,'admin','2015-08-09 16:01:32','0:0:0:0:0:0:0:1'),(173,3,'admin','2015-08-09 17:02:42','0:0:0:0:0:0:0:1'),(174,3,'admin','2015-08-09 17:11:57','0:0:0:0:0:0:0:1'),(175,3,'admin','2015-08-09 17:19:41','0:0:0:0:0:0:0:1'),(176,3,'admin','2015-08-09 17:26:38','0:0:0:0:0:0:0:1'),(177,3,'admin','2015-08-09 17:26:38','0:0:0:0:0:0:0:1'),(178,3,'admin','2015-08-09 17:28:34','0:0:0:0:0:0:0:1'),(179,3,'admin','2015-08-09 17:37:06','0:0:0:0:0:0:0:1'),(180,3,'admin','2015-08-09 17:42:23','0:0:0:0:0:0:0:1'),(181,3,'admin','2015-08-09 17:50:50','0:0:0:0:0:0:0:1'),(182,3,'admin','2015-08-09 17:54:15','0:0:0:0:0:0:0:1'),(183,3,'admin','2015-08-09 18:02:13','0:0:0:0:0:0:0:1'),(184,3,'admin','2015-08-09 18:04:53','0:0:0:0:0:0:0:1'),(185,3,'admin','2015-08-09 18:07:56','0:0:0:0:0:0:0:1'),(186,3,'admin','2015-08-09 18:12:11','0:0:0:0:0:0:0:1'),(187,3,'admin','2015-08-09 18:12:20','0:0:0:0:0:0:0:1'),(188,3,'admin','2015-08-09 18:15:21','0:0:0:0:0:0:0:1'),(189,3,'admin','2015-08-10 16:49:39','0:0:0:0:0:0:0:1'),(190,3,'admin','2015-08-10 16:52:02','0:0:0:0:0:0:0:1'),(191,3,'admin','2015-08-10 16:58:03','0:0:0:0:0:0:0:1'),(192,3,'admin','2015-08-11 16:00:18','0:0:0:0:0:0:0:1'),(193,3,'admin','2015-08-11 16:43:14','0:0:0:0:0:0:0:1'),(194,3,'admin','2015-08-11 17:05:05','0:0:0:0:0:0:0:1'),(195,3,'admin','2015-08-11 17:19:28','0:0:0:0:0:0:0:1'),(196,3,'admin','2015-08-12 15:43:07','0:0:0:0:0:0:0:1'),(197,3,'admin','2015-08-12 16:01:18','0:0:0:0:0:0:0:1'),(198,3,'admin','2015-08-12 16:05:50','0:0:0:0:0:0:0:1'),(199,3,'admin','2015-08-12 16:20:43','0:0:0:0:0:0:0:1'),(200,3,'admin','2015-08-12 16:23:38','0:0:0:0:0:0:0:1'),(201,3,'admin','2015-08-12 16:31:06','0:0:0:0:0:0:0:1'),(202,3,'admin','2015-08-12 16:34:14','0:0:0:0:0:0:0:1'),(203,3,'admin','2015-08-12 16:38:14','0:0:0:0:0:0:0:1'),(204,3,'admin','2015-08-12 16:43:51','0:0:0:0:0:0:0:1'),(205,3,'admin','2015-08-12 16:58:42','0:0:0:0:0:0:0:1'),(206,3,'admin','2015-08-12 17:29:55','0:0:0:0:0:0:0:1'),(207,3,'admin','2015-08-12 17:35:08','0:0:0:0:0:0:0:1'),(208,3,'admin','2015-08-12 17:37:08','0:0:0:0:0:0:0:1'),(209,3,'admin','2015-08-12 17:38:59','0:0:0:0:0:0:0:1'),(210,3,'admin','2015-08-12 17:43:26','0:0:0:0:0:0:0:1'),(211,3,'admin','2015-08-12 17:48:52','0:0:0:0:0:0:0:1'),(212,3,'admin','2015-08-12 17:49:45','0:0:0:0:0:0:0:1'),(213,3,'admin','2015-08-12 17:51:35','0:0:0:0:0:0:0:1'),(214,3,'admin','2015-08-13 10:41:47','0:0:0:0:0:0:0:1'),(215,3,'admin','2015-08-13 14:08:28','0:0:0:0:0:0:0:1'),(216,3,'admin','2015-08-13 17:11:44','0:0:0:0:0:0:0:1'),(217,3,'admin','2015-08-13 17:15:41','0:0:0:0:0:0:0:1'),(218,3,'admin','2015-08-13 20:10:18','0:0:0:0:0:0:0:1'),(219,3,'admin','2015-08-14 22:02:28','0:0:0:0:0:0:0:1'),(220,3,'admin','2015-10-11 18:29:33','0:0:0:0:0:0:0:1'),(221,3,'admin','2015-10-11 18:57:55','0:0:0:0:0:0:0:1'),(222,3,'admin','2015-10-18 14:55:45','0:0:0:0:0:0:0:1'),(223,3,'admin','2015-10-18 15:08:01','0:0:0:0:0:0:0:1'),(224,3,'admin','2015-10-18 15:38:41','0:0:0:0:0:0:0:1'),(225,3,'admin','2015-10-18 15:59:47','0:0:0:0:0:0:0:1'),(226,3,'admin','2015-10-18 16:09:34','0:0:0:0:0:0:0:1'),(227,3,'admin','2015-10-18 16:14:49','0:0:0:0:0:0:0:1'),(228,3,'admin','2015-10-18 16:16:59','0:0:0:0:0:0:0:1'),(229,3,'admin','2015-10-18 16:25:35','0:0:0:0:0:0:0:1'),(230,3,'admin','2015-10-18 16:41:47','0:0:0:0:0:0:0:1'),(231,3,'admin','2015-10-18 17:10:26','0:0:0:0:0:0:0:1'),(232,3,'admin','2015-10-18 17:25:50','0:0:0:0:0:0:0:1'),(233,3,'admin','2015-10-18 17:31:38','0:0:0:0:0:0:0:1'),(234,3,'admin','2015-10-18 17:31:38','0:0:0:0:0:0:0:1'),(235,3,'admin','2015-10-18 18:05:04','0:0:0:0:0:0:0:1'),(236,3,'admin','2015-10-18 22:23:17','0:0:0:0:0:0:0:1'),(237,3,'admin','2015-10-18 22:36:51','0:0:0:0:0:0:0:1'),(238,3,'admin','2015-10-18 22:39:24','0:0:0:0:0:0:0:1'),(239,3,'admin','2015-10-18 23:12:36','0:0:0:0:0:0:0:1'),(240,3,'admin','2015-10-18 23:16:17','0:0:0:0:0:0:0:1'),(241,3,'admin','2015-10-18 23:22:43','0:0:0:0:0:0:0:1'),(242,3,'admin','2015-10-18 23:47:37','0:0:0:0:0:0:0:1');

/*Table structure for table `ly_we_info` */

DROP TABLE IF EXISTS `ly_we_info`;

CREATE TABLE `ly_we_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `appId` varchar(255) DEFAULT NULL,
  `Secret` varchar(255) DEFAULT NULL,
  `BaseURL` varchar(255) DEFAULT 'http://www.36634.com',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `timer` varchar(255) DEFAULT NULL,
  `startime` time DEFAULT NULL,
  `num` int(5) DEFAULT NULL,
  `state` char(1) DEFAULT '0',
  `insteadImg` varchar(255) DEFAULT NULL,
  `orgConn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `ly_we_info` */

insert  into `ly_we_info`(`id`,`url`,`appId`,`Secret`,`BaseURL`,`createTime`,`timer`,`startime`,`num`,`state`,`insteadImg`,`orgConn`) values (1,'http://www.36634.com/jkcs/','wx2ed7799804a912d9','a0d0f8f766db4a5506492ff83ed9275e','http://www.36634.com','2015-08-08 18:29:13','1445183333285931','23:40:00',5,'1','{\"media_id\":\"S5Tv_I_CorBpxPlwtbL1ZwK3NJLXoPm2Om2BNMeot-8\",\"url\":\"https://mmbiz.qlogo.cn/mmbiz/RwBvYYdMiaZDSlV9fo81hZ5NrTqaqSt3uJ95mFb2eX04Ticyial2LgibDFyGGXFlmpsPic1ycMDUic0V8XJnojwGcd0Q/0?wx_fmt=jpeg\"}','http://www.baidu.com'),(2,'http://www.36634.com/yuer/','wxc433c69c6a22c2c8','99bc76ce7348a0c5fb358e2e89eeac4c','http://www.36634.com','2015-08-13 17:13:43','14451814503987450','08:00:00',2,'0','{\"media_id\":\"tr3crKH0yZnVqQq_OFvHzzTxBk0Ua3LaV2b8tzcWE9s\",\"url\":\"https://mmbiz.qlogo.cn/mmbiz/dCO5n5YbCz8j6nawiaFMfA78EYhUh4H1UZibmuggJrNvb8rVB0mN4g33ZSfuMiazmicxUokroqvUBh30ric80kyvrpg/0?wx_fmt=jpeg\"}',''),(3,'http://wx.186jk.com/','wx72d6e2a25d7b3bfa','f4928bc946216a77536bb2238bfc3b20','http://www.36634.com','2016-04-14 00:59:25',NULL,'01:50:00',4,'0',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
