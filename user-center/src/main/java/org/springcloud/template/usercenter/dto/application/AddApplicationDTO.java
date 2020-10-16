package org.springcloud.template.usercenter.dto.application;

import lombok.Data;
import org.zxb.web.dto.BaseDTO;

/**
 * TODO
 *
 * @author zjx
 * @date 2020/7/30 0030 22:31
 */
@Data
public class AddApplicationDTO extends BaseDTO {

    private String name;

    private String userPublicKey;

    private String remark;

}
