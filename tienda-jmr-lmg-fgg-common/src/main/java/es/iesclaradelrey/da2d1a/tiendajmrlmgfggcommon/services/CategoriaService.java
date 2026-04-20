package es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.entities.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> findAll();
    Optional<Categoria> findById(Long id);
    Categoria save(Categoria categoria);
}
