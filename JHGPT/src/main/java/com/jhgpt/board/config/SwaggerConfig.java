package com.jhgpt.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ssafy.board.controller"))
                .paths(PathSelectors.ant("/api/*")) 
                .build()
                .apiInfo(apiInfo()); 
	}

}
