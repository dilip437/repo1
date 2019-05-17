package com.poc;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${student.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${student.rabbitmq.routingkey}")
	private String routingkey;
	
	public void send(Student student) {
		rabbitTemplate.convertAndSend(exchange, routingkey, student);
		System.out.println("Send msg = " + student);
	}
}
