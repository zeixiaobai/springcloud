package org.springcloud.template.usercenter.vo.user;

import lombok.Data;

/**
 * 登录返回VO
 *
 * @author zjx
 * @date 2020/7/31 0031 17:07
 */
@Data
public class LoginVO {

    private String token;
    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 真实姓名
     */
    private String realName;

}
