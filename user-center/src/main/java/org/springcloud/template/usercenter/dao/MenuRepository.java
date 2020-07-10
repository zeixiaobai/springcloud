package org.springcloud.template.usercenter.dao;

import org.springcloud.template.usercenter.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 菜单持久类
 *
 * @author zjx
 * @date 2020/7/10 0010 15:04
 */
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
