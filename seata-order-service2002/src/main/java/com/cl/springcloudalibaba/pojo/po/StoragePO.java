package com.cl.springcloudalibaba.pojo.po;

import lombok.Data;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/12 9:23
 */
@Data
public class StoragePO {
    /**
     * id
     */
    private Long id;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;

}
