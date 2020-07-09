package org.springcloud.template.usercenter.entity;


import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.zxb.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户表
 *
 * @author zjx
 * @date 2020-07-09 17:46:14
 */
@Data
@Entity
@Table(name="zxb_user")
public class User extends BaseEntity {
    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;
    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;
    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;
    /**
     * 用户邮箱
     */
    @Column(name = "user_mail")
    private String userMail;
    /**
     * 登录密码
     */
    @Column(name = "login_password")
    private String loginPassword;

    /**
     * 支付密码
     */
    @Column(name = "pay_password")
    private String payPassword;
    /**
     * 手机号码
     */
    @Column(name = "user_mobile")
    private String userMobile;
    /**
     * 最后登录时间
     */
    @Column(name = "user_lasttime")
    private Date userLasttime;
    /**
     * 最后登录IP
     */
    @Column(name = "user_lastip")
    private String userLastip;
    /**
     * 备注
     */
    @Column(name = "user_memo")
    private String userMemo;
    /**
     * M(男) or F(女)
     */
    @Column(name = "sex")
    private String sex;
    /**
     * 例如：2009-11-27
     */
    @Column(name = "birth_date")
    private String birthDate;
    /**
     * 头像图片路径
     */
    @Column(name = "pic")
    private String pic;
    /**
     * 状态 1 正常 0 无效
     */
    @Column(name = "user_status")
    private String userStatus;

}
