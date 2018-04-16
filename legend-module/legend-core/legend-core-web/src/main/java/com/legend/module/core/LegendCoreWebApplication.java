package com.legend.module.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Administrator
 * @date 2018/3/9
 * <p>
 * 如果配置了session-redis则需要开启@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 36000)
 * </p>
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class LegendCoreWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LegendCoreWebApplication.class, args);
    }
}
