package org.springcloud.template.usercenter.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springcloud.template.usercenter.constant.UcErrorConstant;
import org.springcloud.template.usercenter.dao.ApplicationRepository;
import org.springcloud.template.usercenter.dto.application.AddApplicationDTO;
import org.springcloud.template.usercenter.dto.application.QueryAllDTO;
import org.springcloud.template.usercenter.dto.application.UpdateApplicationDTO;
import org.springcloud.template.usercenter.entity.Application;
import org.springcloud.template.usercenter.service.ApplicationService;
import org.springcloud.template.usercenter.utils.UserBeanUtil;
import org.springcloud.template.usercenter.vo.application.AddApplicationVO;
import org.springcloud.template.usercenter.vo.application.QueryAllVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.zxb.web.exception.BusinessException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 应用服务接口
 *
 * @author zjx
 * @date 2020/7/30 0030 22:01
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public AddApplicationVO addApplication(AddApplicationDTO dto) {
        Application application = new Application();
        BeanUtils.copyProperties(dto, application);
        application.setApplicationId(UUID.randomUUID().toString().replaceAll("-", ""));
        Application save = applicationRepository.save(application);

        AddApplicationVO addApplicationVO = new AddApplicationVO();
        addApplicationVO.setId(save.getId());
        addApplicationVO.setApplicationId(save.getApplicationId());
        return addApplicationVO;
    }

    @Override
    public Page<Application> queryAll(QueryAllDTO dto) {
        //规格定义
        Specification<Application> specification = new Specification<Application>() {
            /**
             * 构造断言
             * @param root 实体对象引用
             * @param query 规则查询对象
             * @param cb 规则构建对象
             * @return 断言
             */
            @Override
            public Predicate toPredicate(Root<Application> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                if (StringUtils.isNotBlank(dto.getName())) { //添加断言
                    Predicate likeNickName = cb.like(root.get("name").as(String.class), dto.getName() + "%");
                    predicates.add(likeNickName);
                }
                if (StringUtils.isNotBlank(dto.getApplicationId())) { //添加断言
                    Predicate applicationId = cb.equal(root.get("applicationId").as(String.class), dto.getApplicationId());
                    predicates.add(applicationId);
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
        //分页信息
        //页码：前端从1开始，jpa从0开始，做个转换
        Pageable pageable = PageRequest.of(dto.getCurrentPage() - 1, dto.getPageSize());
        //查询
        return applicationRepository.findAll(specification, pageable);
    }

    @Override
    public String updateApplication(UpdateApplicationDTO dto) {
        Application application = applicationRepository.getOne(dto.getId());
        if (application == null) {
            throw new BusinessException(UcErrorConstant.USER_DATA_NOT_EXIT_ERROR, "数据不存在");
        }
        UserBeanUtil.copyPropertiesNotNull(dto, application);
        applicationRepository.save(application);
        return null;
    }

}
