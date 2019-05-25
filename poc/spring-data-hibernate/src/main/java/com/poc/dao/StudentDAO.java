package com.poc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poc.model.Student;

@Repository
@Transactional
public class StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public String save(Student student) {
		try {
			Long isSuccess = (Long)getSession().save(student);
			if(isSuccess >= 1){
				return "Success";
			}else{
				return "Error while Saving Student";
			}
		} catch (Exception e) {
			return "Error while Saving Student";
		}
	}

	public String update(Student student) {
		try {
			getSession().saveOrUpdate(student);
			return "Success";
		} catch (Exception e) {
			return "Error while Saving Student";
		}
	}
	
	public boolean delete(Student student) {
		try {
			getSession().delete(student);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public Student get(String id) {
		return getSession().get(Student.class, id);		
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getAll() {
		return getSession().createQuery("from Student").list();
	}
}
