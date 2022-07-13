package com.cl.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/9 11:43
 *
 * openFeign配置日志增强功能
 */
@Configuration
public class FeignConfig {

    /**
     * 日志级别：
     * NONE 不输出日志
     *
     * BASIC 只有请求方法、URL、响应状态代码、执行时间
     *
     * HEADERS基本信息以及请求和响应头
     *
     * FULL 请求和响应 的heads、body、metadata，建议使用这个级别
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}

