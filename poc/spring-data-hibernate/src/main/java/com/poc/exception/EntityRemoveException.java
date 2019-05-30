package com.poc.exception;

public class EntityRemoveException extends EntityException {
	
	private static final long serialVersionUID = 1L;
	
	public EntityRemoveException() {
		super();
	}
	
	public EntityRemoveException(String msg) {
		super(msg);
	}
	
	public EntityRemoveException(Exception e) {
		super(e.toString());
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
