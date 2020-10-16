package org.zjx.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zjx.gateway.dto.RouteInfo;
import org.zjx.gateway.service.DynamicRouteService;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 路由控制类
 *
 * @author zjx
 * @date 2020/10/15 0015 17:43
 */
@RestController
@RequestMapping("/gateway")
public class RouteController {

    @Autowired
    private DynamicRouteService dynamicRouteService;

    @RequestMapping("/add")
    public Mono<String> add(@RequestBody RouteInfo routeInfo) {
        return Mono.just(dynamicRouteService.add(routeInfo));
    }

    @RequestMapping("/delete")
    public Mono<String> delete(String id) {
        return Mono.just(dynamicRouteService.delete(id));
    }

    @RequestMapping("/get")
    public Mono<List<RouteDefinition>> get(String id) {
        return dynamicRouteService.get();
    }

}
