package com.ismaelruge.proyecto_seguimiento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration // Indica que esta clase contiene configuraciones de Spring
public class ConfiguracionUsuarios {

    @Bean // Define un bean para la gestión de usuarios en memoria
    public UserDetailsService userDetailsService() {
        UserDetails usuario = User.builder()
                .username("usuario") // Define el nombre de usuario
                .password(passwordEncoder().encode("contraseña")) // Encripta la contraseña con BCrypt
                .roles("USER") // Asigna el rol "USER"
                .build();

        // Retorna un gestor de usuarios en memoria con el usuario creado
        return new InMemoryUserDetailsManager(usuario);
    }

    @Bean // Define un bean para la codificación de contraseñas
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usa BCrypt para encriptar contraseñas de forma segura
    }
}
