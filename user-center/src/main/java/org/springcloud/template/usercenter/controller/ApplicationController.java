package org.springcloud.template.usercenter.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springcloud.template.usercenter.dto.application.AddApplicationDTO;
import org.springcloud.template.usercenter.dto.application.QueryAllDTO;
import org.springcloud.template.usercenter.dto.application.UpdateApplicationDTO;
import org.springcloud.template.usercenter.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zxb.web.annotation.ZxbLog;
import org.zxb.web.vo.Result;

import javax.validation.Valid;

/**
 * 应用controller
 *
 * @author zjx
 * @date 2020/7/30 0030 22:08
 */
@ZxbLog
@RestController
@RequestMapping("/application")
@Api(tags = "应用相关接口")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/addApplication")
    @ApiOperation(value = "添加应用", notes = "添加应用")
    public Result addApplication(@RequestBody @Valid AddApplicationDTO dto) {
        return Result.buildSuccess(applicationService.addApplication(dto));
    }

    @PostMapping("/queryAll")
    @ApiOperation(value = "查询应用", notes = "查询应用")
    public Result queryAll(@RequestBody @Valid QueryAllDTO dto) {
        return Result.buildSuccess(applicationService.queryAll(dto));
    }

    @PostMapping("/updateApplication")
    @ApiOperation(value = "更新应用", notes = "更新应用")
    public Result updateApplication(@RequestBody @Valid UpdateApplicationDTO dto) {
        return Result.buildSuccess(applicationService.updateApplication(dto));
    }
}
