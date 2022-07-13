package com.cl.springcloud.service;

import com.cl.springcloud.pojo.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/8 17:33
 */

@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //表示feign作用在该接口上,value=提供者服务名
@Component
public interface PaymentFeignService {

    @PostMapping("/payment/getPaymentById")
    CommonResult getPaymentById(@RequestBody String paymentId);

    @GetMapping("/payment/feignTimeout")
     String paymentFeignTimeout();
}
