DROP TABLE IF EXISTS `zxb_sys_user_role`;

CREATE TABLE `zxb_sys_user_role`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `user_id`     varchar(36)  DEFAULT NULL COMMENT '用户ID',
    `role_id`     int(11)  DEFAULT NULL COMMENT '角色ID',
    `create_by`   varchar(20) DEFAULT 'system' comment '创建人',
    `create_time` datetime    DEFAULT current_timestamp comment '创建时间',
    `update_by`   varchar(20) DEFAULT 'system' comment '更新人',
    `update_time` datetime    DEFAULT current_timestamp comment '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='用户与角色对应关系';
