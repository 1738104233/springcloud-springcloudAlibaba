package com.cl.springcloudalibaba.service.impl;

import com.cl.springcloudalibaba.dao.OrderDao;
import com.cl.springcloudalibaba.pojo.po.OrderPO;
import com.cl.springcloudalibaba.service.AccountService;
import com.cl.springcloudalibaba.service.OrderService;
import com.cl.springcloudalibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/11 14:42
 */
@Log4j2
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AccountService accountService;
    @Autowired
    private StorageService storageService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    @GlobalTransactional(name = "cloud-create-order",rollbackFor = Exception.class)
    public void create(OrderPO order) {
        log.info("--------->开始创建订单");
        //新建订单
        orderDao.create(order);

        //扣减库存
        log.info("--------->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());

        //扣减账户
        log.info("--------->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());


        //修改订单状态，从零到1代表已经完成
        log.info("----->开始修改订单状态");
        orderDao.update(order.getUserId(),0);

        log.info("----->下订单结束了");

    }




}
