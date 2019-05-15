package com.ex.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/jdbc")
public class SpringDataJdbcController {

	@Autowired
	private StudentJdbcRepository studentJdbcRepository;

	@RequestMapping(value = {"/test"}, method = RequestMethod.GET)
	public ResponseEntity<String> executeShow() {
		Student entity = studentJdbcRepository.get("L-105");
		return new ResponseEntity("Student: " + entity.getId()
			+ ", " + entity.getFirstName(), HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/insert"}, method = RequestMethod.GET)
	public ResponseEntity<String> insert() {
		Student entity = new Student("Kanu", "K-104");
		studentJdbcRepository.add(entity);
		return new ResponseEntity("Student Add: " + entity.getId()
			+ ", " + entity.getFirstName(), HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/read"}, method = RequestMethod.GET)
	public ResponseEntity<String> read() {
		Student entity = studentJdbcRepository.get("L-105");
		return new ResponseEntity("Student Get: " + entity.getId()
			+ ", " + entity.getFirstName(), HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/update"}, method = RequestMethod.GET)
	public ResponseEntity<String> update() {
		Student entity = new Student("Kiran", "K-104");
		studentJdbcRepository.update(entity);
		return new ResponseEntity("Student Update: " + entity.getId()
			+ ", " + entity.getFirstName(), HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
	public ResponseEntity<String> delete() {
		Student entity = new Student("Kiran", "K-104");
		studentJdbcRepository.delete(entity.getId());
		return new ResponseEntity("Student Delete: " + entity.getId()
			+ ", " + entity.getFirstName(), HttpStatus.OK);
	}
}
