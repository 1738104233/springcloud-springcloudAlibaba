package com.cl.springcloudalibaba.service.impl;

import com.cl.springcloudalibaba.dao.StorageDao;
import com.cl.springcloudalibaba.service.StorageService;
import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/12 9:30
 */
@Service
@Log4j2
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    // 扣减库存
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);

    }

}
