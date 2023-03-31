package com.example.pethospital;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * SpringBoot项目想运行在第三方tomcat上必需实现SpringBootServletInitializer接口的configure方法才能让外部容器运行
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PetHospitalApplication.class);
    }

}
