package com.doudou.peer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//  通过@EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行对话。
@EnableEurekaServer
@SpringBootApplication
public class PeerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(PeerApplication.class).web(true).run(args);
    }

}
