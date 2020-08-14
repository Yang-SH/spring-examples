package com.doudou.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private CounterService counterService;

    @RequestMapping("/hello")
    public String index(){
        //自定义实现对hello接口的访问次数统计
        counterService.increment("didispace.hello.count");

        return "Hello World";
    }

}
