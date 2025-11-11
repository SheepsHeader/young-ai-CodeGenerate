package com.youngheart.youngaicodegenerate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.youngheart.youngaicodegenerate.mapper")
public class YoungAiCodeGenerateApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoungAiCodeGenerateApplication.class, args);
    }

}
