package com.cl.springcloudalibaba.service.impl;

import com.cl.springcloudalibaba.service.AccountService;
import com.cl.springcloudalibaba.dao.AccountDao;
import com.cl.springcloudalibaba.pojo.po.AccountPO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/12 9:30
 */
@Service
@Log4j2
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        accountDao.decrease(userId,money);
        log.info("------->account-service中扣减账户余额结束");

    }
}
