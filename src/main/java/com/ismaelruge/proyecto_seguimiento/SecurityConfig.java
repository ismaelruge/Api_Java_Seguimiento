package com.ismaelruge.proyecto_seguimiento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration // Marca esta clase como una configuración de Spring
public class SecurityConfig {

    @Bean // Define un bean para configurar la seguridad de la aplicación
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Deshabilita la protección CSRF (Cross-Site Request Forgery)
                // Se deshabilita para facilitar pruebas, pero en producción es recomendable habilitarla
                .csrf(csrf -> csrf.disable())

                // Configura las reglas de autorización para las solicitudes HTTP
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // Todas las rutas requieren autenticación
                )

                // Configuración del manejo de sesiones
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        // IF_REQUIRED: Crea una sesión solo si es necesario
                )

                // Configuración del formulario de inicio de sesión
                .formLogin(form -> form
                        .defaultSuccessUrl("/privado", true) // Redirige a "/privado" tras un login exitoso
                        .permitAll() // Permite acceso al formulario de login sin autenticación
                )

                // Configuración de cierre de sesión (logout)
                .logout(logout -> logout
                        .logoutSuccessUrl("/login") // Redirige a "/login" después de cerrar sesión
                        .invalidateHttpSession(true) // Invalida la sesión de usuario al cerrar sesión
                        .deleteCookies("JSESSIONID") // Elimina la cookie de sesión
                )

                // Habilita autenticación básica HTTP (para pruebas o APIs)
                .httpBasic(basic -> {});

        return http.build(); // Construye y devuelve la configuración de seguridad
    }
}
