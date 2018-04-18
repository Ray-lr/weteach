package com.legend.cloud.campus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 * @date 2018/4/18
 */
@SpringBootApplication(scanBasePackages = {"com.legend.module.core", "com.legend.cloud.campus"})
public class LegendCampusApplication {

    public static void main(String[] args) {
        SpringApplication.run(LegendCampusApplication.class, args);
    }
}
