package org.springcloud.template.usercenter.service.impl;

import org.springcloud.template.usercenter.dao.UserRepository;
import org.springcloud.template.usercenter.dto.LoginDTO;
import org.springcloud.template.usercenter.dto.RegistryDTO;
import org.springcloud.template.usercenter.entity.User;
import org.springcloud.template.usercenter.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    /**
     * 注册用户
     *
     * @return {@link User}
     * @Param dto
     * @author zjx
     * @date 2020/07/09 13:52
     */
    @Override
    public User registry(RegistryDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

    /**
     * 登录
     *
     * @return {@link User}
     * @Param dto
     * @author zjx
     * @date 2020/07/09 13:53
     */
    @Override
    public User login(LoginDTO dto) {
        User user = userRepository.findByNickNameAndLoginPassword(dto.getNickName(), dto.getLoginPassword());
        return user;
    }

}
