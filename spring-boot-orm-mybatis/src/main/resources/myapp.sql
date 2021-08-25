/*
Navicat MySQL Data Transfer

Source Server         : jandarService
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : myapp

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2021-08-25 08:47:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(10) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL COMMENT '性别 0 男 1 女',
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('0001', '小花', '25', '0', '2021-08-24');
INSERT INTO `student` VALUES ('0002', '小草', '24', '1', '2021-08-25');
