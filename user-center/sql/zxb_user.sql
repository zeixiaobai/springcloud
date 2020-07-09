DROP TABLE IF EXISTS `zxb_user`;
CREATE TABLE `zxb_user` (
  `id` varchar(36) NOT NULL COMMENT 'ID',
  `user_id` varchar(36) NOT NULL COMMENT '用户id',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `user_mail` varchar(100) DEFAULT NULL COMMENT '用户邮箱',
  `login_password` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `pay_password` varchar(50) DEFAULT NULL COMMENT '支付密码',
  `user_mobile` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `user_lasttime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `user_lastip` varchar(50) DEFAULT NULL COMMENT '最后登录IP',
  `user_memo` varchar(500) DEFAULT NULL COMMENT '备注',
  `sex` char(1) DEFAULT 'M' COMMENT 'M(男) or F(女)',
  `birth_date` char(10) DEFAULT NULL COMMENT '例如：2009-11-27',
  `pic` varchar(255) DEFAULT NULL COMMENT '头像图片路径',
  `user_status` int(1) NOT NULL DEFAULT '1' COMMENT '状态 1 正常 0 无效',
  `create_by` varchar(20) DEFAULT 'system'  comment '创建人',
  `create_time` datetime DEFAULT current_timestamp  comment '创建时间',
  `update_by` varchar(20) DEFAULT 'system'  comment '更新人',
  `update_time` datetime DEFAULT current_timestamp  comment '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_mail`),
  UNIQUE KEY `ud_user_mail` (`user_mail`),
  UNIQUE KEY `ud_user_unique_mobile` (`user_mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

