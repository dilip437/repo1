package com.poc;

public class Response {
	private String text;
	
	public Response() {
	}
	
	public Response(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
