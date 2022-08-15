package com.cl.springcloudalibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/12 9:29
 */
public interface AccountService {
    /**
     * 扣减账户余额
     * @param userId
     * @param money
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);


}
