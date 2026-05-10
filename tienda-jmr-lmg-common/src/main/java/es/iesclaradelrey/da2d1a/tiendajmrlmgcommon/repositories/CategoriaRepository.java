package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNombre(String nombre);
}