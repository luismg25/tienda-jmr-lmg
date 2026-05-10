package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.ProductoDTO;
import java.util.List;

public interface ProductoApiService {
    List<ProductoDTO> findAll();
    List<ProductoDTO> findByCategoria(Long categoriaId);

}

