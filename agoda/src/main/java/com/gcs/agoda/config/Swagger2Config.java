package com.gcs.agoda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 15, 2019	
 *@version 1.0
 */
// http://localhost:8080/api-docs
//http://localhost:8080/swagger-ui.html
@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.gcs.agoda.controller"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("AGODA API")
				.description("Agoda REST API")
				.termsOfServiceUrl("http://agoda.com")
				.licenseUrl("hoang.ngoc.hungit@gmail.com")
				.version("1.0").build();
	}
}
