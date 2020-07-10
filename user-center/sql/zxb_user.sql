DROP TABLE IF EXISTS `zxb_sys_user`;
CREATE TABLE `zxb_sys_user`
(
    `id`          int         NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `user_id`     varchar(36) NOT NULL COMMENT '用户id',
    `user_name`   varchar(50) NOT NULL COMMENT '用户名称',
    `real_name`   varchar(50)          DEFAULT NULL COMMENT '真实姓名',
    `user_mail`   varchar(100)         DEFAULT NULL COMMENT '用户邮箱',
    `password`    varchar(50) NOT NULL COMMENT '用户密码',
    `user_mobile` varchar(50)          DEFAULT NULL COMMENT '手机号码',
    `user_memo`   varchar(500)         DEFAULT NULL COMMENT '备注',
    `sex`         char(1)              DEFAULT 'M' COMMENT 'M(男) or F(女)',
    `birth_date`  char(10)             DEFAULT NULL COMMENT '例如：2009-11-27',
    `pic`         varchar(255)         DEFAULT NULL COMMENT '头像图片路径',
    `user_status` int(1)      NOT NULL DEFAULT '1' COMMENT '状态 1 正常 0 无效',
    `create_by`   varchar(20)          DEFAULT 'system' comment '创建人',
    `create_time` datetime             DEFAULT current_timestamp comment '创建时间',
    `update_by`   varchar(20)          DEFAULT 'system' comment '更新人',
    `update_time` datetime             DEFAULT current_timestamp comment '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `z_user_id` (`user_id`),
    UNIQUE KEY `z_user_mail` (`user_mail`),
    UNIQUE KEY `z_user_unique_mobile` (`user_mobile`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='用户表';

insert into `zxb_sys_user`(`user_id`, `user_name`, `password`)
values ('326337c2-8c92-499b-994e-39fba4002239', 'zjx', '123456');