package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoResumenDTO {
    private List<CarritoItemDTO> items;
    private Long numeroProductosDistintos;
    private Integer unidadesTotales;
    private BigDecimal importeTotalCarro;
}