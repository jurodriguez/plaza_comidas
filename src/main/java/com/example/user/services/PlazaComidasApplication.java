package com.example.user.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PlazaComidasApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlazaComidasApplication.class, args);
    }

}
