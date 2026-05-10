package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.mappers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.CategoriaDTO;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Categoria;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    //MapStruct genera automáticamente el mapeo de campos con el mismo nombre
    CategoriaDTO toDTO(Categoria categoria);
    List<CategoriaDTO> toDTOList(List<Categoria> categorias);
}
