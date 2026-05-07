package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class RegistroDTO {
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String password;
    private boolean aceptaCondiciones;
}
