package com.cl.springcloud.dao;

import com.cl.springcloud.pojo.po.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/5/18 15:36
 */
@Mapper
public interface PaymentDao {
    /**
     * 创建一个付款信息
     * @param serial
     * @return
     */
    int createPayment(@Param("serial") String serial);

    /**
     * 通过id获得付款信息
     * @param payment_id
     * @return
     */
    Payment getPaymentById(@Param("payment_id") Long payment_id);
}
