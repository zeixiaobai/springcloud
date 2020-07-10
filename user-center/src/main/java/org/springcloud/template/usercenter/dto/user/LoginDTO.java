package org.springcloud.template.usercenter.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.zxb.common.dto.BaseDTO;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 登录dto
 *
 * @author zjx
 * @date 13:54
 */
@Data
@ApiModel
public class LoginDTO extends BaseDTO {

    @ApiModelProperty(example = "zhangsan", required = true)
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty(example = "123456", required = true)
    @NotBlank(message = "密码不能为空")
    private String password;

}