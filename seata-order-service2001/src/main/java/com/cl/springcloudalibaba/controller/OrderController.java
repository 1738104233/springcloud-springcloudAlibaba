package com.cl.springcloudalibaba.controller;

import com.cl.springcloudalibaba.pojo.po.OrderPO;
import com.cl.springcloudalibaba.service.OrderService;
import com.cl.springcloudalibaba.unified.result.CommonResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/11 17:24
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResultVO create(OrderPO order)
    {
        orderService.create(order);
        return new CommonResultVO("订单创建成功");
    }

}
