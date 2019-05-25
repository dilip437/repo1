package com.poc.repositories;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.poc.model.Student;
import com.poc.model.StudentRowMapper;

@Repository
public class StudentJdbcRepository {

	private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Student> getAll() {
        return jdbcTemplate.query("SELECT * FROM STUDENT", new StudentRowMapper());
    }

    public int add(final String  id, final String firstName) {
    	return jdbcTemplate.update("INSERT INTO STUDENT VALUES (?, ?)", id, firstName);
    }

    public int add(Student entity) {
    	return jdbcTemplate.update("INSERT INTO STUDENT VALUES (?, ?)", entity.getId(), entity.getFirstName());
    }

    public Student get(final String id) {
        final String query = "SELECT * FROM STUDENT WHERE ID = ?";
        return jdbcTemplate.queryForObject(query, new Object[] { id }, new StudentRowMapper());
    }
    
    public int update(Student entity) {
    	return update(entity.getId(), entity.getFirstName());
    }
    
    public int update(final String  id, final String firstName) {
    	return jdbcTemplate.update("UPDATE STUDENT SET FIRST_NAME=? WHERE ID=?", firstName, id);
    }
    
    public int delete(Student entity) {
    	return delete(entity.getId());
    }
    
    public int delete(final String id) {
    	return jdbcTemplate.update("DELETE FROM STUDENT WHERE ID=?", id);
    }
}
