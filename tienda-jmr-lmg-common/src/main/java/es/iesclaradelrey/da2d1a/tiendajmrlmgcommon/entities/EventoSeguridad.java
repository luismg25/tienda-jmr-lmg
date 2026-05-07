package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "eventos_seguridad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoSeguridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @Column(nullable = false, length = 150)
    private String nombreUsuario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoEventoSeguridad tipo;
}