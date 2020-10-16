package org.springcloud.template.usercenter.dto.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.zxb.web.dto.BaseDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
     * 用户名称
     */
    @NotBlank(message = "用户名称不能为空")
    @Length(min = 1, max = 50, message = "长度为1-50")
    private String userName;
    /**
     * 真实姓名
     */
    @Length(min = 1, max = 50, message = "长度为1-50")
    private String realName;
    /**
     * 用户邮箱
     */
    @Email(message = "邮箱格式错误")
    private String userMail;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 50, message = "长度为6-50")
    private String password;
    /**
     * 手机号码
     */
    private String userMobile;
    /**
     * 备注
     */
    private String userMemo;
    /**
     * M(男) or F(女)
     */
    @NotBlank(message = "性别不能为空")
    @Pattern(regexp = "[M,F]", message = "输入M(男)或者F(女)")
    private String sex;
    /**
     * 例如：2009-11-27
     */
    @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}", message = "日期格式需要YYYY-MM-DD")
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
