package com.ismaelruge.proyecto_seguimiento;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Locale;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api") // Define el prefijo de la URL para todos los endpoints de este controlador
public class SaludoController {

    private final MessageSource messageSource;

    // Inyección de dependencias para acceder a los mensajes internacionalizados
    public SaludoController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/saludo") // Define un endpoint GET en "/api/saludo"
    public Mono<String> obtenerSaludo(
        @RequestHeader(name = "Accept-Language", required = false) String acceptLanguage, // Obtiene el idioma del encabezado HTTP
        @RequestParam(name = "lang", required = false) String langParam // Permite especificar el idioma como parámetro en la URL
    ) {
        // Determina el idioma a usar en base al parámetro o al encabezado HTTP
        String languageCode = (langParam != null && !langParam.isBlank()) ? langParam : acceptLanguage;
        Locale locale = (languageCode != null) ? Locale.forLanguageTag(languageCode) : Locale.getDefault();

        // Obtiene el mensaje traducido desde los archivos de mensajes (ej. messages.properties)
        String mensaje = messageSource.getMessage("saludoReactive.message", null, locale);

        // Retorna el mensaje dentro de un Mono (para programación reactiva con WebFlux)
        return Mono.just(mensaje);
    }
}