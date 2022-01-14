/*
Navicat MySQL Data Transfer

Source Server         : jandarService
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : file_test

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2022-01-14 11:22:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `config`
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `name` varchar(30) DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('FILE_PREFIX', 'e:/');

-- ----------------------------
-- Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `file_id` varchar(50) NOT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

