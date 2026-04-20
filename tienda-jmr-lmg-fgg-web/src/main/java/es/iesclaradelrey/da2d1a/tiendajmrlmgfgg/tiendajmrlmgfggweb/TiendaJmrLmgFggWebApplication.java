package es.iesclaradelrey.da2d1a.tiendajmrlmgfgg.tiendajmrlmgfggweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (
scanBasePackages = {
        //Spring busca en commonlos repositorios, servicios y controladores.
        "es.iesclaradelrey.da2d1a.tiendajmrlmgfgg.tiendajmrlmgfggcommon",
        "es.iesclaradelrey.da2d1a.tiendajmrlmgfgg.tiendajmrlmgfggweb"
        }
)
public class TiendaJmrLmgFggWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiendaJmrLmgFggWebApplication.class, args);
    }

}
