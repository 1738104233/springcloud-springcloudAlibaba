package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/5/30 16:47
 */
@SpringBootApplication
@EnableDiscoveryClient //如果是其他的注册中心推荐使用@EnableDiscoveryClient
public class PaymentMain8004 {

    public static void main(String[] args){
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
