package com.poc.chat;

public class Message {

	public String text;
	public String sender;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}

	@Override
	public String toString() {
		return sender + ": " + text;
	}
}
