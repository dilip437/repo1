package com.poc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poc.service.RabbitMQReceiver;
import com.poc.service.RabbitMQSender;

@Configuration
public class RabbitMQConfig {
	
	@Value("${fanout.exchange}")
	String EXCHANGE_NAME;
	
    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    private static class ReceiverConfig {

    	@Value("${fanout.queue.one}")
    	String QUEUE_NAME_1;
    	
    	@Value("${fanout.queue.two}")
    	String QUEUE_NAME_2;

        @Bean
        public Queue autoDeleteQueue1() {
        	return new Queue(QUEUE_NAME_1, true);
        }

        @Bean
        public Queue autoDeleteQueue2() {
        	return new Queue(QUEUE_NAME_2, true);
        }

        @Bean
        public Binding binding1(FanoutExchange fanout,
            Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
        }

        @Bean
        public Binding binding2(FanoutExchange fanout,
            Queue autoDeleteQueue2) {
            return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
        }

        @Bean
        public RabbitMQReceiver receiver() {
            return new RabbitMQReceiver();
        }
    }

    @Bean
    public RabbitMQSender sender() {
        return new RabbitMQSender();
    }
}
