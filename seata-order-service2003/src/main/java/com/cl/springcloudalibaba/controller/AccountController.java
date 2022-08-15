package com.cl.springcloudalibaba.controller;

import com.cl.springcloud.unified.result.CommonResultVO;
import com.cl.springcloudalibaba.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/12 9:32
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResultVO decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResultVO("扣减账户余额成功！");
    }


}
