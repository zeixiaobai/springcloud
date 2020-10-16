package org.zjx.gateway.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import org.zjx.gateway.dto.RouteInfo;
import org.zjx.gateway.service.DynamicRouteService;
import org.zjx.gateway.utils.LoggerUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * 动态路由实现类
 *
 * @author zjx
 * @date 2020/10/15 0015 17:01
 */
@Service
@Slf4j
public class DynamicRouteServiceImpl implements DynamicRouteService, ApplicationEventPublisherAware {

    @Resource
    private RouteDefinitionRepository routeDefinitionRepository;

    private ApplicationEventPublisher publisher;

    /**
     * 增加路由
     *
     * @param routeInfo
     * @return {@link String}
     * @author zjx
     * @date 2020/10/15 17:48
     */
    @Override
    public String add(RouteInfo routeInfo) {

        RouteDefinition definition = new RouteDefinition();
        definition.setId(routeInfo.getId());
        URI uri = UriComponentsBuilder.fromHttpUrl(routeInfo.getUri()).build().toUri();
        definition.setUri(uri);
        definition.setPredicates(routeInfo.getPredicates());
        definition.setFilters(routeInfo.getFilters());
        routeDefinitionRepository.save(Mono.just(definition)).subscribe();
        notifyChanged();

        return "success";
    }

    /**
     * 删除路由
     *
     * @param id
     * @return {@link String}
     * @author zjx
     * @date 2020/10/15 17:48
     */
    @Override
    public String delete(String id) {
        try {
            routeDefinitionRepository.delete(Mono.just(id)).subscribe();
            notifyChanged();
            return "delete success";
        } catch (Exception e) {
            LoggerUtil.error(log, e);
            return "delete fail,not find route  routeId: " + id;
        }
    }

    @Override
    public Mono<List<RouteDefinition>> get() {
        Flux<RouteDefinition> routeDefinitions = routeDefinitionRepository.getRouteDefinitions();
        return routeDefinitions.collectList();
    }

    private void notifyChanged() {
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }
}
