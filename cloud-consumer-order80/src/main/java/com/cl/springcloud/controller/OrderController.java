package com.cl.springcloud.controller;

import com.cl.springcloud.lb.LoadBalancer;
import com.cl.springcloud.pojo.vo.CommonResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/5/19 15:10
 */
@Log4j2
@Controller
@RequestMapping("/consumer")
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;
    //引入自己写的负载均衡算法，com.cl.springcloud.lb.LoadBalancer
    @Autowired
    private LoadBalancer loadBalancer;
    //服务发现注解 springcloud提供，对于注册进eureka里面的微服务，可以通过服务发现来获得该服务的信息
    @Autowired
    private DiscoveryClient discoveryClient;

    @ResponseBody
    @GetMapping("/getPaymentById")
    public CommonResult getPaymentById(@RequestBody String paymentId){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/getPaymentById",paymentId,CommonResult.class);
    }

    @ResponseBody
    @GetMapping("/getPaymentById2")
    public CommonResult getPaymentById2(@RequestBody String paymentId){
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/getPaymentById", paymentId, CommonResult.class);
        /**
         * restTemplate.postForEntity 返回code、message、json、端口等详细信息
         * restTemplate.postForObject 返回json
         */
        log.info(entity);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult(444,"失败");
        }
    }

    @ResponseBody
    @RequestMapping("/lb")
    public String getPaymentLB(){
        //获得服务下的实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        //使用自己写的负载均衡器,轮询算法
        ServiceInstance serviceInstance = loadBalancer.polling(instances);
        //获取实例的uri
        URI uri = serviceInstance.getUri();
        log.info("getPaymentLB----实例uri："+uri);
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    @ResponseBody
    @GetMapping("/zipkin")
    public String getPaymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin", String.class);
        return result;
    }
}
