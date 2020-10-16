package org.zjx.gateway.dto;

import lombok.Data;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * 路由信息DTO
 *
 * @author zjx
 * @date 2020/10/15 0015 17:58
 */
@Data
public class RouteInfo {

    private String id;

    private String uri;

    private List<FilterDefinition> filters;

    private List<PredicateDefinition> predicates;

    private String order;


}
