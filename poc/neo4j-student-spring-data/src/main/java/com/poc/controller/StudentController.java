package com.poc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.service.StudentService;

@RestController
@RequestMapping("/")
public class StudentController {

	@Autowired
	private StudentService studentService;

    @GetMapping("/graph")
	public Map<String, Object> graph(@RequestParam(value = "limit",required = false) Integer limit) {
		return studentService.graph(limit == null ? 100 : limit);
	}
    
    @GetMapping("/add")
	public String add(@RequestParam("name") String name, @RequestParam("course") String course, @RequestParam("studies") String studies) {
		return studentService.add(name, course, studies);
	}
    
    @GetMapping("/updateByQuery/{name}")
    public String updateByQuery(@PathVariable("name") String name, @RequestParam("newName") String newName) {
    	return studentService.updateByQuery(name, newName);
    }
     
    @GetMapping("/update/{name}")
    public String update(@PathVariable("name") String name, @RequestParam("newName") String newName) {
    	return studentService.update(name, newName);
    }
    
    @GetMapping("/delete/{name}")
    public String delete(@PathVariable("name") String name) {
    	return studentService.delete(name);
    }
    
    @GetMapping("/deleteByQuery/{name}")
    public String deleteByQuery(@PathVariable("name") String name) {
    	return studentService.deleteByQuery(name);
    }
}
