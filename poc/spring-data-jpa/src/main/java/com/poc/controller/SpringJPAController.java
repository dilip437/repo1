package com.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.model.Student;
import com.poc.service.StudentService;

@Controller
@RequestMapping(path="/jpa")
public class SpringJPAController {

	@Autowired
	private StudentService studentService;

	@GetMapping(path="/get/{id}")
	public @ResponseBody Student get(@PathVariable String id) {
		return studentService.get(id);
	}
	
	@GetMapping(path="/add")
	public @ResponseBody Student add(@RequestParam String id, @RequestParam String name) {
		Student s=new Student();
		s.setFirstName(name);
		s.setId(id);
		return studentService.add(s);
	}
	
	@GetMapping(path="/update/{id}")
	public @ResponseBody Student update(@PathVariable String id, @RequestParam String name) {
		Student s=new Student();
		s.setFirstName(name);
		s.setId(id);
		return studentService.update(s);
	}
	
	@GetMapping(path="/delete/{id}")
	public @ResponseBody String delete(@PathVariable String id) {
		studentService.delete(id);
		return "Deleted: " + id; 
	}
}
