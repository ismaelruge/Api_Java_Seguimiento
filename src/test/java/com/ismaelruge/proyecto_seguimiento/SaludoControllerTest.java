package com.ismaelruge.proyecto_seguimiento;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.Locale;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(SaludoController.class)
public class SaludoControllerTest {

//    @Autowired
//    private MockMvc mockMvc;

//    @MockBean
//    private MessageSource messageSource;

//    @BeforeEach
//    void setUp() {
//        when(messageSource.getMessage("saludoReactive.message", null, new Locale("es")))
//                .thenReturn("Â¡Hola, bienvenido a nuestra API Reactiva!");
//
//        when(messageSource.getMessage("saludoReactive.message", null, new Locale("en")))
//                .thenReturn("Hello, welcome to our Reactive API!");
//
//        when(messageSource.getMessage("saludoReactive.message", null, new Locale("fr")))
//                .thenReturn("Bonjour, bienvenue sur notre API rÃ©active!");
//    }

//    @Test
//    @WithMockUser(username = "usuario", password = "contraseña")
//    public void testSaludoEspanol() throws Exception {
//        mockMvc.perform(get("/api/saludo")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .characterEncoding("UTF-8")) // Fuerza la codificación en UTF-8
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(content().string("Â¡Hola, bienvenido a nuestra API Reactiva!"));
//    }

//    @Test
//    @WithMockUser(username = "usuario", password = "contraseña")
//    public void testSaludoIngles() throws Exception {
//        mockMvc.perform(get("/api/saludo")
//                        .header("Accept-Language", "en")
//                        .characterEncoding("UTF-8"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Hello, welcome to our Reactive API!"));
//    }

//    @Test
//    @WithMockUser(username = "usuario", password = "contraseña")
//    public void testSaludoFrances() throws Exception {
//        mockMvc.perform(get("/api/saludo")
//                        .header("Accept-Language", "fr")
//                        .characterEncoding("UTF-8"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Bonjour, bienvenue sur notre API rÃ©active!"));
//    }
}