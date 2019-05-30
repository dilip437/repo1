package com.poc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poc.exception.EntityException;
import com.poc.exception.EntityNotFoundException;
import com.poc.exception.EntityRemoveException;
import com.poc.exception.EntitySaveException;
import com.poc.exception.EntityUpdateException;
import com.poc.model.Student;

@Repository
@Transactional
public class StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public String save(Student student) throws EntityException {
		try {
			Long isSuccess = (Long)getSession().save(student);
			if(isSuccess >= 1){
				return "Success";
			}else{
				throw new EntitySaveException("Error: Saving Student");
			}
		} catch (Exception e) {
			throw new EntitySaveException("Error: Saving Student");
		}
	}

	public String update(Student student) throws EntityException {
		try {
			getSession().saveOrUpdate(student);
			return "Success";
		} catch (Exception e) {
			throw new EntityUpdateException("Error: Updating Student");
		}
	}
	
	public boolean delete(Student student) throws EntityException {
		try {
			getSession().delete(student);
			return true;
		} catch (Exception e) {
			throw new EntityRemoveException("Error: Removing Student");
		}
	}

	@SuppressWarnings("unchecked")
	public Student get(String id) throws EntityException {
		try {
			return getSession().get(Student.class, id);
		} catch (Exception e) {
			throw new EntityNotFoundException("Error: Finding Student");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getAll() throws EntityException {
		try {
			return getSession().createQuery("from Student").list();
		} catch (Exception e) {
			throw new EntityNotFoundException("Error: Finding Student");
		}
	}
}
