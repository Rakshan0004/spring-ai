package com;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @GetMapping("chat")
    public String getMethodName(@RequestParam String q) {
        return chatClient
                .prompt()
                .user(q)
                .call()
                .content();
    }
    
}
