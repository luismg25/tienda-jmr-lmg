package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;
    public ProductoServiceImpl(ProductoRepository pr) { this.productoRepository = pr; }

    @Override public List<Producto> findByCategoria(long id) { return productoRepository.findByCategoria(id); }
    @Override public Optional<Producto> findById(Long id) { return productoRepository.findById(id); }
    @Override public Producto save(Producto p) { return productoRepository.save(p); }
}