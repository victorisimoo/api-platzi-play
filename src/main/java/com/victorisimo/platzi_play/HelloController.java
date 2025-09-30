package com.victorisimo.platzi_play;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final String platform;
    private final PlatziPlayAiService aiService;


    public HelloController(@Value("${spring.application.name}") String platform, PlatziPlayAiService aiService) {
        this.platform = platform;
        this.aiService = aiService;
    }

    @GetMapping("/")
    public String hello() {
        return this.aiService.generateGreeting(this.platform);
    }
}
