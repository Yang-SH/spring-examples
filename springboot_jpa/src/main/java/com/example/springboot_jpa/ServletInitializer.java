package com.example.springboot_jpa;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * WebApplicationInitializer�̳�WebApplicationInitializer��
 * WebApplicationInitializer���Կ�����Web.xml�����������һ���ӿڡ�
 * ͨ��ʵ��WebApplicationInitializer�������п������servlet��listener�ȣ�
 * �ڼ���Web��Ŀ��ʱ����������ӿ�ʵ���࣬�Ӷ���web.xml��ͬ�����á�
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootJpaApplication.class);
    }
}
