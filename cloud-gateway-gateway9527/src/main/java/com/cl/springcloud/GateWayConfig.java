package com.cl.springcloud;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/21 15:21
 *
 * Gateway网关路由有两种配置方式:1、配置文件yml中配置
 *                           2、代码中注入RouteLocator的Bean
 */
@Configuration
public class GateWayConfig {

    /**
     * 当访问地址 http://localhost:9527/guonei 会自动转发到地址:http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                        .build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route2",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji"))
                .build();
        return routes.build();
    }
}
