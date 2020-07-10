DROP TABLE IF EXISTS `zxb_sys_role`;
CREATE TABLE `zxb_sys_role`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `role_id`     int(11) NOT NULL   COMMENT '角色ID',
    `role_name`   varchar(100) DEFAULT NULL COMMENT '角色名称',
    `remark`      varchar(100) DEFAULT NULL COMMENT '备注',
    `create_by`   varchar(20)  DEFAULT 'system' comment '创建人',
    `create_time` datetime     DEFAULT current_timestamp comment '创建时间',
    `update_by`   varchar(20)  DEFAULT 'system' comment '更新人',
    `update_time` datetime     DEFAULT current_timestamp comment '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `z_role_id` (`role_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='角色';

insert into `zxb_sys_role`(`role_id`, `role_name`, `remark`)
values (1, '管理员', '测试');

