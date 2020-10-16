package org.zjx.gateway.service;

import org.springframework.cloud.gateway.route.RouteDefinition;
import org.zjx.gateway.dto.RouteInfo;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 动态路由
 *
 * @author zjx
 * @date 2020/10/15  17:00
 */
public interface DynamicRouteService {
    /**
     * 增加路由
     *
     * @param routeInfo
     * @return {@link String}
     * @author zjx
     * @date 2020/10/15 17:48
     */
    String add(RouteInfo routeInfo);

    /**
     * 删除路由
     *
     * @param id
     * @return {@link String}
     * @author zjx
     * @date 2020/10/15 17:48
     */
    String delete(String id);

    /**
     * 获取路由
     *
     * @return {@link Mono<List<RouteDefinition>>}
     * @author zjx
     * @date 2020/10/15 17:48
     */
    Mono<List<RouteDefinition>> get();

}
