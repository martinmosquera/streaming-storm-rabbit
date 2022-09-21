package com.br.tads.storm;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainTopology {

	public static void main(String[] args) {
		SpringApplication.run(MainTopology.class, args);		
}
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper(); 
	}
}
