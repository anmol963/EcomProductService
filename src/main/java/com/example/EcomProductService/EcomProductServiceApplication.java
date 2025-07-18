package com.example.EcomProductService;

import com.example.EcomProductService.service.InitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomProductServiceApplication implements CommandLineRunner {

	private InitiService initiService;

	public EcomProductServiceApplication(InitiService initiService) {
		this.initiService = initiService;
	}

	public static void main(String[] args) {
		SpringApplication.run(EcomProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initiService.initialize();
	}
}
