package com.poc.exception;

public class EntityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntityException() {
		super();
	}
	
	public EntityException(String msg) {
		super(msg);
	}
	
	public EntityException(Exception e) {
		super(e.toString());
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
