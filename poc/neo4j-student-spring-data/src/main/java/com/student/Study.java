package com.student;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "LEARNED")
public class Study {

	@Id
    @GeneratedValue
	private Long id;
	private List<String> studies = new ArrayList<>();

	@StartNode
	private Course course;

	@EndNode
	private Student student;

	public Study() {
	}

	public Study(Course course, Student student) {
		this.course = course;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public List<String> getStudies() {
		return studies;
	}

	public Course getCourse() {
		return course;
	}

	public Student getStudent() {
		return student;
	}

	public void addStudyName(String name) {
        if (this.studies == null) {
            this.studies = new ArrayList<>();
        }
        this.studies.add(name);
    }
}
