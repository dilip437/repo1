package com.poc;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

	@MessageMapping("/recv")
	@SendTo("/reply/send")
	public Response accept(Message message) throws Exception {
		return new Response("Hi, " + message.getText() + "!");
	}
}
