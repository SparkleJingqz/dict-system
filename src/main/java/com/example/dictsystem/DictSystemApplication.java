package com.example.dictsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.dictsystem.dao")
@SpringBootApplication
public class DictSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DictSystemApplication.class, args);

    }

}
