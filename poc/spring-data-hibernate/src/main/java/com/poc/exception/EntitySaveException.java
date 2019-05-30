package com.poc.exception;

public class EntitySaveException extends EntityException {
	
	private static final long serialVersionUID = 1L;

	public EntitySaveException() {
		super();
	}
	
	public EntitySaveException(String msg) {
		super(msg);
	}
	
	public EntitySaveException(Exception e) {
		super(e.toString());
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
