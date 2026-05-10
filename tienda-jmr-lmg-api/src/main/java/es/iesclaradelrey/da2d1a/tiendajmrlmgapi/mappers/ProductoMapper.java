package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.mappers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.ProductoDTO;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import org.mapstruct.Mapper;
import java.util.List;

//uses le dice a MapStruct que use CategoriaMapper y MarcaMapper para mapear
// los campos marca y categorias del Producto
@Mapper(componentModel = "spring", uses = {CategoriaMapper.class, MarcaMapper.class})
public interface ProductoMapper {
    ProductoDTO toDTO(Producto producto);
    List<ProductoDTO> toDTOList(List<Producto> productos);
}
