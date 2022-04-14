/*
Navicat MySQL Data Transfer

Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : spring_boot_shiro

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2022-04-14 23:45:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` varchar(20) NOT NULL,
  `u_name` varchar(20) NOT NULL,
  `u_pwd` varchar(20) NOT NULL,
  `u_roles` varchar(100) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT '1' COMMENT '1 男 2 女',
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `i_name` (`u_name`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('041231', 'admin', '123456', 'admin', '22', '2', 'adsadd');
INSERT INTO `user` VALUES ('065456', 'root', '123456', 'admin  supAdmin', '21', '1', '445');
