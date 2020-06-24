package com.doudou.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 服务注册，会将controller中所有方法全都映射出去，给服务消费者调用
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() throws Exception {
//        ServiceInstance instance = client.getLocalServiceInstance();
//        logger.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
//        return "Hello World";

        ServiceInstance instance = client.getLocalServiceInstance();
        //让处理线程等待几秒钟
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:" + sleepTime);
        Thread.sleep(sleepTime);
        logger.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
        return "Hello World";
        
    }

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/say,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
        return "say what";
    }

}
