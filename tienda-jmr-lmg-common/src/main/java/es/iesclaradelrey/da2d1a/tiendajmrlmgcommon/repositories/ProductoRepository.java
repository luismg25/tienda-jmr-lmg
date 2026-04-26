package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import java.util.List;

public interface ProductoRepository extends IRepository<Producto, Long> {
    List<Producto> findByCategoria(long idCategoria);
}