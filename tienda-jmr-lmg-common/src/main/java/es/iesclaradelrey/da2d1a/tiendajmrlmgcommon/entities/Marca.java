package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "marcas")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "marca")
    @ToString.Exclude // Evita recursividad infinita en logs
    private List<Producto> productos = new ArrayList<>();
}