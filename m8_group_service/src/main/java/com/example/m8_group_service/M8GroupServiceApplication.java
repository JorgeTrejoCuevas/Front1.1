package com.example.m8_group_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) // 👈 Agregamos esto para apagar la seguridad por defecto
public class M8GroupServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(M8GroupServiceApplication.class, args);
    }

}