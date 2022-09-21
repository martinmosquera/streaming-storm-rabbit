package com.br.tads.storm.rest;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.tads.storm.model.ObjectJsonDTO;

@CrossOrigin
@RestController
public class EndRest {

    @Autowired
    private ModelMapper mapper;
    
    private final static String saveDB = "SaveDB";
    private final static String alertUser = "alertUser";
    
    @GetMapping("/alertas")
    public ResponseEntity<String> inserirAll() {
		
		return ResponseEntity.status(201).body("Alertaas");
	}
}
