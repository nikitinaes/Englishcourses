package com.example.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class CourseRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseRegistrationApplication.class, args);
	}

	// Теперь можно работать с базой данных
}

