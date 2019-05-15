package com.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

	@Autowired
	private StudentRepository studentRepository;

	public Iterable<Student> getAll() {
		return studentRepository.findAll();
	}

	public Student get(String id) {
		return studentRepository.get(id).get(0);
	}
	
	public Student add(Student s) {
		return studentRepository.save(s);
	}
	
	public Student update(Student s) {
		return studentRepository.save(s);
	}
	
	public void delete(String id) {
		studentRepository.deleteById(id);
		return; 
	}
}
