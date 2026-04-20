package es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.repositories.CategoriaRepository;

import java.util.List;
import java.util.Optional;

public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;


    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> findAll() {
        return List.of();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return null;
    }
}
