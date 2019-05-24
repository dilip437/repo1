package com.student;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@NodeEntity
public class Student {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@JsonIgnoreProperties("student")
	@Relationship(type = "LEARNED", direction = Relationship.INCOMING)
	private List<Study> studies;

	public Student() {	
	}
	
	public Student(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Study> getStudies() {
		return studies;
	} 

	public void addStudy(Study study) {
		if (this.studies == null) {
			this.studies = new ArrayList<>();
		}
		this.studies.add(study);
	}
	
}
