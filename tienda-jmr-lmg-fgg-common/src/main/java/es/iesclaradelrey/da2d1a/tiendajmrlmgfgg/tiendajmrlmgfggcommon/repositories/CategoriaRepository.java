package es.iesclaradelrey.da2d1a.tiendajmrlmgfgg.tiendajmrlmgfggcommon.repositories;

import es.iesclaradelrey.da2d1a.tiendajmrlmgfgg.tiendajmrlmgfggcommon.entities.Categoria;

import java.util.List;

public interface CategoriaRepository {
    List<Categoria> findAll();
}

