package com.poc;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMQSender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FanoutExchange fanout;

    public void send(String name, String id) {
    	String message = "[ Name='" + name + "', Id='" + id + "']"; 
        template.convertAndSend(fanout.getName(), "", message);
        System.out.println("Send msg = " + message);
    }
}
