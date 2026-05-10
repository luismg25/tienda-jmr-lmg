package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoItemDTO {
    private Long productoId;
    private String productoNombre;
    private Integer unidades;
    private BigDecimal precioUnitario; // Precio con descuento aplicado
    private BigDecimal importeTotal;
}