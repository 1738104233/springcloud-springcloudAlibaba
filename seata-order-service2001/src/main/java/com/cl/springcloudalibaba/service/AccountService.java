package com.cl.springcloudalibaba.service;

import com.cl.springcloudalibaba.unified.result.CommonResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/11 14:50
 */

@Component
@FeignClient(value = "seata-account-service")
public interface AccountService {
    @PostMapping(value = "/account/decrease")
    CommonResultVO decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
