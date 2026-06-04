package com.dataengineering.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class EmployeeIngestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeIngestionApplication.class, args);
    }
}
