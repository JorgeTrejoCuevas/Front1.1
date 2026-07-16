package com.example.schedule.m9_schedule_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ScheduleConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleConfigServiceApplication.class, args);
	}

}
