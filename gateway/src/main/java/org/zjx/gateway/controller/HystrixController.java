package org.zjx.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 断路由控制类
 *
 * @author zjx
 * @date 2020/10/15 0015 17:55
 */
@RestController
@RequestMapping("/gateway")
public class HystrixController {

    @RequestMapping("/hystrix")
    public Mono<String> fallback() {
        return Mono.just("服务暂时不可用");
    }

}
