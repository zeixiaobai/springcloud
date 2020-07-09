package org.springcloud.template.usercenter.service;

import org.springcloud.template.usercenter.dto.LoginDTO;
import org.springcloud.template.usercenter.dto.RegistryDTO;
import org.springcloud.template.usercenter.entity.User;

/**
 *  用户服务类
 * @author zjx
 * @date 2020-07-09 13:52:28
 */
public interface UserService {

    /**
     *  注册用户
     *
     * @Param dto
     * @author zjx
     * @return {@link User}
     * @date 2020/07/09 13:52
     */
     User registry(RegistryDTO dto);

    /**
     *  登录
     *
     * @Param dto
     * @author zjx
     * @return {@link User}
     * @date 2020/07/09 13:53
     */
     User login(LoginDTO dto);
}
