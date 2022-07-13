package com.cl.springcloud;

import com.cl.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/5/19 15:02
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class) //使用自定义配置规则
public class OrderMain80 {

    public static void main(String[] args){
        SpringApplication.run(OrderMain80.class,args);
    }
}
