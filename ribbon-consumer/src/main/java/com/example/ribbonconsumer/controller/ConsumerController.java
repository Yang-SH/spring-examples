package com.example.ribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者Controller
 */
@RestController
public class ConsumerController {

    //  RestTemplate是Spring提供的用于访问Rest服务的客户端
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/ribbon-consumer",method= RequestMethod.GET)
    public String helloConsumer(){
        //  通过在上面创建的 RestTemplate 来实现对 HELLO-SERVICE 服务提供的/hello接口进行调用。
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }

}
