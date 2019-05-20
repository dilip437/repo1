package com.poc.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;
    
    @Autowired
    public WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }

    @MessageMapping("/send/message")
    @SendTo("/chat")
    public String onReceivedMesage(ChatMessage chatMessage) {
    	System.out.println("[" + chatMessage.getSender() + "] " + chatMessage.getContent());
    	return chatMessage.toJSONString();
    }
    
    @MessageMapping("/chat.addUser")
    @SendTo("/chat")
    public String addUser(ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
    	System.out.println("new user: " + chatMessage.getSender());
    	headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
    	return chatMessage.toJSONString();
    }
}
