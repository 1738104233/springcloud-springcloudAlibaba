package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/7/7 14:44
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3377 {

    public static void main(String[] args){
        SpringApplication.run(ConfigClientMain3377.class,args);
    }
}
