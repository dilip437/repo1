package com.poc.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.poc.model.Course;

@RepositoryRestResource(collectionResourceRel = "courses", path = "courses")
public interface CourseRepository extends Neo4jRepository<Course, Long> {
	
    Course findByName(String name);
}
