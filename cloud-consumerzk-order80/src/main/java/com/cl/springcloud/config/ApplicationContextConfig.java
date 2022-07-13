package com.cl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/5/19 15:29
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 引入RestTemplate
     *
     * Spring RestTemplate是Spring提供的用于访问Rest服务的客户端，
     * RestTemplate提供了多种便捷访问远程Http服务的方法
     * @return
     */
    @Bean
    @LoadBalanced //LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
