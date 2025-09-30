package com.victorisimo.platzi_play;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de Gestión de Películas PlatziPlay.
            Usa menos de 120 caracteres y hazlo con un tono amigable y entusiasta.
            """)
    String generateGreeting();

}
