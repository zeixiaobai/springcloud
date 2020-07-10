package org.springcloud.template.usercenter.service;

import org.springcloud.template.usercenter.dto.user.LoginDTO;
import org.springcloud.template.usercenter.dto.user.RegistryDTO;
import org.springcloud.template.usercenter.entity.User;

/**
 * 用户服务类
 *
 * @author zjx
 * @date 2020-07-09 13:52:28
 */
public interface UserService {

    /**
     * 注册用户
     *
     * @return {@link User}
     * @param dto 注册请求参数
     * @author zjx
     * @date 2020/07/09 13:52
     */
    User registry(RegistryDTO dto);

    /**
     * 登录
     *
     * @return {@link User}
     * @param dto 登录请求参数
     * @author zjx
     * @date 2020/07/09 13:53
     */
    User login(LoginDTO dto);
}
