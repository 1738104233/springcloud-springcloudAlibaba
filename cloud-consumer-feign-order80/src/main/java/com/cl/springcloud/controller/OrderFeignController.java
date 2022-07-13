package com.cl.springcloud.controller;

import com.cl.springcloud.pojo.vo.CommonResult;
import com.cl.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/8 17:45
 */


@Controller
@RequestMapping("/consumer")
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;


    @ResponseBody
    @GetMapping("/getPaymentById")
    public CommonResult testFeign(@RequestBody String paymentId){
        return paymentFeignService.getPaymentById(paymentId);
    }

    @ResponseBody
    @GetMapping("/feignTimeout")
    public String paymentFeignTimeout() {
        //openFeign-ribbon,客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
