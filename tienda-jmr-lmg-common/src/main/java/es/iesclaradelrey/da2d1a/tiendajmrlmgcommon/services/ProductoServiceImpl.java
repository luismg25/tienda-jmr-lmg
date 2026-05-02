package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.ProductoRepository;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto p) {
        return productoRepository.save(p);
    }

    @Override
    public void deleteById(Long id) { productoRepository.deleteById(id); }

    @Override
    public List<Producto> findByCategoria(long id, String sortField, String sortDir) {
        Specification<Producto> spec = (root, query, cb) -> {
            applyOrder(root, query, cb, sortField, sortDir);
            return cb.equal(root.join("categorias", JoinType.INNER).get("id"), id);
        };
        return productoRepository.findAll(spec);
    }

    @Override
    public List<Producto> buscarConFiltros(String nombre, Long marcaId, String origen,
                                           Double minPrecio, Double maxPrecio,
                                           String sortField, String sortDir) {
        Specification<Producto> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (nombre != null && !nombre.isBlank())
                predicates.add(cb.like(cb.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"));

            if (marcaId != null)
                predicates.add(cb.equal(root.get("marca").get("id"), marcaId));

            if (origen != null && !origen.isBlank())
                predicates.add(cb.like(cb.lower(root.get("origen")), "%" + origen.toLowerCase() + "%"));

            if (minPrecio != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("precio"), minPrecio));

            if (maxPrecio != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("precio"), maxPrecio));

            applyOrder(root, query, cb, sortField, sortDir);

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        return productoRepository.findAll(spec);
    }

    private void applyOrder(Root<Producto> root, CriteriaQuery<?> query, CriteriaBuilder cb, String sortField, String sortDir) {
        boolean desc = "desc".equalsIgnoreCase(sortDir);
        String field = (sortField == null || sortField.isBlank()) ? "nombre" : sortField;

        Expression<?> orderExpr = switch (field) {
            case "marca.nombre" -> root.join("marca", JoinType.LEFT).get("nombre");
            case "categorias.nombre" -> {
                query.distinct(true);
                yield root.join("categorias", JoinType.LEFT).get("nombre");
            }
            default -> root.get(field);
        };
        query.orderBy(desc ? cb.desc(orderExpr) : cb.asc(orderExpr));
    }
}