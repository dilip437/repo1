package com.poc;

import java.io.Serializable;

public class MessageDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String text;
	
	public MessageDTO() {}
	
	public MessageDTO(String text) {
		this.text=text;
	}
	
	public String getText() {
		return this.text;
	}
	
	@Override
	public String toString() {
		return "MessageDTO(" + text + ")";
	}
}
