package org.springcloud.template.usercenter.dao;

import org.springcloud.template.usercenter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户持久类
 *
 * @author zjx
 * @date 2020-07-09 17:48:56
 */
public interface UserRepository extends JpaRepository<User,String> {

    /**
     * TODO
     *
     * @return {@link User}
     * @Param nickName  用户名
     * @Param loginPassword 密码
     * @author zjx
     * @date 2020/07/09 17:58
     */
    User findByNickNameAndLoginPassword(String nickName, String loginPassword);

}
