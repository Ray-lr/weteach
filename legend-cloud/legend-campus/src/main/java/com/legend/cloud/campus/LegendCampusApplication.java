package com.legend.cloud.campus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Administrator
 * @date 2018/4/18
 */
@SpringBootApplication(scanBasePackages = {"com.legend.module.core", "com.legend.cloud.campus"})
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class LegendCampusApplication {

    public static void main(String[] args) {
        SpringApplication.run(LegendCampusApplication.class, args);
    }
}
