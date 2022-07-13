package com.cl.springcloud.service;

import com.cl.springcloud.pojo.vo.CommonResult;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/5/18 16:36
 */
public interface PaymentService {
    /**
     * 创建一个付款信息
     * @param serial
     * @return
     */
    CommonResult createPayment(String serial);

    /**
     * 通过id获得付款信息
     * @param paymentId
     * @return
     */
    CommonResult getPaymentById(String  paymentId);
}
