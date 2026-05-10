package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.services;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.CategoriaDTO;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.mappers.CategoriaMapper;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.CategoriaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CategoriaApiServiceImpl implements CategoriaApiService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaApiServiceImpl(CategoriaRepository categoriaRepository,
                                   CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaDTO> findAll() {
        //Usamos findAll(Sort) de PagingAndSortingRepository
        return categoriaMapper.toDTOList(
                categoriaRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"))
        );
    }
}

