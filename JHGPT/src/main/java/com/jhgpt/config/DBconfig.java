package com.jhgpt.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.jhgpt.model.dao")
public class DBconfig {
	

}
