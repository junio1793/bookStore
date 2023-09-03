package com.springBoot.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springBoot.bookstore.service.DBservice;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBservice bservice;
	
	@Bean
	public void instanciaDB() {
		bservice.instanciaDB();
	}

}
