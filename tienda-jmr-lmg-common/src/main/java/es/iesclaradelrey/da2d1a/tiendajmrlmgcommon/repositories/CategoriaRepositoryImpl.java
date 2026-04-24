package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Categoria;
import org.springframework.stereotype.Repository;

@Repository // Spring gestionará este bean gestionado por el contenedor IoC
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