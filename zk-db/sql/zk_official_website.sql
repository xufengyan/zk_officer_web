/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : zk_official_website

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 12/04/2021 17:50:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zk_admin
-- ----------------------------
DROP TABLE IF EXISTS `zk_admin`;
CREATE TABLE `zk_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '管理员名称',
  `password` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '管理员密码',
  `last_login_ip` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最近一次登录IP地址',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '最近一次登录时间',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '\'' COMMENT '头像图片',
  `add_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `role_ids` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '[]' COMMENT '角色列表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_admin
-- ----------------------------
INSERT INTO `zk_admin` VALUES (1, 'admin123', '$2a$10$.rEfyBb/GURD9P2p0fRg/OAJGloGNDkJS4lY0cQHeqDgsbdTylBpu', '0:0:0:0:0:0:0:1', '2021-04-12 17:32:39', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '2018-02-01 00:00:00', '2021-04-12 17:32:39', 0, '[1]');
INSERT INTO `zk_admin` VALUES (4, 'promotion123', '$2a$10$wDZLOLLnzZ1EFZ3ldZ1XFOUWDEX6TnQCUFdJz4g.PoMaLTzS8TjWq', '0:0:0:0:0:0:0:1', '2021-04-08 10:59:55', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '2019-01-07 15:16:59', '2021-04-08 10:59:55', 0, '[3]');
INSERT INTO `zk_admin` VALUES (5, 'mall123', '$2a$10$aCtsc4rG6KmxQ59.IkYse.oRyKuwQoU2CPCmxSdB.d5nXq6aw/z4O', '0:0:0:0:0:0:0:1', '2021-04-08 11:14:25', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '2019-01-07 15:17:25', '2021-04-08 11:14:25', 0, '[2]');
INSERT INTO `zk_admin` VALUES (6, 'mall1234', '$2a$10$aCtsc4rG6KmxQ59.IkYse.oRyKuwQoU2CPCmxSdB.d5nXq6aw/z4O', '0:0:0:0:0:0:0:1', '2021-04-08 10:52:11', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '2019-01-07 15:17:25', '2021-04-08 10:52:11', 0, '[3]');

-- ----------------------------
-- Table structure for zk_basic
-- ----------------------------
DROP TABLE IF EXISTS `zk_basic`;
CREATE TABLE `zk_basic`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ow_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'logo地址',
  `ow_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站名称',
  `ow_brief_introduction` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站简介',
  `ow_qrcode_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '二维码地址',
  `ow_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `ow_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `ow_woek_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作时间',
  `ow_internetcp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备案',
  `add_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `ow_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司网址',
  `ow_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱地址',
  `ow_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司地址',
  `ow_lua_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '语言类型（zh-CN：中文；en：英文）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '官网基本信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_basic
-- ----------------------------
INSERT INTO `zk_basic` VALUES (1, 'http://localhost:8089/admin/storage/fetch/wrdallmxe2coftnwmt92.png', '深圳致开科技有限公司', '<h2 style=\"text-align: center;\">公司简介</h2>\n<h4 style=\"text-align: center;\">致力于做最专业的北斗GPS定位测量解决方案提供商</h4>\n<hr />\n<p>公司是有着丰富实践经验和前沿理论知识的电子工程师发起的，秉承了工程师勤奋，务实，程序的优良品质。 我们始终坚持以客户为中心，坚持创新，致力于为客户提供最优质的产品和服务，帮助合作伙伴以正确的方法制造正确的产品，不仅能够以更低的成本 、更快的速度创新新产品，而且还提高了产品质量和可靠性。</p>\n<p>公司及其前身-众成电子工作室历经数年的磨合、模式、实践、最终决定定位测量领域，公司推出的北斗/GPS土地面积测系统已在工业、农业 交通等各行各业得到广泛应用，由本公司提供技术方案的，GPS/北斗测录在市场上已取得约100K台/年的成绩。</p>\n<p>借助一流的工程能力和优质的服务能力，我们赢得了GPS/北斗测亩仪市场的主导地位，获得合作伙伴的肯定。展望未来，致开 科技坚持创新，客户导向，一如既往的向市场提供稳定的电子产品。</p>\n<p><img src=\"http://ruinianda.com/wp-content/themes/chikytech_theme_v3.6/assets/img/about/qiant.jpg\" width=\"653\" height=\"381\" /></p>', 'http://localhost:8089/admin/storage/fetch/sxw2vy1rqmm7oyj1r35q.jpg', '0755-2720-2606', '13530108906', '周一至周日 9:00-18:00 (节假日除外)', '深圳致开科技有限公司 版权所有 Copyright © 2015-2018 粤ICP备16004202号', '2021-04-12 16:00:37', '2021-04-12 17:39:37', 'www.chikytech.com', 'allen.cao@chiky.cn', '深圳宝安区盐田商务广场A座409、405、411、413', 'zh-CN');
INSERT INTO `zk_basic` VALUES (2, 'http://localhost:8089/admin/storage/fetch/sl9q336i0u1ew2p7kv8m.jpg', '深圳致开科技有限公司', NULL, 'http://localhost:8089/admin/storage/fetch/sl9q336i0u1ew2p7kv8m.jpg', '0755-2720-2606', '13530108906', '周一至周日 9:00-18:00 (节假日除外)', '深圳致开科技有限公司 版权所有 Copyright © 2015-2018 粤ICP备16004202号', '2021-04-12 16:00:37', '2021-04-12 16:00:40', 'www.chikytech.com', 'allen.cao@chiky.cn', '深圳宝安区盐田商务广场A座409、405、411、413', 'en');

-- ----------------------------
-- Table structure for zk_category
-- ----------------------------
DROP TABLE IF EXISTS `zk_category`;
CREATE TABLE `zk_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(10) NULL DEFAULT NULL COMMENT 'key',
  `label` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_category
-- ----------------------------

-- ----------------------------
-- Table structure for zk_download
-- ----------------------------
DROP TABLE IF EXISTS `zk_download`;
CREATE TABLE `zk_download`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `d_max_image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展示大图',
  `d_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `d_descibe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件描述',
  `d_image_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展示图片地址',
  `d_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下载地址',
  `d_lan_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '语言类型（zh_CN中文说明书，en英文说明书）',
  `add_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '说明文件下载表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_download
-- ----------------------------

-- ----------------------------
-- Table structure for zk_image_management
-- ----------------------------
DROP TABLE IF EXISTS `zk_image_management`;
CREATE TABLE `zk_image_management`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `image_type` int(11) NULL DEFAULT NULL COMMENT '图片类型（0：轮播图片，1：合作伙伴，2：招聘网站，3：荣誉资质）',
  `visit_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问地址',
  `add_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `del_type` int(255) NULL DEFAULT 0 COMMENT '删除状态0正常,1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_image_management
-- ----------------------------

-- ----------------------------
-- Table structure for zk_list
-- ----------------------------
DROP TABLE IF EXISTS `zk_list`;
CREATE TABLE `zk_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `c_type` int(255) NULL DEFAULT NULL COMMENT '0:技术领域，1：我们的优势',
  `add_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `del_type` int(1) NULL DEFAULT 0 COMMENT '0正常，1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_list
-- ----------------------------

-- ----------------------------
-- Table structure for zk_log
-- ----------------------------
DROP TABLE IF EXISTS `zk_log`;
CREATE TABLE `zk_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '管理员',
  `ip` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '管理员地址',
  `type` int(11) NULL DEFAULT NULL COMMENT '操作分类',
  `action` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作动作',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '操作状态',
  `result` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作结果，或者成功消息，或者失败消息',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '补充信息',
  `add_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_log
-- ----------------------------
INSERT INTO `zk_log` VALUES (1, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2019-12-08 19:12:40', '2019-12-08 19:12:40', 0);
INSERT INTO `zk_log` VALUES (43, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-03-26 10:39:32', '2021-03-26 10:39:32', 0);
INSERT INTO `zk_log` VALUES (44, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-03-26 10:42:08', '2021-03-26 10:42:08', 0);
INSERT INTO `zk_log` VALUES (45, 'admin123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-03-26 11:52:38', '2021-03-26 11:52:38', 0);
INSERT INTO `zk_log` VALUES (46, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-03-26 13:38:13', '2021-03-26 13:38:13', 0);
INSERT INTO `zk_log` VALUES (47, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-03-26 16:21:50', '2021-03-26 16:21:50', 0);
INSERT INTO `zk_log` VALUES (48, '匿名用户', '0:0:0:0:0:0:0:1', 1, '登录', 0, '认证失败', '', '2021-04-07 15:08:18', '2021-04-07 15:08:18', 0);
INSERT INTO `zk_log` VALUES (49, '匿名用户', '0:0:0:0:0:0:0:1', 1, '登录', 0, '认证失败', '', '2021-04-07 15:12:23', '2021-04-07 15:12:23', 0);
INSERT INTO `zk_log` VALUES (50, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-07 15:16:46', '2021-04-07 15:16:46', 0);
INSERT INTO `zk_log` VALUES (51, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-07 15:34:11', '2021-04-07 15:34:11', 0);
INSERT INTO `zk_log` VALUES (52, 'admin123', '192.168.0.131', 1, '登录', 1, '', '', '2021-04-07 15:41:59', '2021-04-07 15:41:59', 0);
INSERT INTO `zk_log` VALUES (53, 'admin123', '192.168.0.131', 1, '登录', 1, '', '', '2021-04-07 15:42:02', '2021-04-07 15:42:02', 0);
INSERT INTO `zk_log` VALUES (54, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:07:31', '2021-04-08 10:07:31', 0);
INSERT INTO `zk_log` VALUES (55, 'admin123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 10:17:26', '2021-04-08 10:17:26', 0);
INSERT INTO `zk_log` VALUES (56, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:17:32', '2021-04-08 10:17:32', 0);
INSERT INTO `zk_log` VALUES (57, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:18:36', '2021-04-08 10:18:36', 0);
INSERT INTO `zk_log` VALUES (58, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:21:09', '2021-04-08 10:21:09', 0);
INSERT INTO `zk_log` VALUES (59, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:23:02', '2021-04-08 10:23:02', 0);
INSERT INTO `zk_log` VALUES (60, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:24:06', '2021-04-08 10:24:06', 0);
INSERT INTO `zk_log` VALUES (61, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:34:02', '2021-04-08 10:34:02', 0);
INSERT INTO `zk_log` VALUES (62, 'mall123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 10:39:49', '2021-04-08 10:39:49', 0);
INSERT INTO `zk_log` VALUES (63, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:40:07', '2021-04-08 10:40:07', 0);
INSERT INTO `zk_log` VALUES (64, 'mall123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 10:43:19', '2021-04-08 10:43:19', 0);
INSERT INTO `zk_log` VALUES (65, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:45:19', '2021-04-08 10:45:19', 0);
INSERT INTO `zk_log` VALUES (66, 'mall123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 10:48:56', '2021-04-08 10:48:56', 0);
INSERT INTO `zk_log` VALUES (67, 'mall1234', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:49:19', '2021-04-08 10:49:19', 0);
INSERT INTO `zk_log` VALUES (68, 'mall1234', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 10:49:30', '2021-04-08 10:49:30', 0);
INSERT INTO `zk_log` VALUES (69, 'mall1234', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:49:47', '2021-04-08 10:49:47', 0);
INSERT INTO `zk_log` VALUES (70, 'mall1234', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:51:36', '2021-04-08 10:51:36', 0);
INSERT INTO `zk_log` VALUES (71, 'mall1234', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:52:11', '2021-04-08 10:52:11', 0);
INSERT INTO `zk_log` VALUES (72, 'mall1234', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 10:59:35', '2021-04-08 10:59:35', 0);
INSERT INTO `zk_log` VALUES (73, 'promotion123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:59:55', '2021-04-08 10:59:55', 0);
INSERT INTO `zk_log` VALUES (74, 'promotion123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 11:00:05', '2021-04-08 11:00:05', 0);
INSERT INTO `zk_log` VALUES (75, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 11:13:15', '2021-04-08 11:13:15', 0);
INSERT INTO `zk_log` VALUES (76, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 11:14:25', '2021-04-08 11:14:25', 0);
INSERT INTO `zk_log` VALUES (77, 'mall123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 11:22:56', '2021-04-08 11:22:56', 0);
INSERT INTO `zk_log` VALUES (78, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 11:23:01', '2021-04-08 11:23:01', 0);
INSERT INTO `zk_log` VALUES (79, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 11:37:10', '2021-04-08 11:37:10', 0);
INSERT INTO `zk_log` VALUES (80, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 11:39:52', '2021-04-08 11:39:52', 0);
INSERT INTO `zk_log` VALUES (81, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 13:50:01', '2021-04-08 13:50:01', 0);
INSERT INTO `zk_log` VALUES (82, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 15:27:22', '2021-04-08 15:27:22', 0);
INSERT INTO `zk_log` VALUES (83, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 15:30:22', '2021-04-08 15:30:22', 0);
INSERT INTO `zk_log` VALUES (84, 'admin123', '192.168.0.131', 1, '登录', 1, '', '', '2021-04-08 15:35:18', '2021-04-08 15:35:18', 0);
INSERT INTO `zk_log` VALUES (85, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 15:38:55', '2021-04-08 15:38:55', 0);
INSERT INTO `zk_log` VALUES (86, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-09 09:18:36', '2021-04-09 09:18:36', 0);
INSERT INTO `zk_log` VALUES (87, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-09 09:38:50', '2021-04-09 09:38:50', 0);
INSERT INTO `zk_log` VALUES (88, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-09 10:00:31', '2021-04-09 10:00:31', 0);
INSERT INTO `zk_log` VALUES (89, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-09 10:00:49', '2021-04-09 10:00:49', 0);
INSERT INTO `zk_log` VALUES (90, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-10 10:26:47', '2021-04-10 10:26:47', 0);
INSERT INTO `zk_log` VALUES (91, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-12 08:59:27', '2021-04-12 08:59:27', 0);
INSERT INTO `zk_log` VALUES (92, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-12 09:14:33', '2021-04-12 09:14:33', 0);
INSERT INTO `zk_log` VALUES (93, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-12 15:51:29', '2021-04-12 15:51:29', 0);
INSERT INTO `zk_log` VALUES (94, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-12 16:03:40', '2021-04-12 16:03:40', 0);
INSERT INTO `zk_log` VALUES (95, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-12 16:10:31', '2021-04-12 16:10:31', 0);
INSERT INTO `zk_log` VALUES (96, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-12 16:27:24', '2021-04-12 16:27:24', 0);
INSERT INTO `zk_log` VALUES (97, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-12 16:29:29', '2021-04-12 16:29:29', 0);
INSERT INTO `zk_log` VALUES (98, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-12 17:03:47', '2021-04-12 17:03:47', 0);
INSERT INTO `zk_log` VALUES (99, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-12 17:18:27', '2021-04-12 17:18:27', 0);
INSERT INTO `zk_log` VALUES (100, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-12 17:32:39', '2021-04-12 17:32:39', 0);

-- ----------------------------
-- Table structure for zk_permission
-- ----------------------------
DROP TABLE IF EXISTS `zk_permission`;
CREATE TABLE `zk_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `permission` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限',
  `add_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_permission
-- ----------------------------
INSERT INTO `zk_permission` VALUES (1, 1, '*', '2019-01-01 00:00:00', '2019-01-01 00:00:00', 0);
INSERT INTO `zk_permission` VALUES (2, 2, 'admin:category:read', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (3, 2, 'admin:category:update', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (4, 2, 'admin:category:delete', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (5, 2, 'admin:category:create', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (6, 2, 'admin:category:list', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (7, 2, 'admin:brand:create', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (8, 2, 'admin:brand:list', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (9, 2, 'admin:brand:delete', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (10, 2, 'admin:brand:read', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (11, 2, 'admin:brand:update', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (12, 3, 'admin:ad:list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (13, 3, 'admin:ad:delete', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (14, 3, 'admin:ad:create', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (15, 3, 'admin:ad:update', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (16, 3, 'admin:ad:read', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (17, 3, 'admin:groupon:list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (18, 3, 'admin:groupon:update', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (19, 3, 'admin:groupon:create', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (20, 3, 'admin:groupon:read', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (21, 3, 'admin:groupon:delete', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (22, 3, 'admin:topic:create', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (23, 3, 'admin:topic:read', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (24, 3, 'admin:topic:list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (25, 3, 'admin:topic:delete', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (26, 3, 'admin:topic:update', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (27, 3, 'admin:coupon:list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (28, 3, 'admin:coupon:delete', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (29, 3, 'admin:coupon:read', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (30, 3, 'admin:coupon:create', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (31, 3, 'admin:coupon:update', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (32, 2, 'admin:web:mangement', '2021-04-08 11:10:15', '2021-04-08 11:10:17', 1);
INSERT INTO `zk_permission` VALUES (33, 2, 'admin:role:update', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (34, 2, 'admin:role:delete', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (35, 2, 'admin:role:read', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (36, 2, 'admin:role:permission:get', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (37, 2, 'admin:role:create', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (38, 2, 'admin:role:list', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (39, 2, 'admin:role:permission:update', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (40, 2, 'admin:role:update', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (41, 2, 'admin:role:delete', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (42, 2, 'admin:role:read', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (43, 2, 'admin:role:permission:get', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (44, 2, 'admin:role:create', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (45, 2, 'admin:role:list', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (46, 2, 'admin:role:permission:update', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (47, 2, 'admin:web:mangement', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (48, 3, 'admin:web:mangement', '2021-04-08 11:42:34', '2021-04-08 11:42:34', 1);
INSERT INTO `zk_permission` VALUES (49, 3, 'admin:role:update', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (50, 3, 'admin:role:delete', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (51, 3, 'admin:role:read', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (52, 3, 'admin:role:permission:get', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (53, 3, 'admin:role:create', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (54, 3, 'admin:role:list', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (55, 3, 'admin:role:permission:update', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (56, 3, 'admin:basic:mangement', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (57, 3, 'admin:basic:mangement', '2021-04-08 11:52:58', '2021-04-08 11:52:58', 0);

-- ----------------------------
-- Table structure for zk_product
-- ----------------------------
DROP TABLE IF EXISTS `zk_product`;
CREATE TABLE `zk_product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `p_type` int(2) NULL DEFAULT NULL COMMENT '产品类型',
  `p_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `p_image_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品图片地址',
  `p_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品型号',
  `p_introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_product
-- ----------------------------

-- ----------------------------
-- Table structure for zk_role
-- ----------------------------
DROP TABLE IF EXISTS `zk_role`;
CREATE TABLE `zk_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `desc` varchar(1023) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用',
  `add_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name_UNIQUE`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_role
-- ----------------------------
INSERT INTO `zk_role` VALUES (1, '超级管理员', '所有模块的权限', 1, '2019-01-01 00:00:00', '2019-01-01 00:00:00', 0);
INSERT INTO `zk_role` VALUES (2, '商场管理员', '只有商场模块的操作权限', 1, '2019-01-01 00:00:00', '2019-01-07 15:15:12', 0);
INSERT INTO `zk_role` VALUES (3, '推广管理员', '只有推广模块的操作权限', 1, '2019-01-01 00:00:00', '2019-01-07 15:15:24', 0);

-- ----------------------------
-- Table structure for zk_scheme
-- ----------------------------
DROP TABLE IF EXISTS `zk_scheme`;
CREATE TABLE `zk_scheme`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '解决方案',
  `s_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方案名称',
  `s_image_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方案宣传图',
  `s_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方案内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '解决方案表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_scheme
-- ----------------------------
INSERT INTO `zk_scheme` VALUES (1, '定位测量方案1', 'http://localhost:8089/admin/storage/fetch/1sauzzzvcin173ncjyja.jpg', '<h2 style=\"text-align: center;\">公司简介1</h2>\n<h4 style=\"text-align: center;\">致力于做最专业的北斗GPS定位测量解决方案提供商</h4>\n<hr />\n<p>公司是有着丰富实践经验和前沿理论知识的电子工程师发起的，秉承了工程师勤奋，务实，程序的优良品质。 我们始终坚持以客户为中心，坚持创新，致力于为客户提供最优质的产品和服务，帮助合作伙伴以正确的方法制造正确的产品，不仅能够以更低的成本 、更快的速度创新新产品，而且还提高了产品质量和可靠性。</p>\n<p>公司及其前身-众成电子工作室历经数年的磨合、模式、实践、最终决定定位测量领域，公司推出的北斗/GPS土地面积测系统已在工业、农业 交通等各行各业得到广泛应用，由本公司提供技术方案的，GPS/北斗测录在市场上已取得约100K台/年的成绩。</p>\n<p>借助一流的工程能力和优质的服务能力，我们赢得了GPS/北斗测亩仪市场的主导地位，获得合作伙伴的肯定。展望未来，致开 科技坚持创新，客户导向，一如既往的向市场提供稳定的电子产品。</p>\n<p><img src=\"http://ruinianda.com/wp-content/themes/chikytech_theme_v3.6/assets/img/about/qiant.jpg\" width=\"653\" height=\"381\" /></p>');
INSERT INTO `zk_scheme` VALUES (2, '测量定位方案2', NULL, '<h2 style=\"text-align: center;\">公司简介2</h2>\n<h4 style=\"text-align: center;\">致力于做最专业的北斗GPS定位测量解决方案提供商</h4>\n<hr />\n<p>公司是有着丰富实践经验和前沿理论知识的电子工程师发起的，秉承了工程师勤奋，务实，程序的优良品质。 我们始终坚持以客户为中心，坚持创新，致力于为客户提供最优质的产品和服务，帮助合作伙伴以正确的方法制造正确的产品，不仅能够以更低的成本 、更快的速度创新新产品，而且还提高了产品质量和可靠性。</p>\n<p>公司及其前身-众成电子工作室历经数年的磨合、模式、实践、最终决定定位测量领域，公司推出的北斗/GPS土地面积测系统已在工业、农业 交通等各行各业得到广泛应用，由本公司提供技术方案的，GPS/北斗测录在市场上已取得约100K台/年的成绩。</p>\n<p>借助一流的工程能力和优质的服务能力，我们赢得了GPS/北斗测亩仪市场的主导地位，获得合作伙伴的肯定。展望未来，致开 科技坚持创新，客户导向，一如既往的向市场提供稳定的电子产品。</p>\n<p><img src=\"http://ruinianda.com/wp-content/themes/chikytech_theme_v3.6/assets/img/about/qiant.jpg\" width=\"653\" height=\"381\" /></p>');

-- ----------------------------
-- Table structure for zk_storage
-- ----------------------------
DROP TABLE IF EXISTS `zk_storage`;
CREATE TABLE `zk_storage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件的唯一索引',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件名',
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件类型',
  `size` int(11) NOT NULL COMMENT '文件大小',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件访问链接',
  `add_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `key`(`key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件存储表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_storage
-- ----------------------------
INSERT INTO `zk_storage` VALUES (12, 'sl9q336i0u1ew2p7kv8m.jpg', 'fc2a95acfbf7421f9cbf496b77801292.jpg', 'image/jpeg', 16108, 'http://localhost:8089/admin/storage/fetch/sl9q336i0u1ew2p7kv8m.jpg', '2021-04-08 15:39:03', '2021-04-08 15:39:03', 0);
INSERT INTO `zk_storage` VALUES (13, 'cp9t9xzvik3w8d4tcwy6.jpg', 'fc2a95acfbf7421f9cbf496b77801292.jpg', 'image/jpeg', 16108, 'http://localhost:8089/admin/storage/fetch/cp9t9xzvik3w8d4tcwy6.jpg', '2021-04-10 11:25:02', '2021-04-10 11:25:02', 0);
INSERT INTO `zk_storage` VALUES (14, 'lurdfr7w7wo2itgimhgu.jpg', 'section-11.jpg', 'image/jpeg', 114977, 'http://localhost:8089/admin/storage/fetch/lurdfr7w7wo2itgimhgu.jpg', '2021-04-10 15:03:08', '2021-04-10 15:03:08', 0);
INSERT INTO `zk_storage` VALUES (15, '05ysdkfdyk3eh2q6o6ha.sql', 'chikycloudweb.sql', 'application/octet-stream', 45348, 'http://localhost:8089/admin/storage/fetch/05ysdkfdyk3eh2q6o6ha.sql', '2021-04-12 09:59:06', '2021-04-12 09:59:06', 0);
INSERT INTO `zk_storage` VALUES (16, 'sa00gt1x5nde3fftzxlf.txt', '新建文本文档.txt', 'text/plain', 66983, 'http://localhost:8089/admin/storage/fetch/sa00gt1x5nde3fftzxlf.txt', '2021-04-12 11:08:25', '2021-04-12 11:08:25', 0);
INSERT INTO `zk_storage` VALUES (17, 'k4p5pxbt2kfhbrlvmwyb.sql', 'music_dome.sql', 'application/octet-stream', 30948, 'http://localhost:8089/admin/storage/fetch/k4p5pxbt2kfhbrlvmwyb.sql', '2021-04-12 11:21:43', '2021-04-12 11:21:43', 0);
INSERT INTO `zk_storage` VALUES (18, 'yjb3etbzq2pbyp27u8tj.log', 'session.log', 'application/octet-stream', 15191, 'http://localhost:8089/admin/storage/fetch/yjb3etbzq2pbyp27u8tj.log', '2021-04-12 11:22:35', '2021-04-12 11:22:35', 0);
INSERT INTO `zk_storage` VALUES (19, 'z14w5l0rviokm4kt30a2.sql', 'music_dome.sql', 'application/octet-stream', 30948, 'http://localhost:8089/admin/storage/fetch/z14w5l0rviokm4kt30a2.sql', '2021-04-12 11:25:54', '2021-04-12 11:25:54', 0);
INSERT INTO `zk_storage` VALUES (20, '1sauzzzvcin173ncjyja.jpg', 'section-11.jpg', 'image/jpeg', 114977, 'http://localhost:8089/admin/storage/fetch/1sauzzzvcin173ncjyja.jpg', '2021-04-12 17:38:51', '2021-04-12 17:38:51', 0);
INSERT INTO `zk_storage` VALUES (21, 'wrdallmxe2coftnwmt92.png', '1134x1134.png', 'image/png', 128749, 'http://localhost:8089/admin/storage/fetch/wrdallmxe2coftnwmt92.png', '2021-04-12 17:39:29', '2021-04-12 17:39:29', 0);
INSERT INTO `zk_storage` VALUES (22, 'sxw2vy1rqmm7oyj1r35q.jpg', '致开科技二维码.jpg', 'image/jpeg', 153522, 'http://localhost:8089/admin/storage/fetch/sxw2vy1rqmm7oyj1r35q.jpg', '2021-04-12 17:39:34', '2021-04-12 17:39:34', 0);

SET FOREIGN_KEY_CHECKS = 1;
