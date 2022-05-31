/*
Navicat MySQL Data Transfer

Source Server         : shop
Source Server Version : 50737
Source Host           : localhost:3306
Source Database       : store

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-05-18 12:42:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单商品id',
  `oid` int(11) NOT NULL COMMENT '订单id',
  `pid` int(11) NOT NULL COMMENT '商品id',
  `title` varchar(100) NOT NULL COMMENT '商品标题',
  `image` varchar(500) DEFAULT NULL COMMENT '商品图片',
  `price` bigint(20) DEFAULT NULL COMMENT '商品价格',
  `num` int(11) DEFAULT NULL COMMENT '购买的数量',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
