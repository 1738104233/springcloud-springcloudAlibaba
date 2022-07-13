package com.cl.springcloud.cotroller;

import com.cl.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/10 14:14
 */

@Controller
@RequestMapping("/consumer/payment/hystrix")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @ResponseBody
    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @ResponseBody
    @GetMapping("/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_Timeout(id);
    }

}



