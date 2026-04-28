package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    //Gestiona ahora este repositorio, dos objetos de tipo Categoria y su ID es de tipo Long
    //Al extender de JpaRepository tenemos ya sin escribir findAll(), findById(), save() ...

}
