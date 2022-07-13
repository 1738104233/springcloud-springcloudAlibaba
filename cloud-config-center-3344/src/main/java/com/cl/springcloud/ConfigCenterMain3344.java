package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/29 15:51
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigCenterMain3344 {
    public static void main(String[] args){
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
