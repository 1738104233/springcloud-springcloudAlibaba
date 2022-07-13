package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/5/25 14:32
 */

/**
 * @EnableDiscoveryClient基于spring-cloud-commons，并且在classpath中实现。
 *
 * @EnableEurekaClient基于spring-cloud-netflix，只能为eureka作用。
 *
 * 就是如果选用的注册中心是eureka推荐@EnableEurekaClient，
 *
 * 如果是其他的注册中心推荐使用@EnableDiscoveryClient，如果classpath中添加了eureka，则它们的作用是一样的。
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {

    public static void main(String[] args){
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
