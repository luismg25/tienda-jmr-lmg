package es.iesclaradelrey.da2d1a.tiendajmrlmgfgg.tiendajmrlmgfggweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class InicioController {
    @GetMapping("/") // responde a http://localhost:8080/
    public String index() {
        //Devuelve el nombre de la plantilla Thymeleaf: templates/index.html
        return "index";
    }
}
