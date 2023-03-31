package com.example.pethospital;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan(basePackages = "com.example.pethospital.mapper")
//通过注解开启异步线程并配置处理方法
@EnableAsync(proxyTargetClass = true)
public class PetHospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetHospitalApplication.class, args);
    }

}
