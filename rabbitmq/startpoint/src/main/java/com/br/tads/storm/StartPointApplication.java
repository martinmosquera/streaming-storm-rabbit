package com.br.tads.storm;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StartPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartPointApplication.class, args);
	}
	
	@Bean
	  public ModelMapper modelMapper() {
	    ModelMapper modelMapper = new ModelMapper();
	    return modelMapper;
	  }

}
