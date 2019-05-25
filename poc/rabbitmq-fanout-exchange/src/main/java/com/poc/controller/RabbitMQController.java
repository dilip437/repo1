package com.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.service.RabbitMQSender;

@RestController
@RequestMapping(path = "/rabbit-fanout")
public class RabbitMQController {
	
	@Autowired
	RabbitMQSender sender;
	
	@GetMapping(value = "/producer")
	public String producer(@RequestParam("name") String name,@RequestParam("id") String id) {
		sender.send(name, id);
		return "Sent to RabbitMQ Successfully";
	}
}
