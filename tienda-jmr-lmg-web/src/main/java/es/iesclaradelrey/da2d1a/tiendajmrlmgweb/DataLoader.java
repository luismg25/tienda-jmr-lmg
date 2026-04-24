package es.iesclaradelrey.da2d1a.tiendajmrlmgweb;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.CategoriaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Clase para cargar datos con repositorio generico y CommandLineRunner
@Component
public class DataLoader implements CommandLineRunner {
    private final CategoriaService categoriaService;

    public DataLoader(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }


    @Override
    public void run(String... args) throws Exception {
        //cuarzos
        categoriaService.save( new Categoria(1L, "Cuarzos", "Minerales compuestos de sílice, muy comunes y variados en colores.", "cuarzos.jpg"));

        //   GEMAS PRECIOSAS  Esmeraldas, Rubíes, Zafiros
        categoriaService.save(new Categoria(2L, "Gemas Preciosas", "Piedras de alto valor y pureza para joyería", "gemas.jpg"));

        //MINERALES METÁLICOS
        categoriaService.save(new Categoria(3L, "Metálicos", "Minerales con brillo metálico como Pirita, Galena o Hematita", "metalicos.jpg"));

        //FÓSILES Y ROCAS
        categoriaService.save(new Categoria(4L, "Fósiles", "Restos orgánicos mineralizados y rocas sedimentarias", null));

    }


}
