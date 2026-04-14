package es.iesclaradelrey.da2d1a.tiendajmrlmgfgg.tiendajmrlmgfggcommon.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Crea todos los getters y setters
@NoArgsConstructor //Poder instanciar una categoria en una linea
@AllArgsConstructor //Para poder meter en el codigo datos de la base de datos
public class Categoria {
    private long id;
    private String nombre;
    private String descripcion;
    private String imagen;
}

