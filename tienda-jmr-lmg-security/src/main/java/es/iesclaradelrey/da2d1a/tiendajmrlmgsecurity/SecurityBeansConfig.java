package es.iesclaradelrey.da2d1a.tiendajmrlmgsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityBeansConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        //4096 iteraciones ( factor 12, más seguro)
        return new BCryptPasswordEncoder(12);
    }
}