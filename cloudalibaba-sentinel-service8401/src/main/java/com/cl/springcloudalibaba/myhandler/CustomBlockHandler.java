package com.cl.springcloudalibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cl.springcloud.unified.result.CommonResultVO;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/8/4 11:16
 */
public class CustomBlockHandler {
    public static CommonResultVO handleException(BlockException blockException){
        return new CommonResultVO("自定义的限流处理信息---->CustomBlockHandler");
    }
    public static CommonResultVO handleException2(BlockException blockException){
        return new CommonResultVO("自定义的限流处理信息---->CustomBlockHandler---->2");
    }
}
