package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto;

import lombok.Data;

// recibe el id y las unidades por POST
@Data
public class AddProductoRequestDTO {
    private Long productoId;
    private Integer unidades;
}