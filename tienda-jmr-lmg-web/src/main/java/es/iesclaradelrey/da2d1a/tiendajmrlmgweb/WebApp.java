package es.iesclaradelrey.da2d1a.tiendajmrlmgweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring escaneará en TODAS las subcarpetas, tanto de web como de common
@SpringBootApplication(scanBasePackages = "es.iesclaradelrey.da2d1a")
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}