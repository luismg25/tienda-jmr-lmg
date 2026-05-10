package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.mappers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.CarritoItemDTO;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.CarritoItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

// Transforma la entidad CarritoItem en CarritoItemDTO
@Mapper(componentModel = "spring")
public interface CarritoMapper {
    @Mapping(source = "producto.id", target = "productoId")
    @Mapping(source = "producto.nombre", target = "productoNombre")
    @Mapping(target = "precioUnitario", expression = "java(item.getProducto().getPrecioFinal())")
    @Mapping(target = "importeTotal", expression = "java(item.getProducto().getPrecioFinal().multiply(java.math.BigDecimal.valueOf(item.getUnidades())))")
    CarritoItemDTO toDTO(CarritoItem item);

    List<CarritoItemDTO> toDTOList(List<CarritoItem> items);
}