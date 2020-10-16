package org.springcloud.template.usercenter.dto.application;

import lombok.Data;
import org.zxb.web.dto.BaseDTO;

/**
 * 更新应用DTO
 *
 * @author zjx
 * @date 2020/8/3 0003 15:01
 */
@Data
public class UpdateApplicationDTO extends BaseDTO {

    private Integer id;

    private String name;

    private String remark;

    private String userPublicKey;

}
