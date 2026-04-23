package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long id;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private long idCategoria;
    private String imagen;
}

