package com.victorisimo.platzi_play.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de Gestión de Películas {{platform}}.
            Usa menos de 120 caracteres y hazlo con un tono amigable y entusiasta.
            """)
    String generateGreeting(@V("platform") String platform);

    @SystemMessage(
            """
            Eres un asistente experto en recomendar películas basado en las preferencias del usuario.
            Proporciona una lista máxima de 3 películas recomendadas, No incluyas películas que estén fuera de la 
            plataforma". Usa un lenguaje claro y amigable.
            """
    )
    String generateMoviesSuggestions(@UserMessage String userPreferences);

}
