package com;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClient.ChatClientRequestSpec;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/ai")
public class AIController {

    private final ChatClient chatClient;

    public AIController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/prompt")
    public String handlePrompt(@RequestParam String message) {
        // Create a structured prompt
        Prompt prompt = Prompt.builder()
                              .message(message) // User input
                                .build();


        ChatResponse response = chatClient.call(prompt);

        return response.content();
    }
}
