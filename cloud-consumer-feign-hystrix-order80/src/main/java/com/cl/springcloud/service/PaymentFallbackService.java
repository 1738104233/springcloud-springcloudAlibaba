package com.cl.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/16 11:01
 *
 * 配置远程调用超时，宕机....降级（比如80调8001，8001挂了，使用这里兜底）
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "调用paymentInfo_OK服务出现异常了";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "调用paymentInfo_Timeout服务出现异常了";
    }
}
