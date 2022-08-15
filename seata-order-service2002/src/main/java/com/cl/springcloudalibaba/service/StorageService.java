package com.cl.springcloudalibaba.service;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/12 9:29
 */
public interface StorageService {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);

}
