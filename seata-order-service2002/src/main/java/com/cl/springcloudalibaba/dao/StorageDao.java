package com.cl.springcloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/12 9:25
 */
@Mapper
public interface StorageDao {
    /**
     * 扣减库存信息
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
