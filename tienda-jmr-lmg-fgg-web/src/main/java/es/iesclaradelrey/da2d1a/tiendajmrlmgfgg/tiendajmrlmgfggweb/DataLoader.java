package es.iesclaradelrey.da2d1a.tiendajmrlmgfgg.tiendajmrlmgfggweb;

import es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.services.CategoriaService;
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
        categoriaService.save( new Categoria(1L, "Cuarzos", "Minerales compuestos de sílice, muy comunes y variados en colores.", "cuarzo.jpg"));
        categoriaService.save(new Categoria(2L,"Sulfuros","d","sulfuro.jpg"));

        //        categorias.add(new Categoria(1, "Cuarzos", "Minerales compuestos de sílice, muy comunes y variados.", "cuarzo.jpg"));
//        categorias.add(new Categoria(2, "Sulfuros", "Minerales formados por la combinación de azufre con metales.", "sulfuros.jpg"));
//        categorias.add(new Categoria(3, "Silicatos", "El grupo más abundante de minerales en la corteza terrestre.", null));
    }


}
