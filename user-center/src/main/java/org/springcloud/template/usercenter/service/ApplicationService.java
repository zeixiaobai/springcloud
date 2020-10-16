package org.springcloud.template.usercenter.service;

import org.springcloud.template.usercenter.dto.application.AddApplicationDTO;
import org.springcloud.template.usercenter.dto.application.QueryAllDTO;
import org.springcloud.template.usercenter.dto.application.UpdateApplicationDTO;
import org.springcloud.template.usercenter.entity.Application;
import org.springcloud.template.usercenter.vo.application.AddApplicationVO;
import org.springframework.data.domain.Page;

/**
 * 应用服务接口
 *
 * @author zjx
 * @date 2020/7/30 0030 22:01
 */
public interface ApplicationService {

    AddApplicationVO addApplication(AddApplicationDTO dto);

    Page<Application> queryAll(QueryAllDTO dto);

    String updateApplication(UpdateApplicationDTO dto);
}
