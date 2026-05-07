package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                    // 1. RECURSOS ESTÁTICOS: Deben ir primero para que el CSS/JS cargue siempre
                    .requestMatchers("/css/**", "/js/**", "/imagenes/**", "/webjars/**", "/favicon.ico").permitAll()

                    // 2. REGLAS ESPECÍFICAS
                    // H2 console: solo autenticados
                    .requestMatchers("/h2-console/**").authenticated()
                    // Admin: solo autenticados
                    .requestMatchers("/admin/**").authenticated()
                    // Registro: solo para usuarios NO autenticados (anónimos)
                    .requestMatchers("/register").anonymous()

                    // 3. EL COMODÍN FINAL: Siempre debe ser la última regla
                    .anyRequest().permitAll()
            )
            // Configuración de login con formulario personalizado
            .formLogin(form -> form
                    .loginPage("/login") // Le decimos a Spring que use nuestra vista
                    .permitAll()
            )
            // Configuración de cierre de sesión
            .logout(logout -> logout
                    .logoutSuccessUrl("/?logout") // Redirige a la home tras cerrar sesión
                    .permitAll()
            )
            // Desactivar HTTP Basic
            .httpBasic(basic -> basic.disable())
            // CSRF: desactivar solo para H2 console
            .csrf(csrf -> csrf
                    .ignoringRequestMatchers("/h2-console/**")
            )
            // X-Frame-Options: same-origin (necesario para H2)
            .headers(headers -> headers
                    .frameOptions(frame -> frame.sameOrigin())
            )
        ;
        return http.build();
    }
}