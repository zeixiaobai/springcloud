package org.springcloud.template.usercenter.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.zxb.common.dto.BaseDTO;

import java.util.Date;

/**
 * 注册DTO
 *
 * @author zjx
 * @date 13:55
 */
@Data
@ApiModel
public class RegistryDTO extends BaseDTO {

    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 用户邮箱
     */
    private String userMail;
    /**
     * 登录密码
     */
    private String loginPassword;

    /**
     * 支付密码
     */
    private String payPassword;
    /**
     * 手机号码
     */
    private String userMobile;
    /**
     * 最后登录时间
     */
    private Date userLasttime;
    /**
     * 最后登录IP
     */
    private String userLastip;
    /**
     * 备注
     */
    private String userMemo;
    /**
     * M(男) or F(女)
     */
    private String sex;
    /**
     * 例如：2009-11-27
     */
    private String birthDate;
    /**
     * 头像图片路径
     */
    private String pic;
    /**
     * 状态 1 正常 0 无效
     */
    private String userStatus;

}
