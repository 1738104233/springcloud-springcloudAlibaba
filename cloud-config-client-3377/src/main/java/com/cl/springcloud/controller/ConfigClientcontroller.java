package com.cl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/7/4 10:10
 */

@RestController
@RefreshScope //需要动态刷新的类标注@RefreshScope 注解
public class ConfigClientcontroller {

    /**
     * 因为我们读的自己github上的dev文件,所以这里configInfo应该为"master branch,springcloud-config/config-dev.yml version=7"
     * config:
     *   info: "master branch,springcloud-config/config-dev.yml version=7"
     */
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String configInfo(){
        return configInfo;
    }
}
