package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private MarcaDTO marca;
    private List<CategoriaDTO> categorias;
    private BigDecimal precio;
    private Integer descuento;
    private boolean agotado;
    private String origen;
    private LocalDate fechaIngreso;
    private Double peso;
    private String dimensiones;
    private String descripcion;
    private String imagen;
}

