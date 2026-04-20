package es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.repositories;

import java.util.List;
import java.util.Optional;

//T = tipo de entidad ej:Categoria, ID = tipo del identificador (Long)
public interface IRepository<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    void deleteById(ID id);
}