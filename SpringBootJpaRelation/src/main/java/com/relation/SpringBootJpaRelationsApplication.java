package com.relation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class SpringBootJpaRelationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaRelationsApplication.class, args);
	}
//http://localhost:8081/swagger-ui/index.html#/
}
