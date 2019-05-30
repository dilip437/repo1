package com.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.poc.dao.StudentDAO;
import com.poc.model.Student;

@Controller
@RequestMapping(path="/hibernate")
public class StudentController {
	
	@Autowired
	private StudentDAO studentDao;

	@GetMapping(path="/add", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody String add(@RequestParam String id, @RequestParam String name) {
		Student student = new Student();
		student.setFirstName(name);
		student.setId(id);
		studentDao.save(student);
		return "Student succesfully saved!";
	}
	
	@GetMapping(path="/get/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody String get(@PathVariable String id) {
		Student s=studentDao.get(id);
		return s.getFirstName() + ", " + s.getId();
	}
	
	@GetMapping(path="/update/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody String update(@PathVariable String id, @RequestParam String name) {
		Student student = new Student();
		student.setFirstName(name);
		student.setId(id);
		studentDao.update(student);
		return "Student succesfully updated!";
	}

	@GetMapping(path="/all", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Student> getAll() {
		return studentDao.getAll();
	}

	@GetMapping(path="/delete/{id}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody String delete(@PathVariable String id) {
		Student student = new Student();
		student.setId(id);
		studentDao.delete(student);
		return "Student succesfully deleted!";
	}	
}
