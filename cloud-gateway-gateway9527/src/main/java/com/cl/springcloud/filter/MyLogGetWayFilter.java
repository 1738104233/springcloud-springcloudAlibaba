package com.cl.springcloud.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/22 14:36
 *
 * 自定义全局GlobalFilter
 * 自定义过滤器：可以全局日志记录,统一网关鉴权
 */

@Log4j2
@Component
public class MyLogGetWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("****** time in myLogGetWayFilter:"+new Date());
        //请求得带上username http://localhost:9527/payment/lb?username=aa
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (StringUtils.isEmpty(username)){
            log.info("****** 用户名为空");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE); //作出回应
            return exchange.getResponse().setComplete();
        }
        //放行请求
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
