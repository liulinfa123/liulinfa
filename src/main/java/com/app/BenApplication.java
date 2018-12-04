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
        String decrypt = SecurityUtil.decrypt("a88cc1abd86b984849c4607d2dcbb075");
        System.out.println(decrypt);


    }
}
