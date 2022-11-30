/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : example

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 30/11/2022 21:42:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ss_goods
-- ----------------------------
DROP TABLE IF EXISTS `ss_goods`;
CREATE TABLE `ss_goods`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `price` decimal(10, 2) NOT NULL COMMENT '商品售价',
  `uid` int(8) NOT NULL COMMENT '发布者id',
  `desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品描述',
  `view` int(8) NULL DEFAULT NULL COMMENT '浏览量',
  `count` int(4) NOT NULL COMMENT '数量',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品封面',
  `g_cid` int(8) NOT NULL COMMENT '商品父类id',
  `g_sub_cid` int(8) NOT NULL COMMENT '类别子类id',
  `is_del` int(1) NOT NULL COMMENT '是删除 0：否，1:是',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100026 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ss_goods
-- ----------------------------
INSERT INTO `ss_goods` VALUES (100001, 'Redmi Note12Pro 5G IMX766 OIS光学防抖 年度旗舰影像组合 OLED柔性直屏8GB+256GB子夜黑 智能手机小米红米', 1899.00, 1, '品牌： 小米（MI）\n商品名称：小米Redmi Note 12 Pro\n商品编号：100044834019\n商品毛重：498.00g\n商品产地：中国大陆\nCPU型号：天玑1080\n运行内存：8GB\n机身颜色：黑色\n三防标准：IP53\n屏幕分辨率：FHD+\n充电功率：50-79W\n机身内存：256GB\n风格：科技，大气，商务\n屏幕材质：OLED直屏\n后摄主像素：5000万像素\n机身色系：黑色系', 136, 1, '/data/goods/100001/20221129-201307-179E1EED5A5E418BA7E2DF2ED8C02A71.jpg', 101, 1001, 0, '2022-11-03 19:23:06', 'hentai');
INSERT INTO `ss_goods` VALUES (100002, 'Apple iPhone 14 (A2884) 128GB 紫色 支持移动联通电信5G 双卡双待手机', 5999.00, 1, 'erty', 113, 2, '/app/data/goods/100002/80519635.jpg', 101, 1001, 0, '2022-11-03 19:23:08', 'hentai');
INSERT INTO `ss_goods` VALUES (100003, 'Redmi K50 至尊版 骁龙8+旗舰处理器 1亿像素光学防抖 120W+5000mAh 12GB+256GB 雅黑 小米红米K50 Ultra', 3099.00, 1, NULL, 133, 1, '/app/data/goods/100003/60186115.jpg', 101, 1001, 0, '2022-11-03 19:23:10', 'hentai');
INSERT INTO `ss_goods` VALUES (100004, 'vivo iQOO Neo7 12GB+256GB 几何黑 天玑9000+ 独显芯片Pro+ E5柔性直屏 120W超快闪充 5G全网通手机iqooneo7', 29999.00, 1, NULL, 89, 1, '/app/data/goods/100004/53122135.jpg', 101, 1001, 0, '2022-11-03 19:23:13', 'hentai');
INSERT INTO `ss_goods` VALUES (100005, '小度智能屏X10 10英寸高清大屏 影音娱乐智慧屏 触屏智能音箱 WiFi/蓝牙音箱 音响', 849.00, 1, NULL, 68, 1, '/app/data/goods/100005/75165811.jpg', 101, 1003, 0, '2022-11-03 19:23:16', 'hentai');
INSERT INTO `ss_goods` VALUES (100006, '小度智能屏X8 升级版 影音娱乐机顶盒 高清带屏音箱 家庭KTV WiFi/蓝牙音箱音响 京东小家智能生态产品', 579.00, 1, NULL, 45, 1, '/app/data/goods/100006/12875322.jpg', 101, 1003, 0, '2022-11-03 19:23:19', 'hentai');
INSERT INTO `ss_goods` VALUES (100007, '小米小爱音箱Play 小爱同学 AIoT语音控制 蓝牙Mesh网关 超级故事王 智能音箱 智能音响 小爱音响', 99.00, 1, NULL, 87, 1, '/app/data/goods/100007/42088553.jpg', 101, 1003, 0, '2022-11-03 19:23:21', 'hentai');
INSERT INTO `ss_goods` VALUES (100008, '适马（SIGMA）Art 85mm F1.4 DG HSM 全画幅 大光圈定焦镜头 人像肖像特写（佳能单反卡口）', 5199.00, 1, NULL, 90, 1, '/app/data/goods/100008/67013091.jpg', 101, 1002, 0, '2022-11-03 19:23:24', 'hentai');
INSERT INTO `ss_goods` VALUES (100009, '荣耀手环6 全天候血氧监测 95种运动模式 智能手环 运动手环 智能心率 50米防水 陨石黑', 198.00, 1, NULL, 90, 3, '/app/data/goods/100009/39145976.jpg', 101, 1003, 0, '2022-11-03 19:23:26', 'hentai');
INSERT INTO `ss_goods` VALUES (100010, '百事乐（LEBEST）K50s超薄便宜智能手机学生价游戏长续航老人老年机大屏百元备用5g移动电信卡远峰蓝128GB', 587.00, 1, NULL, 67, 4, '/app/data/goods/100010/80025897.jpg', 103, 1001, 0, '2022-11-03 19:23:28', 'hentai');
INSERT INTO `ss_goods` VALUES (100011, '长虹（CHANGHONG） 儿童电话手表长续航学生手表 智能手表GPS定位4G全网通频拍照手表动感蓝 蓝色卡通IP升级版', 299.00, 1, NULL, 48, 2, '/app/data/goods/100011/22899724.jpg', 103, 1003, 0, '2022-11-03 19:23:31', 'hentai');
INSERT INTO `ss_goods` VALUES (100012, 'TCL 8KG变频滚筒L120除菌洗衣机 蒸汽除菌 消毒预洗 夜间洗羽绒洗全自动滚筒超薄洗衣机G80L120-B', 1098.00, 1, NULL, 35, 1, '/app/data/goods/100012/61253193.jpg', 103, 1003, 0, '2022-11-03 19:23:33', 'hentai');
INSERT INTO `ss_goods` VALUES (100013, '科龙空调 大1.5匹挂机自营 新能效变频冷暖 卧室壁挂式 青春派 KFR-35GW/QBA3a(1V01)', 1869.00, 1, NULL, 43, 3, '/app/data/goods/100013/26366750.jpg', 103, 1003, 0, '2022-11-03 19:23:35', 'hentai');
INSERT INTO `ss_goods` VALUES (100014, 'Apple iPhone 14 Pro Max (A2896) 256GB 深空黑色 支持移动联通电信5G 双卡双待手机', 9899.00, 1, NULL, 139, 3, '/app/data/goods/100014/64340815.jpg', 101, 1001, -1, '2022-11-03 19:23:38', 'hentai');
INSERT INTO `ss_goods` VALUES (100015, 'test', 1.00, 1, 'sdefghjkjhgreswdfghujkjhgtresdfghjkm', 2, 1, '/app/tmp/20221130-172657-13B6CFB4EEFA422E97196FE60EC7D9B8.jpg', 104, 1011, -1, '2022-11-30 17:27:21', 'hentai');
INSERT INTO `ss_goods` VALUES (100016, 'asdfgh', 2345.00, 1, '2345', 1, 1, '/app/tmp/20221130-174948-B2EE589B2086403595C0FAEA9A2FE525.jpg', 101, 1001, -1, '2022-11-30 17:49:55', 'hentai');
INSERT INTO `ss_goods` VALUES (100017, 'sdegt', 2345.00, 1, 'wsedrthjk', 1, 1, '/app/tmp/20221130-175324-6FCA6D6AC24D41F186010FE2FACF1315.jpg', 101, 1001, -1, '2022-11-30 17:53:39', 'hentai');
INSERT INTO `ss_goods` VALUES (100018, 'sdfghjk', 2345.00, 1, 'sdefghjk', 1, 1, '/app/tmp/20221130-175851-B20DC6505CCB45F7A7DA92206AE86EDF.jpg', 101, 1001, -1, '2022-11-30 17:59:08', 'hentai');
INSERT INTO `ss_goods` VALUES (100019, 'sdsfghj', 234.00, 1, 'sdfgthujk', 1, 1, '/app/tmp/20221130-180500-E4633CC8A8234EE19ED0AAAC6800014E.jpg', 101, 1001, -1, '2022-11-30 18:05:07', 'hentai');
INSERT INTO `ss_goods` VALUES (100020, 'werty', 234.00, 1, 'asdefghjk', 1, 1, '/data/goods/100020/20221130-180737-A3B13809ADDB48E88074D5F2EEA7AB6C.jpg', 101, 1001, -1, '2022-11-30 18:07:43', 'hentai');
INSERT INTO `ss_goods` VALUES (100021, 'sedfgh', 2345.00, 1, 'sdfgthjuk', 1, 1, '/data/goods/100021/20221130-181103-C4EEF961F79449A59D8441D83FF84F27.jpg', 101, 1001, -1, '2022-11-30 18:11:09', 'hentai');
INSERT INTO `ss_goods` VALUES (100022, 'wesrdtfy', 23456.00, 1, 'asdegthjk', 1, 1, '/data/goods/100022/20221130-181230-A0E7BD6C5FB34286BA0EE26221DF14BC.jpg', 101, 1001, -1, '2022-11-30 18:12:36', 'hentai');
INSERT INTO `ss_goods` VALUES (100023, 'sedgtfhuj', 34567.00, 1, 'sdfghj', 1, 1, '/data/goods/100023/20221130-212916-F966DBF62B874270B60A61CC3E242B5E.jpg', 101, 1001, -1, '2022-11-30 18:13:38', 'hentai');
INSERT INTO `ss_goods` VALUES (100024, 'asdegh', 234567.00, 1, 'swedrtghuji', 1, 1, '/data/goods/100024/20221130-212439-B1671C3D8DD849A29CD21C494BFC9F8C.jpg', 101, 1001, 0, '2022-11-30 21:24:56', 'hentai');
INSERT INTO `ss_goods` VALUES (100025, 'wsaedfgt', 234.00, 1, 'asdefgth', 1, 1, '/data/goods/100025/20221130-212900-2633DCD57524482DBD89A2C0C7CAC82B.jpg', 101, 1001, 0, '2022-11-30 21:29:08', 'hentai');

-- ----------------------------
-- Table structure for ss_goods_categor
-- ----------------------------
DROP TABLE IF EXISTS `ss_goods_categor`;
CREATE TABLE `ss_goods_categor`  (
  `id` int(8) NOT NULL COMMENT '商品类别',
  `name` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ss_goods_categor
-- ----------------------------
INSERT INTO `ss_goods_categor` VALUES (101, '手机数码');
INSERT INTO `ss_goods_categor` VALUES (102, '游戏装备');
INSERT INTO `ss_goods_categor` VALUES (103, '生活百货');
INSERT INTO `ss_goods_categor` VALUES (104, '技能服务');

-- ----------------------------
-- Table structure for ss_goods_comment
-- ----------------------------
DROP TABLE IF EXISTS `ss_goods_comment`;
CREATE TABLE `ss_goods_comment`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `uid` int(8) NOT NULL COMMENT '用户id',
  `g_id` int(8) NOT NULL COMMENT '商品id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `is_del` int(1) NOT NULL COMMENT '是否删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ss_goods_comment
-- ----------------------------
INSERT INTO `ss_goods_comment` VALUES (1, 1, 100001, 'qwesdrfgtrewsedfgredwsrfg', 0, '2022-11-28 14:34:22', 'hentai');
INSERT INTO `ss_goods_comment` VALUES (2, 1, 100001, 'wesrfghfrewqedr', 0, '2022-11-28 14:34:39', 'hentai');
INSERT INTO `ss_goods_comment` VALUES (3, 1, 100001, '2we4rty', 0, '2022-11-28 15:35:28', 'hentai');
INSERT INTO `ss_goods_comment` VALUES (4, 1, 100001, 'we345tyu', 0, '2022-11-28 15:36:50', 'hentai');
INSERT INTO `ss_goods_comment` VALUES (5, 1, 100001, 'sdfthujk', 0, '2022-11-28 15:38:46', 'hentai');
INSERT INTO `ss_goods_comment` VALUES (6, 1, 100001, '2we34rty', 0, '2022-11-28 15:42:27', 'hentai');
INSERT INTO `ss_goods_comment` VALUES (7, 1, 100001, 'wqertyu', 0, '2022-11-28 15:46:42', 'hentai');
INSERT INTO `ss_goods_comment` VALUES (8, 1, 100001, 'ertyuiwert认同感医患纠纷他居然的交通费', 0, '2022-11-28 15:58:01', 'hentai');
INSERT INTO `ss_goods_comment` VALUES (9, 1, 100001, '啊我色弱推哦', 0, '2022-11-28 16:00:24', 'hentai');
INSERT INTO `ss_goods_comment` VALUES (10, 1, 100001, '微软推', 0, '2022-11-28 16:01:22', 'hentai');
INSERT INTO `ss_goods_comment` VALUES (11, 1, 100001, '无色的认同感付货款', 0, '2022-11-28 16:02:21', 'hentai');
INSERT INTO `ss_goods_comment` VALUES (12, 1, 100001, '说的太过分户籍科了', 0, '2022-11-28 16:05:03', 'hentai');
INSERT INTO `ss_goods_comment` VALUES (13, 1, 100001, '无色的人发贴用户', 0, '2022-11-28 16:06:10', 'hentai');
INSERT INTO `ss_goods_comment` VALUES (14, 1, 100001, 'wqasert5y7uiop[', 0, '2022-11-28 16:11:19', 'hentai');

-- ----------------------------
-- Table structure for ss_goods_cover
-- ----------------------------
DROP TABLE IF EXISTS `ss_goods_cover`;
CREATE TABLE `ss_goods_cover`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '商品图片id',
  `g_id` int(8) NOT NULL COMMENT '商品id',
  `path` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ss_goods_cover
-- ----------------------------
INSERT INTO `ss_goods_cover` VALUES (1, 100001, '/data/goods/100001/29198eb69c9c6658.jpg');
INSERT INTO `ss_goods_cover` VALUES (2, 100001, '/data/goods/100001/92235e60e23a5b7e.jpg');

-- ----------------------------
-- Table structure for ss_goods_subcategory
-- ----------------------------
DROP TABLE IF EXISTS `ss_goods_subcategory`;
CREATE TABLE `ss_goods_subcategory`  (
  `id` int(8) NOT NULL COMMENT '子类id',
  `name` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '子类名称',
  `g_cid` int(8) NOT NULL COMMENT '父类id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ss_goods_subcategory
-- ----------------------------
INSERT INTO `ss_goods_subcategory` VALUES (1001, '手机通讯', 101);
INSERT INTO `ss_goods_subcategory` VALUES (1002, '数码配件', 101);
INSERT INTO `ss_goods_subcategory` VALUES (1003, '智能设备', 101);
INSERT INTO `ss_goods_subcategory` VALUES (1004, '影音娱乐', 101);
INSERT INTO `ss_goods_subcategory` VALUES (1005, '游戏机', 102);
INSERT INTO `ss_goods_subcategory` VALUES (1006, '游戏配件', 102);
INSERT INTO `ss_goods_subcategory` VALUES (1007, '保健护理', 103);
INSERT INTO `ss_goods_subcategory` VALUES (1008, '办公用品', 103);
INSERT INTO `ss_goods_subcategory` VALUES (1009, '五金工具', 103);
INSERT INTO `ss_goods_subcategory` VALUES (1010, '办公设备', 103);
INSERT INTO `ss_goods_subcategory` VALUES (1011, '兼职家教', 104);
INSERT INTO `ss_goods_subcategory` VALUES (1012, 'IT服务', 104);
INSERT INTO `ss_goods_subcategory` VALUES (1013, '跑腿代办', 104);
INSERT INTO `ss_goods_subcategory` VALUES (1014, '语言翻译', 104);
INSERT INTO `ss_goods_subcategory` VALUES (1015, '摄影约拍', 104);
INSERT INTO `ss_goods_subcategory` VALUES (1016, '绘画书法', 104);

-- ----------------------------
-- Table structure for ss_shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `ss_shop_cart`;
CREATE TABLE `ss_shop_cart`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `count` int(8) NOT NULL COMMENT '数量',
  `g_id` int(8) NOT NULL COMMENT '商品id',
  `uid` int(8) NOT NULL COMMENT '用户id',
  `number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单号',
  `is_del` int(1) NOT NULL COMMENT '是否支付',
  `create_by` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ss_shop_cart
-- ----------------------------
INSERT INTO `ss_shop_cart` VALUES (5, 2, 100002, 1, '21346576754324354656', -1, 'hentai', '2022-11-29 00:28:12');
INSERT INTO `ss_shop_cart` VALUES (10, 2, 100002, 1, '2356424354245', -1, 'hentai', '2022-11-29 01:12:07');
INSERT INTO `ss_shop_cart` VALUES (13, 2, 100011, 1, NULL, -1, 'hentai', '2022-11-29 09:42:05');
INSERT INTO `ss_shop_cart` VALUES (14, 1, 100001, 3, '234567876543', -1, 'zhangsan', '2022-11-29 14:25:55');
INSERT INTO `ss_shop_cart` VALUES (15, 1, 100007, 3, '234543213456', -1, 'zhangsan', '2022-11-29 14:35:58');
INSERT INTO `ss_shop_cart` VALUES (16, 1, 100002, 3, NULL, -1, 'zhangsan', '2022-11-29 14:36:06');
INSERT INTO `ss_shop_cart` VALUES (17, 1, 100008, 3, NULL, 1, 'zhangsan', '2022-11-29 14:36:15');
INSERT INTO `ss_shop_cart` VALUES (18, 1, 100001, 5, '2345364736343', -1, 'haha', '2022-11-29 22:25:44');
INSERT INTO `ss_shop_cart` VALUES (19, 1, 100002, 5, '3543563463634', -1, 'haha', '2022-11-29 22:25:49');
INSERT INTO `ss_shop_cart` VALUES (20, 1, 100005, 1, NULL, -1, 'hentai', '2022-11-30 00:33:26');
INSERT INTO `ss_shop_cart` VALUES (21, 1, 100001, 5, NULL, 1, 'haha', '2022-11-30 00:33:46');
INSERT INTO `ss_shop_cart` VALUES (22, 1, 100011, 5, NULL, -1, 'haha', '2022-11-30 00:33:58');
INSERT INTO `ss_shop_cart` VALUES (23, 1, 100003, 6, NULL, 1, 'rivate', '2022-11-30 16:31:33');
INSERT INTO `ss_shop_cart` VALUES (24, 1, 100007, 1, NULL, -1, 'hentai', '2022-11-30 21:17:58');

-- ----------------------------
-- Table structure for ss_user
-- ----------------------------
DROP TABLE IF EXISTS `ss_user`;
CREATE TABLE `ss_user`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `avatar` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `is_del` int(1) NOT NULL COMMENT '是否删除 1：是，0：否',
  `create_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ss_user
-- ----------------------------
INSERT INTO `ss_user` VALUES (1, 'Hentai', 'hentai', 'a450f00a7f0901959e2ae4cf73219c74', '/app/data/user/hentai.jpg', '男', '江西省南昌市青山湖区艾溪湖北路688号中兴软件园1号楼6层', '18070504901', 0, 'hentai', '2022-11-01 00:00:00', 'hentai', '2022-11-30 21:18:15');
INSERT INTO `ss_user` VALUES (2, 'Test', 'test', 'e10adc3949ba59abbe56e057f20f883e', '/app/data/user/avatar.png', '女', '南昌市青山湖区艾溪湖北路688号中兴软件园1号楼2层', '18100000000', 0, 'hentai', '2022-11-20 00:00:00', 'hentai', '2022-11-21 00:40:13');
INSERT INTO `ss_user` VALUES (3, '张三', 'zhangsan', 'a450f00a7f0901959e2ae4cf73219c74', '/app/data/user/avatar.png', '男', '南昌市青山湖区艾溪湖北路688号中兴软件园1号楼2层', '18100000000', -1, 'hentai', '2022-11-21 00:42:54', 'hentai', '2022-11-21 00:42:58');
INSERT INTO `ss_user` VALUES (4, '李四', 'lisi', 'a450f00a7f0901959e2ae4cf73219c74', '/app/data/user/avatar.png', '男', '南昌市青山湖区艾溪湖北路688号中兴软件园1号楼2层', '18100000000', 0, 'hentai', '2022-11-21 00:44:24', 'hentai', '2022-11-21 00:44:29');
INSERT INTO `ss_user` VALUES (5, 'haha', 'haha', 'a450f00a7f0901959e2ae4cf73219c74', '/app/data/user/avatar.png', '女', '江西省南昌市新建区欣悦湖街道', '18070504901', 0, 'haha', '2022-11-29 22:10:20', 'haha', '2022-11-30 21:35:22');
INSERT INTO `ss_user` VALUES (6, 'rivate', 'rivate', 'e10adc3949ba59abbe56e057f20f883e', '/app/data/user/avatar.png', '男', '', '', 0, 'rivate', '2022-11-30 16:30:29', 'rivate', '2022-11-30 16:31:24');

SET FOREIGN_KEY_CHECKS = 1;
