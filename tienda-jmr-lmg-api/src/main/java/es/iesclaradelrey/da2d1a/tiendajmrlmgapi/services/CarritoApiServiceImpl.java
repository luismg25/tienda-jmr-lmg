package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.CarritoResumenDTO;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.exceptions.ProductoNoEnCarritoException;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.exceptions.ProductoNotFoundException;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.exceptions.StockInsuficienteException;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.mappers.CarritoMapper;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.CarritoItem;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.CarritoRepository;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.ProductoRepository;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.UsuarioRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CarritoApiServiceImpl implements CarritoApiService {
    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CarritoMapper carritoMapper;

    public CarritoApiServiceImpl(CarritoRepository carritoRepository,
     ProductoRepository productoRepository,
     UsuarioRepository usuarioRepository,
     CarritoMapper carritoMapper) {
        this.carritoRepository = carritoRepository;
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
        this.carritoMapper = carritoMapper;
    }

    // Obtener el usuario autenticado
    private Usuario getUsuarioAutenticado() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario autenticado no encontrado en BD"));
    }

    @Override
    @Transactional(readOnly = true)
    public CarritoResumenDTO getResumenCarrito() {
        Usuario usuario = getUsuarioAutenticado();
        return construirResumen(usuario);
    }

    @Override
    @Transactional
    public CarritoResumenDTO addProducto(Long productoId, Integer unidades) {
        if (unidades <= 0) {
            throw new IllegalArgumentException("Las unidades deben ser mayores a cero");
        }

        Usuario usuario = getUsuarioAutenticado();
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new ProductoNotFoundException(productoId));

        Optional<CarritoItem> itemOpt = carritoRepository.findByUsuarioAndProducto(usuario, producto);

        int unidadesTotalesDeseadas = unidades;
        if (itemOpt.isPresent()) {
            unidadesTotalesDeseadas += itemOpt.get().getUnidades();
        }

        if (producto.getStock() < unidadesTotalesDeseadas) {
            throw new StockInsuficienteException(producto.getNombre(), unidadesTotalesDeseadas, producto.getStock());
        }

        CarritoItem item = itemOpt.orElse(new CarritoItem(null, usuario, producto, 0, LocalDateTime.now()));
        item.setUnidades(unidadesTotalesDeseadas);
        item.setFechaActualizacion(LocalDateTime.now());

        carritoRepository.save(item);

        return construirResumen(usuario);
    }

    @Override
    @Transactional
    public CarritoResumenDTO removeProducto(Long productoId) {
        Usuario usuario = getUsuarioAutenticado();
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new ProductoNotFoundException(productoId));

        CarritoItem item = carritoRepository.findByUsuarioAndProducto(usuario, producto)
                .orElseThrow(() -> new ProductoNoEnCarritoException(productoId));

        carritoRepository.delete(item);

        return construirResumen(usuario);
    }

    @Override
    @Transactional
    public CarritoResumenDTO emptyCarrito() {
        Usuario usuario = getUsuarioAutenticado();
        carritoRepository.deleteByUsuario(usuario);
        return construirResumen(usuario);
    }

    // Construye el DTO final usando las consultas JPQL
    private CarritoResumenDTO construirResumen(Usuario usuario) {
        Long totalProductos = carritoRepository.countDistinctProductosByUsuarioId(usuario.getId());
        Integer totalUnidades = carritoRepository.sumUnidadesTotalesByUsuarioId(usuario.getId());
        BigDecimal importeTotal = carritoRepository.sumImporteTotalByUsuarioId(usuario.getId());

        CarritoResumenDTO resumen = new CarritoResumenDTO();
        resumen.setItems(carritoMapper.toDTOList(carritoRepository.findByUsuario(usuario)));
        resumen.setNumeroProductosDistintos(totalProductos != null ? totalProductos : 0L);
        resumen.setUnidadesTotales(totalUnidades != null ? totalUnidades : 0);
        resumen.setImporteTotalCarro(importeTotal != null ? importeTotal : BigDecimal.ZERO);

        return resumen;
    }
}