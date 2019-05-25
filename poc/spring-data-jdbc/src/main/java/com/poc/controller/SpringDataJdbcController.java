package com.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.model.Student;
import com.poc.service.StudentJdbcService;

@RestController
@RequestMapping(path = "/jdbc")
public class SpringDataJdbcController {

	@Autowired
	private StudentJdbcService studentJdbcService;
	
	@RequestMapping(value = {"/insert"}, method = RequestMethod.GET)
	public ResponseEntity<String> insert(@RequestParam("name") String name, @RequestParam("id") String id) {
		Student entity = new Student(name, id);
		studentJdbcService.add(entity);
		return new ResponseEntity("Student Add: " + entity.getId()
			+ ", " + entity.getFirstName(), HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/read/{id}"}, method = RequestMethod.GET)
	public ResponseEntity<String> read(@PathVariable("id") String id) {
		Student entity = studentJdbcService.get(id);
		return new ResponseEntity("Student Get: " + entity.getId()
			+ ", " + entity.getFirstName(), HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/update/{id}"}, method = RequestMethod.GET)
	public ResponseEntity<String> update(@PathVariable("id") String id, @RequestParam("name") String name) {
		Student entity = new Student(name, id);
		studentJdbcService.update(entity);
		return new ResponseEntity("Student Update: " + entity.getId()
			+ ", " + entity.getFirstName(), HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		Student entity = new Student("", id);
		studentJdbcService.delete(entity.getId());
		return new ResponseEntity("Student Delete: " + entity.getId()
			+ ", " + entity.getFirstName(), HttpStatus.OK);
	}
}
