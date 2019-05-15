package com.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/jpa")
public class MainController {

	@Autowired
	private MainService mainService;

	@GetMapping(path="/get")
	public @ResponseBody Student get(@RequestParam String id) {
		return mainService.get(id);
	}
	
	@GetMapping(path="/add")
	public @ResponseBody Student add(@RequestParam String id, @RequestParam String name) {
		Student s=new Student();
		s.setFirstName(name);
		s.setId(id);
		return mainService.add(s);
	}
	
	@GetMapping(path="/update")
	public @ResponseBody Student update(@RequestParam String id, @RequestParam String name) {
		Student s=new Student();
		s.setFirstName(name);
		s.setId(id);
		return mainService.update(s);
	}
	
	@GetMapping(path="/delete")
	public @ResponseBody String delete(@RequestParam String id) {
		mainService.delete(id);
		return "Deleted: " + id; 
	}
}
