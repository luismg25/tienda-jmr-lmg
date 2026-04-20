package es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.repositories;

import es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.entities.Categoria;
import org.springframework.stereotype.Repository;

@Repository // Spring gestionará este bean
public class CategoriaRepositoryImpl
        extends AbstractMapRepository<Categoria, Long>   // hereda el HashMap
        implements CategoriaRepository {                  // cumple el contrato

    @Override
    protected Long getId(Categoria categoria) {
        // decir al AbstractMapRepository cómo obtener el ID de una Categoria
        return categoria.getId();
    }

}
    //Para añadir en la parte web se cargaran
//        categorias.add(new Categoria(1, "Cuarzos", "Minerales compuestos de sílice, muy comunes y variados.", "cuarzo.jpg"));
//        categorias.add(new Categoria(2, "Sulfuros", "Minerales formados por la combinación de azufre con metales.", "sulfuros.jpg"));
//        categorias.add(new Categoria(3, "Silicatos", "El grupo más abundante de minerales en la corteza terrestre.", null)); // Esta será sin imagen
