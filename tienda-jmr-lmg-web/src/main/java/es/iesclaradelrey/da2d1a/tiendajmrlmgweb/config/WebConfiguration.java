package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //Cuando se haga una peticion GET a terms, aqui se dice que no busque un Controller que lo gestione
        //sino que con setViewName se le renderize hacia templates/terms.html
        registry.addViewController("/terms")
                .setViewName("terms");
    }
}