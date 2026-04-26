package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductoRepositoryImpl extends AbstractMapRepository<Producto, Long> implements ProductoRepository {
    @Override
    protected Long getId(Producto p) { return p.getId(); }

    @Override
    public List<Producto> findByCategoria(long idCategoria) {
        return storage.values().stream()
                .filter(p -> p.getIdCategoria() == idCategoria)
                .collect(Collectors.toList());
    }
}