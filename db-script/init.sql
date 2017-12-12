DROP TABLE IF EXISTS `dingtalk_ext_user`;

CREATE TABLE IF NOT EXISTS `dingtalk_ext_user` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '编号',
  `user_id` VARCHAR(100) NOT NULL COMMENT '外部联系人唯一编码',
  `address` VARCHAR(100) NULL COMMENT '地址',
  `company_name` VARCHAR(100) NULL COMMENT '企业名',
  `follower_userid` VARCHAR(200) NOT NULL COMMENT '负责人userId',
  `label_ids` VARCHAR(200) NOT NULL COMMENT '标签列表',
  `mobile` VARCHAR(200) NOT NULL COMMENT '手机号',
  `name` VARCHAR(200) NOT NULL COMMENT '名称',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  `share_deptids` VARCHAR(255) NULL COMMENT '共享给的部门ID',
  `share_userids` VARCHAR(255) NULL COMMENT '共享给的员工userId列表',
  `state_code` VARCHAR(20) NOT NULL COMMENT '手机号国家码',
  `title` VARCHAR(255) NULL COMMENT '职位',
  `create_date` DATETIME NULL COMMENT '创建时间',
  `update_date` DATETIME NULL COMMENT '更新时间',
  `del_flag` CHAR(1) NULL DEFAULT 0 COMMENT '删除标记\n1：删除\n0：未删除',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC))
  ENGINE = InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin
  COMMENT = '钉钉外部联系人';
  
  
  
  
  
