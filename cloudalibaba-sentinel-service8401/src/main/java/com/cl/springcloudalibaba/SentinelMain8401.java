package com.cl.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/7/28 17:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain8401 {

    public static void main(String[] args){
        SpringApplication.run(SentinelMain8401.class,args);
    }
}
