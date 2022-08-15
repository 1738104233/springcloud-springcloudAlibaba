package com.cl.springcloudalibaba.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cl.springcloud.unified.code.ResultCode;
import com.cl.springcloud.unified.result.CommonResultVO;
import com.cl.springcloudalibaba.myhandler.CustomBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/3 16:50
 */

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException") //用于定义资源，并提供可选的异常处理和 fallback 配置项
    public CommonResultVO byResource() {
        return new CommonResultVO("按资源名称限流测试OK");
    }

    //兜底方法
    public CommonResultVO handleException(BlockException blockException) {
        return new CommonResultVO(ResultCode.ERROR, blockException.getClass().getCanonicalName() + "服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResultVO byUrl() {
        return new CommonResultVO("按url限流测试OK");
    }

    @GetMapping("/rateLimit/custom")
    @SentinelResource(value = "custom",
            blockHandlerClass = CustomBlockHandler.class,
            blockHandler = "handleException"
    )
    public CommonResultVO custom() {
        return new CommonResultVO("自定义的方法演示");
    }
}
