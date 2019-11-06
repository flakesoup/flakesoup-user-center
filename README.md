# uc
user center based on SrpingCloud F

# db
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
