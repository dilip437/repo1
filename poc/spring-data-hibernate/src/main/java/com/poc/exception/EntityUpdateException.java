package com.poc.exception;

public class EntityUpdateException extends EntityException {
	
	private static final long serialVersionUID = 1L;

	public EntityUpdateException() {
		super();
	}
	
	public EntityUpdateException(String msg) {
		super(msg);
	}
	
	public EntityUpdateException(Exception e) {
		super(e.toString());
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
