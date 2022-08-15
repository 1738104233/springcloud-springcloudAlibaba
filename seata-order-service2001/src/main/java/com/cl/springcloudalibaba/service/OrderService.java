package com.cl.springcloudalibaba.service;

import com.cl.springcloudalibaba.pojo.po.OrderPO;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/11 14:41
 */
public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void create(OrderPO order);

}
