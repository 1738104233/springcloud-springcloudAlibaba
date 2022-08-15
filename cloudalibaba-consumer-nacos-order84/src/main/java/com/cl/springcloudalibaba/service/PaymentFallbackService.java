package com.cl.springcloudalibaba.service;

import com.cl.springcloud.pojo.po.Payment;
import com.cl.springcloud.unified.code.ResultCode;
import com.cl.springcloud.unified.result.CommonResultVO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/8 14:09
 */
//fallback
@Component
public class PaymentFallbackService implements PaymentFeignService{
    @Override
    public CommonResultVO paymentSQL(Long id) {
            Payment payment = new Payment(id, "null");
            return new CommonResultVO(ResultCode.ERROR,"服务异常！");
    }
}
