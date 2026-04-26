package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private long id;
    private String nombre;
    private long idCategoria;
    private BigDecimal precio;
    private boolean agotado;
    private String origen;           // Opcional
    private LocalDate fechaIngreso;
    private Double peso;             // Opcional
    private Double ancho;
    private Double alto;
    private Double largo;
    private String descripcion;      // Opcional
    private String imagen;           // Opcional
}

