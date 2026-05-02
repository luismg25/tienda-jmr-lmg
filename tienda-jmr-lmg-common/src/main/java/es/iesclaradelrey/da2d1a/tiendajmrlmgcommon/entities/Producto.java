package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "productos_categorias",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private List<Categoria> categorias = new ArrayList<>();

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "descuento")
    private Integer descuento;

    private boolean agotado;

    @Column(length = 100)
    private String origen;

    private LocalDate fechaIngreso;

    private Double peso;

    @Column(length = 50)
    private String dimensiones;

    @Column(length = 1000)
    private String descripcion;

    @Column(length = 500)
    private String imagen;

    // Calcula el precio con descuento
    public BigDecimal getPrecioFinal() {
        if (descuento == null || descuento == 0) return precio;
        BigDecimal descMultiplier = BigDecimal.valueOf(100 - descuento).divide(BigDecimal.valueOf(100));
        return precio.multiply(descMultiplier);
    }
}