package com.student.repositories;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.student.Student;

@RepositoryRestResource(collectionResourceRel = "students", path = "students")
public interface StudentRepository extends Neo4jRepository<Student, Long> {

	Student findByName(@Param("name") String name);	
	Collection<Student> findByNameLike(@Param("name") String name);

    @Query("MATCH (s:Student)<-[r:LEARNED]-(c:Course) RETURN s,r,c LIMIT {limit}")
	Collection<Student> graph(@Param("limit") int limit);
    
   	@Query("MATCH (s:Student) WHERE s.name= {oldName} SET s.name= {newName} RETURN s")
    Student updateByName(@Param("oldName") String oldName, @Param("newName") String newName);
   	
   	@Query("MATCH (n { name: {name} }) DETACH DELETE n")
    void deleteByName(String name);
}
