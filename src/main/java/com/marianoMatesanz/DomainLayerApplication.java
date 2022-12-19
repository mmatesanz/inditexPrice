package com.marianoMatesanz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Application Prices", version = "2.0", description = "API Prices Inditex"))
public class DomainLayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomainLayerApplication.class, args);
	}

}
