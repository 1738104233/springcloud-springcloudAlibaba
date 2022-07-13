package com.cl.springcloud.controller;

import com.cl.springcloud.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/9 16:50
 */

@Controller
@RequestMapping("/payment/hystrix")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @ResponseBody
    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_OK(id);
    }

    @ResponseBody
    @GetMapping("/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_Timeout(id);
    }

    @ResponseBody
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
