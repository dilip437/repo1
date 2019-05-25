package com.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.model.Student;
import com.poc.repositories.StudentJdbcRepository;

@Service
public class StudentJdbcService {

	@Autowired
	private StudentJdbcRepository studentJdbcRepository;
	
	public List<Student> getAll() {
        return studentJdbcRepository.getAll();
    }

    public int add(final String  id, final String firstName) {
    	return studentJdbcRepository.add(id, firstName);
    }

    public int add(Student entity) {
    	return studentJdbcRepository.add(entity);
    }

    public Student get(final String id) {
        return studentJdbcRepository.get(id);
    }
    
    public int update(Student entity) {
    	return update(entity.getId(), entity.getFirstName());
    }
    
    public int update(final String  id, final String firstName) {
    	return studentJdbcRepository.update(id, firstName);
    }
    
    public int delete(Student entity) {
    	return studentJdbcRepository.delete(entity);
    }
    
    public int delete(final String id) {
    	return studentJdbcRepository.delete(id);
    }
}
