package com.br.tads.storm.rabbitmq;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQConnection {
	private static final String NOME_EXCHANGE = "Storm";
	private AmqpAdmin amqpAdmin;
	
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
			Queue fila = this.novaFila("StartMessage");
			Binding binding = this.relacionarFilaExchange(fila, exchange);
			this.amqpAdmin.declareQueue(fila);
			this.amqpAdmin.declareBinding(binding);
			
			fila = this.novaFila("SaveDB");
			binding = this.relacionarFilaExchange(fila, exchange);
			this.amqpAdmin.declareQueue(fila);
			this.amqpAdmin.declareBinding(binding);
	}
}
