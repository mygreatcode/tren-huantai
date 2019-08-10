package com.tren.huantai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class HuantaiApplication {
// Customize the spring config location
    public static void main(String[] args) {
        SpringApplication.run(HuantaiApplication.class, args);
    }

}
