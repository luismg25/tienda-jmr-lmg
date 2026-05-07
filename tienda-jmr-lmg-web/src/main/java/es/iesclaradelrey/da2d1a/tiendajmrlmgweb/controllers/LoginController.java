package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDate;

@Controller
public class LoginController {

    @Value("${spring.application.name:Geocontrol}")
    private String appName;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("anioActual", LocalDate.now().getYear());
        return "registro/login";
    }
}