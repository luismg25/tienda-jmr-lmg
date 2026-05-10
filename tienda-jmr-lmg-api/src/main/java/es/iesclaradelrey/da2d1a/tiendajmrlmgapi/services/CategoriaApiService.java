package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.CategoriaDTO;
import java.util.List;

public interface CategoriaApiService {
    List<CategoriaDTO> findAll();
}
