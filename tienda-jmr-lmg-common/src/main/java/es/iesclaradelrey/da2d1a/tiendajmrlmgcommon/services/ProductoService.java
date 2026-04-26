package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> findByCategoria(long idCategoria);
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
}
