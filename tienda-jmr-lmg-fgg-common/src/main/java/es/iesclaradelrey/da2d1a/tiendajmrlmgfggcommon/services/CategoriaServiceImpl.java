package es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;//Guarda el repositorio

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
        //PRUEBA
        Categoria prueba = new Categoria(1L, "Cuarzos", "Minerales compuestos de sílice, muy comunes y variados en colores.", "cuarzo.jpg");
        this.categoriaRepository.save(prueba);
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
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
