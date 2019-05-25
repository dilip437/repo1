package com.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.dao.StudentDAO;
import com.poc.model.Student;

@Controller
@RequestMapping(path="/hibernate")
public class StudentController {
	
	@Autowired
	private StudentDAO studentDao;

	@GetMapping(path="/add")
	public @ResponseBody String add(@RequestParam String id, @RequestParam String name) {
		try {
			Student student = new Student();
			student.setFirstName(name);
			student.setId(id);
			studentDao.save(student);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "Student succesfully saved!";
	}
	
	@GetMapping(path="/get/{id}")
	public @ResponseBody String get(@PathVariable String id) {
		try {
			Student s=studentDao.get(id);
			return s.getFirstName() + ", " + s.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@GetMapping(path="/update/{id}")
	public @ResponseBody String update(@PathVariable String id, @RequestParam String name) {
		try {
			Student student = new Student();
			student.setFirstName(name);
			student.setId(id);
			studentDao.update(student);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "Student succesfully updated!";
	}

	@GetMapping(path="/all")
	public @ResponseBody List<Student> getAll() {
		try {
			return studentDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping(path="/delete/{id}")
	public @ResponseBody String delete(@PathVariable String id) {
		try {
			Student student = new Student();
			student.setId(id);
			studentDao.delete(student);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "Student succesfully deleted!";
	}	
}
