package org.springcloud.template.usercenter.service.impl;

import org.springcloud.template.usercenter.constant.UcErrorConstant;
import org.springcloud.template.usercenter.dao.UserRepository;
import org.springcloud.template.usercenter.dto.user.LoginDTO;
import org.springcloud.template.usercenter.dto.user.RegistryDTO;
import org.springcloud.template.usercenter.entity.Token;
import org.springcloud.template.usercenter.entity.User;
import org.springcloud.template.usercenter.service.UserService;
import org.springcloud.template.usercenter.vo.user.LoginVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zxb.web.exception.BusinessException;

import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

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

    @Resource(name = "tokenMap")
    private Map<String, Token> tokenMap;

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
    public LoginVO login(LoginDTO dto) {
        User user = userRepository.findByUserNameAndPassword(dto.getUserName(), dto.getPassword());
        if (user == null) {
            throw new BusinessException(UcErrorConstant.USER_LOGIN_ERROR, "用户或者密码错误");
        }
        // 生成token
        String token = UUID.randomUUID().toString();

        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);
        loginVO.setRealName(user.getRealName());
        loginVO.setUserName(user.getUserName());

        // 缓存
        Token tokenBean = new Token();
        tokenBean.setToken(token);
        tokenBean.setUser(user);
        // 设置时间下次判断是否超时
        tokenBean.setExpireTime(System.currentTimeMillis());

        tokenMap.put(token, tokenBean);

        return loginVO;
    }

}
