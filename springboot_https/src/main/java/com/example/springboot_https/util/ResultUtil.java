package com.example.springboot_https.util;

import com.example.springboot_https.entity.Result;

/**
 * 异常工具类
 */
public class ResultUtil {
    /**
     * 创建请求成功对象，包含结果对象
     * @param obj
     * @return
     */
    public static Result sucess(Object obj) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("sucess");
        result.setDate(obj);
        return result;
    }

    /**
     * 创建请求成功对象
     * @return
     */
    public static Result sucess() {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("sucess");
        return result;
    }

    /**
     * 创建请求异常对象
     * @param code
     * @param message
     * @return
     */
    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }
}
