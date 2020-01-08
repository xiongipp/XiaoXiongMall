package com.xxh.mymall;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xxh.mymall.dao")
public class MymallApplication {


    public static void main(String[] args) {
        SpringApplication.run(MymallApplication.class, args);
    }

}
