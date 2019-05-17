package com.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rabbit-direct")
public class RabbitMQController {
	
	@Autowired
	RabbitMQSender rabbitMQSender;
	
	@GetMapping(value = "/producer")
	public String producer(@RequestParam("name") String name,@RequestParam("id") String id) {
		Student student = new Student();
		student.setStudentId(id);
		student.setStudentName(name);
		rabbitMQSender.send(student);
		return "Sent to RabbitMQ Successfully";
	}
}
