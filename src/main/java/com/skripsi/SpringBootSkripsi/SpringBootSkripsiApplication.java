package com.skripsi.SpringBootSkripsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan({ "com.skripsi.SpringBootSkripsi.controller, com.skripsi.SpringBootSkripsi.repository, "
//        + "com.skripsi.SpringBootSkripsi.model", "controller", "repository", "model" })
public class SpringBootSkripsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSkripsiApplication.class, args);
	}
}
