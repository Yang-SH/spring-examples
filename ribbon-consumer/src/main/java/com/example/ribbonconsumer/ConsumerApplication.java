package com.example.ribbonconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


//  @EnableDiscoveryClient让该应用注册为Eureka客户端应用，以获得服务发现的能力
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

    //  @LoadBalanced开启客户端负载均衡
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}