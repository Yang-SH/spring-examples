package com.example.spring_aop_log.sevice.impl;

import java.io.Serializable;

public class ServiceLogStrategy implements Serializable {

    private boolean async;

    private String threadId;

    private String location;

    private String description;

    private String className;

    private String methodName;

    private String arguments;

    private String result;

    private Long elapsedTime;


    public String format() {
        return "线程ID: {}, 注解位置: {}, 方法描述: {}, 目标类名: {}, 目标方法: {}, 调用参数: {}, 返回结果: {}, 花费时间: {}";
    }

    public Object[] args() {
        return new Object[]{this.threadId, this.location, this.description, this.className, this.methodName, this.arguments, this.result, this.elapsedTime};
    }

}
