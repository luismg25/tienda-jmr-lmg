package es.iesclaradelrey.da2d1a.tiendajmrlmgfggcommon.repositories;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;

public abstract class AbstractMapRepository<T, ID> implements IRepository<T, ID> {

    //el "almacén" en memoria: clave=ID, valor=entidad
    // LinkedHashMap mantiene el orden de inserción
    protected Map<ID, T> storage = new LinkedHashMap<>();

    @Override
    public List<T> findAll() {
        // Devuelve todos los valores del mapa como lista
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<T> findById(ID id) {
        // optional evita el NullPointerException: puede tener valor o estar vacío
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public T save(T entity) {
        //Guarda o actualiza, llama a getId() que cada subclase implementará
        storage.put(getId(entity), entity);
        return entity;
    }

    @Override
    public void deleteById(ID id) {
        storage.remove(id);
    }

    // méto_do abstracto: cada repositorio concreto sabe cómo obtener su ID
    //Ej: para Categoria será "return categoria.getId()"
    protected abstract ID getId(T entity);
}