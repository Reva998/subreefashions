package com.flm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@SpringBootApplication
public class AbcTravelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcTravelsApplication.class, args);
	}

}
