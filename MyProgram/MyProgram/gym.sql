/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : gym

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 28/11/2020 11:00:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '头像地址',
  `jurisdiction` int(11) NULL DEFAULT NULL COMMENT '权限设置1>2',
  `state` int(11) NULL DEFAULT NULL COMMENT '状态1起2禁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'root', '123456', '1260414235@qq.com', NULL, 1, 1);
INSERT INTO `admin` VALUES (2, 'boen', '123456', '1234567891@qq.com', NULL, 2, 1);
INSERT INTO `admin` VALUES (3, '3whz', '123456', '1111111111@qq.com', NULL, 2, 1);

-- ----------------------------
-- Table structure for classclassify
-- ----------------------------
DROP TABLE IF EXISTS `classclassify`;
CREATE TABLE `classclassify`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL COMMENT '1/0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classclassify
-- ----------------------------
INSERT INTO `classclassify` VALUES (1, '减脂', 1);
INSERT INTO `classclassify` VALUES (2, '增肌', 1);

-- ----------------------------
-- Table structure for gym
-- ----------------------------
DROP TABLE IF EXISTS `gym`;
CREATE TABLE `gym`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maximum` int(11) NULL DEFAULT NULL COMMENT '最大容量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gym
-- ----------------------------
INSERT INTO `gym` VALUES (1, 50);

-- ----------------------------
-- Table structure for gymclass
-- ----------------------------
DROP TABLE IF EXISTS `gymclass`;
CREATE TABLE `gymclass`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程名',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文本',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '封面',
  `video` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '视频',
  `difficulty` int(11) NULL DEFAULT NULL COMMENT '难度1.2.3.4.5',
  `ci_id` int(11) NULL DEFAULT NULL COMMENT '类型id',
  `u_id` int(11) NULL DEFAULT NULL COMMENT '用户id管理员为0',
  `top` int(11) NULL DEFAULT NULL COMMENT '顶置',
  `state` int(11) NULL DEFAULT NULL COMMENT '状态1起2禁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gymclass
-- ----------------------------
INSERT INTO `gymclass` VALUES (1, '课程', '我是一个课程', 'banner2.jpg', NULL, NULL, 1, 1, 1, 1);
INSERT INTO `gymclass` VALUES (2, '课程2', '我是第二个课程', 'banner.png', NULL, NULL, 2, 3, NULL, 1);
INSERT INTO `gymclass` VALUES (24, '课程6', '2222', 'banner2.jpg', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` int(11) NOT NULL,
  `c_id` int(11) NULL DEFAULT NULL,
  `u_id` int(11) NULL DEFAULT NULL,
  `time` datetime(6) NULL DEFAULT NULL COMMENT '训练时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for orderclass
-- ----------------------------
DROP TABLE IF EXISTS `orderclass`;
CREATE TABLE `orderclass`  (
  `id` int(11) NOT NULL,
  `c_id` int(11) NULL DEFAULT NULL,
  `u_id` int(11) NULL DEFAULT NULL,
  `time` int(11) NULL DEFAULT NULL COMMENT '训练时间1.2..3.4.5.6',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for passengerflow
-- ----------------------------
DROP TABLE IF EXISTS `passengerflow`;
CREATE TABLE `passengerflow`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `one` int(11) NULL DEFAULT NULL COMMENT '8-10',
  `two` int(11) NULL DEFAULT NULL COMMENT '11-12',
  `three` int(11) NULL DEFAULT NULL COMMENT '12-14',
  `four` int(11) NULL DEFAULT NULL COMMENT '14-16',
  `five` int(11) NULL DEFAULT NULL COMMENT '16-18',
  `six` int(11) NULL DEFAULT NULL COMMENT '18-20',
  `seven` int(11) NULL DEFAULT NULL COMMENT '20：00-22：00',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of passengerflow
-- ----------------------------
INSERT INTO `passengerflow` VALUES (1, 20, 50, 40, 30, 20, 10, 50);
INSERT INTO `passengerflow` VALUES (2, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (3, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (4, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (5, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (6, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (7, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (8, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (9, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (10, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (11, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (12, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (13, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (14, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (15, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (16, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (17, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (18, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (19, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (20, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (21, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (22, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (23, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (24, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (25, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (26, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (27, 40, 20, 50, 60, 30, 20, 40);
INSERT INTO `passengerflow` VALUES (28, 40, 20, 50, 60, 30, 20, 40);

-- ----------------------------
-- Table structure for testdata
-- ----------------------------
DROP TABLE IF EXISTS `testdata`;
CREATE TABLE `testdata`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'td_id',
  `pushUps` int(11) NULL DEFAULT NULL,
  `squat` int(11) NULL DEFAULT NULL,
  `tabletsupport` int(11) NULL DEFAULT NULL,
  `u_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '头像地址',
  `coach` int(11) NULL DEFAULT NULL COMMENT '是不是教练1是0不是',
  `state` int(11) NULL DEFAULT NULL COMMENT '状态1起0禁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangsan', '123456', '0', '123456@qq.com', NULL, 1, 1);
INSERT INTO `user` VALUES (2, 'lisi', '123456', '1', '4444444@qq.com', NULL, 0, 1);
INSERT INTO `user` VALUES (3, 'boen', '123456', '1', '1260414235@qq.com', NULL, 1, 1);

-- ----------------------------
-- Table structure for userclass
-- ----------------------------
DROP TABLE IF EXISTS `userclass`;
CREATE TABLE `userclass`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NULL DEFAULT NULL COMMENT '用户外键',
  `c_id` int(11) NULL DEFAULT NULL COMMENT '课程外键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userclass
-- ----------------------------
INSERT INTO `userclass` VALUES (1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
