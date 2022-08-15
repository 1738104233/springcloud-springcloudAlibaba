package com.cl.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/12 9:21
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源自动创建的配置
//@SpringBootApplication
@EnableDiscoveryClient
public class SeataStorageMainApp2002 {
    public static void main(String[] args){
        SpringApplication.run(SeataStorageMainApp2002.class,args);
    }
}
