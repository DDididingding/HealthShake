package com.jhgpt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jhgpt.model.dao")
public class JhgptApplication {

	public static void main(String[] args) {
		SpringApplication.run(JhgptApplication.class, args);
	}

}
