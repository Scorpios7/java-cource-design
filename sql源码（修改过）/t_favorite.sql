/*
Navicat MySQL Data Transfer

Source Server         : LIM
Source Server Version : 80026
Source Host           : localhost:3306
Source Database       : store

Target Server Type    : MYSQL
Target Server Version : 80026
File Encoding         : 65001

Date: 2022-04-13 10:22:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_favorite`
-- ----------------------------
DROP TABLE IF EXISTS `t_favorite`;
CREATE TABLE `t_favorite` (
  `fid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `pid` int NOT NULL,
  `created_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_favorite
-- ----------------------------
