package com.cl.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.cl.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/9 16:37
 */

@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod",commandProperties = {
        //超过规定时间算超时错误,直接执行兜底方法
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
}) //配置全局降级
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        String result="线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id="+id;
        log.info(result);
        return result;
    }

//    //当前服务不可用了，就做服务降级，执行兜底方法（注意兜底方法要和执行方法参数返回值都保持一致）
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
//            //3s内算正常，超过3s算超时错误,直接执行兜底方法
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    @HystrixCommand //如果在单个方法上指定了fallback则优先使用指定的，没指定则使用默认（就近原则）
    @Override
    public String paymentInfo_Timeout(Integer id) {
        //模拟运行时异常,运行异常直接执行兜底方法
        //int age = 10/0;
        int timeNumber = 2;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (Exception e){
            log.error(e);
        }
        String result="线程池:"+Thread.currentThread().getName()+"paymentInfo_Timeout,id="+id+"\t"+"耗时(秒)"+timeNumber;
        log.info(result);
        return result;
    }


    public String paymentInfo_TimeoutHandler(Integer id) {
        return "我是服务者,系统繁忙或运行错误,请稍后再试"+id;
    }

    //下面是全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试";
    }




    /**
     *  服务熔断:
     * 熔断机制是应对雪崩效应的一种微服务链路保护机制。当扇出链路的某个微服务出错不可用或者响应时间太长时，
     * 会进行服务的降级，进而熔断该节点微服务的调用，快速返回错误的响应信息。
     * 当检测到该节点微服务调用响应正常后，恢复调用链路。
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if (id < 0){
            throw new RuntimeException("id不能为负数");
        }
        //hutool工具包提供
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id不能为负数,请稍后再试"+id;
    }
}
