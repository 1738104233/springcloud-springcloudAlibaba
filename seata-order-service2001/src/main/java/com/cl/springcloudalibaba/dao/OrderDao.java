package com.cl.springcloudalibaba.dao;

import com.cl.springcloudalibaba.pojo.po.OrderPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/11 11:26
 */

@Mapper
public interface OrderDao {

    /**
     * 新建订单
     * @param order
     */
    void create(OrderPO order);

    /**
     * 修改订单状态，从零改为1
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
