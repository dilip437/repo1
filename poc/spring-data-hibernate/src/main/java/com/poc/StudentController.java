package com.poc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping(path="/get")
	public @ResponseBody String get(@RequestParam String id) {
		try {
			Student s=studentDao.get(id);
			return s.getFirstName() + ", " + s.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@GetMapping(path="/update")
	public @ResponseBody String update(@RequestParam String id, @RequestParam String name) {
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

	@GetMapping(path="/delete")
	public @ResponseBody String delete(@RequestParam String id) {
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
