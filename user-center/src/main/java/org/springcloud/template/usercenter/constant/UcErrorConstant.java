package org.springcloud.template.usercenter.constant;

/**
 * 用户错误信息
 *
 * @author zjx
 * @date 2020/7/10 0010 11:05
 */
public class UcErrorConstant {

    private UcErrorConstant() {
    }

    /**
     * 登录错误
     */
    public final static String USER_LOGIN_ERROR = "ZUC0010000";
    /**
     * 数据不存在
     */
    public final static String USER_DATA_NOT_EXIT_ERROR = "ZUC0010001";

    /**
     * 未登录
     */
    public final static String USER_NOT_LOGIN_ERROR = "ZUC0010002";

}
