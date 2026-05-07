package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.config;

import es.iesclaradelrey.da2d1a.tiendajmrlmgsecurity.LogoutEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final LogoutEventHandler logoutEventHandler;

    public SecurityConfig(LogoutEventHandler logoutEventHandler) {
        this.logoutEventHandler = logoutEventHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // RECURSOS ESTÁTICOS
                        .requestMatchers("/css/**", "/js/**", "/imagenes/**", "/webjars/**", "/favicon.ico").permitAll()

                        // REGLAS DE AUTORIZACIÓN
                        // H2 console: Solo administradores (Rol ADMIN)
                        .requestMatchers("/h2-console/**").hasRole("ADMIN")
                        // Área de administración: Solo administradores (Rol ADMIN)
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        // Perfil de usuario: Debe estar autenticado (USER o ADMIN)
                        .requestMatchers("/users/profile/**").authenticated()
                        // Registro: Solo para usuarios NO autenticados
                        .requestMatchers("/register").anonymous()

                        // RESTO DE LA TIENDA
                        .anyRequest().permitAll()
                )
                // Configuración de login con formulario personalizado
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                // Configuración de cierre de sesión con POST (por protección CSRF)
                .logout(logout -> logout
                        .logoutSuccessUrl("/?logout")
                        .permitAll()
                )
                // Desactivar HTTP Basic según requerimientos
                .httpBasic(basic -> basic.disable())

                // Protección contra CSRF: Activa por defecto, excepto para H2
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                )

                // X-Frame-Options: same-origin para permitir el uso de frames en la consola de H2
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin())
                )
        ;

        return http.build();
    }
}