package com.poc.exception;

public class EntityNotFoundException extends EntityException {
	
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException() {
		super();
	}
	
	public EntityNotFoundException(String msg) {
		super(msg);
	}
	
	public EntityNotFoundException(Exception e) {
		super(e.toString());
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
