package com.moneypro.bill_pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.moneypro.bill_pro.mapper")
public class BillProApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillProApplication.class, args);
    }

}
