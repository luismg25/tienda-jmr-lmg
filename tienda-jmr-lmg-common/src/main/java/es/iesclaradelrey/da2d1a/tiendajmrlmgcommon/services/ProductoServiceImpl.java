package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.ProductoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementación de servicios para la gestión de productos.
 * Utiliza Specification para consultas dinámicas complejas.
 */
@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) { this.productoRepository = productoRepository; }

    @Override public List<Producto> findByCategoria(long id) { return productoRepository.findByIdCategoria(id); }
    @Override public Optional<Producto> findById(Long id) { return productoRepository.findById(id); }
    @Override public Producto save(Producto p) { return productoRepository.save(p); }

    @Override
    public List<Producto> buscarConFiltros(String nombre, String origen, Double minPrecio, Double maxPrecio, String sortField, String sortDir) {
        Sort.Direction direction = "desc".equalsIgnoreCase(sortDir) ? Sort.Direction.DESC : Sort.Direction.ASC;
        String field = (sortField == null || sortField.isBlank()) ? "id" : sortField;
        Sort sort = Sort.by(direction, field);

        Specification<Producto> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (nombre != null && !nombre.isBlank()) predicates.add(cb.like(cb.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"));
            if (origen != null && !origen.isBlank()) predicates.add(cb.like(cb.lower(root.get("origen")), "%" + origen.toLowerCase() + "%"));
            if (minPrecio != null) predicates.add(cb.greaterThanOrEqualTo(root.get("precio"), minPrecio));
            if (maxPrecio != null) predicates.add(cb.lessThanOrEqualTo(root.get("precio"), maxPrecio));
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        return productoRepository.findAll(spec, sort);
    }
}