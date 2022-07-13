package com.cl.springcloud.unified.code;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/24 10:01
 *
 * 统一返回状态码定义
 */

public enum ResultCode implements StatusCode{

    SUCCESS("00000", "成功"),
    ERROR("B0001", "系统执行出错"),
    VALIDATE_ERROR("A0403", "参数校验失败");


    private String code;
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
