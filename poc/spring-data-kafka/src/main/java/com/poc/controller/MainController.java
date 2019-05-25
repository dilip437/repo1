package com.poc.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.model.MessageDTO;

@Controller
@RequestMapping(path="/kafka")
public class MainController {

	@Autowired
	private KafkaTemplate<byte[],byte[]> kafkaTemplate;
	
	private static final String topicName = "test-topic";
	
	@GetMapping(path="/send/{text}")
	public @ResponseBody String get(@PathVariable String text) {
		MessageDTO dto = new MessageDTO(text);
		byte[] ba = marshall(dto);
		kafkaTemplate.send(new ProducerRecord<byte[],byte[]>(topicName, ba));
		return "Message sent successfully";
	}
	
	private byte[] marshall(MessageDTO dto) {
	    try {
	      return new ObjectMapper().writeValueAsString(dto).getBytes();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return null;
	}
}
