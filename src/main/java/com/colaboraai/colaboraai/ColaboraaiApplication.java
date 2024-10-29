package com.colaboraai.colaboraai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.colaboraai.colaboraai.config.DatabaseConfig;

@SpringBootApplication
public class ColaboraaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColaboraaiApplication.class, args);
		DatabaseConfig.connect();
	}

}