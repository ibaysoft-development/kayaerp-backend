package com.kaya.erp.kayaerp.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EntityScan(basePackages = { "com.kaya.erp.kayaerp" })
@ComponentScan(basePackages = { "com.kaya.erp.kayaerp" })
@EnableJpaRepositories(basePackages = { "com.kaya.erp.kayaerp" })
@SpringBootApplication
public class KayaerpApplication {

	public static void main(String[] args) {
		SpringApplication.run(KayaerpApplication.class, args);
	}

}
