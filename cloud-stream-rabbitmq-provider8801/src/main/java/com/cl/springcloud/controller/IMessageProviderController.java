package com.cl.springcloud.controller;

import com.cl.springcloud.service.IMessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/7/8 14:19
 */
@RestController
public class IMessageProviderController {

    @Resource
    private IMessageProviderService iMessageProviderService;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return iMessageProviderService.send();
    }

}
