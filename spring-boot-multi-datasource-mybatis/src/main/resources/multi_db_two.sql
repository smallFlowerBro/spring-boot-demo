/*
Navicat MySQL Data Transfer

Source Server         : jandarService
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : multi_db_two

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2021-08-25 22:00:58
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
INSERT INTO `test` VALUES ('1', 'xiaohua');
INSERT INTO `test` VALUES ('2', 'xiaohua');

-- ----------------------------
-- Procedure structure for `stu_findByid`
-- ----------------------------
DROP PROCEDURE IF EXISTS `stu_findByid`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `stu_findByid`(in sid int)
begin
	select * from  test where id=sid;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `stu_testWhile`
-- ----------------------------
DROP PROCEDURE IF EXISTS `stu_testWhile`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `stu_testWhile`(in name VARCHAR(20),out age int,out sex int,out address VARCHAR(20))
begin
        -- 定义两个局部变量
  set age =20;      
	set sex = 1;
	set address='NY';
END
;;
DELIMITER ;
