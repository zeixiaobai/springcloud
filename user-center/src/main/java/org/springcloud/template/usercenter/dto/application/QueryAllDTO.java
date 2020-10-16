package org.springcloud.template.usercenter.dto.application;

import lombok.Data;
import org.zxb.web.dto.BaseDTO;

/**
 * TODO
 *
 * @author zjx
 * @date 2020/7/30 0030 22:58
 */
@Data
public class QueryAllDTO extends BaseDTO {

    /**
     * 当前页码
     */
    private int currentPage = 1;
    /**
     * 每页数量
     */
    private int pageSize = 10;

    private String name;

    private String applicationId;
}
