package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // H2 console: solo autenticados
                        .requestMatchers("/h2-console/**").authenticated()
                        // Admin: solo autenticados
                        .requestMatchers("/admin/**").authenticated()
                        // /register solo para anónimos (se configura más abajo)
                        // El resto: acceso libre
                        .anyRequest().permitAll()
                )
                // Configuración de login con formulario (parámetros por defecto)
                .formLogin(form -> form
                        .permitAll()
                )
                // Desactivar HTTP Basic
                .httpBasic(basic -> basic.disable())
                // CSRF: desactivar solo para H2 console
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                )
                // X-Frame-Options: same-origin (necesario para que la consola H2 muestre frames)
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin())
                );

        return http.build();
    }
}