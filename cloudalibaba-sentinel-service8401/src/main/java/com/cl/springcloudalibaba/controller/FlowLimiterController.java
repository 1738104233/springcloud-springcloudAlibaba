package com.cl.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/7/28 17:29
 */

@RestController
public class FlowLimiterController {

    @GetMapping("/testA")
    public String testA() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("------testA  RT");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        int age = 10 / 0;
        System.out.println("------testB 异常比例");
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC() {
        int age = 10 / 0;
        System.out.println("------testC 异常数");
        return "------testC";
    }


    @SentinelResource(value = "testHotkey",blockHandler = "dealWithTestHotkey")//用于定义资源，并提供可选的异常处理和 fallback 配置项
    @GetMapping("/testHotkey")
    public String testHotkey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotkey";
    }
    //兜底方法
    public String dealWithTestHotkey(String p1, String p2, BlockException blockException){
        return "------dealWithTestHotkey";//sentinel系统默认提示：Blocked by Sentinel (flow limiting)
    }
}
