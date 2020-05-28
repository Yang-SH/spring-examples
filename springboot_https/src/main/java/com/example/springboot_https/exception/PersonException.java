package com.example.springboot_https.exception;

import com.example.springboot_https.enums.ResultEnum;

/**
 * 自定义异常类
 */

//RuntimeException继承Exception,spring只对继承RuntimeException的异常进行回滚
public class PersonException extends RuntimeException {
    private Integer code;

    public PersonException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

