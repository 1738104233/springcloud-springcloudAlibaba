package com.cl.springcloudalibaba.service;

import com.cl.springcloudalibaba.unified.result.CommonResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/11 14:49
 */
@Component
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonResultVO decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
