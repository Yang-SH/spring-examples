package com.example.springboot_https.handler;

import com.example.springboot_https.entity.Result;
import com.example.springboot_https.exception.PersonException;
import com.example.springboot_https.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    /**
     * 捕获异常类
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof PersonException){
            PersonException personException = (PersonException) e;
            return ResultUtil.error(personException.getCode(),personException.getMessage());
        }
        log.error("【系统错误】",e);
        return ResultUtil.error(-1,"未知错误");
    }
}

