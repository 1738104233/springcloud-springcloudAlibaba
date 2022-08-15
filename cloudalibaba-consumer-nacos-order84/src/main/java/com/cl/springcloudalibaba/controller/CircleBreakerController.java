package com.cl.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cl.springcloud.pojo.po.Payment;
import com.cl.springcloud.unified.code.ResultCode;
import com.cl.springcloud.unified.result.CommonResultVO;
import com.cl.springcloudalibaba.service.PaymentFeignService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/4 15:21
 */

@RestController
@Log4j2
@RequestMapping("/consumer")
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";
    @Value("${service-url.nacos-user-service}")
    private String serverURL;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private PaymentFeignService paymentFeignService;

//--------------------------    ribbon --------------------------
    @GetMapping("/payment/{id}")
    //@SentinelResource(value = "payment") //没有配置
    //@SentinelResource(value = "payment",fallback = "handlerFallback") //fallback只负责业务异常
    //@SentinelResource(value = "payment",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "payment",fallback = "handlerFallback",blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})//exceptionsToIgnore放过指定异常
    public CommonResultVO payment(@PathVariable Long id){
        CommonResultVO result = restTemplate.getForObject(serverURL + "/paymentSQL/" + id, CommonResultVO.class, id);
        if (id == 4){
         throw new IllegalArgumentException("IllegalArgumentException,非法参数!参数校验失败...");
        }else if (id > 4){
            throw new NullPointerException("NullPointerException,没有该条数据...");
        }
        return result;
    }

    //fallback
    public CommonResultVO handlerFallback(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id, "null");
        return new CommonResultVO(ResultCode.ERROR,"兜底异常handlerFallback,exception:"+e.getMessage()+",data:"+payment);
    }

    //blockHandler
    public CommonResultVO blockHandler(@PathVariable Long id, BlockException blockException){
        Payment payment = new Payment(id, "null");
        return new CommonResultVO(ResultCode.ERROR,"blockHandler-sentinel限流,无此流水: blockException:"+blockException.getMessage()+",data:"+payment);
    }


    //--------------------------  openFeign --------------------------
    @GetMapping("/paymentFeign/{id}")
    public CommonResultVO paymentFeign(@PathVariable Long id){
        return paymentFeignService.paymentSQL(id);
    }
}
