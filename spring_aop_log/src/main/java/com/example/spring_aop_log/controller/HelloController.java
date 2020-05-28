package com.example.spring_aop_log.controller;

import com.example.spring_aop_log.annotation.SystemControllerLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value="/hello", method= RequestMethod.GET)
    @SystemControllerLog(description = "hello 你好")
    public String hello(){
        return "hello";
    }

}
