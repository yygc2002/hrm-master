package com.qiujie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan("com.qiujie.mapper")
@ComponentScan("blockchain.web.*")
@ComponentScan("blockchain.websocket")
@SpringBootApplication
@EnableTransactionManagement // 事务
public class HrmApplication {
    public static void main(String[] args) {
        SpringApplication.run(HrmApplication.class, args);
    }
}
