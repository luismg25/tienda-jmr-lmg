package es.iesclaradelrey.da2d1a.tiendajmrlmgfgg.tiendajmrlmgfggcommon.repositories;

import es.iesclaradelrey.da2d1a.tiendajmrlmgfgg.tiendajmrlmgfggcommon.entities.Categoria;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriaRepositoryMock implements CategoriaRepository {

    @Override
    public List<Categoria> findAll() {
        List<Categoria> categorias = new ArrayList<>();

        categorias.add(new Categoria(1, "Cuarzos", "Minerales compuestos de sílice, muy comunes y variados.", "cuarzo.jpg"));
        categorias.add(new Categoria(2, "Sulfuros", "Minerales formados por la combinación de azufre con metales.", "sulfuros.jpg"));
        categorias.add(new Categoria(3, "Silicatos", "El grupo más abundante de minerales en la corteza terrestre.", null)); // Esta será sin imagen

        return categorias;//Devolvemos la lista con las categorias
    }
}