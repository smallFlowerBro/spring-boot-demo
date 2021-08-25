/*
Navicat MySQL Data Transfer

Source Server         : jandarService
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : multi_db_one

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2021-08-25 22:00:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'XIAOHUA');
INSERT INTO `test` VALUES ('2', 'XIAOHUA');
