package com.cl.springcloudalibaba.pojo.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/11 11:21
 */
@Data
public class OrderPO {
    /**
     * id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 数量
     */
    private Integer count;
    /**
     * 金额
     */
    private BigDecimal money;
    /**
     * 单状态：0：创建中；1：已完结
     */
    private Integer status;

}
