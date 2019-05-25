package com.poc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.poc.model.Student;

public interface StudentRepository extends CrudRepository<Student, String> {

	@Query("select s from Student s where s.id = :id")
	List<Student> get(String id);
}
