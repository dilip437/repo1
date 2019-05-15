package com.ex.test;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class StudentJdbcRepository {

	private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("STUDENT");
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
