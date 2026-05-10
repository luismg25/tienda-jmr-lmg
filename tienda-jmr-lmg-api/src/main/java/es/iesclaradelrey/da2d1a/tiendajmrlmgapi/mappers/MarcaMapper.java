package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.mappers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.MarcaDTO;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Marca;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MarcaMapper {
    MarcaDTO toDTO(Marca marca);
}
