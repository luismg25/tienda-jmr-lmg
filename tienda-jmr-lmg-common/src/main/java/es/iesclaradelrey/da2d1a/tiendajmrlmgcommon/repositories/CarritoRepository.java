package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.CarritoItem;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarritoRepository extends JpaRepository<CarritoItem, Long> {

    List<CarritoItem> findByUsuario(Usuario usuario);

    Optional<CarritoItem> findByUsuarioAndProducto(Usuario usuario, Producto producto);

    void deleteByUsuario(Usuario usuario);

    @Query("SELECT COUNT(ci) FROM CarritoItem ci WHERE ci.usuario.id = :usuarioId")
    Long countDistinctProductosByUsuarioId(@Param("usuarioId") Long usuarioId);

    @Query("SELECT SUM(ci.unidades) FROM CarritoItem ci WHERE ci.usuario.id = :usuarioId")
    Integer sumUnidadesTotalesByUsuarioId(@Param("usuarioId") Long usuarioId);

    @Query("SELECT SUM(ci.unidades * (ci.producto.precio * (100 - COALESCE(ci.producto.descuento, 0)) / 100)) " +
            "FROM CarritoItem ci WHERE ci.usuario.id = :usuarioId")
    BigDecimal sumImporteTotalByUsuarioId(@Param("usuarioId") Long usuarioId);
}