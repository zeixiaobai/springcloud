package org.springcloud.template.usercenter.entity;

import lombok.Data;

/**
 * token实体
 *
 * @author zjx
 * @date 2020/7/31 0031 17:12
 */
@Data
public class Token {
    /**
     * token字符串
     */
    private String token;
    /**
     * 超时时间
     */
    private long expireTime;
    /**
     * 用户信息
     */
    private User user;
}
