package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    @Id
    @Column(length = 6)
    private String id;

    @Column(length = 100)
    private String descripcion;
}