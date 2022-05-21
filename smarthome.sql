/*
Navicat MySQL Data Transfer

Source Server         : mySql
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : smarthome

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2022-05-21 16:37:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Account` char(10) NOT NULL,
  `Password` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `StaffNo` char(10) DEFAULT NULL,
  PRIMARY KEY (`Account`),
  UNIQUE KEY `AdminAccount` (`Account`),
  KEY `AdminStaffNo` (`StaffNo`),
  CONSTRAINT `AdminStaffNo` FOREIGN KEY (`StaffNo`) REFERENCES `security` (`staffno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('俊小皓', '12345', '1');

-- ----------------------------
-- Table structure for control
-- ----------------------------
DROP TABLE IF EXISTS `control`;
CREATE TABLE `control` (
  `UserAccount` char(10) NOT NULL,
  `FacilityNo` char(10) NOT NULL,
  PRIMARY KEY (`UserAccount`,`FacilityNo`),
  KEY `ControlFacilityNO` (`FacilityNo`),
  KEY `ControlAccount` (`UserAccount`),
  CONSTRAINT `ControlFacilityNO` FOREIGN KEY (`FacilityNo`) REFERENCES `facility` (`facilityno`),
  CONSTRAINT `UserAccount` FOREIGN KEY (`UserAccount`) REFERENCES `user` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of control
-- ----------------------------
INSERT INTO `control` VALUES ('奚小曼', 'A1');
INSERT INTO `control` VALUES ('冯俊皓', 'L4');
INSERT INTO `control` VALUES ('冯俊皓', 'L5');
INSERT INTO `control` VALUES ('李大菊', 'L5');
INSERT INTO `control` VALUES ('李大菊', 'L6');

-- ----------------------------
-- Table structure for facility
-- ----------------------------
DROP TABLE IF EXISTS `facility`;
CREATE TABLE `facility` (
  `FacilityNo` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Category` char(10) NOT NULL,
  `RemainWarPer` int(10) NOT NULL,
  `RoomName` char(10) DEFAULT NULL,
  `isFault` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `FaultType` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ControledNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`FacilityNo`),
  KEY `RoomName` (`RoomName`),
  KEY `Category` (`Category`),
  KEY `No` (`FacilityNo`),
  CONSTRAINT `RoomName` FOREIGN KEY (`RoomName`) REFERENCES `room` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of facility
-- ----------------------------
INSERT INTO `facility` VALUES ('A1', '空调', '12', '卧室', 'true', null, '0');
INSERT INTO `facility` VALUES ('A2', '冰箱', '2', '客厅', 'true', null, '0');
INSERT INTO `facility` VALUES ('A4', '空调', '3', '客厅', 'true', null, '0');
INSERT INTO `facility` VALUES ('L4', '节能灯', '2', '卧室', 'false', null, '1');
INSERT INTO `facility` VALUES ('L5', '灯', '12', '客厅', 'false', null, '2');
INSERT INTO `facility` VALUES ('L6', '灯', '23', '卧室', 'false', null, '1');
INSERT INTO `facility` VALUES ('L7', '节能灯', '12', '卧室', 'false', null, '0');
INSERT INTO `facility` VALUES ('W1', '洗衣机', '3', '卧室', null, null, '0');

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `Time` time NOT NULL,
  `Events` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Category` char(10) DEFAULT NULL,
  `KeyWords` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logs
-- ----------------------------
INSERT INTO `logs` VALUES ('11:18:01', '新增', '控制变动', 'L3');
INSERT INTO `logs` VALUES ('11:18:06', '删除', '控制变动', 'L3');
INSERT INTO `logs` VALUES ('11:45:31', '删除', '控制变动', 'L5');
INSERT INTO `logs` VALUES ('11:45:31', '变更', '用户变动', '匡小栋');
INSERT INTO `logs` VALUES ('11:45:36', '注销', '用户变动', '匡小栋');
INSERT INTO `logs` VALUES ('12:10:35', '删除', '控制变动', 'L6');
INSERT INTO `logs` VALUES ('12:10:35', '变更', '用户变动', '李小菊');
INSERT INTO `logs` VALUES ('12:10:35', '注销', '用户变动', '李小菊');
INSERT INTO `logs` VALUES ('12:12:53', '新增', '用户变动', '匡小栋');
INSERT INTO `logs` VALUES ('12:13:10', '新增', '用户变动', '李小菊');
INSERT INTO `logs` VALUES ('12:13:46', '新增', '用户变动', '小王');
INSERT INTO `logs` VALUES ('12:13:56', '变更', '用户变动', '小王');
INSERT INTO `logs` VALUES ('12:14:55', '新增', '控制变动', 'L6');
INSERT INTO `logs` VALUES ('12:14:55', '变更', '用户变动', '小王');
INSERT INTO `logs` VALUES ('12:15:18', '删除', '控制变动', 'L6');
INSERT INTO `logs` VALUES ('12:15:18', '变更', '用户变动', '小王');
INSERT INTO `logs` VALUES ('12:15:18', '注销', '用户变动', '小王');
INSERT INTO `logs` VALUES ('12:15:35', '变更', '用户变动', '李小菊');
INSERT INTO `logs` VALUES ('12:15:43', '注销', '用户变动', '匡小栋');
INSERT INTO `logs` VALUES ('08:48:33', '新增', '用户变动', '江大涵');
INSERT INTO `logs` VALUES ('08:49:39', '新增', '控制变动', 'L5');
INSERT INTO `logs` VALUES ('08:49:39', '变更', '用户变动', '江大涵');
INSERT INTO `logs` VALUES ('08:49:43', '新增', '控制变动', 'L6');
INSERT INTO `logs` VALUES ('08:49:43', '变更', '用户变动', '江大涵');
INSERT INTO `logs` VALUES ('08:49:49', '删除', '控制变动', 'L6');
INSERT INTO `logs` VALUES ('08:49:49', '变更', '用户变动', '江大涵');
INSERT INTO `logs` VALUES ('08:50:16', '变更', '用户变动', '江大涵');
INSERT INTO `logs` VALUES ('08:50:42', '删除', '控制变动', 'L5');
INSERT INTO `logs` VALUES ('08:50:42', '变更', '用户变动', '江大涵');
INSERT INTO `logs` VALUES ('08:50:42', '注销', '用户变动', '江大涵');
INSERT INTO `logs` VALUES ('08:50:56', '变更', '用户变动', '江小涵');
INSERT INTO `logs` VALUES ('08:51:02', '变更', '用户变动', '江小涵');
INSERT INTO `logs` VALUES ('08:51:16', '注销', '用户变动', '李小菊');
INSERT INTO `logs` VALUES ('08:56:51', '新增', '用户变动', '江大涵');
INSERT INTO `logs` VALUES ('08:57:00', '变更', '用户变动', '江大涵');
INSERT INTO `logs` VALUES ('08:59:55', '新增', '用户变动', '李小菊');
INSERT INTO `logs` VALUES ('09:01:00', '新增', '用户变动', '奚小曼');
INSERT INTO `logs` VALUES ('09:01:27', '新增', '用户变动', '李大菊');
INSERT INTO `logs` VALUES ('09:05:50', '注销', '用户变动', '李小菊');
INSERT INTO `logs` VALUES ('09:05:59', '新增', '用户变动', '李小菊');
INSERT INTO `logs` VALUES ('09:06:18', '注销', '用户变动', '李大菊');
INSERT INTO `logs` VALUES ('09:06:29', '新增', '用户变动', '李大菊');
INSERT INTO `logs` VALUES ('09:06:56', '注销', '用户变动', '奚小曼');
INSERT INTO `logs` VALUES ('09:07:02', '新增', '用户变动', '奚小曼');
INSERT INTO `logs` VALUES ('09:11:26', '变更', '用户变动', '江大涵');
INSERT INTO `logs` VALUES ('09:11:47', '新增', '用户变动', '江中涵');
INSERT INTO `logs` VALUES ('09:12:45', '新增', '控制变动', 'L7');
INSERT INTO `logs` VALUES ('09:12:45', '变更', '用户变动', '江中涵');
INSERT INTO `logs` VALUES ('09:13:18', '删除', '控制变动', 'L7');
INSERT INTO `logs` VALUES ('09:13:18', '变更', '用户变动', '江中涵');
INSERT INTO `logs` VALUES ('09:13:18', '注销', '用户变动', '江中涵');
INSERT INTO `logs` VALUES ('09:13:39', '变更', '用户变动', '江小涵');
INSERT INTO `logs` VALUES ('09:24:02', '新增', '用户变动', '数据库');
INSERT INTO `logs` VALUES ('09:24:09', '变更', '用户变动', '数据库');
INSERT INTO `logs` VALUES ('09:24:36', '新增', '控制变动', 'L7');
INSERT INTO `logs` VALUES ('09:24:36', '变更', '用户变动', '数据库');
INSERT INTO `logs` VALUES ('09:24:50', '删除', '控制变动', 'L7');
INSERT INTO `logs` VALUES ('09:24:50', '变更', '用户变动', '数据库');
INSERT INTO `logs` VALUES ('09:25:22', '注销', '用户变动', '数据库');
INSERT INTO `logs` VALUES ('09:25:41', '变更', '用户变动', '江小涵');
INSERT INTO `logs` VALUES ('09:26:37', '变更', '设备变动', 'L4');
INSERT INTO `logs` VALUES ('09:26:53', '新增', '设备变动', 'L8');
INSERT INTO `logs` VALUES ('09:27:00', '注销', '设备变动', 'L8');
INSERT INTO `logs` VALUES ('13:57:33', '新增', '设备变动', 'A1');
INSERT INTO `logs` VALUES ('13:58:12', '新增', '控制变动', 'A1');
INSERT INTO `logs` VALUES ('13:58:12', '变更', '用户变动', '奚小曼');
INSERT INTO `logs` VALUES ('13:58:12', '变更', '设备变动', 'A1');
INSERT INTO `logs` VALUES ('13:58:23', '新增', '控制变动', 'L6');
INSERT INTO `logs` VALUES ('13:58:23', '变更', '用户变动', '李大菊');
INSERT INTO `logs` VALUES ('13:58:23', '变更', '设备变动', 'L6');
INSERT INTO `logs` VALUES ('13:58:33', '新增', '控制变动', 'L5');
INSERT INTO `logs` VALUES ('13:58:33', '变更', '用户变动', '李大菊');
INSERT INTO `logs` VALUES ('13:58:33', '变更', '设备变动', 'L5');
INSERT INTO `logs` VALUES ('14:01:46', '新增', '设备变动', 'A4');
INSERT INTO `logs` VALUES ('14:01:53', '变更', '设备变动', 'A1');
INSERT INTO `logs` VALUES ('14:13:01', '新增', '用户变动', '12数据库');
INSERT INTO `logs` VALUES ('14:13:30', '变更', '设备变动', 'A2');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `Name` char(10) NOT NULL,
  `Temperature` int(3) DEFAULT NULL,
  `Humidity` int(3) DEFAULT NULL,
  `QuanofFacility` int(2) NOT NULL,
  `MaxQuantity` int(2) NOT NULL,
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('卧室', null, null, '5', '10');
INSERT INTO `room` VALUES ('客厅', '26', '70', '3', '10');

-- ----------------------------
-- Table structure for security
-- ----------------------------
DROP TABLE IF EXISTS `security`;
CREATE TABLE `security` (
  `staffno` char(10) NOT NULL,
  `FingprintNo` int(10) DEFAULT NULL,
  `IrisNo` int(10) DEFAULT NULL,
  `AccountNum` int(10) NOT NULL,
  `isHome` char(5) NOT NULL,
  `InOutNum` int(10) NOT NULL,
  PRIMARY KEY (`staffno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security
-- ----------------------------
INSERT INTO `security` VALUES ('1', '1', '1', '4', 'true', '10');
INSERT INTO `security` VALUES ('2', '2', '2', '4', 'true', '11');
INSERT INTO `security` VALUES ('3', '3', '3', '1', 'true', '8');
INSERT INTO `security` VALUES ('4', '4', '4', '0', 'false', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Account` char(10) NOT NULL,
  `Password` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CanAdd` char(5) DEFAULT NULL,
  `CanDelete` char(5) DEFAULT NULL,
  `CanControl` char(5) DEFAULT NULL,
  `StaffNo` char(10) DEFAULT NULL,
  `ControlNum` int(10) DEFAULT NULL,
  PRIMARY KEY (`Account`),
  KEY `StaffNo2` (`StaffNo`),
  CONSTRAINT `StaffNo2` FOREIGN KEY (`StaffNo`) REFERENCES `security` (`staffno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('12数据库', '1234', 'true', 'true', 'true', '2', '0');
INSERT INTO `user` VALUES ('冯俊皓', '12345', 'true', 'true', 'true', '1', '2');
INSERT INTO `user` VALUES ('奚小曼', '1234', 'true', 'true', 'false', '3', '1');
INSERT INTO `user` VALUES ('李大菊', '1234', 'true', 'true', 'true', '2', '2');
INSERT INTO `user` VALUES ('李小菊', '1234', 'false', 'false', 'false', '2', '0');
INSERT INTO `user` VALUES ('江大涵', '12345', 'true', 'true', 'true', '1', '0');
INSERT INTO `user` VALUES ('江小涵', '12345', 'true', 'true', 'true', '1', '0');

-- ----------------------------
-- View structure for controlfacilityview
-- ----------------------------
DROP VIEW IF EXISTS `controlfacilityview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `controlfacilityview` AS select `control`.`UserAccount` AS `UserAccount`,`control`.`FacilityNo` AS `FacilityNo`,`facility`.`RoomName` AS `RoomName`,`facility`.`isFault` AS `isFault` from (`control` join `facility` on((`control`.`FacilityNo` = `facility`.`FacilityNo`))) ;

-- ----------------------------
-- View structure for hikhujk
-- ----------------------------
DROP VIEW IF EXISTS `hikhujk`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `hikhujk` AS select `user`.`Account` AS `Account`,`user`.`StaffNo` AS `StaffNo`,`control`.`FacilityNo` AS `FacilityNo` from (`user` join `control` on((`control`.`UserAccount` = `user`.`Account`))) ;

-- ----------------------------
-- View structure for securityview
-- ----------------------------
DROP VIEW IF EXISTS `securityview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `securityview` AS select `security`.`staffno` AS `staffno`,`security`.`AccountNum` AS `AccountNum`,`security`.`isHome` AS `isHome`,`security`.`InOutNum` AS `InOutNum` from `security` ;

-- ----------------------------
-- View structure for userview
-- ----------------------------
DROP VIEW IF EXISTS `userview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `userview` AS select `user`.`Account` AS `Account`,`user`.`CanAdd` AS `CanAdd`,`user`.`CanDelete` AS `CanDelete`,`user`.`CanControl` AS `CanControl`,`user`.`StaffNo` AS `StaffNo`,`user`.`ControlNum` AS `ControlNum` from `user` ;

-- ----------------------------
-- Procedure structure for facilityDelete
-- ----------------------------
DROP PROCEDURE IF EXISTS `facilityDelete`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `facilityDelete`(IN `facilityNo` char(10))
BEGIN
	#Routine body goes here...
	DELETE FROM control where control.FacilityNo=facilityNo;
  DELETE FROM facility where facility.FacilityNo=facilityNo;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for SecurityDelete
-- ----------------------------
DROP PROCEDURE IF EXISTS `SecurityDelete`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SecurityDelete`(IN `staffNo` char)
BEGIN
	#Routine body goes here...
	DELETE FROM admin where admin.StaffNo=staffNo;
	DELETE FROM `security` where `security`.staffno = staffNo ;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for userDelete
-- ----------------------------
DROP PROCEDURE IF EXISTS `userDelete`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `userDelete`(IN `delete_Account` char(10))
BEGIN
	#Routine body goes here...
	DELETE FROM control where control.UserAccount = delete_Account;
	DELETE FROM `user` where `user`.Account = delete_Account;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Trig_AdminAdd`;
DELIMITER ;;
CREATE TRIGGER `Trig_AdminAdd` AFTER INSERT ON `admin` FOR EACH ROW begin
INSERT INTO logs(Time,Events,Category,KeyWords) 
     VALUES(curtime(),'变更','管理员变动',new.Account);
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Trig_AdminChange`;
DELIMITER ;;
CREATE TRIGGER `Trig_AdminChange` AFTER UPDATE ON `admin` FOR EACH ROW begin
INSERT INTO logs(Time,Events,Category,KeyWords) 
     VALUES(curtime(),'更改','管理员变动',’密码修改‘);
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Trig_AdiminDelete`;
DELIMITER ;;
CREATE TRIGGER `Trig_AdiminDelete` AFTER DELETE ON `admin` FOR EACH ROW begin
INSERT INTO logs(Time,Events,Category,KeyWords) 
     VALUES(curtime(),'注销','管理员变动',old.Account);
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `controlAdd`;
DELIMITER ;;
CREATE TRIGGER `controlAdd` AFTER INSERT ON `control` FOR EACH ROW begin
INSERT INTO logs(Time,Events,Category,KeyWords) 
     VALUES(curtime(),'新增','控制变动',new.FacilityNo);
Update user set ControlNum=ControlNum+1 where Account = new.UserAccount;
Update facility set ControledNum=ControledNum+1 where FacilityNo = new.FacilityNo;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `controlDelete`;
DELIMITER ;;
CREATE TRIGGER `controlDelete` AFTER DELETE ON `control` FOR EACH ROW begin
INSERT INTO logs(Time,Events,Category,KeyWords) 
     VALUES(curtime(),'删除','控制变动',old.FacilityNo);
Update user set ControlNum = ControlNum - 1 where Account = old.UserAccount;
Update facility set ControledNum = ControledNum - 1 where FacilityNo = old.FacilityNo;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Trig_FacilityAdd`;
DELIMITER ;;
CREATE TRIGGER `Trig_FacilityAdd` AFTER INSERT ON `facility` FOR EACH ROW begin
INSERT INTO logs(Time,Events,Category,KeyWords) 
     VALUES(curtime(),'新增','设备变动',new.FacilityNo);
Update room 
set QuanofFacility = QuanofFacility+1
where Name = new.RoomName;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Trig_FacilityChange`;
DELIMITER ;;
CREATE TRIGGER `Trig_FacilityChange` AFTER UPDATE ON `facility` FOR EACH ROW begin
INSERT INTO logs(Time,Events,Category,KeyWords) 
     VALUES(curtime(),'变更','设备变动',new.FacilityNo);
Update room 
set QuanofFacility = QuanofFacility+1
where Name = new.RoomName;
Update room 
set QuanofFacility = QuanofFacility-1
where Name = old.RoomName;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Trig_FacilityDelete`;
DELIMITER ;;
CREATE TRIGGER `Trig_FacilityDelete` AFTER DELETE ON `facility` FOR EACH ROW begin
INSERT INTO logs(Time,Events,Category,KeyWords) 
     VALUES(curtime(),'注销','设备变动',old.FacilityNo);
Update room 
set QuanofFacility = QuanofFacility-1
where Name = old.RoomName;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Trig_UserAdd`;
DELIMITER ;;
CREATE TRIGGER `Trig_UserAdd` AFTER INSERT ON `user` FOR EACH ROW begin
INSERT INTO logs(Time,Events,Category,KeyWords) 
     VALUES(curtime(),'新增','用户变动',new.Account);
Update security
Set AccountNum = AccountNum+1
where staffno = new.StaffNo; 
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Trig_UserChange`;
DELIMITER ;;
CREATE TRIGGER `Trig_UserChange` AFTER UPDATE ON `user` FOR EACH ROW begin
INSERT INTO logs(Time,Events,Category,KeyWords) 
     VALUES(curtime(),'变更','用户变动',new.Account);
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Trig_UserDelete`;
DELIMITER ;;
CREATE TRIGGER `Trig_UserDelete` AFTER DELETE ON `user` FOR EACH ROW begin
INSERT INTO logs(Time,Events,Category,KeyWords) 
     VALUES(curtime(),'注销','用户变动',old.Account);
Update security
Set AccountNum = AccountNum-1
where staffno = old.StaffNo; 
end
;;
DELIMITER ;
