package com.br.tads.storm.rabbitmq;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQConnection {
	private static final String NOME_EXCHANGE = "Streaming";
	@Autowired
	private AmqpAdmin amqpAdmin;
	@Autowired
	public RabbitMQConnection(AmqpAdmin amqpAdmin) {
		this.amqpAdmin = amqpAdmin;
	}
	
	private Queue novaFila(String nomeFila) {
		return new Queue(nomeFila, true, false, true);
	}
	
	private DirectExchange novaExchange() {
		return new DirectExchange(NOME_EXCHANGE);
	}
	
	private Binding relacionarFilaExchange(Queue fila, DirectExchange exchange) {
		return new Binding(fila.getName(), DestinationType.QUEUE, exchange.getName(),
				fila.getName(), null);
	}
	
	@PostConstruct
	private void criarFilas() {
		DirectExchange exchange = novaExchange();
		this.amqpAdmin.declareExchange(exchange);
			Queue filaStart = this.novaFila("StartMessage");
			Binding bindingStart = this.relacionarFilaExchange(filaStart, exchange);
			this.amqpAdmin.declareQueue(filaStart);
			this.amqpAdmin.declareBinding(bindingStart);
			
			Queue filaAlert = this.novaFila("alertUser");
			Binding bindingAlert = this.relacionarFilaExchange(filaAlert, exchange);
			this.amqpAdmin.declareQueue(filaAlert);
			this.amqpAdmin.declareBinding(bindingAlert);
			
			Queue filaSave = this.novaFila("saveDB");
			Binding bindingSave = this.relacionarFilaExchange(filaSave, exchange);
			this.amqpAdmin.declareQueue(filaSave);
			this.amqpAdmin.declareBinding(bindingSave);
	}
}
