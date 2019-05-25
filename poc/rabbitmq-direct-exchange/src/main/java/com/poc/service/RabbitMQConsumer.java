package com.poc.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.poc.model.Student;

@Component
@RabbitListener(queues = {"student.queue"})
public class RabbitMQConsumer {

    @RabbitHandler
    public void receiveMessage(Student student)
    {
    	System.out.println("Recv msg = " + student.toString());
    }
}
