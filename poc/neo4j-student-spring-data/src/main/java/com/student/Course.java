package com.student;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Course {

    @Id
    @GeneratedValue
	private Long id;
	private String name;
	
	@Relationship(type = "LEARNED")
	private List<Student> students = new ArrayList<>();
	
	public Course() {
		
	}
	
	public Course(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public List<Student> getStudents() {
		return students;
	}
	
}
