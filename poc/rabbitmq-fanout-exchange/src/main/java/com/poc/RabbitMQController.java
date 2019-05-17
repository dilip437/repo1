package com.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
