package com.br.tads.storm.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tads.storm.model.ObjectJsonDTO;

@Service
public class RabbitMQService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviaMensagem(String nomeFila, ObjectJsonDTO mensagem) {
        this.rabbitTemplate.convertAndSend(nomeFila, mensagem);
    }
}
