package com.cl.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/5/31 10:56
 */
@Controller
@Log4j2
@RequestMapping("/consumerzk")
public class OrderZKController {

    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping("/zk")
    public String paymentInfo(){

        //使用RestTemplate发送请求
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }

}
