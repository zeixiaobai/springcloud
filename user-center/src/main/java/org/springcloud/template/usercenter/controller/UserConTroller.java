package org.springcloud.template.usercenter.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springcloud.template.usercenter.dto.LoginDTO;
import org.springcloud.template.usercenter.entity.User;
import org.springcloud.template.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zxb.common.dto.Result;
import org.zxb.web.exception.BusinessException;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理相关接口")
public class UserConTroller {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口", notes = "用户登录接口")
    public Result login(@RequestBody @Valid LoginDTO dto) {
        User user = userService.login(dto);
        if (user == null) {
            return Result.buildFail("10001", "用户不存在");
        }
        return Result.buildSuccess(user);
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "用户注册接口", notes = "用户注册接口")
    public Result addUser(String form) {
//        User user = userService.saveAndFlush(form);
//        System.out.println(user.getId());
        return Result.buildSuccess(null);
    }


}
