package org.springcloud.template.usercenter.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springcloud.template.usercenter.constant.UcErrorConstant;
import org.springcloud.template.usercenter.dto.user.LoginDTO;
import org.springcloud.template.usercenter.dto.user.RegistryDTO;
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

/**
 *  用户管理相关接口
 * @author zjx
 * @date 2020-07-10 13:29:20
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理相关接口")
public class UserController {

    @Autowired
    private  UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口", notes = "用户登录接口")
    public Result login(@RequestBody @Valid LoginDTO dto) {
        User user = userService.login(dto);
        if (user == null) {
            throw new BusinessException(UcErrorConstant.USER_LOGIN_ERROR, "用户或者密码错误");
        }
        return Result.buildSuccess(user);
    }

    @PostMapping("/registry")
    @ApiOperation(value = "用户注册接口", notes = "用户注册接口")
    public Result registry(@RequestBody @Valid RegistryDTO dto) {
        return Result.buildSuccess(userService.registry(dto));
    }


}
