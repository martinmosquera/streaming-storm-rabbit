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

import com.br.tads.storm.model.ObjectJson;
import com.br.tads.storm.model.ObjectJsonDTO;
import com.br.tads.storm.rabbitmq.RabbitMQService;
import com.br.tads.storm.repository.ObjectJsonRepository;

@CrossOrigin
@RestController
public class StartRest {
	
	@Autowired
	RabbitMQService rabbitService;
	@Autowired
    private ObjectJsonRepository repo;
    @Autowired
    private ModelMapper mapper;
    
    private final static String Start_Message = "StartMessage";
    
    @GetMapping("/registros")
    public ResponseEntity<List<ObjectJsonDTO>> inserirAll() {
		List<ObjectJsonDTO> lista = new ArrayList<ObjectJsonDTO>();
		for(ObjectJson obj : repo.findAll()){
			lista.add(mapper.map(obj,ObjectJsonDTO.class));
			ObjectJsonDTO otdo = mapper.map(obj, ObjectJsonDTO.class);
			this.rabbitService.enviaMensagem(Start_Message, otdo);
		};
		return ResponseEntity.status(201).body(lista);
	}
    
    @GetMapping("/add")
    public ResponseEntity<ObjectJsonDTO> insere() {
		ObjectJson o = new ObjectJson();
		o.setId(66);
		o.setTotal_UPDRS(60);
		ObjectJsonDTO otdo = mapper.map(o, ObjectJsonDTO.class);
		this.rabbitService.enviaMensagem(Start_Message, otdo);
		return ResponseEntity.status(201).body(otdo);
	}
}
