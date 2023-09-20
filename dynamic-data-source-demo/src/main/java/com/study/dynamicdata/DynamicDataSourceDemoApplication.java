package com.study.dynamicdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luohongxiao
 */
@SpringBootApplication
@MapperScan("com.study.dynamicdata.dao")
public class DynamicDataSourceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDataSourceDemoApplication.class, args);
    }

}
