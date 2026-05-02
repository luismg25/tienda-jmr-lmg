package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {
    List<Producto> findByCategoriasId(long idCategoria);
    default List<Producto> findByIdCategoria(long id) { return findByCategoriasId(id); }
}