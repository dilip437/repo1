package com.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.model.Student;
import com.poc.service.RabbitMQSender;

@RestController
@RequestMapping(path = "/rabbit-direct")
public class RabbitMQController {
	
	@Autowired
	RabbitMQSender rabbitMQSender;
	
	@GetMapping(value = "/producer")
	public String producer(@RequestParam("id") String id, @RequestParam("name") String name) {
		Student student = new Student();
		student.setStudentId(id);
		student.setStudentName(name);
		rabbitMQSender.send(student);
		return "Sent to RabbitMQ Successfully";
	}
}
