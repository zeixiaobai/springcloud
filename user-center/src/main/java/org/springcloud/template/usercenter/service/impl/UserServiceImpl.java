package org.springcloud.template.usercenter.service.impl;

import org.springcloud.template.usercenter.dao.UserRepository;
import org.springcloud.template.usercenter.dto.user.LoginDTO;
import org.springcloud.template.usercenter.dto.user.RegistryDTO;
import org.springcloud.template.usercenter.entity.User;
import org.springcloud.template.usercenter.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现
 *
 * @author zjx
 * @date 2020-07-10 15:02:14
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    /**
     * 注册用户
     *
     * @param dto 注册请求参数
     * @return {@link User}
     * @author zjx
     * @date 2020/07/09 13:52
     */
    @Override
    public User registry(RegistryDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return userRepository.save(user);
    }

    /**
     * 登录
     *
     * @param dto 登录请求参数
     * @return {@link User}
     * @author zjx
     * @date 2020/07/09 13:53
     */
    @Override
    public User login(LoginDTO dto) {
        return userRepository.findByUserNameAndPassword(dto.getUserName(), dto.getPassword());
    }

}
