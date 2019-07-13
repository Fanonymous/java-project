/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : db_internetsys

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2017-06-02 09:07:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_repair`
-- ----------------------------
DROP TABLE IF EXISTS `t_repair`;
CREATE TABLE `t_repair` (
  `taskId` int(11) NOT NULL auto_increment,
  `userName` varchar(8) default NULL,
  `publishTime` varchar(25) NOT NULL,
  `userAddress` varchar(50) NOT NULL,
  `phone` varchar(11) default NULL,
  `troubleDesc` varchar(100) default NULL,
  `repairer` varchar(8) default NULL,
  `repairTime` varchar(25) default NULL,
  `finishTime` varchar(25) default NULL,
  `dealWay` varchar(100) default NULL,
  `state` char(8) default NULL,
  PRIMARY KEY  (`taskId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_repair
-- ----------------------------
INSERT INTO `t_repair` VALUES ('8', '张三', '2017-05-12 22:31:21', '5号楼', '18690447871', '灯泡坏了', 'zhangwei', '2017-05-19 10:06:38', null, null, '维修中');
INSERT INTO `t_repair` VALUES ('9', '张三', '2017-05-13 09:38:14', '5号楼', '18690447871', '门坏了', null, null, null, null, '待维修');
INSERT INTO `t_repair` VALUES ('10', '张三', '2017-05-13 09:39:03', '5号楼', '18690447871', '锁坏了', null, null, null, null, '待维修');
INSERT INTO `t_repair` VALUES ('11', '张三', '2017-05-13 09:39:45', '5号楼', '18690447871', '灯泡坏了', null, null, null, null, '待维修');
INSERT INTO `t_repair` VALUES ('12', '张三', '2017-05-13 09:40:04', '5号楼', '18690447871', '灯泡坏了', null, null, null, null, '待维修');
INSERT INTO `t_repair` VALUES ('13', '张三', '2017-05-13 09:40:20', '5号楼', '18690447871', '灯泡坏了', null, null, null, null, '待维修');
INSERT INTO `t_repair` VALUES ('14', '张三', '2017-05-13 09:40:37', '5号楼', '18690447871', '灯泡坏了', null, null, null, null, '待维修');
INSERT INTO `t_repair` VALUES ('15', '张三', '2017-05-13 09:40:52', '5号楼', '18690447871', '灯泡坏了', null, null, null, null, '待维修');
INSERT INTO `t_repair` VALUES ('16', '李四', '2017-05-13 11:15:37', '8号楼', '18690447871', '灯泡坏了', 'zhangwei', '2017-05-13 11:16:21', '2017-05-13 11:16:33', '换灯泡', '已维修');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL auto_increment,
  `userName` varchar(20) NOT NULL,
  `password` char(6) NOT NULL,
  `level` varchar(6) NOT NULL,
  `name` varchar(8) default NULL,
  `sex` char(2) default NULL,
  `birthday` date default NULL,
  `grade` varchar(20) default NULL,
  `major` varchar(20) default NULL,
  `phone` varchar(11) default NULL,
  `address` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('13', 'admin', '1', '1', '郭福建', '男', '2017-04-21', '2013', '计算机科学与技术', '18690447871', '8号楼');
INSERT INTO `t_user` VALUES ('15', 'zhangwei', '1', '2', '张伟', '男', '1995-07-19', '', '', '18690447871', '8号楼');
INSERT INTO `t_user` VALUES ('16', '201396104075', '1', '3', '小明', '男', '2017-04-24', '2013', '计算机科学与技术', '18690447871', '8号楼');
INSERT INTO `t_user` VALUES ('19', '201396104077', '1', '3', '张三', '男', '1995-02-07', '2013', '计算机科学与技术', '18690447871', '5号楼');
INSERT INTO `t_user` VALUES ('20', 'weixiu', '1', '2', '张一男', '男', '1995-02-14', '', '', '', '8号楼');
INSERT INTO `t_user` VALUES ('21', '201396104074', '1', '3', '李四', '男', '2017-05-13', '2013', '计算机科学与技术', '18690447871', '8号楼');
