package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")    //la tabla se llamará "productos"
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //autoincremento, H2 asigna el ID
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    private Long idCategoria;

    @Column(nullable = false, precision = 10, scale = 2) // precision=10 y scale=2 : máximo 99999999.99
    private BigDecimal precio;

    private boolean agotado;

    @Column(length = 100)
    private String origen;

    private LocalDate fechaIngreso;

    private Double peso;
    private Double ancho;
    private Double alto;
    private Double largo;

    @Column(length = 1000)
    private String descripcion;

    @Column(length = 500)
    private String imagen;
}
