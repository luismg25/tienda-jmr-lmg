package es.iesclaradelrey.da2d1a.tiendajmrlmgweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Spring escaneará en TODAS las subcarpetas, tanto de web como de common
@SpringBootApplication(scanBasePackages = "es.iesclaradelrey.da2d1a")
@EnableJpaRepositories(basePackages = "es.iesclaradelrey.da2d1a")//Busca los repositorios JPA
@EntityScan(basePackages = "es.iesclaradelrey.da2d1a")//Busca las clases Entidad
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}