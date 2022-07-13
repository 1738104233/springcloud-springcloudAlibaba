package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/21 14:12
 */

@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {

    public static void main(String[] args){
        SpringApplication.run(GateWayMain9527.class,args);
    }
}
