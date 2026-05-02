package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class InicioAdminController {

    @GetMapping("/")
    public String redirectSlash() {
        return "redirect:/admin";
    }

    @GetMapping
    public String inicio() {
        return "admin/inicio";
    }
}