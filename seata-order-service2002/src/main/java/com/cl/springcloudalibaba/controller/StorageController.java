package com.cl.springcloudalibaba.controller;

import com.cl.springcloud.unified.result.CommonResultVO;
import com.cl.springcloudalibaba.service.StorageService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/12 9:32
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResultVO decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResultVO("扣减库存成功！");
    }

}
