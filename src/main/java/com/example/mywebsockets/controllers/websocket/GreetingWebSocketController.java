package com.example.mywebsockets.controllers.websocket;

import com.example.mywebsockets.domain.Greeting;
import com.example.mywebsockets.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingWebSocketController {

    public static final String GET_HELLO_URL="/hello";
    public static final String BROADCAST_GET_HELLO_URL="/topic/greetings";

    @MessageMapping(GET_HELLO_URL)
    @SendTo(BROADCAST_GET_HELLO_URL)
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
