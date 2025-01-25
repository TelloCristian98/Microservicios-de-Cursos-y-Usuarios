package com.example.micro_cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCursosApplication.class, args);
	}

}
