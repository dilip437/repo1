package com.poc;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RabbitMQReceiver {
	
	@RabbitListener(queues = "${fanout.queue.one}")
    public void receive1(String in) throws InterruptedException {
        receive(in, 1);
    }

    @RabbitListener(queues = "${fanout.queue.two}")
    public void receive2(String in) throws InterruptedException {
        receive(in, 2);
    }

    public void receive(String message, int receiver) throws InterruptedException {
    	System.out.println("instance " + receiver + " Recv msg = " + message);
    }
}
