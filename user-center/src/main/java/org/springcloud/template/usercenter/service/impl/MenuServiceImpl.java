package org.springcloud.template.usercenter.service.impl;

import org.springcloud.template.usercenter.dao.MenuRepository;
import org.springcloud.template.usercenter.entity.Menu;
import org.springcloud.template.usercenter.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单服务实现
 *
 * @author zjx
 * @date 2020/7/10 0010 15:01
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    /**
     * 查询所有菜单
     *
     * @param
     * @return {@link List<Menu>}
     * @author zjx
     * @date 2020/07/16 13:11
     */
    @Override
    public List<Menu> queryAll() {
        return menuRepository.findAll();
    }
}
