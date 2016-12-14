package com.ciecc.fire.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker // 通过@EnableWebSocketMessageBroker注解开启使用STOMP协议来传输基于代理(messagebroker)的消息，这时控制器支持使用@MessageMapping,就像使用@requestmapping一样
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {// 注册STOMP协议的节点(endpoint),并映射的指定URL

		registry.addEndpoint("endopintWisely").withSockJS();//注册一个STOMP协议的endpoint,并指定使用SockJS协议
		registry.addEndpoint("endopintChat").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {//配置消息代理(Message Broker)
		registry.enableSimpleBroker("/queue/", "/topic/");
		//registry.enableSimpleBroker("/queue/","/topic/"); //广播式应配置一个/topic消息代理
	}

}
