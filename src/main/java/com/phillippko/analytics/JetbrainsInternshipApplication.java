package com.phillippko.analytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class JetbrainsInternshipApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetbrainsInternshipApplication.class, args);
    }

}
