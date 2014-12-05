/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : testspring

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2014-12-05 17:27:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `marks`
-- ----------------------------
DROP TABLE IF EXISTS `marks`;
CREATE TABLE `marks` (
  `SID` int(11) NOT NULL,
  `MARKS` int(11) NOT NULL,
  `YEAR` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of marks
-- ----------------------------
INSERT INTO `marks` VALUES ('8', '99', '2010');
INSERT INTO `marks` VALUES ('9', '97', '2010');
INSERT INTO `marks` VALUES ('10', '100', '2011');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `ID` int(11) NOT NULL auto_increment,
  `NAME` varchar(20) NOT NULL,
  `AGE` int(11) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'Zara', '11');
INSERT INTO `student` VALUES ('2', 'Nuha', '20');
INSERT INTO `student` VALUES ('3', 'Ayan', '15');
INSERT INTO `student` VALUES ('4', 'Zara', '11');
INSERT INTO `student` VALUES ('5', 'Nuha', '2');
INSERT INTO `student` VALUES ('6', 'Ayan', '15');
INSERT INTO `student` VALUES ('8', 'Zara', '11');
INSERT INTO `student` VALUES ('9', 'Nuha', '20');
INSERT INTO `student` VALUES ('10', 'Ayan', '25');

-- ----------------------------
-- Procedure structure for `getRecord`
-- ----------------------------
DROP PROCEDURE IF EXISTS `getRecord`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRecord`(
IN in_id INTEGER,
OUT out_name VARCHAR(20),
OUT out_age  INTEGER)
BEGIN
   SELECT name, age
   INTO out_name, out_age
   FROM Student where id = in_id;
END
;;
DELIMITER ;
