package com.legend.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Administrator
 * @date 2018/3/13
 */
@SpringBootApplication(scanBasePackages = {"com.legend"})
@EnableTransactionManagement
public class LegendCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(LegendCloudApplication.class, args);
    }
}
