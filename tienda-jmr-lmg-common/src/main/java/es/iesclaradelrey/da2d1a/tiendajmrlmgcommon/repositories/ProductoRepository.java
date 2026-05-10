package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {
    //consulta derivada por categoría con parámetro Sort
    List<Producto> findByCategorias_Id(Long categoriaId, Sort sort);
}