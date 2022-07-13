package com.cl.springcloud.controller;

import com.cl.springcloud.pojo.vo.CommonResult;
import com.cl.springcloud.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/5/18 16:43
 */
@Log4j2
@Controller
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    //服务发现注解 springcloud提供，对于注册进eureka里面的微服务，可以通过服务发现来获得该服务的信息
    @Autowired
    private DiscoveryClient discoveryClient;

    @ResponseBody
    @RequestMapping("/createPayment")
    public CommonResult createPayment(@RequestBody String serial) {
         return paymentService.getPaymentById(serial);
    }

    @ResponseBody
    @RequestMapping("/getPaymentById")
    public CommonResult getPaymentById(@RequestBody String paymentId) {
       return paymentService.getPaymentById(paymentId);
    }

    @ResponseBody
    @RequestMapping("/discovery")
    public Object discovery(){
        HashMap<String, Object> map = new HashMap<>();
        //获得服务列表
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            log.info("service---"+service);
        }
        //获得服务下的实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        map.put("services:",services);
        map.put("instances:",instances);
        return map;
    }

    //获取yml文件里配置的端口
    @Value("${server.port}")
    private String serverPort;

    @ResponseBody
    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @ResponseBody
    @GetMapping("/feignTimeout")
    public String paymentFeignTimeout(){

        //模拟openFeign超时
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            log.error(e);
        }
        return serverPort;
    }

}
