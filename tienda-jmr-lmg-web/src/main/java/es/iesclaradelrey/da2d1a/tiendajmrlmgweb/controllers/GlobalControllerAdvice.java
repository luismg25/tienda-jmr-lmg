package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.time.LocalDate;

@ControllerAdvice
public class GlobalControllerAdvice {
    // Establece el nombre de la app en el head y en el footer
    @ModelAttribute("appName")
    public String getAppName() { return "Geocontrol"; }

    // El footer muestra el año actual
    @ModelAttribute("anioActual")
    public int getAnioActual() {
        return LocalDate.now().getYear();
    }
}
