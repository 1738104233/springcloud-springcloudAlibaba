package com.cl.springcloud.unified;

import com.cl.springcloud.unified.code.ResultCode;
import com.cl.springcloud.unified.result.CommonResultVO;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/24 15:42
 *
 * 处理@Validated参数校验异常统一返回
 */

//RestControllerAdvice和ControllerAdvice是全局接口异常处理的类，当发生异常没有捕获时，便会触发这个异常
@RestControllerAdvice  //推荐使用这个，老版本项目用不了则@ControllerAdvice
//@ControllerAdvice
public class ValidatedExceptionAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class}) //捕获异常,你想拦截@Validated校验什么类型的异常
    public CommonResultVO MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new CommonResultVO(ResultCode.VALIDATE_ERROR, objectError.getDefaultMessage());
    }
}

