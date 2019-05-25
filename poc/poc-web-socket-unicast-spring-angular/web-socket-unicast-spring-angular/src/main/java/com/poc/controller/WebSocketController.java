package com.poc.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.poc.model.Message;
import com.poc.model.Response;

@Controller
public class WebSocketController {

	@MessageMapping("/recv")
	@SendTo("/reply/send")
	public Response accept(Message message) throws Exception {
		return new Response("[You Say]: " + message.getText());
	}
}
