package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Crea todos los getters y setters
@NoArgsConstructor //Poder instanciar una categoria en una linea
@AllArgsConstructor //Para poder meter en el codigo datos de la base de datos
@Entity //le dice a Hibernate que hay una tabla en esta clase, que correspondera a la base de datos
@Table(name = "categorias")  //Esta tabla con el nombre ccategorias
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincremento
    private Long id;          //Clave primaria de la tabla, nullable

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 2000)
    private String descripcion;

    @Column(length = 500)
    private String imagen;

//    private long id;
//    private String nombre;
//    private String descripcion;
//    private String imagen;
}

