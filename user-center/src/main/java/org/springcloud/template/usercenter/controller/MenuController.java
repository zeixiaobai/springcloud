package org.springcloud.template.usercenter.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springcloud.template.usercenter.dto.menu.AddMenuDTO;
import org.springcloud.template.usercenter.dto.user.LoginDTO;
import org.springcloud.template.usercenter.service.MenuService;
import org.springcloud.template.usercenter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zxb.common.dto.Result;

import javax.validation.Valid;

/**
 * 菜单相关接口
 *
 * @author zjx
 * @date 2020/7/10 0010 14:18
 */
@RestController
@RequestMapping("/menu")
@Api(tags = "菜单相关接口")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/addMenu")
    @ApiOperation(value = "添加菜单", notes = "添加菜单")
    public Result addMenu(@RequestBody @Valid AddMenuDTO dto) {
        return null;
    }

}
