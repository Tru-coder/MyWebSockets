package com.example.mywebsockets.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@RequiredArgsConstructor
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Value("${spring.rabbitmq.host}")
    public  String host;

    @Value("${spring.rabbitmq.username}")
    public  String username;

    @Value("${spring.rabbitmq.password}")
    public  String password;

    public static final String TOPIC_DESTINATION_PREFIX = "/topic";
    public static final String APPLICATION_DESTINATION_PREFIX = "/app";

    public static final String REGISTRY = "/mine-socket";

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        config.enableSimpleBroker(TOPIC_DESTINATION_PREFIX);
        config.setApplicationDestinationPrefixes(APPLICATION_DESTINATION_PREFIX);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(REGISTRY);
    }


}
