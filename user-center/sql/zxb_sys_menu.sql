DROP TABLE IF EXISTS `zxb_sys_menu`;
CREATE TABLE `zxb_sys_menu`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `menu_id`   int(11) NOT NULL,
    `parent_id` int(11)      DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
    `name`      varchar(50)  DEFAULT NULL COMMENT '菜单名称',
    `url`       varchar(200) DEFAULT NULL COMMENT '菜单URL',
    `type`      int(11)      DEFAULT NULL COMMENT '类型   0：超链接   1：菜单   2：按钮  3：图片',
    `icon`      varchar(50)  DEFAULT NULL COMMENT '菜单图标',
    `order_num` int(11)      DEFAULT NULL COMMENT '排序',
    `create_by`   varchar(20)  DEFAULT 'system' comment '创建人',
    `create_time` datetime     DEFAULT current_timestamp comment '创建时间',
    `update_by`   varchar(20)  DEFAULT 'system' comment '更新人',
    `update_time` datetime     DEFAULT current_timestamp comment '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `z_menu_id` (`menu_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='菜单管理';
