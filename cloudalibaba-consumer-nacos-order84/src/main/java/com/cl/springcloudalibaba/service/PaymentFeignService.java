package com.cl.springcloudalibaba.service;

import com.cl.springcloud.pojo.po.Payment;
import com.cl.springcloud.unified.result.CommonResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/8 14:05
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentFeignService {

    @GetMapping("/paymentSQL/{id}")
    public CommonResultVO paymentSQL(@PathVariable("id") Long id);


}
