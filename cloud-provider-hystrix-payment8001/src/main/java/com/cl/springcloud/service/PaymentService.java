package com.cl.springcloud.service;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/9 16:37
 */
public interface PaymentService {
    /**
     * 访问测试
     * @param id
     * @return
     */
    String paymentInfo_OK(Integer id);

    /**
     * 模拟业务执行需要处理3秒
     * @param id
     * @return
     */
    String paymentInfo_Timeout(Integer id);

    /**
     * 服务熔断
     * @param id
     * @return
     */
    String paymentCircuitBreaker(Integer id);
}
