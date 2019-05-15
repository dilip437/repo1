package com.ex.test;

public class Student {
	private String firstName;
	private String id;

	public Student() {}
	
	public Student(String firstName, String id) {
		this.firstName = firstName;
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
