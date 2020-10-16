package org.springcloud.template.usercenter.dao;

import org.springcloud.template.usercenter.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.function.Predicate;

/**
 * TODO
 *
 * @author zjx
 * @date 2020/7/30 0030 22:02
 */
public interface ApplicationRepository  extends JpaRepository<Application, Integer>, JpaSpecificationExecutor<Application> {

}
