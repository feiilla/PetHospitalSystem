package com.example.pethospital.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 配置线程池参数
 */
@Slf4j
@Configuration
public class ExecutorConfig {
    @Bean
    public Executor asyncServiceExecutor() {
        log.info("Start asyncServiceExecutor...");

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        //最大线程数是当前cpu的线程数
        executor.setMaxPoolSize(2);
        //设置阻塞队列大小
        executor.setQueueCapacity(200);
        //配置线程池中的线程名称前缀
        executor.setThreadNamePrefix("Async-service-");
        //线程池维护线程所允许的空闲时间
        executor.setKeepAliveSeconds(20);
        //设置拒绝策略，当poll达到max size的时候，由调用者所在的线程执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        return executor;
    }
}
