package com.example.spring_aop_log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class SpringAopLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopLogApplication.class, args);
    }

}
