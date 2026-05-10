package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.ProductoDTO;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.mappers.ProductoMapper;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.ProductoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductoApiServiceImpl implements ProductoApiService {
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoApiServiceImpl(ProductoRepository productoRepository,
                                  ProductoMapper productoMapper) {
        this.productoRepository =productoRepository;
        this.productoMapper = productoMapper ;
    }

    @Override
    @Transactional(readOnly =true)
    public List<ProductoDTO> findAll() {
        // findAll(Sort) de PagingAndSortingRepository
        return productoMapper.toDTOList(
                productoRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> findByCategoria(Long categoriaId) {
        // Consulta derivada con Sort como parámetro -- SIN OrderBy
        return productoMapper.toDTOList(
                productoRepository.findByCategorias_Id(
                        categoriaId,
                        Sort.by(Sort.Direction.ASC, "nombre")
                )
        );
    }
}

