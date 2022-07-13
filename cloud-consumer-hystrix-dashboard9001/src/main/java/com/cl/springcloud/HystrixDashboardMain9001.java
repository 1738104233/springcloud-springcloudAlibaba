package com.cl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/20 10:13
 */

@SpringBootApplication
@EnableHystrixDashboard //使用hystrix仪表盘
public class HystrixDashboardMain9001 {

    public static void main(String[] args){
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}
