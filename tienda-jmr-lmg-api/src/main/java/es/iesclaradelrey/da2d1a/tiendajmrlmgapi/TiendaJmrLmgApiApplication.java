
package es.iesclaradelrey.da2d1a.tiendajmrlmgapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Escanea todos los paquetes de common, security y api
@SpringBootApplication(scanBasePackages = "es.iesclaradelrey.da2d1a")
@EnableJpaRepositories(basePackages = "es.iesclaradelrey.da2d1a")
@EntityScan(basePackages = "es.iesclaradelrey.da2d1a")
public class TiendaJmrLmgApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TiendaJmrLmgApiApplication.class, args);
    }
}