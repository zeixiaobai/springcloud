package org.springcloud.template.usercenter.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springcloud.template.usercenter.dto.menu.AddMenuDTO;
import org.springcloud.template.usercenter.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zxb.web.annotation.ZxbLog;
import org.zxb.web.vo.Result;

import javax.validation.Valid;

/**
 * 菜单相关接口
 *
 * @author zjx
 * @date 2020/7/10 0010 14:18
 */
@ZxbLog
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

    @GetMapping("/queryAll")
    @ApiOperation(value = "查询菜单", notes = "查询菜单")
    public Result queryAll() {
        return Result.buildSuccess(menuService.queryAll());
    }

}
