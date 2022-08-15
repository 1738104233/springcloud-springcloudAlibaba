package com.cl.springcloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/12 15:35
 */
@Configuration
@MapperScan({"com.cl.springcloudalibaba.dao"})
public class MyBatisConfig {
}
