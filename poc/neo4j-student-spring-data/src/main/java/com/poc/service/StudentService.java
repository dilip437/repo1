package com.poc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.model.Course;
import com.poc.model.Student;
import com.poc.model.Study;
import com.poc.repositories.CourseRepository;
import com.poc.repositories.StudentRepository;

@Service
public class StudentService {

    private final static Logger LOG = LoggerFactory.getLogger(StudentService.class);

    @Autowired
	private StudentRepository studentRepository;

    @Autowired
	private CourseRepository courseRepository;

	private Map<String, Object> toD3Format(Collection<Student> students) {
		List<Map<String, Object>> nodes = new ArrayList<>();
		List<Map<String, Object>> rels = new ArrayList<>();
		int i = 0;
		Iterator<Student> result = students.iterator();
		while (result.hasNext()) {
			Student student = result.next();
			nodes.add(map("name", student.getName(), "label", "student"));
			int target = i;
			i++;
			for (Study study : student.getStudies()) {
				Map<String, Object> actor = map("name", study.getCourse().getName(), "label", "studies");
				int source = nodes.indexOf(actor);
				if (source == -1) {
					nodes.add(actor);
					source = i++;
				}
				rels.add(map("source", source, "target", target));
			}
		}
		return map("nodes", nodes, "links", rels);
	}

	private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put(key1, value1);
		result.put(key2, value2);
		return result;
	}

    @Transactional(readOnly = true)
    public Student findByName(String name) {
        Student result = studentRepository.findByName(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Student> findByNameLike(String name) {
        Collection<Student> result = studentRepository.findByNameLike(name);
        return result;
    }

	@Transactional(readOnly = true)
	public Map<String, Object>  graph(int limit) {
		Collection<Student> result = studentRepository.graph(limit);
		return toD3Format(result);
	}
	
    @Transactional(readOnly = false)
    public String add(String name, String courseName, String studies) {
    	try {
			Student student = new Student(name);
			Course course = courseRepository.findByName(courseName);
			if(course == null) 
				return "'" + courseName + "' " + "not found";
			Study study = new Study(course, student);
			study.addStudyName(studies);
			student.addStudy(study);
			studentRepository.save(student); 
			return "Added successfully";
		} catch (Exception e) {
			return "Exception";
		}
    }
    
    @Transactional(readOnly = false)
    public String updateByQuery(String name, String newName) {
    	try {
    		Student student = studentRepository.updateByName(name, newName);
    		return "Updated successfully";
    	} catch (Exception e) {
			return "Exception";
		}	
    }
    
    @Transactional(readOnly = false)
    public String update(String name, String newName) {
    	try {
			Student student = studentRepository.findByName(name);
			if(student == null) 
				return "'" + name + "' " + "not found";
			student.setName(newName);
			studentRepository.save(student);
			return "Updated successfully";
		} catch (Exception e) {
			return "Exception";
		} 
    }
    
    @Transactional(readOnly = false)
    public String deleteByQuery(String name) {
    	try {
    		studentRepository.deleteByName(name);
    		return "Deleted successfully";
    	} catch (Exception e) {
			return "Exception";
		}
    }
    
    @Transactional(readOnly = false)
    public String delete(String name) {
    	try {
			Student student = studentRepository.findByName(name);
			if(student == null) 
				return "'" + name + "' " + "not found";
			studentRepository.deleteById(student.getId());
			return "Deleted successfully";
		} catch (Exception e) {
			return "Exception";
		} 
    }
}
