package com.demo.sb.service.springboot_demo_service;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
* The Application class is a spring boot starter class. 
* 
* @author  Koushik Maiti
* @version 1.0
* @since   2018-04-06 
*/

@SpringBootApplication
@EnableSwagger2
public class Application {
	
	@Value("${apiVersion}")
	String apiVersion;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
		
	@Bean
	public Docket demoApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Spring Boot API").apiInfo(apiInfo()).select()
				.paths(regex("/api/.*")).build();		
	}	
	
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring Boot Demo REST APIs").description("Spring Boot Demo REST APIs")
				.termsOfServiceUrl("http://....").contact(new Contact("Telstra HPSE...", "https://www.telstra.com", "koushik.maiti@wipro.com")).license("Telstra Licensed")
				.licenseUrl("https://wipro.com").version(apiVersion).build();
	}

}
