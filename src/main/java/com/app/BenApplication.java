package com.app;

import com.app.utils.SecurityUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.app.*.dao")
public class BenApplication {

    public static void main(String[] args) {
        SpringApplication.run(BenApplication.class, args);
    }
}
