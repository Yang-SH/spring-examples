package com.example.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    //  RestTemplate是Spring提供的用于访问Rest服务的客户端
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod="helloFallback")
    public String helloService(){
        //  通过在上面创建的 RestTemplate 来实现对 HELLO-SERVICE 服务提供的/hello接口进行调用。
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }

    public String helloFallback(){
        return "error";
    }

}
