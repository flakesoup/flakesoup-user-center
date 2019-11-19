# uc
user center based on SrpingCloud F

# db
```sql
CREATE DATABASE  `flakesoup` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `mobile` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '密码加密',
  `salt` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '随机盐',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user_idx_name` (`name`),
  KEY `user_idx_mobile` (`mobile`),
  KEY `user_idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户表';
```


## TODO

* 用户相关接口分布式锁控制并发修改





## 分库分表

##### 创建数据库和表

```sql
--创建数据库
CREATE DATABASE  flakesoup_uc_0 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
CREATE DATABASE  flakesoup_uc_1 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

--创建数据表
USE flakesoup_uc_0;
USE flakesoup_uc_1;

--创建用户表
CREATE TABLE `t_user_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `mobile` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码加密',
  `status` tinyint(4) COLLATE utf8mb4_bin DEFAULT 0 COMMENT '用户状态枚举,0默认',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  INDEX `tuser0_idx_name` (`name`),
  INDEX `tuser0_idx_mobile` (`mobile`),
  INDEX `tuser0_idx_status` (`status`),
  INDEX `tuser0_idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户表';
CREATE TABLE `t_user_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `mobile` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码加密',
  `status` tinyint(4) COLLATE utf8mb4_bin DEFAULT 0 COMMENT '用户状态枚举,0默认',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  INDEX `tuser1_idx_name` (`name`),
  INDEX `tuser1_idx_mobile` (`mobile`),
  INDEX `tuser1_idx_status` (`status`),
  INDEX `tuser1_idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户表';
CREATE TABLE `t_user_2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `mobile` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码加密',
  `status` tinyint(4) COLLATE utf8mb4_bin DEFAULT 0 COMMENT '用户状态枚举,0默认',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  INDEX `tuser2_idx_name` (`name`),
  INDEX `tuser2_idx_mobile` (`mobile`),
  INDEX `tuser2_idx_status` (`status`),
  INDEX `tuser2_idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户表';
--创建用户信息表
CREATE TABLE `t_user_profile_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) COLLATE utf8mb4_bin NOT NULL COMMENT '用户ID',
  `age` tinyint(4) COLLATE utf8mb4_bin DEFAULT 0 COMMENT '用户年龄',
  `gender` tinyint(4) COLLATE utf8mb4_bin DEFAULT 0 COMMENT '用户性别',
  `nickname` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户昵称',
  `address` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户地址',
  `email` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户邮箱',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `tuserp0_idx_user_id` (`user_id`),
  INDEX `tuserp0_idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户信息表';
CREATE TABLE `t_user_profile_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) COLLATE utf8mb4_bin NOT NULL COMMENT '用户ID',
  `age` tinyint(4) COLLATE utf8mb4_bin DEFAULT 0 COMMENT '用户年龄',
  `gender` tinyint(4) COLLATE utf8mb4_bin DEFAULT 0 COMMENT '用户性别',
  `nickname` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户昵称',
  `address` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户地址',
  `email` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户邮箱',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `tuserp1_idx_user_id` (`user_id`),
  INDEX `tuserp1_idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户信息表';
CREATE TABLE `t_user_profile_2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) COLLATE utf8mb4_bin NOT NULL COMMENT '用户ID',
  `age` tinyint(4) COLLATE utf8mb4_bin DEFAULT 0 COMMENT '用户年龄',
  `gender` tinyint(4) COLLATE utf8mb4_bin DEFAULT 0 COMMENT '用户性别',
  `nickname` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户昵称',
  `address` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户地址',
  `email` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户邮箱',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `tuserp2_idx_user_id` (`user_id`),
  INDEX `tuserp2_idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户信息表';

```



##### 不用迁移数据的扩展方案，如何分片





