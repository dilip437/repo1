package com.poc.chat.model;

public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
    
    @Override
	public String toString() {
    	return toJSONString();
	}
    
    public String toJSONString() {
    	
    	String type = this.type == null ? "" : "\"type\": \"" + this.type + "\"";
    	type = type.length() > 0 ? type + "," : "";
    	
    	String sender = this.sender == null ? "" : "\"sender\": \"" + this.sender + "\"";
    	sender = sender.length() > 0 ? sender + "," : "";
    	
    	String content = this.content == null ? "" : "\"content\": \"" + this.content + "\"";

    	String json = "{" + type + sender + content + "}";
    	json = json.replace(",}", "}");
    	json = json.replace("{,", "{");
		return json;
	}
     
}

