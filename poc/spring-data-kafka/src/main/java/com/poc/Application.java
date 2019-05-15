package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Application {

	private static final String topicName = "test-topic";
	private static final String groupId = "test";
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @KafkaListener(topics = topicName, groupId = groupId)
    public void listen(byte[] message) {
    	MessageDTO dto = (MessageDTO) unMarshall(message);
    	System.out.println("Recv: " + dto.getText());
    }
    
	private Object unMarshall(byte[] ba) {
        try {
        	return new ObjectMapper().readValue(ba, MessageDTO.class);
        } catch (Exception e) {
          e.printStackTrace();
        }
	    return null;
	}
}