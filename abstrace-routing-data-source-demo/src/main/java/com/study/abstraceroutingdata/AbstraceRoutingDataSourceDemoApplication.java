package com.study.abstraceroutingdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.study.abstraceroutingdata.dao")
public class AbstraceRoutingDataSourceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbstraceRoutingDataSourceDemoApplication.class, args);
    }

}
