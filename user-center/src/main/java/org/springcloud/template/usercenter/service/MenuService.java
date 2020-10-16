package org.springcloud.template.usercenter.service;

import org.springcloud.template.usercenter.entity.Menu;
import org.zxb.common.dto.Result;

import java.util.List;

/**
 * 菜单服务
 *
 * @author zjx
 * @date 2020/7/10 0010 15:00
 */
public interface MenuService {

    /**
     * 查询所有菜单
     *
     * @param
     * @return {@link List<Menu>}
     * @author zjx
     * @date 2020/07/16 13:11
     */
    List<Menu> queryAll();

}
