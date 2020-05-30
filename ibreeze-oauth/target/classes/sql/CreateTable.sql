CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `sys_permission` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `permission_NAME` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `permission_url` varchar(100) DEFAULT NULL COMMENT '菜单地址',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父菜单id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `ROLE_NAME` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(60) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role_permission` (
  `RID` int(11) NOT NULL COMMENT '角色编号',
  `PID` int(11) NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`RID`,`PID`),
  KEY `FK_Reference_12` (`PID`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`RID`) REFERENCES `sys_role` (`ID`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`PID`) REFERENCES `sys_permission` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `password` varchar(120) NOT NULL COMMENT '密码',
  `status` int(1) DEFAULT '1' COMMENT '1开启0关闭',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user_role` (
  `UID` int(11) NOT NULL COMMENT '用户编号',
  `RID` int(11) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`UID`,`RID`),
  KEY `FK_Reference_10` (`RID`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`RID`) REFERENCES `sys_role` (`ID`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`UID`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


