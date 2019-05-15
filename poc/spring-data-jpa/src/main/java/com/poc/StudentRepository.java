package com.poc;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

interface StudentRepository extends CrudRepository<Student, String> {

	@Query("select s from Student s where s.id = :id")
	List<Student> get(String id);
}
