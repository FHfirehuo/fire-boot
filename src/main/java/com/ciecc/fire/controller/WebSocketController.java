package com.ciecc.fire.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import com.ciecc.fire.domain.BToSMessage;
import com.ciecc.fire.domain.SToBMessage;

@Controller
public class WebSocketController {

	@MessageMapping("welcome") // 当浏览器向服务端发送请求时，通过@MessageMapping映射/welcome这个地址，类似于@RequestMessage
	@SendTo("topic/getResponse") // 当服务器端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息。我感觉topic/getResponse只是一个标识端不能说是严格意义的路径所以要和stompClient.subscribe('topic/getResponse',）中的路径保持一致
	public SToBMessage say(BToSMessage message) throws InterruptedException {

		Thread.sleep(3000);
		return new SToBMessage("welcome, " + message.getName() + " ！");
	}

	private SimpMessagingTemplate messagingTemplate; // 通过messagingTemplate向浏览器发送消息

	private final SimpMessageSendingOperations messageSendingOperations;

	@Autowired
	public WebSocketController(SimpMessageSendingOperations messageSendingOperations,
			SimpMessagingTemplate messagingTemplate) {
		this.messageSendingOperations = messageSendingOperations;
		this.messagingTemplate = messagingTemplate;
	}

	 //@SubscribeMapping//用于只发生一次的请求比如订阅
	@MessageMapping("chat") // 当浏览器向服务端发送请求时，通过@MessageMapping映射/welcome这个地址，类似于@RequestMessage
	public void handleChat(Principal principal, String msg) {
		if (principal.getName().equals("fire")) {
			System.out.println(principal.getName() + "-send: " + msg);
			messagingTemplate.convertAndSendToUser("wangtao", "/queue/notifications",
					principal.getName() + "-send: " + msg);

		} else {
			messageSendingOperations.convertAndSendToUser("fire", "/queue/notifications",
					principal.getName() + "-send: " + msg);
		}
	}
}
