package com.poc.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.poc.chat.model.ChatMessage;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;
    
    @Autowired
    public WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }
    
    @MessageMapping("/send/message/{group}")
    @SendTo("/chat/{group}")
    public String onReceivedMesage(@DestinationVariable(value = "group") String group, ChatMessage chatMessage) {
    	System.out.println("[" + chatMessage.getSender() + "] " + chatMessage.getContent());
    	return chatMessage.toJSONString();
    }
    
    @MessageMapping("/chat.addUser/{group}")
    @SendTo("/chat/{group}")
    public String addUser(@DestinationVariable(value = "group") String group, ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor) {
    	System.out.println("addUser: {group}: " + group);
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		headerAccessor.getSessionAttributes().put("group", group);
		return chatMessage.toJSONString();
    }
}
