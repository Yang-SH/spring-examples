package com.example.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    private final Logger logger = Logger.getLogger(getClass());

    //  RestTemplate是Spring提供的用于访问Rest服务的客户端
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback",commandKey = "helloKey")
    public String helloService() {
        long start = System.currentTimeMillis();
        //  消费服务的逻辑
        //  通过在上面创建的 RestTemplate 来实现对 HELLO-SERVICE 服务提供的/hello接口进行调用。
        String result = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        long end = System.currentTimeMillis();
        logger.info("Spend time : " + (end - start));
        return result;
    }

    public String helloFallback() {
        return "error";
    }

}
