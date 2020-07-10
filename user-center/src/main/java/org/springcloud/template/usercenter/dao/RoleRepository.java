package org.springcloud.template.usercenter.dao;

import org.springcloud.template.usercenter.entity.Role;
import org.springcloud.template.usercenter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 角色持久类
 *
 * @author zjx
 * @date 2020/7/10 0010 15:04
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
