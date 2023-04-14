package com.mashibing.juc.c_32_AliQuestions;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Component
public class Pool {
    @Bean
    public ThreadPoolTaskExecutor APool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setQueueCapacity(1000);
        executor.setKeepAliveSeconds(3);
        executor.setThreadNamePrefix("Apool-");
        executor.setMaxPoolSize(6);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.initialize();
        return executor;
    }
}
