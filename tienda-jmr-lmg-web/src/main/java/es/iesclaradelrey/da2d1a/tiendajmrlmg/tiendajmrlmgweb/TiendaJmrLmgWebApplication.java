//package es.iesclaradelrey.da2d1a.tiendajmrlmgfgg.tiendajmrlmgfggweb;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication (
//scanBasePackages = {
//        //Spring busca en commonlos repositorios, servicios y controladores.
//        "es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon",
//        "es.iesclaradelrey.da2d1a.tiendajmrlmgfggweb"
//        }
//)
//public class TiendaJmrLmgFggWebApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(TiendaJmrLmgFggWebApplication.class, args);
//    }
//
//}
package es.iesclaradelrey.da2d1a.tiendajmrlmg.tiendajmrlmgweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        // Al poner la carpeta "da2d1a", Spring buscará hacia adentro en TODAS las subcarpetas,
        // pillando tanto el módulo web como el common sin equivocarse.
        scanBasePackages = "es.iesclaradelrey.da2d1a"
)
public class TiendaJmrLmgWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(TiendaJmrLmgWebApplication.class, args);
    }
}