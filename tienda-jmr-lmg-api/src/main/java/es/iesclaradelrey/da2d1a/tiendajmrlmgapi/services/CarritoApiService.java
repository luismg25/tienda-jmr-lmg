package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.CarritoResumenDTO;

public interface CarritoApiService {
    CarritoResumenDTO getResumenCarrito();
    CarritoResumenDTO addProducto(Long productoId, Integer unidades);
    CarritoResumenDTO removeProducto(Long productoId);
    CarritoResumenDTO emptyCarrito();
}